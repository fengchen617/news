package com.bawei6.news.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bawei6.basemodel.net.protocol.resp.BaseRespEntity;
import com.bawei6.news.bean.RegisterBean;
import com.bawei6.news.bean.SelectBean;
import com.bawei6.news.transmit.SelectMiddle;

import java.util.List;

/**
 * @author fengchen
 * @date 2020/1/15.
 * @description：注册
 */
public class RegisterViewModel extends AndroidViewModel {
    SelectMiddle selectMiddle=null;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        selectMiddle=new SelectMiddle();
    }

    public LiveData<BaseRespEntity<RegisterBean>> register(RegisterBean registerBean){
        return selectMiddle.register(registerBean);
    }
}
