package com.example.app5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SegundoJogo extends AppCompatActivity {

    ImageView circulo, pedra, papel, tesoura, btnVoltar;
    String [] itens = {"pedra", "papel", "tesoura"};
    int posicao;
    String escolhaComputador;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundo_jogo);
        circulo = findViewById(R.id.circulo);
        pedra = findViewById(R.id.pedra);
        papel = findViewById(R.id.papel);
        tesoura = findViewById(R.id.tesoura);
        btnVoltar = findViewById(R.id.btnvoltar);

        Random r = new Random();
        posicao = r.nextInt(itens.length);
        escolhaComputador = itens[posicao];

        pedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (escolhaComputador.equals("pedra")) {
                    Intent i = new Intent(SegundoJogo.this, EscolheuPedra.class);
                    i.putExtra("escolhaComputador", escolhaComputador);
                    i.putExtra("escolhaUsuario", "pedra");
                    startActivity(i);
                    finish();
                } else {
                    if (escolhaComputador.equals("papel")) {
                        Intent i = new Intent(SegundoJogo.this, EscolheuPapel.class);
                        i.putExtra("escolhaComputador", escolhaComputador);
                        i.putExtra("escolhaUsuario", "pedra");
                        startActivity(i);
                        finish();
                    } else {
                        Intent i = new Intent(SegundoJogo.this, EscolheuTesoura.class);
                        i.putExtra("escolhaComputador", escolhaComputador);
                        i.putExtra("escolhaUsuario", "pedra");
                        startActivity(i);
                        finish();
                    }
                }
            }
        });

        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (escolhaComputador.equals("pedra")) {
                    Intent i = new Intent(SegundoJogo.this, EscolheuPedra.class);
                    i.putExtra("escolhaComputador", escolhaComputador);
                    i.putExtra("escolhaUsuario", "papel");
                    startActivity(i);
                    finish();
                } else {
                    if (escolhaComputador.equals("papel")) {
                        Intent i = new Intent(SegundoJogo.this, EscolheuPapel.class);
                        i.putExtra("escolhaComputador", escolhaComputador);
                        i.putExtra("escolhaUsuario", "papel");
                        startActivity(i);
                        finish();
                    } else {
                        Intent i = new Intent(SegundoJogo.this, EscolheuTesoura.class);
                        i.putExtra("escolhaComputador", escolhaComputador);
                        i.putExtra("escolhaUsuario", "papel");
                        startActivity(i);
                        finish();
                    }
                }
            }
        });

        tesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (escolhaComputador.equals("pedra")) {
                    Intent i = new Intent(SegundoJogo.this, EscolheuPedra.class);
                    i.putExtra("escolhaComputador", escolhaComputador);
                    i.putExtra("escolhaUsuario", "tesoura");
                    startActivity(i);
                    finish();
                } else {
                    if (escolhaComputador.equals("papel")) {
                        Intent i = new Intent(SegundoJogo.this, EscolheuPapel.class);
                        i.putExtra("escolhaComputador", escolhaComputador);
                        i.putExtra("escolhaUsuario", "tesoura");
                        startActivity(i);
                        finish();
                    } else {
                        Intent i = new Intent(SegundoJogo.this, EscolheuTesoura.class);
                        i.putExtra("escolhaComputador", escolhaComputador);
                        i.putExtra("escolhaUsuario", "tesoura");
                        startActivity(i);
                        finish();
                    }
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SegundoJogo.this, SegundaTela.class);
                startActivity(i);
                finish();
            }
        });
    }
}
