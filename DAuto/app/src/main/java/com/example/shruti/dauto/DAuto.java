package com.example.shruti.dauto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class DAuto extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout rl;
    AutoCompleteTextView emailId;
    ArrayAdapter<String> ad;
    String email[]={"Shrutikatyal1997@gmail.com",
                    "Shruti@hotmail.com",
                    "NishthaGupta1197@yahoo.com",
                    "Devkatyal200@gmail.com"};
    Button login;
    EditText password;
    int i=0;
//    int j=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dauto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,email);
        rl=(RelativeLayout)findViewById(R.id.rl);

        emailId=new AutoCompleteTextView(this);
        RelativeLayout.LayoutParams p=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        p.topMargin=53;

        emailId.setLayoutParams(p);
        rl.addView(emailId);
        emailId.setHint("E-mail Id");
        emailId.setThreshold(2);
        emailId.setAdapter(ad);

        password=(EditText)findViewById(R.id.pass);
        login=(Button)findViewById(R.id.button);
        login.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dauto, menu);
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

        if(i>=2) {
            password.setText("");
            password.setEnabled(false);
            Toast.makeText(this, "No more attempts allowed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(password.getText().toString().equals("Shruti@97"))
            {
               Toast.makeText(this,"Cool!! You cracked it..",Toast.LENGTH_SHORT).show();
            }
            else
            {
                i++;
                Toast.makeText(this, "Wrong Password" + (3 - i) + " attempts left", Toast.LENGTH_SHORT).show();
                password.setText("");
                emailId.setText("");

            }

        }

    }
}
