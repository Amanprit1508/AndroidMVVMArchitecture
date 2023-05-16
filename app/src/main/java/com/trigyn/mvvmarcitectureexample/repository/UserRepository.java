package com.trigyn.mvvmarcitectureexample.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.trigyn.mvvmarcitectureexample.model.data.User;
import com.trigyn.mvvmarcitectureexample.model.data.UserDao;
import com.trigyn.mvvmarcitectureexample.model.data.UserDatabase;

public class UserRepository {

    private UserDao userDao;
    private LiveData<User> user;

    public UserRepository(Application application){
        UserDatabase database = UserDatabase.getInstance(application);
        userDao = database.userDao();
        user = userDao.getUser();

    }

    public void insertUser(User user){

        new InsertUserAsyncTask(userDao).execute(user);
    }
    public void updateUser(User user){
        new UpdateUserAsyncTask(userDao).execute(user);
    }
    public void deleteUser(User user){
        new DeleteUserAsyncTask(userDao).execute(user);
    }
    public LiveData<User> getUser(){
        return user;
    }
    private static class InsertUserAsyncTask extends AsyncTask<User,Void,Void>{

        private UserDao userDao;

        public InsertUserAsyncTask(UserDao userDao){
            this.userDao=userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }
    private static class UpdateUserAsyncTask extends AsyncTask<User,Void,Void>{

        private UserDao userDao;

        public UpdateUserAsyncTask(UserDao userDao){
            this.userDao=userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.update(users[0]);
            return null;
        }
    }
    private static class DeleteUserAsyncTask extends AsyncTask<User,Void,Void>{

        private UserDao userDao;

        public DeleteUserAsyncTask(UserDao userDao){
            this.userDao=userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.delete(users[0]);
            return null;
        }
    }
}
