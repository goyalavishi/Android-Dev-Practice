package com.github.florent37.materialviewpager.sample.bookcrow;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.materialviewpager.sample.R;
import com.github.florent37.materialviewpager.sample.viewPager.MainActivity;

public class LogIn extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    Switch show_password;
    EditText username,pass;
    Button logIn,sign;
    TextView error;
    static String user,password;
    public static int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        error=(TextView)findViewById(R.id.error);
        username= (EditText) findViewById(R.id.username);       //username=email
        pass=(EditText)findViewById(R.id.pass);
        logIn=(Button)findViewById(R.id.log);
        sign=(Button)findViewById(R.id.sign);
        show_password=(Switch)findViewById(R.id.switch1);

        show_password.setOnCheckedChangeListener(this);
        sign.setOnClickListener(this);
        logIn.setOnClickListener(this);
        user=username.getText().toString();
        password=pass.getText().toString();

    }

    @Override
    public void onClick(View v) {

        error.setText("");

        switch(v.getId())
        {
            case R.id.log:
                DataBaseOperations db=new DataBaseOperations(this);
                boolean flag=false;
                Cursor c=db.getInfo();
                pos=0;
                if(c.getCount()>0) {
                    c.moveToFirst();

                    do {
                        if (c.getString(2).equals(username.getText().toString()) && c.getString(1).equals(pass.getText().toString())) {
                            flag = true;
                            //Toast.makeText(this,c.getString(0)+" "+c.getString(1)+" "+c.getCount(),Toast.LENGTH_SHORT).show();
                            break;
                        }
                        pos++;
                    } while (c.moveToNext());
                }

                if(flag)
                {
                    Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
                    user=c.getString(0);
                    password=pass.getText().toString();
                    Intent i=new Intent(LogIn.this,MainActivity.class);
                    startActivity(i);
                }
                else
                {
                    error.setText("*Invalid username or password");
                }
                break;
            case R.id.sign:
                Intent i=new Intent(this,SignUp.class);
                startActivity(i);
                break;
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked)
            pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        else
        {
            pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            pass.setSelection(pass.getText().length());

        }
    }
}
