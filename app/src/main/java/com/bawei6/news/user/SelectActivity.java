package com.bawei6.news.user;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei6.basemodel.base.BaseActivity;
import com.bawei6.basemodel.net.protocol.resp.BaseRespEntity;
import com.bawei6.basemodel.utils.MsgUtils;
import com.bawei6.news.R;
import com.bawei6.news.adapter.SelectAdapter;
import com.bawei6.news.bean.SelectBean;
import com.bawei6.news.viewmodel.SelectViewModel;

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
        setContentView(R.layout.activity_select);

    }

    @Override
    protected void initEvent() {
        select_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
                    list.add(new SelectBean(id,typename));
                }
                selectAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        select_re = (RecyclerView) findViewById(R.id.select_re);
        select_next = (Button) findViewById(R.id.select_next);
        select_re.setLayoutManager(new GridLayoutManager(this,3));
        selectAdapter=new SelectAdapter(R.layout.select_adapter_item,list);
        select_re.setAdapter(selectAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select;
    }
}
