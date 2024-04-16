package com.example.app5;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TerceiroJogoSegundaTela extends AppCompatActivity {

    RecyclerView recyclerView;
//    ItemAdapter adapter;
//    ArrayList<ItemData> dadosAL;
    boolean escuro = false;
    TextView dicas, qtdTentativas;
    ImageView btnVoltar;
    String resultado;
    String sequencia;
    int totalTentativas, qtdIguais;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terceiro_jogo_segunda_tela);
//        dadosAL = new ArrayList<>();
        dicas = findViewById(R.id.dicas);
        btnVoltar = findViewById(R.id.btnvoltar);
        qtdTentativas = findViewById(R.id.qtdTentativas);

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


        Intent telaAnterior = this.getIntent();
        resultado = telaAnterior.getStringExtra("dicas");
        totalTentativas = telaAnterior.getIntExtra("qtdTentativas", 0);

        dicas.setText(resultado);
        qtdTentativas.setText("Total de tentativas: " + String.valueOf(totalTentativas));

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TerceiroJogoSegundaTela.this, TerceiroJogo.class);
                startActivity(i);
                finish();
            }
        });
    }
}
