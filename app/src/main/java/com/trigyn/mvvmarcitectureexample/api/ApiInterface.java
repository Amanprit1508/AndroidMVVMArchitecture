package com.trigyn.mvvmarcitectureexample.api;

import com.trigyn.mvvmarcitectureexample.model.LoginResponse;
import com.trigyn.mvvmarcitectureexample.model.LoginUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    public static String API_KEY = "hjysgt87e-anvbsdkjks-84376-abc-dt34986tj";


    @POST("api/login")
    Call<LoginResponse> login(@Body LoginUser loginUser);

}
