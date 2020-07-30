package com.example.avishigoyal.contactlist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ArrayList<ListData> myList;
    String title[];
    String desc[];
    int imageId[];

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

        myList=new ArrayList<ListData>();
       title =new String[]{
                "title 1","title 2","title 3"
        };

        desc=new String[]{
                "desc 1","desc 2","desc 3"
        };
        imageId=new int[]{
                R.drawable.noti,R.drawable.msg,R.drawable.noti
        };

        setListData();
        ListView l=(ListView)findViewById(R.id.listView);
        MyAdapter adapt=new MyAdapter(this,myList);
        l.setAdapter(adapt);

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


    void setListData(){

        for(int i=0;i<3;i++){
            ListData l=new ListData();

            l.setTitle(title[i]);
            l.setDiscription(desc[i]);
            l.setImageId(imageId[i]);
            l.setTime(new Date().toLocaleString());

            myList.add(l);
        }




    }
}
