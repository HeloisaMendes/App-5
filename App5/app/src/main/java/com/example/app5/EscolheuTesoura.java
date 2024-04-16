package com.example.app5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EscolheuTesoura extends AppCompatActivity {

    ImageView circulo, pedra, papel, tesoura, btnVoltar;
    TextView resultado;
    String escolhaComputador, escolhaUsuario, ganhou;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escolheu_tesoura);
        circulo = findViewById(R.id.circulo);
        pedra = findViewById(R.id.pedra);
        papel = findViewById(R.id.papel);
        tesoura = findViewById(R.id.tesoura);
        resultado = findViewById(R.id.resutado);
        btnVoltar = findViewById(R.id.btnvoltar);

        Intent telaAnterior = this.getIntent();
        escolhaComputador = telaAnterior.getStringExtra("escolhaComputador");
        escolhaUsuario = telaAnterior.getStringExtra("escolhaUsuario");

        //Comparação entre a escolha do computador e a escolha do usuário
        if (escolhaUsuario.equals("pedra")) {
            ganhou = "Você ganhou!";
        } else {
            if (escolhaUsuario.equals("papel")) {
                ganhou = "Você perdeu!!!";
            } else {
                ganhou = "Empate!!!";
            }
        }

        resultado.setText(ganhou);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EscolheuTesoura.this, SegundoJogo.class);
                startActivity(i);
                finish();
            }
        });
    }
}

