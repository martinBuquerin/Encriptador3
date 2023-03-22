package com.example.encriptadorv3;

import static com.example.encriptadorv3.R.id.textView;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    public static TextView cifrando =null;
    public static Boolean cifrarAlEscribir = false;
    public static Boolean cifrarCesar = false;
    public static Boolean cifrarIntercambio = false;
    public static Boolean cifrarClave = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        Button btnCifra = (Button) findViewById(R.id.button);
        Button btnDesci = (Button) findViewById(R.id.button2);
        Button btnAjustes = (Button) findViewById(R.id.button3);
         cifrando = (TextView) findViewById(textView);
        TextView codigo = (TextView) findViewById(R.id.editText2);
        EditText mensaje = (EditText) findViewById(R.id.editText);

        btnCifra.setText("CIFRA");
        btnDesci.setText("DESCIFRA");
        btnAjustes.setText("AJUSTES");
        cifrando.setText("");
        mensaje.setText("");
        codigo.setText("");

        if(cifrarAlEscribir){
            cifrando.setText("   Cifrar al escribir");
            cifrando.setTextSize(20);
            cifrando.setTextColor(getResources().getColor(R.color.black));
        }

        btnAjustes.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainActivity.this, ajustes.class);
                startActivity(intent);
                return false;
            }
        });



        btnCifra.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(cifrarCesar==false&cifrarClave==false&cifrarIntercambio==false){
                Toast.makeText(getApplicationContext(), "Error debe seleccionar un método de encriptacion", Toast.LENGTH_SHORT).show();
            }else if (cifrarCesar==true||cifrarClave==true||cifrarIntercambio==true){

                if(cifrarCesar){
                    if(cifrarAlEscribir){
                        mensaje.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void afterTextChanged(Editable editable) {
                                String tempString = mensaje.getText().toString();
                                String cifra = cifrarCaesar(tempString);

                                codigo.setText(cifra);
                            }
                        });

                    }
                    String tempString = mensaje.getText().toString();
                    String cifra = cifrarCaesar(tempString);
                    mensaje.setText(" ");
                    codigo.setText(cifra);
                }
                if(cifrarClave){
                    if(cifrarAlEscribir){
                        mensaje.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void afterTextChanged(Editable editable) {
                                String tempString = mensaje.getText().toString();
                                String cifra = encClave(tempString);

                                codigo.setText(cifra);
                            }
                        });

                    }
                    String tempString = mensaje.getText().toString();
                    String cifra = encClave(tempString);
                    mensaje.setText(" ");
                    codigo.setText(cifra);
                }
                if(cifrarIntercambio){
                    if(cifrarAlEscribir){
                        mensaje.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                            }

                            @Override
                            public void afterTextChanged(Editable editable) {
                                String tempString = mensaje.getText().toString();
                                String cifra = encriptadoIntercambio(tempString);

                                codigo.setText(cifra);
                            }
                        });

                    }
                    String tempString = mensaje.getText().toString();
                    String cifra = encriptadoIntercambio(tempString);
                    mensaje.setText(" ");
                    codigo.setText(cifra);
                }

            }

        }
    });


        btnDesci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cifrarCesar==false&cifrarClave==false&cifrarIntercambio==false){
                    Toast.makeText(getApplicationContext(), "Error debe seleccionar un método de encriptacion", Toast.LENGTH_SHORT).show();
                }else if (cifrarCesar==true||cifrarClave==true||cifrarIntercambio==true){

                    if(cifrarCesar){
                        if(cifrarAlEscribir){
                            mensaje.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                }

                                @Override
                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                }

                                @Override
                                public void afterTextChanged(Editable editable) {
                                    String tempString = mensaje.getText().toString();
                                    String cifra = descifrarCaesar(tempString);
                                    codigo.setText(cifra);

                                }
                            });

                        }
                        String tempString = codigo.getText().toString();
                        String cifra = descifrarCaesar(tempString);
                        codigo.setText(" ");
                        mensaje.setText(cifra);
                    }
                    if(cifrarClave){
                        if(cifrarAlEscribir){
                            mensaje.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                }

                                @Override
                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                }

                                @Override
                                public void afterTextChanged(Editable editable) {
                                    String tempString = mensaje.getText().toString();
                                    String cifra = desClave(tempString);

                                    codigo.setText(cifra);
                                }
                            });

                        }
                        String tempString = codigo.getText().toString();
                        String cifra = desClave(tempString);
                        mensaje.setText(cifra);
                        codigo.setText("");
                    }
                    if(cifrarIntercambio){
                        if(cifrarAlEscribir){
                            mensaje.addTextChangedListener(new TextWatcher() {
                                @Override
                                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                }

                                @Override
                                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                }

                                @Override
                                public void afterTextChanged(Editable editable) {
                                    String tempString = mensaje.getText().toString();
                                    String cifra = desencriptadoIntercambio(tempString);

                                    codigo.setText(cifra);
                                }
                            });

                        }
                        String tempString = codigo.getText().toString();
                        String cifra = desencriptadoIntercambio(tempString);
                        codigo.setText(" ");
                        mensaje.setText(cifra);
                    }

                }

            }
        });

    }


    public static String encriptadoIntercambio(String mensaje) {

        int largo = mensaje.length();
        char[] mensajeAr = new char[largo];

        String dividido;
        char[] mensajeEncrip = null;
        char mensajA[];
        if(largo % 2 == 0) {
            mensajeAr=mensaje.toCharArray();
            mensajeEncrip = new char[largo];
            for (int i = 0; i < mensaje.length(); i = i + 2) {
                int pos = i;
                mensajeEncrip[pos + 1] = mensajeAr[i];
                mensajeEncrip[pos] = mensajeAr[i + 1];
                //System.out.println(String.valueOf(mensajeEncrip));
            }
        }else{
            mensaje+=" ";
            mensajeAr=mensaje.toCharArray();
            mensajeEncrip = new char[largo+1];
            for (int i = 0; i < mensaje.length(); i = i + 2) {
                int pos = i;
                mensajeEncrip[pos + 1] = mensajeAr[i];
                mensajeEncrip[pos] = mensajeAr[i + 1];
                //System.out.println(String.valueOf(mensajeEncrip));
            }
        }
        String res = String.valueOf(mensajeEncrip);
        return res;
    }

    public static String desencriptadoIntercambio(String mensaje) {
        int largo = mensaje.length();
        char[] mensajeAr = new char[largo];

        String dividido;
        char[] mensajeEncrip = null;
        char mensajA[];
        if(largo % 2 == 0) {
            mensajeAr=mensaje.toCharArray();
            mensajeEncrip = new char[largo];
            for (int i = 0; i < mensaje.length(); i = i + 2) {
                int pos = i;
                mensajeEncrip[pos + 1] = mensajeAr[i];
                mensajeEncrip[pos] = mensajeAr[i + 1];
                //System.out.println(String.valueOf(mensajeEncrip));
            }
        }else{
            mensaje+=" ";
            mensajeAr=mensaje.toCharArray();
            mensajeEncrip = new char[largo+1];
            for (int i = 0; i < mensaje.length(); i = i + 2) {
                int pos = i;
                mensajeEncrip[pos + 1] = mensajeAr[i];
                mensajeEncrip[pos] = mensajeAr[i + 1];
                //System.out.println(String.valueOf(mensajeEncrip));
            }
        }
        String res = String.valueOf(mensajeEncrip);
        return res;
    }


    public static String encClave(String mensaje) {
        String encriptado = "";

        String clave="PATATA";

        for (int i = 0; i < mensaje.length(); i++) {


            char c = mensaje.charAt(i);
            char k = clave.charAt(i % clave.length());

            int suma= c + k;

            if (suma > 122) {
                suma -= 26;
            }else if (suma < 97) {
                suma += 26;
            }

            encriptado += (char) suma;

        }
        return encriptado;
    }



    public static String desClave(String mensaje) {
        String desencriptado = "";
        String clave = "PATATA";

        char[] des = new char[mensaje.length()];
        for (int i = 0; i < mensaje.length(); i++) {

            char c = mensaje.charAt(i);
            char k = clave.charAt(i % clave.length());


            int resta = c - k;


            if (resta > 122) {
                resta -= 26;
            } else if (resta < 97) {
                resta += 26;
            }

            des[i] = (char) resta;
            //desencriptado += (char) resta;
        }
        desencriptado = String.valueOf(des);
        return desencriptado;
    }







    public static String desencriptadoClave(String mensaje) {

        int largo = mensaje.length();
        char clave [] = {'P','A','T','A','T','A'};
        char claveRep[] = new char[largo];
        char[] mensajeAr;
        char[] desencriptado = new char[largo];

        mensajeAr = mensaje.toCharArray();

//en esta parte agrego la cantidad de caracteres de la clave, para que tenga la misma dimension que el texto a encriptar
        int contador = 0;
        for (int j = 0; j < largo; j++) {

            if (contador >= clave.length) {
                contador = 0;
            }
            claveRep[j] = clave[contador];

            contador++;
        }


// desencriptando
        for (int i = 0; i < largo; i++) {
            int val = (int) mensajeAr[i];
            int valorClave = (int) claveRep[i];

            int des = valorClave - val;

            int suma = 'A' - (  ( (valorClave + 'A') - val ) % 26);

                desencriptado[i] = (char) suma;

        }
        String res = String.valueOf(desencriptado);
        return res;
    }

    public static String encriptadoClave(String mensaje) {

        int largo = mensaje.length();
        char clave [] = {'P','A','T','A','T','A'};
        char claveRep[] = new char[largo];
        char[] mensajeAr;

      char[] encriptado = new char[largo];


        mensajeAr = mensaje.toCharArray();

//en esta parte agrego la cantidad de caracteres de la clave, para que tenga la misma dimension que el texto a encriptar
        int contador = 0;
        for (int j = 0; j < largo; j++) {

            if (contador >= clave.length) {
                contador = 0;
            }
            claveRep[j] = clave[contador];

            contador++;
        }

// realizo la suma del valor de ambas arrays para encriptar
        for (int i = 0; i < largo; i++) {

            int valorMensaje = (int) mensajeAr[i];
            int valorClave = (int) claveRep[i];
           // int suma = valorMensaje + valorClave;
            int suma = 'A' + (  ( (valorMensaje - 'A') + valorClave ) % 26);
            encriptado[i] = (char) suma;


        }

        String res = String.valueOf(encriptado);
        return res;
    }

    private static String cifrarCaesar(String cadena) {
        StringBuilder encriptado = new StringBuilder();
        int clave = 3;
        for (int i = 0; i < cadena.length(); i++)
        {
            if (Character.isUpperCase(cadena.charAt(i)))
            {
                char ch = (char)(((int)cadena.charAt(i) + clave - 65) % 27 + 65);
                encriptado.append(ch);
            }
            else
            {
                char ch = (char)(((int)cadena.charAt(i) + clave - 97) % 27 + 97);
                encriptado.append(ch);
            }
        }
        return encriptado.toString();

    }

    private static String descifrarCaesar(String cadena) {
        StringBuilder desencriptado = new StringBuilder();
        int clave = 3;
        for (int i = 0; i < cadena.length(); i++){
            if (Character.isUpperCase(cadena.charAt(i))){
                char ch = (char)(((int)cadena.charAt(i) - clave - 65 + 27) % 27 + 65);
                desencriptado.append(ch);
            }else{
                char ch = (char)(((int)cadena.charAt(i) - clave - 97 + 27) % 27 + 97);
                desencriptado.append(ch);
            }
        }
        return desencriptado.toString();
    }
}

