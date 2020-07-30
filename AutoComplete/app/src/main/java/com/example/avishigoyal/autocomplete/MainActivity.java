package com.example.avishigoyal.autocomplete;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        String choice;
        RelativeLayout rel;
        String [] colors={"Red","Green","Grey","Black"};
        Button color;
        AutoCompleteTextView autoCompleteTextView;
        //TextView textView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            color=(Button) findViewById(R.id.color);
            autoCompleteTextView=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
            rel=(RelativeLayout) findViewById(R.id.activity_main);
            ArrayAdapter adapter= new ArrayAdapter(this,android.R.layout.select_dialog_item,colors);
            autoCompleteTextView.setThreshold(1);//kitne chars baad we want hint
            autoCompleteTextView.setAdapter(adapter);
            color.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            choice=autoCompleteTextView.getText().toString();
            switch (choice)
            {
                case "Red" : rel.setBackgroundColor(Color.RED);
                    break;
                case "Green" :
                    rel.setBackgroundColor(Color.GREEN);
                    break;
                case "Grey" :
                    rel.setBackgroundColor(Color.GRAY);
                    break;
                case "Black" :rel.setBackgroundColor(Color.BLACK);
                    break;
            }
        }


}
