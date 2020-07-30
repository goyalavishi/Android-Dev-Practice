package com.example.shruti.menus;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    static DatabaseOperations db;
    String s;
    static ListView list;
    static ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db=new DatabaseOperations(this);
        //db.insert("Avishi","67899998");
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,db.getInfo());


        //arrayAdapter.add("Shruti");
        //arrayAdapter.add("Sanjay");
        //arrayAdapter.add("Nishtha");

        list=(ListView)findViewById(R.id.listView);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(this);
        registerForContextMenu(list);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        //Getting item from listView on which contextmenu was called
        ListView lv = (ListView) v;
        AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
        s= (String) lv.getItemAtPosition(acmi.position);
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select the Action");
        getMenuInflater().inflate(R.menu.options,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        //Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
        switch(item.getItemId())
        {
            case R.id.call:
                Toast.makeText(this,"Calling"+ " "+s,Toast.LENGTH_SHORT).show();
                break;
            case R.id.sms:
                Toast.makeText(this,"Sending a text to "+s,Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);

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
       // if (id == R.id.action_settings) {
         //   return true;
        //}

        if (id==R.id.newContact)
        {
            Intent i=new Intent(this,AddNewContact.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        Cursor c=db.getInformation();
        if(c.getCount()>0)
        {
            c.moveToPosition(position);
            if (c.getString(1).equals(parent.getItemAtPosition(position)))
            {
                Intent i = new Intent(this, ViewContact.class);
                i.putExtra(TableData.TableInfo.ID, c.getInt(0));
                startActivity(i);
            }
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,db.getInfo());
        list.setAdapter(arrayAdapter);
    }
}
