package com.example.app5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapterTerceiroJogo extends RecyclerView.Adapter<ItemAdapterTerceiroJogo.ViewHolder> {

    Context contexto;
    ArrayList<ItemDataTerceiroJogo> itens;
    boolean escuro;

    public ItemAdapterTerceiroJogo(Context contexto, ArrayList<ItemDataTerceiroJogo> itens, boolean escuro) {
        this.contexto = contexto;
        this.itens = itens;
        this.escuro = escuro;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.item_view_terceiro_jogo,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapterTerceiroJogo.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.sequenciaUsuario.setText(itens.get(position).getSequencia());
        holder.primeiroDigito.setText(itens.get(position).getPrimeiroDigito());
        holder.segundoDigito.setText(itens.get(position).getSegundoDigito());
        holder.terceiroDigito.setText(itens.get(position).getTerceiroDigito());
        holder.quartoDigito.setText(itens.get(position).getQuartoDigito());
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView sequenciaUsuario, primeiroDigito, segundoDigito, terceiroDigito, quartoDigito;
        // Cada variável vai receber determinado campo da tela item_view
        // Exemplo: a variável nome vai receber o campo nome (que é um textview)
        public ViewHolder(View itemView) {
            super(itemView);
            sequenciaUsuario = itemView.findViewById(R.id.sequenciaUsuario);
            primeiroDigito = itemView.findViewById(R.id.primeiroDigito);
            segundoDigito = itemView.findViewById(R.id.segundoDigito);
            terceiroDigito = itemView.findViewById(R.id.terceiroDigito);
            quartoDigito = itemView.findViewById(R.id.quartoDigito);

            if(escuro){
                sequenciaUsuario.setTextColor(Color.WHITE);
                primeiroDigito.setTextColor(Color.WHITE);
                segundoDigito.setTextColor(Color.WHITE);
                terceiroDigito.setTextColor(Color.WHITE);
                quartoDigito.setTextColor(Color.WHITE);
            }
        }
    }
}
