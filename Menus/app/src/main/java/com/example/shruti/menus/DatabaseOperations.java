 package com.example.shruti.menus;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.example.shruti.menus.MainActivity.db;

/**
 * Created by shruti on 10/11/2016.
 */

public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int d_version=1;

    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE, null,d_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_QUERY="CREATE TABLE "+TableData.TableInfo.TABLE_NAME+" ("+TableData.TableInfo.ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                TableData.TableInfo.NAME+" TEXT,"+ TableData.TableInfo.PHONE_NUMBER +" TEXT );";

        db.execSQL(CREATE_QUERY);
    }

    public void insert(String name,String phone)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(TableData.TableInfo.NAME,name);
        c.put(TableData.TableInfo.PHONE_NUMBER,phone);
        db.insert(TableData.TableInfo.TABLE_NAME,null,c);
        db.close();


    }

    public ArrayList<String> getInfo()
    {
        ArrayList<String> contacts=new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TableData.TableInfo.TABLE_NAME,null);
        if(res.getCount()>0)
        while (res.moveToNext())
        {
            contacts.add(res.getString(1));
        }
        return contacts;

    }

    public boolean updateData(String id,String name,String phn) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableData.TableInfo.ID,id);
        contentValues.put(TableData.TableInfo.NAME,name);
        contentValues.put(TableData.TableInfo.PHONE_NUMBER,phn);
        db.update(TableData.TableInfo.TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Cursor getInformation()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TableData.TableInfo.TABLE_NAME,null);
        return res;
    }

    public boolean deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TableData.TableInfo.TABLE_NAME, TableData.TableInfo.ID+" = ?",new String[]{id});
        return true;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
