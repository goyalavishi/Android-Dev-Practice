package com.example.shruti.bookcrow;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class BookCrow extends AppCompatActivity implements View.OnClickListener {

    LinearLayout l;
    ImageView logo;
    Button join,logIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        l=(LinearLayout)findViewById(R.id.linear);
        logo=(ImageView)findViewById(R.id.pic);
        join=(Button)findViewById(R.id.join);
        logIn=(Button)findViewById(R.id.logbtn);



        new Thread(){
            public void run()
            {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {

                    l.setVisibility(View.GONE);
                    //logo.setVisibility(View.VISIBLE);
                    //join.setVisibility(View.VISIBLE);
                   // logo.setEnabled(true);
                   // join.setEnabled(true);
                   // logIn.setVisibility(View.VISIBLE);
                }
            }
        }.start();

        join.setOnClickListener(this);
        logIn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_crow, menu);
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

    @Override
    public void onClick(View v) {

        Intent i=new Intent(this,LogIn.class);
        startActivity(i);
    }
}
