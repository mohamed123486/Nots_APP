package com.example.not_bad.DataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class Data_Acsess {
     static SQLiteDatabase sqLiteDatabase;
     SQLiteOpenHelper sqLiteOpenHelper;
    static Data_Acsess data_acsess;
    Context context;

    private Data_Acsess(Context context) {
        this.context=context;
        sqLiteOpenHelper=new My_Data_Base(context);
    }

    public static Data_Acsess  instans(Context context){
        if (data_acsess==null)
            data_acsess= new Data_Acsess(context);
        return data_acsess;
    }

    public  void open(){
        sqLiteDatabase=sqLiteOpenHelper.getWritableDatabase();

    }
    public  void  close(){
        if (sqLiteDatabase!=null)
            sqLiteDatabase.close();
    }

    public  boolean insert(model m){
        ContentValues c=new ContentValues();
        c.put(My_Data_Base.msg,m.getMsg());
        c.put(My_Data_Base.time,m.getTime());
        c.put(My_Data_Base.titel,m.getTitel());
        long l=sqLiteDatabase.insert(My_Data_Base.Table_name,null,c);

        return l!=-1;

    }
    public static ArrayList<model>getall(){
        ArrayList<model>m=new ArrayList<>();
        Cursor c = sqLiteDatabase.rawQuery("select * from " +My_Data_Base.Table_name, null);
        if (c.moveToFirst()){
            do {
                @SuppressLint("Range") int i=c.getInt(c.getColumnIndex(My_Data_Base.id));
                @SuppressLint("Range") String titel=c.getString(c.getColumnIndex(My_Data_Base.titel));
                @SuppressLint("Range") String msg=c.getString(c.getColumnIndex(My_Data_Base.msg));
                @SuppressLint("Range") String time=c.getString(c.getColumnIndex(My_Data_Base.time));
                m.add(new model(i,titel,msg,time));
            }while (c.moveToNext());
        }
        return m;

    }
    public  boolean update(model m){
        ContentValues c=new ContentValues();
        c.put(My_Data_Base.id,m.getId());
        c.put(My_Data_Base.msg,m.getMsg());
        c.put(My_Data_Base.time,m.getTime());
        c.put(My_Data_Base.titel,m.getTitel());
        long l = sqLiteDatabase.update(My_Data_Base.Table_name, c, My_Data_Base.id + "=?", new String[]{String.valueOf(m.getId())});
        return l>0;
    }
    public void del(model id) {
        int rowsDeleted = sqLiteDatabase.delete(My_Data_Base.Table_name, My_Data_Base.id + "=?", new String[]{String.valueOf(id.getId())});
        if (rowsDeleted > 0) {
            Toast.makeText(context, "تم حذف العنصر", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "لم يتم الحذف", Toast.LENGTH_SHORT).show();
        }

    }

    public model getone(int id){
        model m;
        Cursor c = sqLiteDatabase.rawQuery("select * from "+My_Data_Base.Table_name+" WHERE "+My_Data_Base.id+"=?",new String[]{String.valueOf(id)});
        if (c.moveToFirst()){
                @SuppressLint("Range") int i=c.getInt(c.getColumnIndex(My_Data_Base.id));
                @SuppressLint("Range") String titel=c.getString(c.getColumnIndex(My_Data_Base.titel));
                @SuppressLint("Range") String msg=c.getString(c.getColumnIndex(My_Data_Base.msg));
                @SuppressLint("Range") String time=c.getString(c.getColumnIndex(My_Data_Base.time));
                m=new model(i,titel,msg,time);
                return m;
    }
        return  null;
}
}
