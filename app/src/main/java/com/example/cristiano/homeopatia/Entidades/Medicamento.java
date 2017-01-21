package com.example.cristiano.homeopatia.Entidades;

/**
 * Created by cristiano on 31/10/16.
 */

public class Medicamento {
    private long medicamentoId;

        private String sintomas_idsintomas;
        private String animais_idanimais;
        private String crianca_idcrianca;
        private String vegetais_idvegetais;
        private String nome_med;
        private String historico_med;

    public long getMedicamentoId() {
        return medicamentoId;
    }

    public void setMedicamentoId(long medicamentoId) {
        this.medicamentoId = medicamentoId;
    }

    public String getSintomas_idsintomas() {
        return sintomas_idsintomas;
    }

    public void setSintomas_idsintomas(String sintomas_idsintomas) {
        this.sintomas_idsintomas = sintomas_idsintomas;
    }

    public String getAnimais_idanimais() {
        return animais_idanimais;
    }

    public void setAnimais_idanimais(String animais_idanimais) {
        this.animais_idanimais = animais_idanimais;
    }

    public String getCrianca_idcrianca() {
        return crianca_idcrianca;
    }

    public void setCrianca_idcrianca(String crianca_idcrianca) {
        this.crianca_idcrianca = crianca_idcrianca;
    }

    public String getVegetais_idvegetais() {
        return vegetais_idvegetais;
    }

    public void setVegetais_idvegetais(String vegetais_idvegetais) {
        this.vegetais_idvegetais = vegetais_idvegetais;
    }

    public String getNome_med() {
        return nome_med;
    }

    public void setNome_med(String nome_med) {
        this.nome_med = nome_med;
    }

    public String getHistorico_med() {
        return historico_med;
    }

    public void setHistorico_med(String historico_med) {
        this.historico_med = historico_med;
    }


}

