package com.example.shruti.radio3;

import android.app.ActionBar;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout rl;
    Button hindi,eng;
    TextView text;
    RadioGroup rg;
    RadioButton r1,r2,r3;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        flag=false;
        rl=(RelativeLayout)findViewById(R.id.rl);
        hindi=(Button)findViewById(R.id.hindi);
        eng=(Button)findViewById(R.id.eng);
        text=(TextView)findViewById(R.id.text);

        hindi.setOnClickListener(this);
        eng.setOnClickListener(this);

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

        if(flag)
        {
            r1.setText("");
            r2.setText("");
            r3.setText("");

            r1.setChecked(false);
            r2.setChecked(false);
            r3.setChecked(false);
        }

        rg=(RadioGroup)new RadioGroup(this);
        r1=(RadioButton)new RadioButton(this);
        r2=(RadioButton)new RadioButton(this);
        r3=(RadioButton)new RadioButton(this);

        flag=true;
        //rg.setVisibility(R.);

        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams((int)RelativeLayout.LayoutParams.WRAP_CONTENT,(int)RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin=200;
        params.topMargin=400;

        rg.setLayoutParams(params);
        rg.addView(r1);
        rg.addView(r2);
        rg.addView(r3);

        if(v.getId()==R.id.hindi)
        {
            r1.setText("Jai Ho   (SlumDog Millionaire)");
            r2.setText("Tu Jo Mila  (Bajarangi Bhaijaan)");
            r3.setText("Ladki Beautiful  (Kapoor & Sons)");

            rl.addView(rg);

            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    if(r1.isChecked()){

                        text.setText("Jai Ho   (SlumDog Millionaire) added");
                    }
                    else
                        if(r2.isChecked())
                        {
                            text.setText("Tu Jo Mila  (Bajarangi Bhaijaan) added");
                        }
                    else
                            if(r3.isChecked())
                            {
                                text.setText("Ladki Beautiful  (Kapoor & Sons) added");
                            }

                }
            });
        }
        else
        if(v.getId()==R.id.eng)
        {
            r1.setText("Perfect  (One Direction)");
            r2.setText("Hide Away  (Daya)");
            r3.setText("Army  (Ellie Goulding)");
            rl.addView(rg);

            rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    if(r1.isChecked()){

                        text.setText("Perfect  (One Direction) added");
                    }
                    else
                    if(r2.isChecked())
                    {
                        text.setText("Hide Away  (Daya) added");
                    }
                    else
                    if(r3.isChecked())
                    {
                        text.setText("Army  (Ellie Goulding) added");
                    }

                }
            });
        }



    }
}
