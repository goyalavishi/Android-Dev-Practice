package com.example.shruti.menu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    RelativeLayout rl;
    RadioButton r1,r2;
    RadioGroup rg;
    Button button;
    TextView t,sum,tot;
    CheckBox c1,c2,c3;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
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



        flag=false;
        tot=(TextView)findViewById(R.id.total);
        sum=(TextView)findViewById(R.id.summary);
        t=(TextView)findViewById(R.id.textView);
        rg=(RadioGroup)findViewById(R.id.rg);
        r1=(RadioButton)findViewById(R.id.veg);
        r2=(RadioButton)findViewById(R.id.nveg);
        button=(Button)findViewById(R.id.button);
        rl=(RelativeLayout)findViewById(R.id.rl);

        button.setOnClickListener(this);
        rg.setOnCheckedChangeListener(this);


    }

    @Override
    public void onClick(View v) {

        if(flag)
        {
        sum.setText("Summary..");
        String s="";
        int price=0;
        if(r1.isChecked())
        {
            if(c1.isChecked())
            {
                s+="\nDal Makhani       Rs150";
                price+=150;
            }

            if(c2.isChecked())
            {
                s+="\nShahi Paneer      Rs200";
                price+=200;
            }

            if(c3.isChecked())
            {
                s+="\nSoya Chaap        Rs200";
                price+=200;
            }
        }
        else
        if(r2.isChecked())
        {
            if(c1.isChecked())
            {
                s+="\nButter Chicken        Rs450";
                price+=450;
            }

            if(c2.isChecked())
            {
                s+="\nChilli Chicken         Rs500";
                price+=500;
            }

            if(c3.isChecked())
            {
                s+="\nRogan Josh            Rs550";
                price+=550;
            }
        }


        Toast tst=Toast.makeText(this,"Thank You!! Have A Nice Day",Toast.LENGTH_SHORT);
        //tst.setMargin(1000,200);
            tst.show();

        t.setText(s);
        tot.setText("\nTotal           Rs "+price);

    }
        else
            Toast.makeText(this,"Fill your choice please!!",Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(flag) {
            c1.setText("");
            c2.setText("");
            c3.setText("");

            c1.setChecked(false);
            c2.setChecked(false);
            c3.setChecked(false);
        }

        t.setText("");
        tot.setText("");
        sum.setText("");
        c1=new CheckBox(this);
        c2=new CheckBox(this);
        c3=new CheckBox(this);
        flag=true;

        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams params2=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams params3=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.leftMargin=params2.leftMargin=params3.leftMargin=200;

        params.topMargin=500;
        params2.topMargin=550;
        params3.topMargin=600;

        if(r1.isChecked()){

            c1.setLayoutParams(params);

            c2.setLayoutParams(params2);

            c3.setLayoutParams(params3);

            c1.setText("Dal Makhani       Rs150");
            c2.setText("Shahi Paneer      Rs200");
            c3.setText("Soya Chaap        Rs200");

            rl.addView(c1);
            rl.addView(c2);
            rl.addView(c3);

        }

        else
        if(r2.isChecked()){

            c1.setLayoutParams(params);
            c2.setLayoutParams(params2);
            c3.setLayoutParams(params3);

            c1.setText("Butter Chicken       Rs450");
            c2.setText("Chilli Chicken       Rs500");
            c3.setText("Rogan Josh           Rs550");

            rl.addView(c1);
            rl.addView(c2);
            rl.addView(c3);

        }
        else
            c1.setText("Enter your choice first");

    }
}
