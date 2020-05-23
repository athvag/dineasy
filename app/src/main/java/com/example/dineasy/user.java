package com.example.dineasy;

public class user {
    int id;
    static String email;
    static String username="User2";
    static int phone_num;
    static int password;
    String Firstname;
    String Lastname;

    public user(int id, String name) {
        this.id = id;
        this.username = name;
    }
    public user(int id, String email, String name, int pnum, int pwd, String First, String Last) {
        this.id = id;
        this.email= email;
        this.username = name;
        this.phone_num = pnum;
        this.password = pwd;
        this.Firstname = First;
        this.Lastname = Last;
    }

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    public static String getUsername() {
        return username;
    }

    /*public void setName(String name) {
        this.username = name;
    }*/

    public String getEmail(){
        return email;
    }

    public int getPassword(){
        return password;
    }

    public int getPhone(){
        return phone_num;
    }

    public void setEmail(String email){
        user.email = email;
    }

    public void setPhone(int PhNum){
        this.phone_num = PhNum;
    }

    public void checkPassword(){}


}


