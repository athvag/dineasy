package com.example.dineasy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class basic_user extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private TextView currentuser,phoneNum;
    int k=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_user);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);
    }
    public void scanButton(View view){
       /* IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setPrompt("Scan the table's barcode");
        intentIntegrator.setOrientationLocked(false);
        intentIntegrator.setBeepEnabled(false);
        intentIntegrator.initiateScan(); */
        setContentView(R.layout.basic_user_after_qr);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String scanContent = scanningResult.getContents();
        if(scanContent == null){
        //if(scanContent.equals ("1234")){

              // Intent intent = new Intent(basic_user.this, basic_user_after_qr.class);
               //startActivity(intent);
            setContentView(R.layout.basic_user_after_qr);

           }
        else{
            setContentView(R.layout.basic_user);
            //Intent intent = new Intent(basic_user.this, basic_user.class);
            //startActivity(intent);
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    private void moveToMainScreen() {
        Intent intent = new Intent(basic_user.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.example_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(final MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                SessionManagement sessionManagement = new SessionManagement(basic_user.this);
                sessionManagement.removeSession();
                moveToMainScreen();
            case R.id.item3:
                final int[] flag = new int[1];
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
                                    setContentView(R.layout.profile);
                                    username = (EditText) findViewById(R.id.username2);
                                    phone = (EditText) findViewById(R.id.phone);
                                    Button btn3 = (Button) findViewById(R.id.push_button8);
                                    btn3.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View v) {
                                            finish();
                                            Intent intent = new Intent(basic_user.this,basic_user.class);
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
            default:
                return false;
        }
    }

    public void setName(String name){
        user.username = name;
    }
}
