package com.example.dineasy;

public class Payment extends OrderDetails{
    int payment_id;
    String payment_price;
    boolean payment_status;

    public Payment(int id, String price, boolean status)
    {
        this.payment_id =id;
        this.payment_price = price;
        this.payment_status = status;
    }

    public void setPayment_status(boolean status)
    {
        this.payment_status = status;
    }
}
