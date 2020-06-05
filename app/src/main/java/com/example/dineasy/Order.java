package com.example.dineasy;

public class Order extends Tables {
    private int order_id;
    private String order_username,order_time;
    private boolean order_status;

    public Order(String bemail,int bid,boolean bphone_num) {
        super(bemail,bid,bphone_num);
    }

    public void setOrderStatus(Boolean status){
        this.order_status = status;
    }

    public void setPaymentPrice(){
    }

    public static String getUsername(){
        return User.getUsername();
    }


}
