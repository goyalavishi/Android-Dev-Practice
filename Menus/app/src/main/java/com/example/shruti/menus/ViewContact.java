package com.example.shruti.menus;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewContact extends AppCompatActivity {

    TextView name,phn;
    String cname,mobile;
    int idu;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle b=getIntent().getExtras();
        idu= b.getInt(TableData.TableInfo.ID);

        DatabaseOperations db=new DatabaseOperations(this);
        name=(TextView)findViewById(R.id.contact_name);
        phn=(TextView)findViewById(R.id.mobile);
       delete=(Button)findViewById(R.id.delete);
        Cursor c=db.getInformation();
        while(c.moveToNext())
        {
            if(c.getInt(0)==idu)
            {
             //   Toast.makeText(this,idu+"",Toast.LENGTH_SHORT).show();
                cname=c.getString(1);
                mobile=c.getString(2);
                break;
            }
        }

        name.setText(cname);
        phn.setText(mobile);

        final AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setTitle("Delete contact");
        adb.setMessage("Are you sure,you want to delete this contact?");
        adb.setPositiveButton("Delete any ways?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(ViewContact.this,"Deleting",Toast.LENGTH_SHORT).show();
                new Thread(){
                    @Override
                    public void run() {
                        //super.run();

                        DatabaseOperations db=new DatabaseOperations(ViewContact.this);
                        db.deleteData(idu+"");

                        try {
                            Thread.sleep(1000);
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
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            adb.show();
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id==R.id.updat)
        {
            Intent i=new Intent(this,Update.class);
            i.putExtra(TableData.TableInfo.ID,idu);
            i.putExtra(TableData.TableInfo.NAME,cname);
            i.putExtra(TableData.TableInfo.PHONE_NUMBER,mobile);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
