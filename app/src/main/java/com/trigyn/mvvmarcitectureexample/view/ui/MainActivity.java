package com.trigyn.mvvmarcitectureexample.view.ui;


import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.trigyn.mvvmarcitectureexample.R;
import com.trigyn.mvvmarcitectureexample.databinding.ActivityMainBinding;
import com.trigyn.mvvmarcitectureexample.model.LoginUser;
import com.trigyn.mvvmarcitectureexample.viewModel.LoginUserViewModel;
import com.trigyn.mvvmarcitectureexample.viewModel.factory.LoginUserViewModelFactory;


public class MainActivity extends AppCompatActivity {

    //private UserViewModel userViewModel;
    LoginUserViewModel loginUserViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
          loginUserViewModel = ViewModelProviders.of(this, (ViewModelProvider.Factory) new LoginUserViewModelFactory(new LoginUser(),this)).get(LoginUserViewModel.class);
            activityMainBinding.setLoginUserViewModel(loginUserViewModel);


        /*
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {

            }
        });
    }*/
        loginUserViewModel.getLoginResult().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }

}