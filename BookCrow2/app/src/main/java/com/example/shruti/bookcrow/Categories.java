package com.example.shruti.bookcrow;

import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class Categories extends AppCompatActivity implements View.OnClickListener {

    Button skip_submit; //either to skip or to submit
    FrameLayout romance,education,biographies,fiction,sci_fi,horror,mystery,drama;
    int n=0;//no of categories selected
    boolean isChecked[]={false,false,false,false,false,false,false,false};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        skip_submit= (Button) findViewById(R.id.skip);

        romance=(FrameLayout)findViewById(R.id.romance);            //0
        education= (FrameLayout) findViewById(R.id.education);      //1
        biographies=(FrameLayout)findViewById(R.id.biography);
        fiction= (FrameLayout) findViewById(R.id.fiction);
        sci_fi=(FrameLayout)findViewById(R.id.sci_fi);
        horror=(FrameLayout)findViewById(R.id.horror);
        mystery=(FrameLayout)findViewById(R.id.mystery);
        drama=(FrameLayout)findViewById(R.id.drama);                //7

        skip_submit.setOnClickListener(this);
        romance.setOnClickListener(this);
        education.setOnClickListener(this);
        biographies.setOnClickListener(this);
        fiction.setOnClickListener(this);
        sci_fi.setOnClickListener(this);
        horror.setOnClickListener(this);
        mystery.setOnClickListener(this);
        drama.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        if(v.getId()!=R.id.skip)
        {
            if(n==0)
            {
                skip_submit.setText("Submit");
            }
        }



        switch (v.getId())
        {
            case R.id.skip:
                String text=skip_submit.getText().toString();
                if(text.equalsIgnoreCase("skip"))
                {

                }
                else
                {
                    DataBaseOperations db=new DataBaseOperations(this);
                    db.update(LogIn.user,LogIn.password,isChecked);
                   /* Cursor c=db.getInfo();
                    if(c.getCount()>0) {
                        c.moveToFirst();

                        do {
                            String s="";
                            boolean flag=false;
                            if (c.getString(0).equals(LogIn.user) && c.getString(1).equals(LogIn.password)) {
                                for(int i=0;i<8;i++)
                                    s+=c.getInt(i+2)+"";
                                flag=true;
                            //    break;
                            }
                            if(flag)
                            Toast.makeText(this,s+"",Toast.LENGTH_SHORT).show();
                        } while (c.moveToNext());
                    }*/
                }
                break;

            case R.id.romance:
                if(!isChecked[0]) {
                    n++;
                    isChecked[0]=true;
                    romance.setBackgroundColor(Color.parseColor("#CC33b5e5"));
                }
                else
                {
                    n--;
                    if(n==0)
                        skip_submit.setText("Skip");
                    isChecked[0]=false;
                    romance.setBackgroundColor(Color.parseColor("#CCFFFFFF"));
                }
                break;
            case R.id.education:
                if(!isChecked[1]) {
                    n++;
                    isChecked[1]=true;
                    education.setBackgroundColor(Color.parseColor("#CC33b5e5"));
                }
                else
                {
                    n--;
                    if(n==0)
                        skip_submit.setText("Skip");
                    isChecked[1]=false;
                    education.setBackgroundColor(Color.parseColor("#CCFFFFFF"));
                }
                break;
            case R.id.biography:
                if(!isChecked[2]) {
                    n++;
                    isChecked[2]=true;
                    biographies.setBackgroundColor(Color.parseColor("#CC33b5e5"));
                }
                else
                {
                    n--;
                    if(n==0)
                        skip_submit.setText("Skip");
                    isChecked[2]=false;
                    biographies.setBackgroundColor(Color.parseColor("#CCFFFFFF"));
                }
                break;
            case R.id.fiction:
                if(!isChecked[3]) {
                    n++;
                    isChecked[3]=true;
                    fiction.setBackgroundColor(Color.parseColor("#CC33b5e5"));
                }
                else
                {
                    n--;
                    if(n==0)
                        skip_submit.setText("Skip");
                    isChecked[3]=false;
                    fiction.setBackgroundColor(Color.parseColor("#CCFFFFFF"));
                }
                break;
            case R.id.sci_fi:
                if(!isChecked[4]) {
                    n++;
                    if(n==0)
                        skip_submit.setText("Skip");
                    isChecked[4]=true;
                    sci_fi.setBackgroundColor(Color.parseColor("#CC33b5e5"));
                }
                else
                {
                    n--;
                    isChecked[4]=false;
                    sci_fi.setBackgroundColor(Color.parseColor("#CCFFFFFF"));
                }
                break;
            case R.id.horror:
                if(!isChecked[5]) {
                    n++;
                    isChecked[5]=true;
                    horror.setBackgroundColor(Color.parseColor("#CC33b5e5"));
                }
                else
                {
                    n--;
                    if(n==0)
                        skip_submit.setText("Skip");
                    isChecked[5]=false;
                    horror.setBackgroundColor(Color.parseColor("#CCFFFFFF"));
                }
                break;
            case R.id.mystery:
                if(!isChecked[6]) {
                    n++;
                    isChecked[6]=true;
                    mystery.setBackgroundColor(Color.parseColor("#CC33b5e5"));
                }
                else
                {
                    n--;
                    if(n==0)
                        skip_submit.setText("Skip");
                    isChecked[6]=false;
                    mystery.setBackgroundColor(Color.parseColor("#CCFFFFFF"));
                }
                break;
            case R.id.drama:
                if(!isChecked[7]) {
                    n++;
                    if(n==0)
                        skip_submit.setText("Skip");
                    isChecked[7]=true;
                    drama.setBackgroundColor(Color.parseColor("#CC33b5e5"));
                }
                else
                {
                    n--;
                    if(n==0)
                        skip_submit.setText("Skip");
                    isChecked[7]=false;
                    drama.setBackgroundColor(Color.parseColor("#CCFFFFFF"));
                }
                break;
        }
    }

}

