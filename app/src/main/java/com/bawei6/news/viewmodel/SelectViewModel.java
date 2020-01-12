package com.bawei6.news.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bawei6.basemodel.net.protocol.resp.BaseRespEntity;
import com.bawei6.news.bean.SelectBean;

import java.util.List;

/**
 * @author fengchen
 * @date 2020/1/12.
 * @description：操作层
 */
public class SelectViewModel extends AndroidViewModel {
    SelectMiddle selectMiddle=null;

    public SelectViewModel(@NonNull Application application) {
        super(application);
        selectMiddle=new SelectMiddle();
    }
    public LiveData<BaseRespEntity<List<SelectBean>> >select(){
        return selectMiddle.select();
    }
}
