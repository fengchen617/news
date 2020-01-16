package com.bawei6.news.adapter;

import android.view.View;

import androidx.annotation.Nullable;

import com.bawei6.news.R;
import com.bawei6.news.bean.SelectBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * @author fengchen
 * @date 2020/1/12.
 * @description：
 */
public class SelectAdapter extends BaseQuickAdapter<SelectBean, BaseViewHolder> {
    public SelectAdapter(int layoutResId, @Nullable List<SelectBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SelectBean item) {
        helper.setText(R.id.select_item_text,item.getTypename())
                .addOnClickListener(R.id.select_item_text);
    }
}
