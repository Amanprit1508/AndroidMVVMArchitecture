package com.trigyn.mvvmarcitectureexample.model;

public class RegistrationUser {

    private String username;
    private String email;
    private String password;
    private String mobileNum;

   /* public RegistrationUser(String username, String email, String password, String mobileNum) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobileNum = mobileNum;
    }*/

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNum() {
        return mobileNum;
    }
}
