package com.bawei6.news.user;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei6.basemodel.base.BaseActivity;
import com.bawei6.basemodel.net.protocol.resp.BaseRespEntity;
import com.bawei6.basemodel.utils.MsgUtils;
import com.bawei6.basemodel.utils.NumberPool;
import com.bawei6.basemodel.utils.SPUtils;
import com.bawei6.news.R;
import com.bawei6.news.adapter.SelectAdapter;
import com.bawei6.news.bean.SelectBean;
import com.bawei6.news.viewmodel.SelectViewModel;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class SelectActivity extends BaseActivity<SelectViewModel, ViewDataBinding>{
    LiveData<BaseRespEntity<SelectBean>> select;
    private SelectAdapter selectAdapter;
    private ArrayList<SelectBean>list=new ArrayList<>();
    private RecyclerView select_re;
    private Button select_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initData() {
        LiveData<BaseRespEntity<List<SelectBean>>> select = mViewModel.select();
        select.observe(this,new Observer<BaseRespEntity<List<SelectBean>>>() {
            @Override
            public void onChanged(BaseRespEntity<List<SelectBean>> listBaseRespEntity) {
                MsgUtils.log(listBaseRespEntity.getData().size()+"");
                int data = listBaseRespEntity.getData().size() - 1;
                for (int i = 0; i < data; i++) {
                    int id = listBaseRespEntity.getData().get(i).getId();
                    String typename = listBaseRespEntity.getData().get(i).getTypename();
                    MsgUtils.log(typename);
                    list.add(new SelectBean(id,typename));
                }
                init_item();
            }
        });
    }

    private void init_item() {
        select_re.setLayoutManager(new GridLayoutManager(SelectActivity.this,3));
        selectAdapter=new SelectAdapter(R.layout.select_adapter_item,list);
        select_re.setAdapter(selectAdapter);
        selectAdapter.notifyDataSetChanged();

        selectAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId()==R.id.select_item_text) {
                    view.setBackgroundColor(Color.YELLOW);
                }
            }
        });

        select_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        boolean getflag = SPUtils.getInstance().getflag(this, NumberPool.SELECT);
        if (getflag){
            Intent intent = new Intent(SelectActivity.this, LoginActivity.class);
            startActivity(intent);
        }else {
            SPUtils.getInstance().setBoolean(this, NumberPool.SELECT,true);
        }
        select_re = (RecyclerView) findViewById(R.id.select_re);
        select_next = (Button) findViewById(R.id.select_next);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select;
    }
}
