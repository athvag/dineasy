package com.example.dineasy;

import android.widget.Button;

public class Basic_User extends user {
    String payment_method[];
    Button Search;

    public Basic_User(int id, String name,String email,int password,int phone_num, String Firstname, String Lastname) {
        super(id, name,email, password,phone_num,Firstname,Lastname);
    }

    public String[] payment_method(){
        return payment_method;
    }

    public void onClick(Button Search){}

    public void scanQR(){}

    public void getCard(){}

    public void selectCard(){}

    public void verifyCard(){}

    public void callWaiter(){}

    public void getUserInfo(){}

    public void setPayment(){}

}
