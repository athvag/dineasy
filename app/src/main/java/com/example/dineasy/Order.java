package com.example.dineasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Order extends AppCompatActivity {
    Button coffeeButton,saladButton,pizzaButton,bevButton;
    String choices = "";
    String indPrice = "";
    double price = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);
        coffeeButton = (Button) findViewById(R.id.coffeeAdd);
        saladButton = (Button) findViewById(R.id.saladAdd);
        pizzaButton = (Button) findViewById(R.id.pizzaAdd);
        bevButton = (Button) findViewById(R.id.bevAdd);

    }
    public void add_to_list(View view){
        if (view == findViewById(R.id.coffeeAdd)){
            choices = choices + "Freddo Espresso"+"\n";
            indPrice = indPrice + "3.00 €" + "\n";
            price = price + 3;

        }
        else if (view == findViewById(R.id.saladAdd)){
            choices = choices + "Ceasar's Salad"+"\n";
            indPrice = indPrice + "6.00 €" + "\n";
            price = price + 6;

        }
        else if (view == findViewById(R.id.pizzaAdd)){
            choices = choices + "Του μερακλή"+"\n";
            indPrice = indPrice + "12.00 €" + "\n";
            price = price + 12;

        }
        else if (view == findViewById(R.id.bevAdd)){
            choices = choices + "Coca Cola" +"\n";
            indPrice = indPrice + "1.50 €" + "\n";
            price = price + 1.5;

        }
    }
    public void placeOrder(View view){
        Intent i = new Intent(Order.this,OrderDetails.class);
        Bundle bundle = new Bundle ();
        bundle.putString("indPrice",indPrice);
        bundle.putString("choices",choices);
        bundle.putDouble("price",price);
        i.putExtras(bundle);
        startActivity(i);
    }
}