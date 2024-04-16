package com.example.app5;


import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class QuartoJogo extends AppCompatActivity {

    RecyclerView recyclerView;
    ItemAdapterQuartoJogo adapter;
    ArrayList<String> itens;
    boolean escuro = false;
    EditText valorDigitado;
    ImageView btnAdicionar, btnOk, btnVoltar;
    TextView titulo, sorteio;
    String itemSorteado;
    String [] valores;

    int qtdItens = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quarto_jogo);

        itens = new ArrayList<String>();
        valorDigitado = findViewById(R.id.editText);
        recyclerView = findViewById(R.id.recyclerView);
        btnAdicionar = findViewById(R.id.btnadicionar);
        btnOk = findViewById(R.id.btnOk);
        sorteio = findViewById(R.id.valorSorteado);
        btnVoltar = findViewById(R.id.btnvoltar);

        int modoAtual = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;

        switch (modoAtual) {
            case Configuration.UI_MODE_NIGHT_NO:
                escuro = false;
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                escuro = true;
                TextView textView = findViewById(R.id.titulo);
                textView.setTextColor(Color.WHITE);
                break;
        }

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!valorDigitado.getText().toString().isEmpty()) {

                    itens.add(valorDigitado.getText().toString());
                    valorDigitado.setText("");

                    adapter = new ItemAdapterQuartoJogo(QuartoJogo.this, itens, escuro);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(QuartoJogo.this));
                    recyclerView.setAdapter(adapter);
                    qtdItens ++;
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (itens.isEmpty()) {
                    Toast.makeText(QuartoJogo.this,"Digite pelo menos uma palavra ou número", Toast.LENGTH_SHORT).show();
                } else {
                    itemSorteado = itens.get(new Random().nextInt(itens.size()));
                    sorteio.setText("Item sorteado: " + itemSorteado);
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(QuartoJogo.this, SegundaTela.class);
                startActivity(i);
                finish();
            }
        });
    }
}
