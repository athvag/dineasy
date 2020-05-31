package com.example.dineasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentDetails extends AppCompatActivity {
    TextView listView,priceView,indPriceView,tableID;
    String list_choice;
    String price_choice;
    Double price_bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
        listView = (TextView) findViewById(R.id.listView3);
        priceView = (TextView) findViewById(R.id.priceView2);
        indPriceView = (TextView) findViewById(R.id.indpriceview2);

        Bundle bundle = getIntent().getExtras();
        list_choice = bundle.getString("choices");
        price_bd = bundle.getDouble("price");
        price_choice = bundle.getString("indPrice");
        tableID = findViewById(R.id.textView24);
        tableID.setText(Tables.code);
        indPriceView.setText(price_choice);
        listView.setText(list_choice);
        priceView.setText("Συνολική τιμή " + price_bd.toString() + "€");



    }
    public void completePayment(View view){
        Payment.payment_status = true;
        Intent intent = new Intent(PaymentDetails.this, BasicUserActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        Toast.makeText(PaymentDetails.this, "Η πληρωμή σας με ID: " + Payment.payment_id + " ήταν επιτυχής " , Toast.LENGTH_SHORT).show();

    }
    }