package com.bawei6.news.user;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.bawei6.basemodel.base.InitActivity;
import com.bawei6.headline.HeadLineFragment;
import com.bawei6.homepage.HomePageFragment;
import com.bawei6.minemodel.MineFragment;
import com.bawei6.news.R;
import com.bawei6.news.bean.CommonBean;
import com.bawei6.videomodel.VideoFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class StratActivity extends InitActivity {

    private FrameLayout start_f;
    private CommonTabLayout start_common;
    private ArrayList<CustomTabEntity> list_common = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strat);
        initView();
    }

    private void initView() {
        start_f = (FrameLayout) findViewById(R.id.start_f);
        start_common = (CommonTabLayout) findViewById(R.id.start_common);
        initdata();
    }

    private void initdata() {
        list_common.add(new CommonBean("主页",R.drawable.c_home,R.drawable.s_home));
        list_common.add(new CommonBean("视频",R.drawable.c_v,R.drawable.s_v));
        list_common.add(new CommonBean("微头条",R.drawable.c_f,R.drawable.s_f));
        list_common.add(new CommonBean("我的",R.drawable.c_my,R.drawable.s_my));
        getSupportFragmentManager().beginTransaction()
                .show(new HomePageFragment())
                .hide(new HeadLineFragment())
                .hide(new MineFragment())
                .hide(new VideoFragment()).commit();
        start_common.setTabData(list_common);
        start_common.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (position==0){
                    getSupportFragmentManager().beginTransaction().replace(R.id.start_f,new HomePageFragment()).commit();
                }else if (position==1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.start_f,new VideoFragment()).commit();
                }else if (position==2){
                    getSupportFragmentManager().beginTransaction().replace(R.id.start_f,new HeadLineFragment()).commit();
                }else if (position==3){
                    getSupportFragmentManager().beginTransaction().replace(R.id.start_f,new MineFragment()).commit();
                }
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }
}
