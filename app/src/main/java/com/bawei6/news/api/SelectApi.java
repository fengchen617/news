package com.bawei6.news.api;

import androidx.lifecycle.LiveData;

import com.bawei6.basemodel.net.protocol.resp.BaseRespEntity;
import com.bawei6.news.bean.SelectBean;

import java.util.List;

import retrofit2.http.GET;

/**
 * @author fengchen
 * @date 2020/1/12.
 * @description：
 */
public interface SelectApi {
    @GET("api/NewsType/getAllTypes")
    LiveData<BaseRespEntity<List<SelectBean>>> select();
}
