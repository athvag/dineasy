package com.example.dineasy;

public class Order extends  Tables {
    private int order_id;
    private String order_username,order_time;
    private boolean order_status;

    public Order(int id, String name, String address, int pnum, String email, double rat) {
        super(id, name, address, pnum, email, rat);
    }

    public void setOrderStatus(Boolean status){
        this.order_status = status;
    }

    public void setPaymentPrice(){
    }

    public String getUsername(){
        return Basic_User.getUsername();
    }

    public void placeOrder(){}

    public void getOrder(){}
}
