package com.example.app5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SegundaTela extends AppCompatActivity {

    ImageView primeiroBotao, segundoBotao, terceiroBotao, quartoBotao, quintoBotao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_tela);
        primeiroBotao = findViewById(R.id.primeiroBotao);
        segundoBotao = findViewById(R.id.segundoBotao);
        terceiroBotao = findViewById(R.id.terceiroBotao);
        quartoBotao = findViewById(R.id.quartoBotao);

        primeiroBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SegundaTela.this, PrimeiroJogo.class);
                startActivity(i);
                finish();
            }
        });

        segundoBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SegundaTela.this, SegundoJogo.class);
                startActivity(i);
                finish();
            }
        });

        terceiroBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SegundaTela.this, TerceiroJogo.class);
                startActivity(i);
                finish();
            }
        });

        quartoBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SegundaTela.this, QuartoJogo.class);
                startActivity(i);
                finish();
            }
        });
    }
}
