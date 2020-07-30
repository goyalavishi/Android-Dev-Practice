package com.github.florent37.materialviewpager.sample.bookcrow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.florent37.materialviewpager.sample.R;

import java.util.ArrayList;

/**
 * Created by Dell on 11/1/2016.
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

        TextView book=(TextView)convertView.findViewById(R.id.bookname);
        TextView author=(TextView)convertView.findViewById(R.id.author);
        ImageView image=(ImageView)convertView.findViewById(R.id.img);
        TextView price=(TextView)convertView.findViewById(R.id.price);

        book.setText(listitem.getBook());
        author.setText(listitem.getAuthor());
        price.setText(String.valueOf(listitem.getPrice()));
        image.setImageResource(listitem.getImageId());

        return convertView;
    }
}
