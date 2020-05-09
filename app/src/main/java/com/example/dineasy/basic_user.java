package com.example.dineasy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class basic_user extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_user);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);
    }
    public void scanButton(View view){
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        intentIntegrator.setPrompt("Scan the table's barcode");
        intentIntegrator.setOrientationLocked(false);
        intentIntegrator.setBeepEnabled(false);
        intentIntegrator.initiateScan();



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        String scanContent = scanningResult.getContents();
        if(scanContent != null){
        if(scanContent.equals ("1234")){

               Intent intent = new Intent(basic_user.this, basic_user_after_qr.class);
               startActivity(intent);
           }
        else{
            Intent intent = new Intent(basic_user.this, basic_user.class);
            startActivity(intent);
        }}
        else{
            Intent intent = new Intent(basic_user.this, basic_user.class);
            startActivity(intent);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
    public void logout(View view){
        //this method will remove session and open login screen
        SessionManagement sessionManagement = new SessionManagement(basic_user.this);
        sessionManagement.removeSession();

        moveToMainScreen();
    }

    private void moveToMainScreen() {
        Intent intent = new Intent(basic_user.this,Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
