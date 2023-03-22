package com.example.encriptadorv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;


import java.util.Objects;

public class ajustes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        Objects.requireNonNull(getSupportActionBar()).hide();
        TextView titulo = (TextView) findViewById(R.id.textView2);
        TextView textSwitch = (TextView) findViewById(R.id.textView3);
        RadioButton cesar =(RadioButton) findViewById(R.id.radioButton);
        RadioButton pares =(RadioButton) findViewById(R.id.radioButton5);
        RadioButton clave =(RadioButton) findViewById(R.id.radioButton4);
        Switch cambiarModo = (Switch) findViewById(R.id.switch1);


        titulo.setText("  AJUSTES");
        titulo.setTextSize(55);
        titulo.setTextColor(getResources().getColor(R.color.black));
        cesar.setText("  Cifrado del César");
        cesar.setTextSize(25);
        cesar.setTextColor(getResources().getColor(R.color.verdeNegro));
        pares.setText("  Intercambio Pares");
        pares.setTextSize(25);
        pares.setTextColor(getResources().getColor(R.color.verdeNegro));
        clave.setText("  Mediante contraseña");
        clave.setTextSize(25);
        clave.setTextColor(getResources().getColor(R.color.verdeNegro));
        textSwitch.setText("Cifrar mientras se escribe");
        textSwitch.setTextSize(23);
        textSwitch.setTextColor(getResources().getColor(R.color.black));
        cambiarModo.setText("");
        cambiarModo.setTextSize(35);
        cambiarModo.setChecked(false);
        if(MainActivity.cifrarAlEscribir==true){
            cambiarModo.setChecked(true);
        }else{
            cambiarModo.setChecked(false);
        }

        if(MainActivity.cifrarCesar==true){
           cesar.setChecked(true);
        }else{
            cesar.setChecked(false);
        }

        if(MainActivity.cifrarIntercambio==true){
            pares.setChecked(true);
        }else{
            pares.setChecked(false);
        }

        if(MainActivity.cifrarClave==true){
            clave.setChecked(true);
        }else{
            clave.setChecked(false);
        }

        cambiarModo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cambiarModo.isChecked()){
                    MainActivity.cifrando.setText("   Cifrar al escribir");
                    MainActivity.cifrando.setTextSize(20);
                    MainActivity.cifrando.setTextColor(getResources().getColor(R.color.black));
                    MainActivity.cifrarAlEscribir = true;
                    cambiarModo.setChecked(true);
                }else{
                    MainActivity.cifrando.setText("");
                    MainActivity.cifrarAlEscribir = false;
                }
            }
        });

        cesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cesar.isChecked()){
                    MainActivity.cifrarCesar = true;
                    cesar.setChecked(true);
                    MainActivity.cifrarIntercambio = false;
                    MainActivity.cifrarClave = false;


                }else{
                    MainActivity.cifrarCesar = false;
                    cesar.setChecked(false);


                }
            }
        });

        pares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pares.isChecked()){
                    MainActivity.cifrarIntercambio = true;
                    pares.setChecked(true);
                    MainActivity.cifrarClave=false;
                    MainActivity.cifrarCesar=false;


                }else{
                    MainActivity.cifrarIntercambio = false;
                    pares.setChecked(false);


                }
            }
        });

        clave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clave.isChecked()){
                    MainActivity.cifrarClave = true;
                    clave.setChecked(true);
                    MainActivity.cifrarCesar=false;
                    MainActivity.cifrarIntercambio = false;

                }else{
                    MainActivity.cifrarClave = false;
                    clave.setChecked(false);

                }
            }
        });

    }
}