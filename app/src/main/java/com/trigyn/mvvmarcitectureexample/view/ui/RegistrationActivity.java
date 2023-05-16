package com.trigyn.mvvmarcitectureexample.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.trigyn.mvvmarcitectureexample.R;
import com.trigyn.mvvmarcitectureexample.databinding.ActivityRegistrationBinding;
import com.trigyn.mvvmarcitectureexample.model.RegistrationUser;
import com.trigyn.mvvmarcitectureexample.viewModel.UserViewModel;
import com.trigyn.mvvmarcitectureexample.viewModel.factory.RegistrationUserViewModelFactory;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegistrationBinding registrationBinding = DataBindingUtil.setContentView(this,R.layout.activity_registration);
        UserViewModel userViewModel = ViewModelProviders.of(this,(ViewModelProvider.Factory)new RegistrationUserViewModelFactory(new RegistrationUser(),this)).get(UserViewModel.class);
        registrationBinding.setUserViewModel(userViewModel);
    }
}