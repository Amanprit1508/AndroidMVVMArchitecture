package com.trigyn.mvvmarcitectureexample.viewModel.factory;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.trigyn.mvvmarcitectureexample.model.RegistrationUser;
import com.trigyn.mvvmarcitectureexample.viewModel.LoginUserViewModel;
import com.trigyn.mvvmarcitectureexample.viewModel.UserViewModel;

public class RegistrationUserViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private RegistrationUser registrationUser;
    private Context context;

    public RegistrationUserViewModelFactory(RegistrationUser registrationUser, Context context) {
        this.registrationUser = registrationUser;
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new UserViewModel((Application) context.getApplicationContext(),registrationUser);
    }
}
