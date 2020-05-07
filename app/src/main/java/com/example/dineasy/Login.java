package com.example.dineasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login2);

        Button btn3 = (Button) findViewById(R.id.push_button13);
        btn3.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                openBBC3();
            }
        });
    }

    public void openBBC3(){
        Intent intent = new Intent(this, basic_user.class);
        startActivity(intent);
    }
}
