package com.example.shruti.kaunbanegacrorepati;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity implements View.OnClickListener {

    Button play;
    TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        play=(Button)findViewById(R.id.play);
        score=(TextView)findViewById(R.id.finalsc);
        score.setText("Score: "+getIntent().getExtras().getString("score"));

        play.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(this, Quiz.class);
        startActivity(i);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
