package com.example.avishigoyal.dynamiclist;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<ListData> myList;
    ImageView image;
    Bitmap bitmap;
    EditText t,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        myList= new ArrayList<>();
        image = (ImageView)findViewById(R.id.image);
        t=(EditText)findViewById(R.id.title);
        d=(EditText)findViewById(R.id.desc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addContact(View v){

        setList();
        Toast.makeText(this,"Contact added",Toast.LENGTH_LONG);

    }

    public void showContact(View v){

        Intent i=new Intent(this,Contacts.class);
        startActivity(i);

    }


    public void pickImage(View v){


        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i,1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1&&resultCode== Activity.RESULT_OK){

            try{
                if(bitmap!=null)
                {
                    bitmap.recycle();
                }
                InputStream s=getContentResolver().openInputStream(data.getData());
                bitmap= BitmapFactory.decodeStream(s);
                assert s != null;
                s.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setList(){

        String s1=t.getText().toString();
        String s2=d.getText().toString();

        ListData l=new ListData();
        l.setTitle(s1);
        l.setDiscription(s2);
        l.setImage(bitmap);

        myList.add(l);


    }
}
