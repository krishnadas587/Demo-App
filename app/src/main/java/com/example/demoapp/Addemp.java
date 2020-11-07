package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Addemp extends AppCompatActivity {
    DatePickerDialog.OnDateSetListener date;
    Calendar myCalendar;
    EditText dateofb;
    RadioGroup gender;
    RadioButton checkedRadioButton;
    Spinner place;
    EditText name;
    EditText desig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addemp);
        dateofb=findViewById(R.id.dob);
        name=findViewById(R.id.name);
        desig=findViewById(R.id.designation);

        gender=findViewById(R.id.gender_group);
        place=findViewById(R.id.location);


        myCalendar = Calendar.getInstance();


        String[] arraySpinner = new String[]{
                "Select one", "Palakkad", "Koratti", "Thrissur", "Guruvayoor"
        };
        setspinner(place, arraySpinner);
        dateofb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Addemp.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();

            }

        });
        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }


        };
    }

    private void setspinner(Spinner place, String[] arraySpinner) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        place.setAdapter(adapter);
    }

    private void updateLabel() {
        String myFormat = "YYYY-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
        dateofb.setText(sdf.format(myCalendar.getTime()));
    }


    public void saveemp(View view) {
        checkedRadioButton =gender.findViewById(gender.getCheckedRadioButtonId());
        if (!name.getText().toString().equals("")&&!desig.getText().toString().equals("")&&!dateofb.getText().toString().equals("")&&!place.getSelectedItem().toString().toLowerCase().equals("select one")&&gender.getCheckedRadioButtonId() != -1) {
            employeedb db=new employeedb(getApplicationContext());

            System.out.println(checkedRadioButton.getText().toString());

            if (db.insertdata(name.getText().toString(),dateofb.getText().toString(),desig.getText().toString(),place.getSelectedItem().toString(),checkedRadioButton.getText().toString())){
                Toast.makeText(Addemp.this,"Succesfully Saved",Toast.LENGTH_SHORT).show();
                finish();
            }

        }
        else {
            Toast.makeText(Addemp.this,"Fill All Fields",Toast.LENGTH_SHORT).show();
        }








// This will get the radiobutton in the radiogroup that is checked




    }


}