package com.trigyn.mvvmarcitectureexample.repository;

import com.trigyn.mvvmarcitectureexample.api.ApiClient;
import com.trigyn.mvvmarcitectureexample.api.ApiInterface;
import com.trigyn.mvvmarcitectureexample.model.LoginResponse;
import com.trigyn.mvvmarcitectureexample.model.LoginUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {

    public void loginApi(LoginUser loginUser,ILoginResponse loginResponse){

        ApiInterface apiInterface = ApiClient.getInstance().create(ApiInterface.class);
        Call<LoginResponse> call = apiInterface.login(loginUser);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.isSuccessful()){

                    loginResponse.onResponse(response.body());
                }else{
                    loginResponse.onFailure(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginResponse.onFailure(t);
            }
        });
    }

    public interface ILoginResponse{

        void onResponse(LoginResponse loginResponse);
        void onFailure(Throwable t);
    }
}
