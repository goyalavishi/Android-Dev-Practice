package com.example.shruti.menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {


    EditText name,phn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name= (EditText) findViewById(R.id.edit_name);
        phn=(EditText)findViewById(R.id.edit_phn);

        final Bundle b=getIntent().getExtras();
        name.setText(b.getString(TableData.TableInfo.NAME));
        phn.setText(b.getString(TableData.TableInfo.PHONE_NUMBER));

        Button update= (Button) findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             DatabaseOperations db=new DatabaseOperations(Update.this);
                db.updateData(b.getInt(TableData.TableInfo.ID)+"",name.getText().toString(),phn.getText().toString());

                Toast.makeText(Update.this,"Contact Updated"/*+b.getInt(TableData.TableInfo.ID)+""*/,Toast.LENGTH_SHORT).show();

                new Thread(){
                    public void run()
                    {
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        finally {
                            finish();
                        }
                    }
                }.start();

            }
        });

    }

}
