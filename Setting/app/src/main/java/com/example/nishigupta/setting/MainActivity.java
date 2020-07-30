package com.example.nishigupta.setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    char gen = 'f';
    ImageView avatar;
    //RelativeLayout rel;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        ArrayAdapter adp;
        list = (ListView) findViewById(R.id.listView);
        String s[] = {"My Preferences", "Leased Books", "Rented Books", "Settings", "Logout"};
        adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, s);
        //rel=(RelativeLayout)findViewById(R.id.relative);
        avatar = (ImageView) findViewById(R.id.imageView);

        if (gen == 'f') {
            // rel.setBackgroundColor(Color.parseColor("#5093ff"));
            avatar.setImageDrawable(getResources().getDrawable(R.drawable.girl));
        } else {
            avatar.setImageDrawable(getResources().getDrawable(R.drawable.boy));
            //rel.setBackgroundColor(Color.parseColor("#5093ff"));
        }
        list.setAdapter(adp);
        list.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,[position-1],Toast.LENGTH_SHORT).show();
        if(position==0)
        {
            Intent inent = new Intent(this, Preference.class);
            startActivity(inent);
        }
        else if(position==1)
        {
            Intent inent = new Intent(this, LeasedBook.class);
            startActivity(inent);
        }
        else if(position==2)
        {
            Intent inent = new Intent(this, RentedBook.class);
            startActivity(inent);
        }
        else if(position ==3)
        {
            Intent inent = new Intent(this, Settings.class);
            startActivity(inent);
        }
    }
}
