package com.vnext.demomvp.model.network;

import com.vnext.demomvp.model.entity.Category;
import com.vnext.demomvp.model.entity.BaseResponse;
import com.vnext.demomvp.model.entity.User;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RequestAPI {
    @FormUrlEncoded
    @POST("data_store/get_account.php")
    Call<ArrayList<User>> signIn(@Field("Username") String username, @Field("Password") String password);

    @GET("data_store/getdata_category.php")
    Call<ArrayList<Category>> getDataCategory();

    @FormUrlEncoded
    @POST("data_store/register.php")
    Call<BaseResponse<String>> register(@FieldMap HashMap<String, String> map);


}
