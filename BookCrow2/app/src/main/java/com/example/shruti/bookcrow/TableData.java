package com.example.shruti.bookcrow;

import android.provider.BaseColumns;

/**
 * Created by shruti on 10/9/2016.
 */

public class TableData  {

    public TableData()
    {

    }

    public static abstract class TableInfo implements BaseColumns{

        public static final String TABLENAME="UserInfo";
        public static final String DATABASE="Users";
        //public static final String ID="id";
        public static final String USER_NAME="username";
        public static final String USER_PASS="password";
        public static final String ROMANCE="romance";
        public static final String MYSTERY="mystery";
        public static final String EDUCATION="education" ;
        public static final String BIOGRAPHIES="biographies";
        public static final String FICTION="fiction";
        public static final String SCI_FI="scifi";
        public static final String HORROR="horror";
        public static final String DRAMA="drama";

        //romance,education,biographies,fiction,sci_fi,horror,mystery,drama

    }

    public static abstract class BookData implements BaseColumns{

        public static final String TABLENAME="BookTable";
        public static final String DATABASE="BookData";
        public static final String AUTHOR="Author";
        public static final String BOOK="Book";
        public static final String PRICE="Price";


    }
}
