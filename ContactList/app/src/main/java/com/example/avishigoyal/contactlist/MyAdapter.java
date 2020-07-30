package com.example.avishigoyal.contactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Avishi Goyal on 19-12-2015.
 */
public class MyAdapter extends BaseAdapter {
    Context c;
    ArrayList<ListData> mylist;
    LayoutInflater inflater;

    MyAdapter(Context c,ArrayList<ListData>mylist){
        this.c=c;
        inflater=LayoutInflater.from(this.c);
        this.mylist=mylist;
    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return mylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView=inflater.inflate(R.layout.listdata,parent,false);
        ListData listitem=(ListData)getItem(position);

        TextView title=(TextView)convertView.findViewById(R.id.text);
        TextView desc=(TextView)convertView.findViewById(R.id.text2);
        ImageView image=(ImageView)convertView.findViewById(R.id.img);
        TextView time=(TextView)convertView.findViewById(R.id.text3);

        title.setText(listitem.getTitle());
        desc.setText(listitem.getDiscription());
        time.setText(String.valueOf(listitem.getTime()));
        image.setImageResource(listitem.getImageId());

        return convertView;
    }
}
