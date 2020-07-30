package com.example.avishigoyal.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String msg = "Activity State: ";

    /*when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, " onCreate()");
    }

    /*when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, " onStart()");
    }

    /*when the activity becomes visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, " onResume()");
    }

    /* when the current activity is being paused and the previous activity is being resumed. */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, " onPause()");
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, " onStop()");
    }

    //Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }
}
