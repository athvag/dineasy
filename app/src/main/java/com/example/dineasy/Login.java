package com.example.dineasy;

public class Login {
    String login_username,login_email;
    int login_password;

    public Login(String lname,int lpass){
        this.login_username = lname;
        this.login_password = lpass;
    }

    public String getUsername(){
        return user.getUsername();
    }

    public String getEmail(){
        return user.email;
    }

    public int getPassword(){
        return user.password;
    }
}
