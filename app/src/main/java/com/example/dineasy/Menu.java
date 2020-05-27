package com.example.dineasy;

public class Menu {
    String dish_name;
    String dish_category;
    float price;

    public Menu (String onoma, String kathgoria, float timh){
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
