package com.example.not_bad.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class My_Data_Base extends SQLiteAssetHelper {


    public static String  id="id";
    public static int version=1;
    public static String titel="titel";
    public static String msg="msg";
    public static String time="time";
    public static Context context;
    public  static final String Data_BaseName="notBad.db";
    public static String Table_name="not_tt";

    public My_Data_Base(Context context) {

        super(context, Data_BaseName, null, version);
        this.context=context;
    }
}
