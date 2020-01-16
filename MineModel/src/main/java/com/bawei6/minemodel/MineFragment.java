package com.bawei6.minemodel;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import com.bawei6.basemodel.base.BaseFragment;
import com.bawei6.basemodel.utils.MsgUtils;
import com.bawei6.basemodel.utils.NumberPool;
import com.bawei6.basemodel.utils.PhotoUtils;
import com.bawei6.minemodel.viewmodel.MineViewModel;


/**
 * @author fengchen
 * @date 2020/1/15.
 * @description：我的页面
 */
public class MineFragment extends BaseFragment<MineViewModel, ViewDataBinding> {
    //头事件
    private ImageView mine_title_img;
    private TextView mine_title_msg;
    private ImageView mine_title_go;
    //Tools
    private TextView mine_tools_sc;
    private TextView mine_tools_ls;
    private TextView mine_tools_yj;

    @Override
    protected void initEvent() {
        //头像
        mine_title_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MsgUtils.showmsg(getContext(),"123");
                PhotoUtils.img(getActivity());
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        //Head
        mine_title_img=view.findViewById(R.id.mine_title_img);
        mine_title_msg=view.findViewById(R.id.mine_title_msg);
        mine_title_go=view.findViewById(R.id.mine_title_go);
        //Tools
        mine_tools_sc=view.findViewById(R.id.mine_tools_sc);
        mine_tools_ls=view.findViewById(R.id.mine_tools_ls);
        mine_tools_yj=view.findViewById(R.id.mine_tools_yj);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.mine_main_item;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NumberPool.MSGFRIST) {
            // 从相册返回的数据
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                mine_title_img.setImageURI(uri);
            }
        }
    }
}
