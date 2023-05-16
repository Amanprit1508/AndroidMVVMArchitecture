package com.trigyn.mvvmarcitectureexample.viewModel;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.trigyn.mvvmarcitectureexample.model.LoginResponse;
import com.trigyn.mvvmarcitectureexample.model.LoginUser;
import com.trigyn.mvvmarcitectureexample.repository.LoginRepository;
import com.trigyn.mvvmarcitectureexample.view.ui.RegistrationActivity;

public class LoginUserViewModel extends ViewModel
{
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> mLoginResultMutableData = new MutableLiveData<>();
    public LoginRepository loginRepository;
    private LoginUser loginUser;
    private Context context;

    public LoginUserViewModel(LoginUser loginUser, Context context) {
        this.loginUser = loginUser;
        this.context = context;
        loginRepository = new LoginRepository();
    }



   public void onLoginClick(){
        loginUser.setEmail(email.getValue());
        loginUser.setPassword(password.getValue());

        if(!loginUser.isValidEmailId()){
            Toast.makeText(context, "Invalid Email", Toast.LENGTH_SHORT).show();
        }else if(!loginUser.isValidPassword()){
            Toast.makeText(context, "Password should be minimum 6 Characters", Toast.LENGTH_SHORT).show();
        }else if(loginUser.isValidCredentials()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                  //  Toast.makeText(context, "Login Successfully", Toast.LENGTH_SHORT).show();
                    login(loginUser);
                }
            },500);
        }else{
            Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }
   }

   public void login(LoginUser loginUser){
        //progressbar visible

       mLoginResultMutableData.postValue("Checking");

       loginRepository.loginApi(loginUser, new LoginRepository.ILoginResponse() {
           @Override
           public void onResponse(LoginResponse loginResponse) {
               //progressbar invisible

               mLoginResultMutableData.postValue("Login Success");
           }

           @Override
           public void onFailure(Throwable t) {
                //progressbar invisible
               mLoginResultMutableData.postValue("Login Failure: "+t.getLocalizedMessage());
           }
       });
   }

   public void onRegistrationClick(){

       Intent intent = new Intent(context, RegistrationActivity.class);
       context.startActivity(intent);

   }

   public LiveData<String> getLoginResult(){
        return mLoginResultMutableData;
   }
}
