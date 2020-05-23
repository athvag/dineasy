package com.example.dineasy;

public class Signup  {
    String signup_username,signup_email,signup_email_ver,signup_firstname,signup_lastname;
    int signup_password;


    public void setUsername(String uname){
        this.signup_username = uname;
    }

    public void setPassword(int pass){
        this.signup_password = pass;
    }

    public void setEmail(String email){
        this.signup_email = email;
    }

    public void setFirstname(String fname){
        this.signup_firstname = fname;
    }

    public void setLastname(String lname){
        this.signup_lastname = lname;
    }
}
