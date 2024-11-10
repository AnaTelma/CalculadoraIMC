package com.example.imc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText nome,altura,peso;
    Button botao;
    ImageView imagem;
    ImageView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (EditText) findViewById(R.id.et_name);
        altura = (EditText) findViewById(R.id.et_height);
        peso = (EditText) findViewById(R.id.et_weight);
        botao = (Button) findViewById(R.id.btn_ok);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarTelaResultado();
            }
        });
    }
    public void mostrarTelaResultado(){

        if(TextUtils.isEmpty(nome.getText().toString())){
            nome.setError("Campo obrigatório");
            return;
        }
        if(TextUtils.isEmpty(altura.getText().toString())){
            altura.setError("Campo obrigatório");
            return;
        }
        if(TextUtils.isEmpty(peso.getText().toString())){
            peso.setError("Campo obrigatório");
            return;
        }
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("nome",nome.getText().toString());
        intent.putExtra("altura",altura.getText().toString());
        intent.putExtra("peso",peso.getText().toString());
        startActivity(intent);
    }
}