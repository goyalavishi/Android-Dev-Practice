package com.example.shruti.transitions;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewGroup v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Explode explode=new Explode();
            explode.setDuration(5000);
            getWindow().setExitTransition(explode);
        }
        setContentView(R.layout.activity_main);

        v=(ViewGroup)findViewById(R.id.activity_main);
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ActivityOptionsCompat compat=ActivityOptionsCompat.makeSceneTransitionAnimation(this,null);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(new Intent(this,B.class),compat.toBundle());
        }
        else
        {
            Toast.makeText(this,"ERRRRR",Toast.LENGTH_SHORT).show();
        }
    }
}
