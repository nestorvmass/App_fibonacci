package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText numero;
    Button benviar;
    TextView tvtexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = findViewById(R.id.etnum1);
        benviar = findViewById(R.id.pbenviar);
        tvtexto = findViewById(R.id.textView3);

        benviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ejecutar();

                if(validarcampo()){
                    Intent i = new Intent(MainActivity.this, Actividad2.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("numero", numero.getText().toString());
                    i.putExtras(bundle);
                    startActivity(i);
                }else{
                    numero.setError("Campo Requerido");
                    numero.requestFocus();
                }

            }

        });

    }

    public boolean validarcampo(){

        if( numero.getText().length()>=1){
            System.out.println("Tiene contenido");
            return true;
        }

        return false;
    }
    public void ejecutar(){

        if( numero.getText().length()>=1){
            System.out.println("Esta en blanco");
            //tvtexto.setText(Integer.parseInt(numero.toString())*2)
            imprimir(numero.getText().toString());
            imprimir("Se imprimio el primero");
            int numero1 = Integer.parseInt(numero.getText().toString())*2;

            tvtexto.setText(""+numero1);
        }

    }

    public void imprimir(String mensaje){
        System.out.println(mensaje);
    }
}