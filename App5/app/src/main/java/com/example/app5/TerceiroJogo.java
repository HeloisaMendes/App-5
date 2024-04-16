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

public class TerceiroJogo extends AppCompatActivity {

    RecyclerView recyclerView;
    ItemAdapterTerceiroJogo adapter;
    ArrayList<ItemDataTerceiroJogo> itens;
    boolean escuro = false;
    EditText digitos;
    ImageView btnOk, btnVoltar;
    int [] sequencia = new int[4];
    int [] digitosTentativa = new int[4];
    String entrada, seq = "", resultado = "";
    int qtdIguais = 0;
    int posicoesIguais = 0;
    int numero, qtdItens = 0;
    int numeroTentativa = 0;
    String primeiroDigito, segundoDigito, terceiroDigito, quartoDigito;
    int quantidadeTentativas = 0;
    int totalIguais = 0;

    int n;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terceiro_jogo);

        itens = new ArrayList<ItemDataTerceiroJogo>();
        digitos = findViewById(R.id.digitos);
        btnOk = findViewById(R.id.btnOk);
        btnVoltar = findViewById(R.id.btnvoltar);
        recyclerView = findViewById(R.id.recyclerView);


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

        Random r = new Random();
        // Gerar a sequência de 4 dígitos
        for (int i = 0; i < 4; i++) {
            boolean repetido;
            do {
                numero = r.nextInt(10);
                repetido = false;
                for (int j = 0; j < i; j++) {
                    if (sequencia[j] == numero) {
                        repetido = true;
                        break;
                    }
                }
            } while (repetido); // Garante que o número gerado seja diferente dos anteriores
            sequencia[i] = numero;
            seq = seq + sequencia[i];
        }


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quantidadeTentativas ++;

                // colocar a editText na variável entrada
                entrada = digitos.getText().toString();

                // Verificar se tem 4 dígitos
                if (entrada.length() != 4) {
                    Toast.makeText(TerceiroJogo.this, "Insira exatamente 4 dígitos", Toast.LENGTH_SHORT).show();
                    digitos.setText("");
                } else {

                    // colocar cada digito da variável entrada no vetor
                    if (entrada.length() == 4) {
                        for (int i = 0; i < 4; i ++) {
                            char digito = entrada.charAt(i);
                            digitosTentativa[i] = Character.getNumericValue(digito);
                        }
                    }

                    totalIguais = 0;
                    posicoesIguais = 0;

                    // Comparar cada dígito
                    for (int j = 0; j < 4; j ++) { // j representará a posição dos números digitados pelo usuário
                        for (int k = 0; k < 4; k ++) { // k representará a posição dos números sorteados
                            if (digitosTentativa[j] == sequencia[k]) { // se entrar é porque eles são iguais
                                qtdIguais ++;
                                totalIguais ++;
                                if (j != k) { // quero saber se os números estão em posições diferentes
                                    if (j == 0) {
                                        primeiroDigito = digitosTentativa[j] + " certo na posição errada";
                                    } else {
                                        if (j == 1) {
                                            segundoDigito = digitosTentativa[j] + " certo na posição errada";
                                        } else {
                                            if (j == 2) {
                                                terceiroDigito = digitosTentativa[j] + " certo na posição errada";
                                            } else {
                                                quartoDigito = digitosTentativa[j] + " certo na posição errada";
                                            }
                                        }
                                    }
                                } else { // está na mesma posição
                                    posicoesIguais ++;
                                    if (j == 0) {
                                        primeiroDigito = digitosTentativa[j] + " certo";
                                    } else {
                                        if (j == 1) {
                                            segundoDigito = digitosTentativa[j] + " certo";
                                        } else {
                                            if (j == 2) {
                                                terceiroDigito = digitosTentativa[j] + " certo";
                                            } else {
                                                quartoDigito = digitosTentativa[j] + " certo";
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if (qtdIguais == 0) {
                            if (j == 0) {
                                primeiroDigito = digitosTentativa[j] + " dígito errado";
                            } else {
                                if (j == 1) {
                                    segundoDigito = digitosTentativa[j] + " dígito errado";
                                } else {
                                    if (j == 2) {
                                        terceiroDigito = digitosTentativa[j] + " dígito errado";
                                    } else {
                                        quartoDigito = digitosTentativa[j] + " dígito errado";
                                    }
                                }
                            }
                        }

                        qtdIguais = 0;
                    }


                    if (totalIguais == 4 && posicoesIguais == 4) { // significa que ele ganhou
                        numeroTentativa ++;
                        Intent i = new Intent(TerceiroJogo.this, TerceiroJogoSegundaTela.class);
                        i.putExtra("qtdTentativas", quantidadeTentativas);
                        i.putExtra("dicas", "Parabéns, você conseguiu desvendar o código secreto!!!!");
                        startActivity(i);
                        finish();
                    } else {
                        numeroTentativa ++;


                        itens.add(new ItemDataTerceiroJogo(entrada, primeiroDigito, segundoDigito, terceiroDigito, quartoDigito));

                        adapter = new ItemAdapterTerceiroJogo(TerceiroJogo.this, itens, escuro);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(TerceiroJogo.this));
                        recyclerView.setAdapter(adapter);
                        qtdItens ++;

                        digitos.setText("");

                    }
                }

            }
        });


        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TerceiroJogo.this, SegundaTela.class);
                startActivity(i);
                finish();
            }
        });

    }
}
