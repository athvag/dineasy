package com.example.dineasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BasicBusinessActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private TextView currentuser,phoneNum;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }



    private void moveToMainScreen() {
        Intent intent = new Intent(BasicBusinessActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
        popup.inflate(R.menu.example_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                SessionManagement sessionManagement = new SessionManagement(BasicBusinessActivity.this);
                sessionManagement.removeSession();
                moveToMainScreen();
                return false;
            case R.id.item3:
                setContentView(R.layout.profile);
                currentuser = findViewById(R.id.username2);
                phoneNum = findViewById(R.id.phone);
                Bundle extras = getIntent().getExtras();
                currentuser.setText(extras.getString("Username"));
                phoneNum.setText(extras.getString("Phone"));
                Button btn = (Button) findViewById(R.id.push_button8);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.passwordcheck);
                        Button btn2 = (Button) findViewById(R.id.push_button16);
                        btn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                final EditText username,phone;
                                setContentView(R.layout.profile2);
                                username = (EditText) findViewById(R.id.username2);
                                phone = (EditText) findViewById(R.id.phone);
                                Button btn3 = (Button) findViewById(R.id.push_button8);
                                btn3.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View v) {
                                        finish();
                                        Intent intent = new Intent(BasicBusinessActivity.this, BasicUserActivity.class);
                                        setName(username.getText().toString());
                                        intent.putExtra("Username",username.getText().toString());
                                        intent.putExtra("Phone",phone.getText().toString());
                                        startActivity(intent);
                                    }
                                });
                            }
                        });
                    }
                });
                return false;
            default:
                return false;
        }
    }

    public void setName(String name){
        SessionManagement sessionManagement = new SessionManagement(BasicBusinessActivity.this);
        sessionManagement.setSESname(name);
    }
}
