package com.trigyn.mvvmarcitectureexample.model.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String username;

    private String emailId;

    private String password;

    private String mobileNum;

    public void setId(int id) {
        this.id = id;
    }

    public User(String username, String emailId, String mobileNum,String password) {

        this.username = username;
        this.emailId = emailId;
        this.mobileNum = mobileNum;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public String getPassword() {
        return password;
    }
}
