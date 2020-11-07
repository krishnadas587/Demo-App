package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Currency;

public class Loginpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
    }
    public void loginbutton(View view){
        validate();

    }

    private void validate() {
        EditText id=findViewById(R.id.userid);
        EditText password=findViewById(R.id.password);
        Databaselogin databaselogin=new Databaselogin(getApplicationContext());
        Cursor cursor=databaselogin.getAlldata();
        while (cursor.moveToNext()){
            String email_real=cursor.getString(3);
            String pass_real=cursor.getString(4);
            System.out.println(email_real);
            System.out.println(pass_real);
            if (id.getText().toString().equals(email_real)){
                if (password.getText().toString().equals(pass_real)) {
                    jump();
                }
                else {
                    password.setError("Incorrect Password");
                }
            }
            else {
                id.setError("Incorrect Username");
            }

        }
    }

    private void jump() {
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor=MainActivity.sharedPreferences.edit();
        editor.putBoolean("loginstatus",true);
        editor.apply();
        Intent intent=new Intent(getApplicationContext(),HomePage.class);
        startActivity(intent);
        finish();
    }
    public void notregisterbutton(View view){
        Intent intent=new Intent(getApplicationContext(),RegisterPage.class);
        startActivity(intent);
    }
}