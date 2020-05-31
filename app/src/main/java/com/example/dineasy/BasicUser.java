package com.example.dineasy;

public class BasicUser extends User {
    String payment_method[];


    public BasicUser(int id, String name, String email, int password, int phone_num, String Firstname, String Lastname) {
        super(id, name,email, password,phone_num,Firstname,Lastname);
    }

    public String[] payment_method(){
        return payment_method;
    }

}
