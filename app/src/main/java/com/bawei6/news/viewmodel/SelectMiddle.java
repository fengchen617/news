package com.bawei6.news.viewmodel;

import androidx.lifecycle.LiveData;

import com.bawei6.basemodel.net.protocol.resp.BaseRespEntity;
import com.bawei6.news.bean.SelectBean;

import java.util.List;

/**
 * @author fengchen
 * @date 2020/1/12.
 * @description：中间层 传递值
 */
public class SelectMiddle {
    SelectService selectService;
    public SelectMiddle(){
        selectService=new SelectService();
    }
    public LiveData<BaseRespEntity<List<SelectBean>>>select(){
        return selectService.select();
    }
}
