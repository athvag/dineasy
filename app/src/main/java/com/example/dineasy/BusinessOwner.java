package com.example.dineasy;

public class BusinessOwner extends User
{
    int business_owner_id;

    public BusinessOwner(int id, String email, String username, int phone_num, int password, String Firstname, String Lastname)
    {
        super(id, email, username, phone_num, password, Firstname, Lastname );
        this.business_owner_id=id;
    }
}