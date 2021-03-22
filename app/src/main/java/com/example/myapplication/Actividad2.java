package com.example.myapplication;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Actividad2 extends AppCompatActivity {

    EditText etnumeroamigo;
    RadioButton botonf;
    RadioButton botona;
    RadioGroup radiogroup;
    TextView tvparametro;
    TextView tvresultado;
    Button bresultado;
    Bundle mensaje;
    int validacion = -1;
    int numero;
    int numero1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);

        etnumeroamigo = findViewById(R.id.etnumeroamigo);
        botonf = findViewById(R.id.radioButton1);
        botona = findViewById(R.id.radioButton2);
        radiogroup = findViewById(R.id.radioGroup);
        tvparametro = findViewById(R.id.tvrparametro);
        tvresultado = findViewById(R.id.tvresultado);
        bresultado = findViewById(R.id.bresultado);
        mensaje = getIntent().getExtras();
        tvparametro.setText(mensaje.getString("numero"));
        numero = Integer.parseInt(tvparametro.getText().toString());
        imprimir("Conversion a INT: "+numero);
        numero1 = Integer.parseInt(tvparametro.getText().toString());
        etnumeroamigo.setEnabled(false);

    }
    public void NumeroAmigo(View view){
        //imprimir("Boton resolver");
        if(botonf.isChecked()==true){
        }
        if(botona.isChecked()==true){
            imprimir("Numero amigo Radiobuton2");
            etnumeroamigo.setEnabled(true);
        }
    }


    private void imprimir(String mensaje){
        System.out.println(mensaje);
    }

    public void activarRadio1(View view){
        etnumeroamigo.setEnabled(false);
        imprimir("Fibonacci Radiobuton1");
        tvresultado.setText("Tener en cuenta que el calculo depende del tamaño del numero ingresado. esta aplicacion no permite calcular la serie Fibonacci de un numero mayor a 40 porque tardara mucho");
        if(numero1>40){
            //botonf.setError("Campo Requerido");
            botonf.setError("1");
            botonf.requestFocus();
            bresultado.setEnabled(false);

        }
        validacion = 1;
    }

    public void activarRadio2(View view){
        etnumeroamigo.setEnabled(true);
        tvresultado.setText("");
        imprimir("Fibonacci Radiobuton2");
        validacion = 2;
        etnumeroamigo.requestFocus();
        bresultado.setEnabled(true);

    }

    public void resolver(View v){
        //int numero1 = Integer.parseInt(tvparametro.getText().toString());
        int numero2;

        ArrayList<String> arrayFibonacci= new ArrayList<String>();
        String listado="Serie fibonacci de: "+numero;
        if(validacion==1){
            int i;
            for(i=0;i<=numero1;i++){
                arrayFibonacci.add(i+1+". "+fibonacci(i));
                //arrayFibonacci.add(String.valueOf(fibonacci(n)));
                //imprimir("Se Guarda:" + arrayFibonacci.get(i));
                listado += "\n"+arrayFibonacci.get(i);
            }
            imprimir(listado);
            tvresultado.setText(listado);
            tvresultado.setMovementMethod(new ScrollingMovementMethod());

        }else if(validacion ==2){
            if(etnumeroamigo.getText().length()>=1){
                numero2 = Integer.parseInt(etnumeroamigo.getText().toString());
                if(sonAmigos(numero1, numero2)){
                    imprimir("Son numeros Amigos");
                    tvresultado.setText("los numeros "+numero1+ " y "+numero2+" son amigos");
                }else{
                    tvresultado.setText("No son numeros amigos");
                }

            }else{
                //tvparametro.setText("El campo esta vacio");

                //tvresultado.setText("Por favor ingrese un valor en el campo numero amigo");
                imprimir(""+numero1);


                etnumeroamigo.setError("Campo Requerido");
                etnumeroamigo.requestFocus();
            }
        }
    }


    int fibonacci(int n)
    {
        if (n>1){
            return fibonacci(n-1) + fibonacci(n-2);  //función recursiva
        }
        else if (n==1) {  // caso base
            return 1;
        }
        else if (n==0){  // caso base
            return 0;
        }
        else{ //error
            System.out.println("Debes ingresar un tamaño mayor o igual a 1");
            return -1;
        }
    }




    private boolean sonAmigos(int num1, int num2){
        boolean amigos;
        if(num1==sumaDivisores(num2)){
            amigos = num2==sumaDivisores(num1)?true:false;
        } else {
            amigos = false;
        }
        return amigos;
    }
    private int sumaDivisores(int numero){
        int sumaDivisores = 0;
        for(int i=1;i<numero;i++){
            if(numero%i==0){
                sumaDivisores += i;
            }
        }
        return sumaDivisores;
    }
}
