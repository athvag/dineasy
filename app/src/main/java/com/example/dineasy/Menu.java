package com.example.dineasy;

public class Menu extends Business{
    String dish_name;
    String dish_category;
    float price;

    public Menu(int bid, String bemail, String busername, int bphone_num, int bpassword, String bFirstname, String bLastname,int id, String name, String address, int pnum, String email, double rat,String onoma,String kathgoria,float timh) {
        super(bid,bemail,busername,bphone_num,bpassword,bFirstname,bLastname,id, name, address, pnum, email, rat);
        this.dish_name = onoma;
        this.dish_category = kathgoria;
        this.price = timh;
    }


    public void setDishName(String o) {
        this.dish_name = o;
    }

    public void setDishCat(String c) {
        this.dish_category = c;
    }

    public void setPrice(float p) {
        this.price = p;
    }

    public String getDishName() {
        return dish_name;
    }

    public String getDishCat() {
        return dish_category;
    }

    public float getDishPrice() {
        return price;
    }

}
