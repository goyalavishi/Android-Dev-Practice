package com.github.florent37.materialviewpager.sample.bookcrow;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dell on 10/27/2016.
 */

public class BookDataBase extends SQLiteOpenHelper {
    public static final int D_VERSION=1;

    public BookDataBase(Context context) {
        super(context, TableData.BookData.DATABASE, null,D_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_QUERY="CREATE TABLE "+ TableData.BookData.TABLENAME+"("+TableData.BookData.BOOK+" TEXT,"+
                TableData.BookData.AUTHOR+" TEXT,"+ TableData.BookData.PRICE+" INTEGER,"+TableData.BookData.type+" INTEGER );";

        db.execSQL(CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insert(String author, String bookname, int price,int category)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(TableData.BookData.AUTHOR,author);
        contentValues.put(TableData.BookData.BOOK,bookname);
        contentValues.put(TableData.BookData.PRICE,price);
        contentValues.put(TableData.BookData.type,category);
        db.insert(TableData.BookData.TABLENAME,null,contentValues);
    }

    public void delete()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        //db.delete();
    }

    public Cursor getInfo()
    {
        SQLiteDatabase SQ=getReadableDatabase();
        String cols[]={TableData.BookData.BOOK,TableData.BookData.AUTHOR,TableData.BookData.PRICE,TableData.BookData.type};
        Cursor cursor=SQ.query(TableData.BookData.TABLENAME,cols,null,null,null,null,null);
        return cursor;
    }

}
