package com.example.shruti.radiobutton1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup rg;
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

        rg=(RadioGroup)findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(this);

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

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch(checkedId)
        {
            case R.id.art:
                Toast.makeText(this,"You have selected Arts..Opinion recorded",Toast.LENGTH_SHORT).show();
                break;

            case R.id.maths:
                Toast.makeText(this,"You have selected Maths..Opinion recorded",Toast.LENGTH_SHORT).show();
                break;

            case R.id.history:
                Toast.makeText(this,"You have selected History..Opinion recorded",Toast.LENGTH_SHORT).show();
                break;

            case R.id.literature:
                Toast.makeText(this,"You have selected Literature..Opinion recorded",Toast.LENGTH_SHORT).show();
                break;

            case R.id.science:
                Toast.makeText(this,"You have selected Science..Opinion recorded",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
