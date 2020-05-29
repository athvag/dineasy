package com.example.dineasy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import static com.example.dineasy.user.email;
import static com.example.dineasy.user.password;
import static com.example.dineasy.user.phone_num;

public class Popup extends MapsActivity {
    private TextView BusName;
    private EditText date, time, num;
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
        SessionManagement sessionManagement = new SessionManagement(Popup.this);
        int userID = sessionManagement.getSession();
        date = findViewById(R.id.editTextDate3);
        time = findViewById(R.id.editTextTime2);
        num = findViewById(R.id.editTextTextPersonName2);
        Booking bk = new Booking(userID, user.username, email, password, phone_num, user.Firstname, user.Lastname, Booking.booking_id, user.username, date.getText().toString(), time.getText().toString(), num.getText().toString(), phone_num);
        this.finish();
        Intent intent = new Intent(Popup.this, BasicUserActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        Toast.makeText(Popup.this, "Κύριε " + user.username + "\nΗ κράτησή σας ήταν επιτυχής " + "\nΗμερομηνία: " +date.getText().toString() + "\nΏρα: " + time.getText().toString() + "\nΑριθμός Ατόμων: " + num.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}