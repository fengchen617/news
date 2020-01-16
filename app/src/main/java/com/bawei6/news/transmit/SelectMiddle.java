package com.bawei6.news.transmit;

import androidx.lifecycle.LiveData;

import com.bawei6.basemodel.net.protocol.resp.BaseRespEntity;
import com.bawei6.news.bean.LoginBean;
import com.bawei6.news.bean.RegisterBean;
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
    //初始化信息
    public LiveData<BaseRespEntity<List<SelectBean>>>select(){
        return selectService.select();
    }
    //注册
    public LiveData<BaseRespEntity<RegisterBean>>register(RegisterBean registerBean){
        return selectService.register(registerBean);
    }
    //登录
    public LiveData<BaseRespEntity<LoginBean>>login(String name , String pwd){
        return selectService.login(name,pwd);
    }
}

