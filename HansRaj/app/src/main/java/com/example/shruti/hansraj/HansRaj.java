package com.example.shruti.hansraj;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class HansRaj extends AppCompatActivity implements View.OnClickListener {


    RadioButton rb1,rb2,rb3,rb4;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hans_raj);
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


        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        img=(ImageView)findViewById(R.id.image);

        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);
/*
        new Thread(){

            @Override
            public void run() {
                super.run();

                for (int j=0;j<4;j++)
                {
                    for(int i=0;i<4;i++)
                    {
                        switch(i)
                        {
                            case 0:
                                img.setImageResource(R.drawable.h1);
                                break;
                            case 1:
                                img.setImageResource(R.drawable.h3);
                                break;
                            case 2:
                                img.setImageResource(R.drawable.h2);
                                break;
                            case 3:
                                img.setImageResource(R.drawable.h4);
                                break;
                        }
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();*/

    }

    @Override
    public void onClick(View v) {

       if(rb1.isChecked())
           img.setImageResource(R.drawable.h1);
        else
           if(rb2.isChecked())
               img.setImageResource(R.drawable.h);
           else
           if(rb3.isChecked())
               img.setImageResource(R.drawable.h3);
           else
           if(rb4.isChecked())
               img.setImageResource(R.drawable.h4);
    }
}
