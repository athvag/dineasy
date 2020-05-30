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

import java.util.ArrayList;

public class BasicUserActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private TextView currentuser,phoneNum;
    private TextView coffee,salads,pizza,bev;
    com.example.dineasy.Menu m = new com.example.dineasy.Menu(3,"1234","as",1234,123,"12","12",12,"12","12",12,"12",12,12,2,"12","1", 1);
    ArrayList<String> me = m.getList();
    int n=1;
    Button coffeeButton,saladButton,pizzaButton,bevButton;
    String choices = "";
    String indPrice = "";
    double price = 0.00;
    private Bundle savedInstanceState1;

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
        n=2;
    }
    public void moveMap(View view) {
        Intent intent = new Intent(BasicUserActivity.this, Map.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
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
            n=1;
            setContentView(R.layout.basic_user);

            //Intent intent = new Intent(basic_user.this, basic_user.class);
            //startActivity(intent);
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onBackPressed() {
        if (n == 1) {

            Toast.makeText(BasicUserActivity.this,"Επιλέξτε Αποσύνδεση για να επιστρεψετε στην αρχική οθόνη", Toast.LENGTH_LONG).show();

        }else if(n == 2){
            n = 1;
            setContentView(R.layout.basic_user);

        }
        else if(n == 3){
            n = 2;
            setContentView(R.layout.basic_user_after_qr);

        }

    }
    private void moveToMainScreen() {
        Intent intent = new Intent(BasicUserActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }



    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.example_menu);
        popup.show();
    }
    public void showMenu(View view){
        n=3;
        setContentView(R.layout.menu);
        coffee = findViewById(R.id.Freddo);
        salads = findViewById(R.id.Ceasars);
        pizza = findViewById(R.id.PizzaName);
        bev = findViewById(R.id.bevName);
        coffee.setText(me.get(0));
        salads.setText(me.get(1));
        pizza.setText(me.get(2));
        bev.setText(me.get(3));
    }

    @Override
    public boolean onMenuItemClick(final MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                SessionManagement sessionManagement = new SessionManagement(BasicUserActivity.this);
                sessionManagement.removeSession();
                n=2;
                moveToMainScreen();
                return false;
            case R.id.item3:
                n=2;
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
                                            Intent intent = new Intent(BasicUserActivity.this, BasicUserActivity.class);
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
            case R.id.item4:
                Toast.makeText(BasicUserActivity.this,"Η εφαρμογή σας είναι ενημερωμένη", Toast.LENGTH_LONG).show();
                return false;
            default:
                return false;
        }
    }

    public void setName(String name){
        SessionManagement sessionManagement = new SessionManagement(BasicUserActivity.this);
        sessionManagement.setSESname(name);
    }
    //PARAGGELIA//

    public void moveToOrder(View view) {
        n=3;
        setContentView(R.layout.order);
        coffeeButton = (Button) findViewById(R.id.coffeeAdd);
        saladButton = (Button) findViewById(R.id.saladAdd);
        pizzaButton = (Button) findViewById(R.id.pizzaAdd);
        bevButton = (Button) findViewById(R.id.bevAdd);
    }

    public void add_to_list(View view){
        if (view == findViewById(R.id.coffeeAdd)){
            choices = choices +me.get(0)+"\n";
            indPrice = indPrice + "3.00 €" + "\n";
            price = price + 3;
            Toast.makeText(BasicUserActivity.this,"Προστέθηκε στη παραγγελία: "+ me.get(0), Toast.LENGTH_SHORT).show();
        }
        else if (view == findViewById(R.id.saladAdd)){
            choices = choices + me.get(1)+"\n";
            indPrice = indPrice + "6.00 €" + "\n";
            price = price + 6;
            Toast.makeText(BasicUserActivity.this,"Προστέθηκε στη παραγγελία: "+ me.get(1), Toast.LENGTH_SHORT).show();
        }
        else if (view == findViewById(R.id.pizzaAdd)){
            choices = choices + me.get(2)+"\n";
            indPrice = indPrice + "12.00 €" + "\n";
            price = price + 12;
            Toast.makeText(BasicUserActivity.this,"Προστέθηκε στη παραγγελία: "+ me.get(2), Toast.LENGTH_SHORT).show();
        }
        else if (view == findViewById(R.id.bevAdd)){
            choices = choices + me.get(3) +"\n";
            indPrice = indPrice + "1.50 €" + "\n";
            price = price + 1.5;
            Toast.makeText(BasicUserActivity.this,"Προστέθηκε στη παραγγελία: "+ me.get(3), Toast.LENGTH_SHORT).show();
        }
    }
    public void placeOrder(View view){
        Intent i = new Intent(BasicUserActivity.this,OrderDetails.class);
        Bundle bundle = new Bundle ();
        bundle.putString("indPrice",indPrice);
        bundle.putString("choices",choices);
        bundle.putDouble("price",price);
        i.putExtras(bundle);
        startActivity(i);
    }
    public void startPayment(View view) {
        if (Payment.payment_id != 0) {
            Intent y = new Intent(BasicUserActivity.this, PaymentDetails.class);
            Bundle bundle = new Bundle();
            bundle.putString("indPrice", indPrice);
            bundle.putString("choices", choices);
            bundle.putDouble("price", price);
            y.putExtras(bundle);
            startActivity(y);
        } else {
            Toast.makeText(BasicUserActivity.this, "Παρακαλώ επιλέξτε Παραγγελία", Toast.LENGTH_SHORT).show();
        }
    }

}
