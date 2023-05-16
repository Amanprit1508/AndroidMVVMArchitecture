package com.trigyn.mvvmarcitectureexample.viewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.trigyn.mvvmarcitectureexample.model.RegistrationUser;
import com.trigyn.mvvmarcitectureexample.model.data.User;
import com.trigyn.mvvmarcitectureexample.repository.UserRepository;

public class UserViewModel extends AndroidViewModel {
    private UserRepository repository;
    private LiveData <User> user;
    private RegistrationUser registrationUser;
    private User usermodel;


    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> mobilenum = new MutableLiveData<>();

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository=new UserRepository(application);
        user = repository.getUser();
    }

    public UserViewModel(@NonNull Application application, RegistrationUser registrationUser) {
        super(application);
        this.registrationUser = registrationUser;
        repository=new UserRepository(application);

    }

    public void insert(User user){
        repository.insertUser(user);
    }
    public void update(User user){
        repository.updateUser(user);
    }
    public void delete(User user){
        repository.deleteUser(user);
    }
    public LiveData<User> getUser(){
        return user;
    }


    public void onClickRegister(){

        insert(new User(username.getValue(),email.getValue(),mobilenum.getValue(),password.getValue()));


    }
}
