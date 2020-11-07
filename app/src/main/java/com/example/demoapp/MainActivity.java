package com.example.demoapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        new Handler().postDelayed(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void run() {
                if (sharedPreferences.getBoolean("loginstatus", false) == true) {
                    Intent intent=new Intent(getApplicationContext(),HomePage.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    jump();
                }




            }
        }, 3000);

    }

    private void jump() {
        Intent intent=new Intent(getApplicationContext(),Loginpage.class);
        startActivity(intent);
        finish();
    }
}