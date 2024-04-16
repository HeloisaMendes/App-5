package com.example.app5;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Objects;

public class PrimeiroJogo extends AppCompatActivity {

    EditText fraseDigitada, deslocamento;
    ImageView btnCodificar, btnDescodificar, btnVoltar;
    String letras;
    int valorDeslocamento;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeiro_jogo);
        fraseDigitada = findViewById(R.id.editTextFrase);
        deslocamento = findViewById(R.id.valorDeslocamento);
        btnCodificar = findViewById(R.id.btnCodificar);
        btnDescodificar = findViewById(R.id.btnDescodificar);
        btnVoltar = findViewById(R.id.btnvoltar);

        btnCodificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!fraseDigitada.getText().toString().isEmpty() && !deslocamento.getText().toString().isEmpty()) { // conferir se alguma palavra foi digitada e se o valor do deslocamento está correto

                    int valor = parseInt(deslocamento.getText().toString());

                    if (valor <= 25) {
                        letras = fraseDigitada.getText().toString().trim(); // colocar a editText dentro de uma string retirando os espaços do início e do fim
                        valorDeslocamento = parseInt(deslocamento.getText().toString());

                        String codificada = codificarFrase(letras, valorDeslocamento);

                        Intent f = new Intent(PrimeiroJogo.this, SegundaTelaPrimeiroJogo.class);
                        f.putExtra("fraseCodificada", codificada);
                        f.putExtra("ação", "codificar");
                        startActivity(f);
                        finish();

                    } else {
                        Toast.makeText(PrimeiroJogo.this, "O valor do deslocamento deve ser um número entre 0 e 25", Toast.LENGTH_SHORT).show();
                        deslocamento.setText("");
                    }
                } else {
                    Toast.makeText(PrimeiroJogo.this, "Todos os campos devem ser preenchidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDescodificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!fraseDigitada.getText().toString().isEmpty() && !deslocamento.getText().toString().isEmpty()) { // conferir se alguma palavra foi digitada e se o valor do deslocamento está correto

                    int valor = parseInt(deslocamento.getText().toString());

                    if (valor <= 25) {
                        letras = fraseDigitada.getText().toString().trim(); // colocar a editText dentro de uma string retirando os espaços do início e do fim
                        valorDeslocamento = parseInt(deslocamento.getText().toString());

                        String descodificada = descodificarFrase(letras, valorDeslocamento);

                        Intent descod = new Intent(PrimeiroJogo.this, SegundaTelaPrimeiroJogo.class);
                        descod.putExtra("fraseDescodificada", descodificada);
                        descod.putExtra("ação", "descodificar");
                        startActivity(descod);
                        finish();

                    } else {
                        Toast.makeText(PrimeiroJogo.this, "O valor do deslocamento deve ser um número entre 0 e 25", Toast.LENGTH_SHORT).show();
                        deslocamento.setText("");
                    }
                } else {
                    Toast.makeText(PrimeiroJogo.this, "Todos os campos devem ser preenchidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PrimeiroJogo.this, SegundaTela.class);
                startActivity(i);
                finish();
            }
        });

    }
    public String codificarFrase(String letras, int deslocamento) {
        StringBuilder resultado = new StringBuilder();

        for (int n = 0; n < letras.length(); n ++) {
            char caractere = letras.charAt(n);

            //Verificar se o caractere é uma letra do alfabeto
            if (Character.isLetter((caractere))) {
                // Mantém o caso (maiúsculo ou minúsculo) do caractere original
                char base = Character.isUpperCase(caractere) ? 'A' : 'a';
                // Aplicar a cifra de César
                char novoCaractere = (char) (((caractere - base + valorDeslocamento) % 26) + base);
                resultado.append(novoCaractere);
            } else {
                // Se não for uma letra do alfabeto, mantém o caractere original
                resultado.append(caractere);
            }
        }
        return resultado.toString();
    }

    public String descodificarFrase(String letras, int deslocamento) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < letras.length(); i++) {
            char caractere = letras.charAt(i);

            // Verifica se o caractere é uma letra do alfabeto
            if (Character.isLetter(caractere)) {
                // Mantém o caso (maiúsculo ou minúsculo) do caractere original
                char base = Character.isUpperCase(caractere) ? 'A' : 'a';
                // Aplica o deslocamento negativo para descodificar
                char novoCaractere = (char) (((caractere - base - deslocamento + 26) % 26) + base);
                resultado.append(novoCaractere);
            } else {
                // Se não for uma letra do alfabeto, mantém o caractere original
                resultado.append(caractere);
            }
        }

        return resultado.toString();
    }
}
