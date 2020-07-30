package com.example.shruti.menus;

import android.provider.BaseColumns;

/**
 * Created by shruti on 10/11/2016.
 */

public class TableData {

    public TableData()
    {

    }

    public static abstract class TableInfo implements BaseColumns {

        public static final String DATABASE="Contacts";
        public static final String TABLE_NAME="contact_table";
        public static final String NAME="name";
        public static final String ID="id";
        public static final String PHONE_NUMBER="phn";

    }

}
