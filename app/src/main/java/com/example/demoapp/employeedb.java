package com.example.demoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class employeedb extends SQLiteOpenHelper {
    static String Database_name="emp_database.db";
    static String Table_Name="emp_table";
    public employeedb(@Nullable Context context) {
        super(context,Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_Name + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,dateofbirth TEXT,designation TEXT,place TEXT,gender TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        onCreate(db);
    }
    public boolean insertdata(String name,String dob,String desig,String place,String gender){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("dateofbirth",dob);
        contentValues.put("designation",desig);
        contentValues.put("place",place);
        contentValues.put("gender",gender);

        long result=db.insert(Table_Name,null,contentValues);
        db.close();
        return result != -1;

    }
    Cursor getAlldata(){
        SQLiteDatabase db= this.getWritableDatabase();
        return db.rawQuery("select * from "+Table_Name,null);
    }
    public void deletetable(){
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        onCreate(db);

    }
}
