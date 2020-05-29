package com.example.dineasy;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Popup extends MapsActivity {
    private TextView BusName;
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
}