package com.example.dineasy;

public class Order extends  Tables {
    private int order_id;
    private String order_username,order_time;
    private boolean order_status;

    public Order(int bid, String bemail, String busername, int bphone_num, int bpassword, String bFirstname, String bLastname,int id, String name, String address, int pnum, String email, double rat,double lat,double lon) {
        super(bid,bemail,busername,bphone_num,bpassword,bFirstname,bLastname,id, name, address, pnum, email, rat,lat,lon);
    }

    public void setOrderStatus(Boolean status){
        this.order_status = status;
    }

    public void setPaymentPrice(){
    }

    public static String getUsername(){
        return user.getUsername();
    }

    public void placeOrder(){}

    public void getOrder(){}
}
