package com.example.dineasy;

public class Business_Owner extends user
{
    int business_owner_id;

    public Business_Owner(int id, String email, String username, int phone_num, int password, String Firstname, String Lastname)
    {
        super(id, email, username, phone_num, password, Firstname, Lastname );
        this.business_owner_id=id;
    }
}