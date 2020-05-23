package com.example.dineasy;

public class user {
    int id;
    static String email;
    static String username="User2";
    int phone_num;
    static int password;
    String Firstname;
    String Lastname;

    public user(int id, String name) {
        this.id = id;
        this.username = name;
    }

    public int getId() {
        return id;
    }

    /*public void setId(int id) {
        this.id = id;
    }*/

    public String getUsername() {
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
