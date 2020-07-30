package com.github.florent37.materialviewpager.sample.bookcrow;

import android.database.Cursor;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

import com.github.florent37.materialviewpager.sample.R;

import java.util.ArrayList;

public class Search extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Bundle bundle=getIntent().getExtras();
        ArrayList<Integer> pos=bundle.getIntegerArrayList("positions");
        ArrayList<ListData> myList=new ArrayList<ListData>();
        for(int i=0;i<pos.size();i++)
        {
            BookDataBase b=new BookDataBase(this);
            Cursor c=b.getInfo();
            c.moveToPosition(pos.get(i));
            ListData d=new ListData();
            d.setBook(c.getString(0));
            d.setAuthor(c.getString(1));
            d.setPrice("RS "+c.getInt(2)+"");
            switch (c.getInt(3))
            {
                case 0:
                    d.setImageId(R.drawable.love);
                    break;
                case 1:
                    d.setImageId(R.drawable.edu);
                    break;
                case 2:
                    d.setImageId(R.drawable.biog);
                    break;
                case 3:
                    d.setImageId(R.drawable.fict);
                    break;
                case 4:
                    d.setImageId(R.drawable.scf);
                    break;
                case 5:
                    d.setImageId(R.drawable.horror);
                    break;
                case 6:
                    d.setImageId(R.drawable.myst);
                    break;
                case 7:
                    d.setImageId(R.drawable.drama);
                    break;
            }
            myList.add(d);
        }
        MyAdapter adapter=new MyAdapter(this,myList);
        ListView l=(ListView) findViewById(R.id.searchResult);
        l.setAdapter(adapter);
    }

}
