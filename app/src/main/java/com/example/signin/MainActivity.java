package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button sigin;
    Button ingresar;

    EditText usuario;
    EditText pasword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sigin =(Button)findViewById(R.id.sigin);
        ingresar = (Button) findViewById(R.id.ingresar);

        pasword = (EditText) findViewById(R.id.password);
        usuario = (EditText) findViewById(R.id.usuario);

        sigin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Sigin.class);
                startActivity(i);
            }
        });

    }
}