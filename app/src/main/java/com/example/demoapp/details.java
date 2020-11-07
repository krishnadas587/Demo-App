package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;

public class details extends AppCompatActivity {
    EditText name,dat,des,place;
    String names;
    Bundle exte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        exte=getIntent().getExtras();
        names=exte.getString("selected");
        name=findViewById(R.id.name);
        dat=findViewById(R.id.dob);
        des=findViewById(R.id.desig);
        place=findViewById(R.id.place);
        employeedb db=new employeedb(getApplicationContext());
        Cursor cursor=db.getAlldata();
        while (cursor.moveToNext()) {
            if (cursor.getString(1).equals(names)){
                name.setText(cursor.getString(1));
                dat.setText(cursor.getString(2));
                des.setText(cursor.getString(3));
                place.setText(cursor.getString(4));
            }
        }
    }
}