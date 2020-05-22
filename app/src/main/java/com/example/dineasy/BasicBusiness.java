package com.example.dineasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BasicBusiness extends AppCompatActivity {
    int k = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_business);
        openBBC();
    }

    public void openBBC(){
        Button btn = (Button) findViewById(R.id.push_button5);
        Button btn2 = (Button) findViewById(R.id.push_button6);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                k = 1;
                setContentView(R.layout.basic_business_creation);
                Button btn3 = (Button) findViewById(R.id.push_button9);
                btn3.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        k = 3;
                        setContentView(R.layout.basic_business_creation2);
                    }
                });
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                k = 2;
                setContentView(R.layout.manage_business);
            }
        });
    }

    public void onBackPressed() {
        if (k == 1 || k == 2) {
            k = 0;
            setContentView(R.layout.basic_business);
            openBBC();
        }else if(k == 3){
            k = 1;
            setContentView(R.layout.basic_business_creation);
        }
        else {
            super.onBackPressed();
        }
    }
}
