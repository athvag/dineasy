package com.example.dineasy;

public class Business extends Business_Owner
{

    int bus_id;
    String bus_name;
    String bus_address;
    int bus_phone_num;
    String bus_email;
    double bus_rating;

    public Business (int bid, String bemail, String busername, int bphone_num, int bpassword, String bFirstname, String bLastname,int id, String name, String address, int pnum, String email, double rat)
    {
        super(bid,bemail,busername,bphone_num,bpassword,bFirstname,bLastname);
        this.bus_id = id;
        this.bus_name = name;
        this.bus_address = address;
        this.bus_phone_num = pnum;
        this.bus_email = email;
        this.bus_rating = rat;
    }

    public void setBusName(String n)
    {
        this.bus_name = n;
    }

    public void setBusAdr(String a)
    {
        this.bus_address = a;
    }

    public void setBusNum(int bn)
    {
        this.bus_phone_num = bn;
    }

    public void setBusEmail(String e)
    {
        this.bus_email = e;
    }

    public double getBusRating ()
    {
        return bus_rating;
    }

    //public void getBooking () {}

    //public void getBusiness () {}

    public void addTable() {}
    public void editTable() {}
    public void changeMenu() {}

}
