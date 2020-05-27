package com.example.dineasy;

public class Waiter extends Business {
    int waiter_id;
    public static int counter=0;

    public Waiter(int bid, String bemail, String busername, int bphone_num, int bpassword, String bFirstname, String bLastname,int id, String name, String address, int pnum, String email, double rat)
    {
        super(bid,bemail,busername,bphone_num,bpassword,bFirstname,bLastname,id, name, address, pnum, email, rat);
        counter++;
        this.waiter_id = id*100+counter;
    }
}
