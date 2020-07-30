package com.example.shruti.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int images[]={R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5};
    int index=0;
    int size=images.length;
    ImageButton back,forward;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img=(ImageView)findViewById(R.id.imageView);
        back=(ImageButton)findViewById(R.id.back);
        forward=(ImageButton)findViewById(R.id.forward);

        back.setOnClickListener(this);
        forward.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(index==1)
            back.setEnabled(false);
        else
        if(!back.isEnabled())
            back.setEnabled(true);

        if(index==size-2)
            forward.setEnabled(false);
        else
        if(!forward.isEnabled())
            forward.setEnabled(true);

        switch(view.getId())
        {
            case R.id.back:
                img.setImageResource(images[--index]);
                break;
            case R.id.forward:
                img.setImageResource(images[++index]);
                break;
        }


    }
}
