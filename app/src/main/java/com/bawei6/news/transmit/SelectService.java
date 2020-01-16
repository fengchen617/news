package com.bawei6.news.transmit;

import androidx.lifecycle.LiveData;

import com.bawei6.basemodel.net.RetrofitFactory;
import com.bawei6.basemodel.net.protocol.resp.BaseRespEntity;
import com.bawei6.news.api.SelectApi;
import com.bawei6.news.bean.LoginBean;
import com.bawei6.news.bean.RegisterBean;
import com.bawei6.news.bean.SelectBean;

import java.util.List;

/**
 * @author fengchen
 * @date 2020/1/12.
 * @description：数据层
 */
public class SelectService {
    //初始化的信息
    public LiveData<BaseRespEntity<List<SelectBean>>> select(){
        return RetrofitFactory.getInstance().create(SelectApi.class).select();
    }

    //注册
    public LiveData<BaseRespEntity<RegisterBean>> register(RegisterBean registerBean){
        return RetrofitFactory.getInstance().create(SelectApi.class).register(registerBean);
    }

    //登录
    public LiveData<BaseRespEntity<LoginBean>> login(String name,String pwd){
        return RetrofitFactory.getInstance().create(SelectApi.class).login(name,pwd);
    }
}
