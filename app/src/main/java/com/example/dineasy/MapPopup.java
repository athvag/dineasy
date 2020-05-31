package com.example.dineasy;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.dineasy.User.email;
import static com.example.dineasy.User.password;
import static com.example.dineasy.User.phone_num;

public class MapPopup extends Map {
    private TextView BusName;
    private EditText date, time, num;
    private TextView coffee,salads,pizza,bev;
    com.example.dineasy.Menu m = new com.example.dineasy.Menu(3,"1234","as",1234,123,"12","12",12,"12","12",12,"12",12,12,2,"12","1", 1);
    ArrayList<String> me = m.getList();
    int n = 0;
    Business B = new Business(1,"2","3",4,5,"6","7",8,"Los Amigos","1",5,"1",1,38.392069,23.881827);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        n=1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_window);
        BusName = findViewById(R.id.textView19);
        BusName.setText(B.bus_name);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width*.9),(int)(height*.5));

    }

    public void showMenu(View view){
        n=2;
        setContentView(R.layout.menu);
        coffee = findViewById(R.id.Freddo);
        salads = findViewById(R.id.Ceasars);
        pizza = findViewById(R.id.PizzaName);
        bev = findViewById(R.id.bevName);
        coffee.setText(me.get(0));
        salads.setText(me.get(1));
        pizza.setText(me.get(2));
        bev.setText(me.get(3));
    }

    public void onBackPressed() {
        if(n==2){
            setContentView(R.layout.popup_window);
        }
    }

    public void pressBooking(View view)
    {
        n=2;
        setContentView(R.layout.booking);
    }

    public void createBooking(View view)
    {
        SessionManagement sessionManagement = new SessionManagement(MapPopup.this);
        int userID = sessionManagement.getSession();
        String username = sessionManagement.getSESname();
        date = findViewById(R.id.editTextDate3);
        time = findViewById(R.id.editTextTime2);
        num = findViewById(R.id.editTextTextPersonName2);
        Booking bk = new Booking(userID, User.username, email, password, phone_num, User.Firstname, User.Lastname, Booking.booking_id, User.username, date.getText().toString(), time.getText().toString(), num.getText().toString(), phone_num);
        this.finish();
        Intent intent = new Intent(MapPopup.this, BasicUserActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        Toast.makeText(MapPopup.this, "Αγαπητέ " + username + "\nΗ κράτησή σας ήταν επιτυχής " + "\nΗμερομηνία: " +date.getText().toString() + "\nΏρα: " + time.getText().toString() + "\nΑριθμός Ατόμων: " + num.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    public void checkBooking() {}
}