package com.example.imc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    TextView resultado;
    String strNome;
    Float fltAltura,fltPeso,fltResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        
        resultado = (TextView) findViewById(R.id.tv_Result);

        Intent intent = getIntent();
        strNome = intent.getStringExtra("nome");
        fltAltura = Float.parseFloat(intent.getStringExtra("altura"));
        fltPeso = Float.parseFloat(intent.getStringExtra("peso"));
        fltResult = fltPeso/(fltAltura*fltAltura);

        String strResult = "Olá " + strNome + "!";
        strResult = strResult + "\n" + "IMC = " + fltResult.toString();

        if(fltResult < 18.5){
            strResult = strResult + "\n" + "Abaixo do Peso" ;

        }
        else if(fltResult < 24.9){
            strResult = strResult + "\n" + "Peso Normal";

        }
        else if(fltResult < 29.9){
            strResult = strResult + "\n" + "Sobrepeso";

        }
        else if(fltResult < 39.9){
            strResult = strResult + "\n" + "Obesidade";
        }
        else{
            strResult = strResult + "\n" + "Obesidade Grave";
        }

        resultado.setText(strResult);

        }
    }