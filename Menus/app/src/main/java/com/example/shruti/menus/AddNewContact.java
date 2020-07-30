package com.example.shruti.menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class AddNewContact extends AppCompatActivity {

    EditText name,phn;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name=(EditText)findViewById(R.id.name);
        phn=(EditText)findViewById(R.id.editText);
        b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(AddNewContact.this,b);
                popupMenu.getMenuInflater().inflate(R.menu.save,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.sim1:
                                Toast.makeText(AddNewContact.this, "Saving contact to SIM1", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.sim2:
                                Toast.makeText(AddNewContact.this, "Saving contact to SIM2", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.Sd:
                                Toast.makeText(AddNewContact.this, "Saving contact to SD card", Toast.LENGTH_SHORT).show();
                                break;
                        }

                        return false;
                    }
                });
                popupMenu.show();
               // MainActivity.arrayAdapter.add(name.getText().toString());
                //MainActivity.list.setAdapter(MainActivity.arrayAdapter);

                new Thread() {
                    @Override
                    public void run() {

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        finally {

                             MainActivity.db=new DatabaseOperations(AddNewContact.this);
                            MainActivity.db.insert(name.getText().toString(),phn.getText().toString());
                            finish();
                        }

                    }
                }.start();
            }
        });
    }

}
