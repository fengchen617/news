package com.bawei6.news.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bawei6.basemodel.net.protocol.resp.BaseRespEntity;
import com.bawei6.news.bean.LoginBean;
import com.bawei6.news.bean.RegisterBean;
import com.bawei6.news.transmit.SelectMiddle;

/**
 * @author fengchen
 * @date 2020/1/15.
 * @description：登录
 */
public class LoginViewModel extends AndroidViewModel {
    SelectMiddle selectMiddle=null;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        selectMiddle=new SelectMiddle();
    }

    public LiveData<BaseRespEntity<LoginBean>> login(String name,String pwd){
        return selectMiddle.login(name,pwd);
    }
}
