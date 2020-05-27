package com.example.dineasy;

public class Tables extends Business{
    private int table_id,table_qr,table_capacity;
    private boolean table_status;

    public Tables(int id, String name, String address, int pnum, String email, double rat) {
        super(id, name, address, pnum, email, rat);
    }

    public void setTableQR(int code){
        this.table_qr = code;
    }
    public void setTableCap(int cap){
        this.table_capacity = cap;
    }
    public void setTableStatus(boolean status){
        this.table_status = status;
    }
    public void verifyQR(){

    }
    public void getTablesInfo(){}
}
