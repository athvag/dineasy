package com.example.dineasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login2);
        Name = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.push_button13);
        Info = (TextView) findViewById(R.id.textError);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }
    private void validate(String username, String password){
        if((username.equals ("admin")) && (password.equals  ("1234"))){
            Intent intent = new Intent (Login.this,basic_user.class);
            startActivity(intent);
        } else {
        Info.setText("Λάθος Όνομα Χρήστη/Κωδικός.");
        }
    }

}
