package com.github.florent37.materialviewpager.sample.bookcrow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.florent37.materialviewpager.sample.R;

public class Settings extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ArrayAdapter adp;
        list=(ListView)findViewById(R.id.listView2);
        String s[]={"Change your prefrences", "Change password"};
        adp=new ArrayAdapter(this,android.R.layout.simple_list_item_1,s);
        list.setAdapter(adp);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,[position-1],Toast.LENGTH_SHORT).show();
    }
}

