package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Sigin extends AppCompatActivity  {

    int dia, mes, ano;
    EditText fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);
        fecha = (EditText) findViewById(R.id.nacimiento);
        fecha.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                dia = c.get(Calendar.DAY_OF_MONTH);
                mes = c.get(Calendar.MONTH);
                ano = c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Sigin.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        fecha.setText(dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                },dia,mes,ano);
                datePickerDialog.show();
            }
        });


    }




}