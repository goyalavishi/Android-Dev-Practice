package com.github.florent37.materialviewpager.sample.bookcrow;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by shruti on 10/9/2016.
 */

public class DataBaseOperations extends SQLiteOpenHelper {

    public static final int D_VERSION=1;

    public DataBaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE, null, D_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_QUERY="CREATE TABLE "+ TableData.TableInfo.TABLENAME+"("+ TableData.TableInfo.USER_NAME+" TEXT,"+
                TableData.TableInfo.USER_PASS+" TEXT,"+TableData.TableInfo.EMAIL+" TEXT,"+TableData.TableInfo.ROMANCE+" TEXT,"+TableData.TableInfo.EDUCATION+
                " TEXT,"+TableData.TableInfo.BIOGRAPHIES+" TEXT,"+TableData.TableInfo.FICTION+" TEXT,"
                +TableData.TableInfo.SCI_FI+" TEXT,"+TableData.TableInfo.HORROR+" TEXT,"+TableData.TableInfo.MYSTERY+" TEXT,"
                +TableData.TableInfo.DRAMA+" TEXT,"+ TableData.TableInfo.PHONE_NUM+" TEXT);";

        db.execSQL(CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(DataBaseOperations dop, String username, String password,String email,String num)
    {
        SQLiteDatabase SQ=dop.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(TableData.TableInfo.USER_NAME,username);
        c.put(TableData.TableInfo.USER_PASS,password);
        c.put(TableData.TableInfo.EMAIL,email);
        c.put(TableData.TableInfo.PHONE_NUM,num);
        SQ.insert(TableData.TableInfo.TABLENAME, null, c);
        SQ.close();
    }

    public boolean update(String email,String userpass,boolean pref[])
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableData.TableInfo.USER_NAME,email);
        contentValues.put(TableData.TableInfo.USER_PASS,userpass);

        if(pref[0])
            contentValues.put(TableData.TableInfo.ROMANCE,"1");
        if(pref[1])
            contentValues.put(TableData.TableInfo.EDUCATION,"1");
        if(pref[2])
            contentValues.put(TableData.TableInfo.BIOGRAPHIES,"1");
        if(pref[3])
            contentValues.put(TableData.TableInfo.FICTION,"1");
        if(pref[4])
            contentValues.put(TableData.TableInfo.SCI_FI,"1");
        if(pref[5])
            contentValues.put(TableData.TableInfo.HORROR,"1");
        if(pref[6])
            contentValues.put(TableData.TableInfo.MYSTERY,"1");
        if(pref[7])
            contentValues.put(TableData.TableInfo.DRAMA,"1");

        int i=db.update(TableData.TableInfo.TABLENAME, contentValues,TableData.TableInfo.EMAIL,new String[] { email });
        Log.v("hello",""+i);
        Cursor c=getInfo();
        if(c.getCount()>0)
        {
            c.moveToFirst();
            do{
                Log.v("abcd",c.getString(4)+"");
            }while(c.moveToNext());
        }
        return true;
    }


    public Cursor getInfo()
    {
        SQLiteDatabase SQ=getReadableDatabase();
        String cols[]={TableData.TableInfo.USER_NAME,TableData.TableInfo.USER_PASS,TableData.TableInfo.EMAIL ,TableData.TableInfo.MYSTERY,TableData.TableInfo.ROMANCE,TableData.TableInfo.HORROR,
                TableData.TableInfo.EDUCATION,TableData.TableInfo.FICTION,TableData.TableInfo.SCI_FI,TableData.TableInfo.BIOGRAPHIES,TableData.TableInfo.DRAMA};
        Cursor cursor=SQ.query(TableData.TableInfo.TABLENAME,cols,null,null,null,null,null);
        return cursor;
    }
}
