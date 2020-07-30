package com.example.nishigupta.setting;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class RentedBook extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rented_book);
        ArrayAdapter adp;
        list=(ListView)findViewById(R.id.listView5);
        String s[]={"XYZ"};
        adp=new ArrayAdapter(this,android.R.layout.simple_list_item_1,s);
        list.setAdapter(adp);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,[position-1],Toast.LENGTH_SHORT).show();
    }
}

