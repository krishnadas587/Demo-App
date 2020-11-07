package com.example.demoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databaselogin extends SQLiteOpenHelper {
    static String Database_name="login_database.db";
    static String Table_Name="login_table";
    public Databaselogin(@Nullable Context context) {
        super(context,Database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_Name + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,Firstname TEXT,Last_name TEXT,email_id TEXT,Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        onCreate(db);
    }
    public boolean insertdata(String fname,String lname,String email,String password){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Firstname",fname);
        contentValues.put("Last_name",lname);
        contentValues.put("email_id",email);
        contentValues.put("Password",password);

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
