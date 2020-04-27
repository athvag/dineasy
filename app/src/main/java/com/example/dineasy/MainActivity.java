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
        setContentView(R.layout.basic_business_creation);
        Button btn = (Button) findViewById(R.id.push_button14);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                openBBC();
            }

        });
    }

    public void openBBC(){
        Intent intent = new Intent(this, BasicBusiness.class);
        startActivity(intent);
    }

}
