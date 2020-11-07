package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    models mod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

//        List<String> names=new ArrayList<>();
//        List<String> design=new ArrayList<>();
        fullload();



    }

    private void fullload() {
        employeedb db=new employeedb(getApplicationContext());
        Cursor cursor=db.getAlldata();
        List<String> names=new ArrayList<>();
        List<String> position=new ArrayList<>();
        while (cursor.moveToNext()){
            String name=cursor.getString(1);
            String designation=cursor.getString(3);
            names.add(name);
            position.add(designation);

//            mod.setName(name);
//            mod.setDesig(designation);

        }

        loaddata(names,position);
    }

    private void loaddata(List<String> na,List<String> pl) {
        RecyclerView recyclerView = findViewById(R.id.recycle_employee);
        StaggeredGridLayoutManager grid = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(grid);


        adapteremp adapter = new adapteremp(HomePage.this, na,pl);
        recyclerView.setAdapter(adapter);
    }

    public void add_emp_butt(View view) {
        Intent intent=new Intent(getApplicationContext(),Addemp.class);
        startActivity(intent);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        fullload();
        ;
    }
}