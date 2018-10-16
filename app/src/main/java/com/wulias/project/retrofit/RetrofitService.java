package com.wulias.project.retrofit;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Retrofit 接口管理
 * Created by Gavin
 * 2018/9/26
 */
public interface RetrofitService {
    @FormUrlEncoded
    @POST("Login/login")
    Observable<Object> getCinemaList(@FieldMap Map<String, String> map); //获取影院列表

    @FormUrlEncoded
    @POST("Public/Login/register")
    Observable<Object> getTickets(@FieldMap Map<String, String> map); //票信息
}
