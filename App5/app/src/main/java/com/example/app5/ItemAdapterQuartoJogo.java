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

public class ItemAdapterQuartoJogo extends RecyclerView.Adapter<ItemAdapterQuartoJogo.ViewHolder> {

    Context contexto;
    ArrayList<String> itens;
    boolean escuro;

    public ItemAdapterQuartoJogo(Context contexto, ArrayList<String> itens, boolean escuro) {
        this.contexto = contexto;
        this.itens = itens;
        this.escuro = escuro;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.item_view_quarto_jogo,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapterQuartoJogo.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.escolhaUsuario.setText(itens.get(position));
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView escolhaUsuario;
        // Cada variável vai receber determinado campo da tela item_view
        // Exemplo: a variável nome vai receber o campo nome (que é um textview)
        public ViewHolder(View itemView) {
            super(itemView);
            escolhaUsuario = itemView.findViewById(R.id.usuarioDigitou);

            if(escuro){
                escolhaUsuario.setTextColor(Color.WHITE);

            }
        }
    }
}
