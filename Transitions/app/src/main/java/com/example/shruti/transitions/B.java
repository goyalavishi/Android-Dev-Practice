package com.example.shruti.transitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;

public class B extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Slide slide=new Slide();
            slide.setDuration(5000);
            getWindow().setEnterTransition(slide);
        }
        setContentView(R.layout.activity_b);
    }
}
