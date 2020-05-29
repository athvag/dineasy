package com.example.dineasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.security.Key;

public class OrderDetails extends AppCompatActivity {
TextView listView,priceView,indPriceView;
String list_choice;
String price_choice;
Double price_bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        listView = (TextView) findViewById(R.id.listView);
        priceView = (TextView) findViewById(R.id.priceView);
        indPriceView = (TextView) findViewById(R.id.indpriceview);

        Bundle bundle = getIntent().getExtras();
        list_choice = bundle.getString("choices");
        price_bd = bundle.getDouble("price");
        price_choice = bundle.getString("indPrice");

        indPriceView.setText(price_choice);
        listView.setText(list_choice);
        priceView.setText("Συνολική τιμή " + price_bd.toString() + "€");

        Payment payment = new Payment(1, price_bd.toString(), false);

    }

}