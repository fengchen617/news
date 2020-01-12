package com.bawei6.news.viewmodel;

import androidx.lifecycle.LiveData;

import com.bawei6.basemodel.net.RetrofitFactory;
import com.bawei6.basemodel.net.protocol.resp.BaseRespEntity;
import com.bawei6.news.api.SelectApi;
import com.bawei6.news.bean.SelectBean;

import java.util.List;

/**
 * @author fengchen
 * @date 2020/1/12.
 * @description：数据层
 */
public class SelectService {
    public LiveData<BaseRespEntity<List<SelectBean>>> select(){
        return RetrofitFactory.getInstance().create(SelectApi.class).select();
    }
}
