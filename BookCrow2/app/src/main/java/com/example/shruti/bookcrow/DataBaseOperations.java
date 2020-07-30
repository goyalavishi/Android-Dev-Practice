package com.example.shruti.bookcrow;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
                TableData.TableInfo.USER_PASS+" TEXT,"+TableData.TableInfo.ROMANCE+" INTEGER DEFAULT 0,"+TableData.TableInfo.EDUCATION+
                " INTEGER DEFAULT 0,"+TableData.TableInfo.BIOGRAPHIES+" INTEGER DEFAULT 0,"+TableData.TableInfo.FICTION+" INTEGER DEFAULT 0,"
                +TableData.TableInfo.SCI_FI+" INTEGER DEFAULT 0,"+TableData.TableInfo.HORROR+" INTEGER DEFAULT 0,"+TableData.TableInfo.MYSTERY+" INTEGER DEFAULT 0,"
                +TableData.TableInfo.DRAMA+" INTEGER DEFAULT 0 );";

        db.execSQL(CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(DataBaseOperations dop, String username, String password)
    {
        SQLiteDatabase SQ=dop.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(TableData.TableInfo.USER_NAME,username);
        c.put(TableData.TableInfo.USER_PASS,password);
        /*c.put(TableData.TableInfo.ROMANCE,0);
        c.put(TableData.TableInfo.EDUCATION,0);
        c.put(TableData.TableInfo.BIOGRAPHIES,0);
        c.put(TableData.TableInfo.FICTION,0);
        c.put(TableData.TableInfo.SCI_FI,0);
        c.put(TableData.TableInfo.HORROR,0);
        c.put(TableData.TableInfo.MYSTERY,0);
        c.put(TableData.TableInfo.DRAMA,0);*/
        SQ.insert(TableData.TableInfo.TABLENAME, null, c);
        SQ.close();
    }

    public boolean update(String username,String userpass,boolean pref[])
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TableData.TableInfo.USER_NAME,username);
        contentValues.put(TableData.TableInfo.USER_PASS,userpass);

        if(pref[0])
        contentValues.put(TableData.TableInfo.ROMANCE,1);
        if(pref[1])
        contentValues.put(TableData.TableInfo.EDUCATION,1);
        if(pref[2])
        contentValues.put(TableData.TableInfo.BIOGRAPHIES,1);
        if(pref[3])
        contentValues.put(TableData.TableInfo.FICTION,1);
        if(pref[4])
        contentValues.put(TableData.TableInfo.SCI_FI,1);
        if(pref[5])
        contentValues.put(TableData.TableInfo.HORROR,1);
        if(pref[6])
        contentValues.put(TableData.TableInfo.MYSTERY,1);
        if(pref[7])
        contentValues.put(TableData.TableInfo.DRAMA,1);

        db.update(TableData.TableInfo.TABLENAME, contentValues, "username = ?",new String[] { username });
        return true;
    }


    public Cursor getInfo()
    {
        SQLiteDatabase SQ=getReadableDatabase();
        String cols[]={TableData.TableInfo.USER_NAME,TableData.TableInfo.USER_PASS, TableData.TableInfo.MYSTERY,TableData.TableInfo.ROMANCE,TableData.TableInfo.HORROR,
                TableData.TableInfo.EDUCATION,TableData.TableInfo.FICTION,TableData.TableInfo.SCI_FI,TableData.TableInfo.BIOGRAPHIES,TableData.TableInfo.DRAMA};
        Cursor cursor=SQ.query(TableData.TableInfo.TABLENAME,cols,null,null,null,null,null);
        return cursor;
    }

}
