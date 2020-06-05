package com.example.dineasy;

public class Tables{
    private int table_id,table_qr,table_capacity;
    private boolean table_status;
    static String code = "1234";

    public Tables(String code,int table_capacity,boolean table_status)
    {}

    public void setTableQR(int code){
        this.table_qr = code;
    }
    public void setTableCap(int cap){
        this.table_capacity = cap;
    }
    public void setTableStatus(boolean status){
        this.table_status = status;
    }


}