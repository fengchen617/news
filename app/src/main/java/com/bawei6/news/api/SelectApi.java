package com.bawei6.news.api;

import androidx.lifecycle.LiveData;

import com.bawei6.basemodel.net.protocol.resp.BaseRespEntity;
import com.bawei6.news.bean.LoginBean;
import com.bawei6.news.bean.RegisterBean;
import com.bawei6.news.bean.SelectBean;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @author fengchen
 * @date 2020/1/12.
 * @description：
 */
public interface SelectApi {
    //初始的信息选择界面
    @GET("api/NewsType/getAllTypes")
    LiveData<BaseRespEntity<List<SelectBean>>> select();

    //登录
    @POST("api/User/login")
    @FormUrlEncoded
    LiveData<BaseRespEntity<LoginBean>> login(
            @Field("username")String username,
            @Field("pwd")String pwd
    );

    //注册
    @POST("api/User/register")
    LiveData<BaseRespEntity<RegisterBean>> register(@Body RegisterBean registerBean);

}
