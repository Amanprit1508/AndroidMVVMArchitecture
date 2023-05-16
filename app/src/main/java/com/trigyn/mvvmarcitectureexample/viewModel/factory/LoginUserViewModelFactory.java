package com.trigyn.mvvmarcitectureexample.viewModel.factory;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.trigyn.mvvmarcitectureexample.model.LoginUser;
import com.trigyn.mvvmarcitectureexample.viewModel.LoginUserViewModel;

public class LoginUserViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private LoginUser loginUser;
    private Context context;

    public LoginUserViewModelFactory(LoginUser loginUser, Context context) {
        this.loginUser = loginUser;
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new LoginUserViewModel(loginUser,context);
    }
}
