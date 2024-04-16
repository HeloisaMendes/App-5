package com.example.app5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SegundaTelaPrimeiroJogo extends AppCompatActivity {

    TextView resultado;
    String frase, acao;
    ImageView btnVoltar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_tela_primeiro_jogo);
        resultado = findViewById(R.id.textView);
        btnVoltar = findViewById(R.id.btnvoltar);


        Intent telaAnterior = this.getIntent();
        acao = telaAnterior.getStringExtra("ação");
        if ("codificar".equals(acao)) {
            frase = telaAnterior.getStringExtra("fraseCodificada");
            resultado.setText(frase);
        } else {
            frase = telaAnterior.getStringExtra("fraseDescodificada");
            resultado.setText(frase);
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SegundaTelaPrimeiroJogo.this, PrimeiroJogo.class);
                startActivity(i);
                finish();
            }
        });
    }
}
