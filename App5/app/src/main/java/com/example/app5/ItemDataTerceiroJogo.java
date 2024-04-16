package com.example.app5;

public class ItemDataTerceiroJogo {

   private String sequencia, primeiroDigito, segundoDigito, terceiroDigito, quartoDigito;

    public ItemDataTerceiroJogo() {
    }

    public ItemDataTerceiroJogo(String sequencia, String primeiroDigito, String segundoDigito, String terceiroDigito, String quartoDigito) {
        this.sequencia = sequencia;
        this.primeiroDigito = primeiroDigito;
        this.segundoDigito = segundoDigito;
        this.terceiroDigito = terceiroDigito;
        this.quartoDigito = quartoDigito;
    }

    public String getSequencia() {
        return sequencia;
    }

    public void setSequencia(String sequencia) {
        this.sequencia = sequencia;
    }

    public String getPrimeiroDigito() {
        return primeiroDigito;
    }

    public void setPrimeiroDigito(String primeiroDigito) {
        this.primeiroDigito = primeiroDigito;
    }

    public String getSegundoDigito() {
        return segundoDigito;
    }

    public void setSegundoDigito(String segundoDigito) {
        this.segundoDigito = segundoDigito;
    }

    public String getTerceiroDigito() {
        return terceiroDigito;
    }

    public void setTerceiroDigito(String terceiroDigito) {
        this.terceiroDigito = terceiroDigito;
    }

    public String getQuartoDigito() {
        return quartoDigito;
    }

    public void setQuartoDigito(String quartoDigito) {
        this.quartoDigito = quartoDigito;
    }
}