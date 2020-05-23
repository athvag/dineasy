package com.example.dineasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText Password;
    private Button Login;
    private TextView Info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login2);
        username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.push_button13);
        Info = (TextView) findViewById(R.id.textError);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                validate(username.getText().toString(),Password.getText().toString());
           }
      });
    }

    @Override
    protected void onStart() {
        super.onStart();

       checkSession();

    }

    private void checkSession() {
        //check if user is logged in
        //if user is logged in move to basic user
        SessionManagement sessionManagement = new SessionManagement(LoginActivity.this);
        int userID = sessionManagement.getSession();
        if(userID != -1){
            //user is logged in and move to next
            if (userID ==1) {
                moveToNextActivity();
            }
            else {
                moveToNextActivity2();
            }
        }
        else{
            //do nothing
        }
    }
   private void validate(String username, String password){
        if((username.equals ("admin")) && (password.equals  ("1234"))){
            user user = new user(1,"temp");
            SessionManagement sessionManagement = new SessionManagement(LoginActivity.this);
            sessionManagement.saveSession(user);
            //2
            moveToNextActivity();
      }
        else if((username.equals ("user")) && (password.equals  ("1234"))){
            user user = new user(2,"temp");
            SessionManagement sessionManagement = new SessionManagement(LoginActivity.this);
            sessionManagement.saveSession(user);

            //2
            moveToNextActivity2(); }

        else {
       Info.setText("Λαθος Όνομα Χρήστη/Κωδικός.");
        }
    }

    private void moveToNextActivity2() {
        Intent intent = new Intent(LoginActivity.this, BasicUserActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        SessionManagement sessionManagement = new SessionManagement(LoginActivity.this);
        String username= sessionManagement.getSESname();
        intent.putExtra("Username",username);
        startActivity(intent);
    }


    private void moveToNextActivity() {
        Intent intent = new Intent(LoginActivity.this, BasicBusinessActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        SessionManagement sessionManagement = new SessionManagement(LoginActivity.this);
        String username= sessionManagement.getSESname();
        intent.putExtra("Username",username);
        startActivity(intent);
    }

    public String getName(){
        return user.username;
    }
}
