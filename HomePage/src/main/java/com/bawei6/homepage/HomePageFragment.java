package com.bawei6.homepage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.SearchView;
import androidx.databinding.ViewDataBinding;

import com.bawei6.basemodel.base.BaseFragment;
import com.bawei6.basemodel.utils.MsgUtils;
import com.bawei6.homepage.viewmodel.HomePageViewModel;

/**
 * @author fengchen
 * @date 2020/1/15.
 * @description：主页
 */
public class HomePageFragment extends BaseFragment<HomePageViewModel, ViewDataBinding> {
    private SearchView homepage_title_search;
    private ImageView homepage_title_img;

    @Override
    protected void initEvent() {
        homepage_title_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        homepage_title_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MsgUtils.showmsg(getContext(),"123");
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        homepage_title_search=view.findViewById(R.id.homepage_title_search);
        homepage_title_img=view.findViewById(R.id.homepage_title_img);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.homepage_main_item;
    }
}