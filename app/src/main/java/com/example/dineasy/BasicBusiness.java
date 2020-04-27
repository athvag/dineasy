package com.example.dineasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BasicBusiness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_business);
        Button btn = (Button) findViewById(R.id.push_button5);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                openBBC();
            }

        });
        Button btn2 = (Button) findViewById(R.id.push_button5);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                openBBC2();
            }

        });
    }

    public void openBBC(){
        Intent intent = new Intent(this, BusinessCreation.class);
        startActivity(intent);
    }
    public void openBBC2(){
        Intent intent = new Intent(this, ManageBusiness.class);
        startActivity(intent);
    }

}
