package com.example.dineasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button btn = (Button) findViewById(R.id.push_button14);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                openBBC();
            }

        });
        Button btn2 = (Button) findViewById(R.id.push_button12);
        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                openBBC2();
            }

        });
        Button btn3 = (Button) findViewById(R.id.push_button15);
        btn3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                openBBC3();
            }

        });


    }


    public void openBBC(){
        Intent intent = new Intent(this, BasicBusinessActivity.class);
        startActivity(intent);
    }

    public void openBBC2(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void openBBC3(){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

}
