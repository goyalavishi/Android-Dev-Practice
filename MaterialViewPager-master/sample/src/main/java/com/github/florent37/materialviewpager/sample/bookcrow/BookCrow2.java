package com.github.florent37.materialviewpager.sample.bookcrow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.florent37.materialviewpager.sample.R;

public class BookCrow2 extends AppCompatActivity implements View.OnClickListener {

    Button logIn,join;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_crow2);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        logIn=(Button)findViewById(R.id.logbtn);
        join=(Button)findViewById(R.id.join);

        logIn.setOnClickListener(this);
        join.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.logbtn:
                Intent i=new Intent(BookCrow2.this,LogIn.class);
                startActivity(i);
                break;

            case R.id.join:
                Intent j=new Intent(BookCrow2.this,SignUp.class);
                startActivity(j);
                break;

        }

    }
}
