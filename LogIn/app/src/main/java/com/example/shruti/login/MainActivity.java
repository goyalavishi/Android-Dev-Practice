package com.example.shruti.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    AutoCompleteTextView user;
    ArrayAdapter<String> ad;
    String users[]={"Shruti","Shreya","Dev","Devil","Nishtha","Avishi"};
    Button login;
    ImageButton eyes;
    EditText password;
     int i=0,k=0;
//    int j=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,users);

        eyes= (ImageButton) findViewById(R.id.eyes);
        user=(AutoCompleteTextView)findViewById(R.id.user);
        user.setThreshold(1);
        user.setAdapter(ad);

        eyes.setOnClickListener(this);
        password=(EditText)findViewById(R.id.pass);
        login=(Button)findViewById(R.id.button);
        login.setOnClickListener(this);

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

        if(v.getId()==R.id.eyes)
        {
            k++;
            if(k%2==0) {
                eyes.setImageResource(R.drawable.open);
                password.setInputType(InputType.TYPE_CLASS_TEXT);
            }
                else{
                eyes.setImageResource(R.drawable.close);
                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                password.setSelection(password.getText().length());
            }
        }
        else {
            if (i >= 2) {
                password.setText("");
                password.setEnabled(false);
                Toast.makeText(this, "No more attempts allowed", Toast.LENGTH_SHORT).show();
            } else {
                if (password.getText().toString().equals("") || password.getText().toString().equals("")) {
                    Toast.makeText(this, "Enter password and username", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().equals("Shruti@97")) {
                    i = 0;
                    Intent intent = new Intent(MainActivity.this, Welcome.class);
                    intent.putExtra("name", user.getText().toString());
                    startActivity(intent);
                } else {
                    i++;
                    Toast.makeText(this, "Wrong Password" + (3 - i) + " attempts left", Toast.LENGTH_SHORT).show();
                    password.setText("");
                    user.setText("");

                }

            }
        }
    }
}
