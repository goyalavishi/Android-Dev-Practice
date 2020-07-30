package com.example.shruti.radio;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView bg, fg;
    RadioGroup rg1, rg2;
    RelativeLayout rl;
    Button b;
    String bcolor, fcolor;
    RadioButton rb[];

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

        rb=new RadioButton[8];
        rb[0] = (RadioButton) findViewById(R.id.black);
        rb[1] = (RadioButton) findViewById(R.id.green);
        rb[2] = (RadioButton) findViewById(R.id.pink);
        rb[3] = (RadioButton) findViewById(R.id.white);
        rb[4] = (RadioButton) findViewById(R.id.black_fg);
        rb[5] = (RadioButton) findViewById(R.id.blue_fg);
        rb[6] = (RadioButton) findViewById(R.id.yellow_fg);
        rb[7] = (RadioButton) findViewById(R.id.white_fg);
        rl = (RelativeLayout) findViewById(R.id.rl);
        bg = (TextView) findViewById(R.id.bg);
        fg = (TextView) findViewById(R.id.fg);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup);
        rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        b = (Button) findViewById(R.id.button);

        b.setOnClickListener(this);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.black:
                        bcolor = "black";
                        break;
                    case R.id.pink:
                        bcolor = "pink";
                        break;
                    case R.id.white:
                        bcolor = "white";
                        break;
                    case R.id.green:
                        bcolor = "green";
                }
            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.black_fg:
                        fcolor = "black";
                        rl.setBackgroundColor(Color.MAGENTA);
                        break;
                    case R.id.yellow_fg:
                        fcolor = "yellow";
                        break;

                    case R.id.white_fg:
                        fcolor = "white";
                        break;
                    case R.id.blue_fg:
                        fcolor = "blue";
                }
            }
        });

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
    public void onClick(View v) {

       if(bcolor.equals("black"))
           rl.setBackgroundColor(Color.BLACK);
        else
           if(bcolor.equals("white"))
               rl.setBackgroundColor(Color.WHITE);
        else
               if(bcolor.equals("pink"))
                   rl.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        else
                   if(bcolor.equals("green"))
                       rl.setBackgroundColor(Color.GREEN);

        if(fcolor.equals("black"))
        {
            bg.setTextColor(Color.BLACK);
            fg.setTextColor(Color.BLACK);
            for(int i=0;i<8;i++)
                rb[i].setTextColor(Color.BLACK);
        }
        else
        if(fcolor.equals("white"))
        {
            bg.setTextColor(Color.WHITE);
            fg.setTextColor(Color.WHITE);
            for(int i=0;i<8;i++)
                rb[i].setTextColor(Color.WHITE);
        }
        else
        if(fcolor.equals("yellow"))
        {
            bg.setTextColor(Color.YELLOW);
            fg.setTextColor(Color.YELLOW);
            for(int i=0;i<8;i++)
                rb[i].setTextColor(Color.YELLOW);
        }
        else
        if(fcolor.equals("blue"))
        {
            bg.setTextColor(Color.BLUE);
            fg.setTextColor(Color.BLUE);
            for(int i=0;i<8;i++)
                rb[i].setTextColor(Color.BLUE);
        }


    }
}