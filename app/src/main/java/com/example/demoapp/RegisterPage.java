package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
    }
    public void finishbutton(View view){
        EditText fname=findViewById(R.id.firstname);
        EditText lname=findViewById(R.id.lastname);
        EditText email_id=findViewById(R.id.emailadd);
        EditText password=findViewById(R.id.password);
        EditText con_pass=findViewById(R.id.con_pass);
        if (!fname.getText().toString().equals("")){
            if (!lname.getText().toString().equals("")){
                if (!email_id.getText().toString().equals("")){
                    if (!password.getText().toString().equals("")){
                        if (!con_pass.getText().toString().equals("")) {
                            if (con_pass.getText().toString().equals(password.getText().toString())) {
                                adddata(fname.getText().toString(),lname.getText().toString(),email_id.getText().toString(),password.getText().toString());
                            }
                            else {
                                Toast.makeText(RegisterPage.this,"Password not match",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(RegisterPage.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(RegisterPage.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(RegisterPage.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(RegisterPage.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(RegisterPage.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
        }



    }

    private void adddata(String fname,String lname,String email,String pass) {
        Databaselogin databaselogin=new Databaselogin(getApplicationContext());
        if (databaselogin.insertdata(fname,lname,email,pass)){
            jump();
        }
    }

    private void jump() {
        finish();
    }
}