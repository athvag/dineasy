package com.example.dineasy;

public class Booking extends BasicUser {
    static int booking_id;
    String booking_name;
    String booking_date;
    String booking_time;
    String booking_ppl;
    int booking_phone_num;
    static int counter=0;

    public Booking (int id, String name,String email,int password,int phone_num, String Firstname, String Lastname, int bkid, String bkname, String bkdt, String bktm, String bkppl, int bknm)
    {
        super(id, name, email, password, phone_num, Firstname, Lastname);
        this.booking_name=name;
        this.booking_phone_num=phone_num;
        counter++;
        setBKID(counter);
    }

    public String getBKName()
    {
        return booking_name;
    }

    public void setBKID(int id)
    {
        this.booking_id=id;
    }

    public void setBKPpl(String a)
    {
        this.booking_ppl=a;
    }

    public void setBKPhone(int p)
    {
        this.booking_phone_num = p;
    }


}
