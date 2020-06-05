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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
                        //TRAPEZIA//
                        createExampleList();
                        buildRecyclerView();

                        buttonInsert = findViewById(R.id.button_insert);
                        editTextInsert = findViewById(R.id.edittetxt_insert);
                        buttonInsert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int id = Integer.parseInt(editTextInsert.getText().toString());
                                int position = 0;
                                insertItem(position,id);
                            }
                        });
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

    @Override
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

                Toast.makeText(BasicBusinessActivity.this,"Επιλέξτε Αποσύνδεση για να επιστρεψετε στην αρχική οθόνη", Toast.LENGTH_LONG).show();
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
    public boolean onMenuItemClick(final MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                SessionManagement sessionManagement = new SessionManagement(BasicBusinessActivity.this);
                sessionManagement.removeSession();
                k=1;
                moveToMainScreen();
                return false;
            case R.id.item3:
                k=1;
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
                                        Intent intent = new Intent(BasicBusinessActivity.this, BasicBusinessActivity.class);
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
                Toast.makeText(BasicBusinessActivity.this,"Η εφαρμογή σας είναι ενημερωμένη", Toast.LENGTH_LONG).show();
                return false;
            default:
                return false;
        }
    }

    public void setName(String name){
        SessionManagement sessionManagement = new SessionManagement(BasicBusinessActivity.this);
        sessionManagement.setSESname(name);
    }
    //TRAPEZIA
    private ArrayList<TablesAdd> mExampleList;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;
    private EditText editTextInsert;

    public void insertItem(int position,int id){
        mExampleList.add(position, new TablesAdd(R.drawable.ic_tables,"Table ID: " + id, "Number of people:",R.drawable.ic_delete));
        mAdapter.notifyItemInserted(position);
        editTextInsert = findViewById(R.id.edittetxt_insert);
        Tables t = new Tables(editTextInsert.getText().toString(),5,false);
    }
    public void removeItem(int position){
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }


    public void createExampleList(){
        mExampleList = new ArrayList<>();
        // mExampleList.add(new ExampleItem(R.drawable.ic_tables,"Line 1","Line 2",R.drawable.ic_delete));
        //mExampleList.add(new ExampleItem(R.drawable.ic_tables,"ΕΠΕΣΕ Ο","ΑΡΗΣ",R.drawable.ic_delete));
    }
    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mExampleList.get(position);
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }
 
}
