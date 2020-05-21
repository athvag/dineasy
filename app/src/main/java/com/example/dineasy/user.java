package com.example.dineasy;

public class user {
    int id;
    String email;
    String username;
    int phone_num;
    int password;
    String Firstname;
    String Lastname;

    public user(int id, String name) {
        this.id = id;
        this.username = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }
}
