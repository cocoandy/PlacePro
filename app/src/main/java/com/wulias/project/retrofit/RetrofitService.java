package com.wulias.project.retrofit;

import com.wulias.project.base.BaseBean;
import com.wulias.project.base.LoginBean;
import com.wulias.project.bean.AdvertBean;

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
    Observable<LoginBean> loginLogin(@FieldMap Map<String, String> map); //登录

    @FormUrlEncoded
    @POST("Login/register")
    Observable<Object> loginRegister(@FieldMap Map<String, String> map); //注册

    @FormUrlEncoded
    @POST("Common/home_page")
    Observable<BaseBean<AdvertBean>> advert(@FieldMap Map<String, String> map); //注册

    @FormUrlEncoded
    @POST("User/user_info")
    Observable<Object> userDetail(@FieldMap Map<String, String> map); //用户信息
}
