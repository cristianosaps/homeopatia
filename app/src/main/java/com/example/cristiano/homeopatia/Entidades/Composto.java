package com.example.cristiano.homeopatia.Entidades;

/**
 * Created by lfelipeeb on 22/01/17.
 */

/**
 * Esta classe define um objeto sem chaves estrangeiras, com todos os dados contido nele.
 *
 * Tipo Medicamento X, com caracteristicas do Vegetal, Animal, Fisico, Mentais, etc
 */
public class Composto {
    private Animais animais;
    private Crianca crianca;
    private Medicamento medicamento;
    private Sintomas sintomas;
    private Vegetais vegetais;

    public Animais getAnimais() {
        return animais;
    }

    public void setAnimais(Animais animais) {
        this.animais = animais;
    }

    public Crianca getCrianca() {
        return crianca;
    }

    public void setCrianca(Crianca crianca) {
        this.crianca = crianca;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Sintomas getSintomas() {
        return sintomas;
    }

    public void setSintomas(Sintomas sintomas) {
        this.sintomas = sintomas;
    }

    public Vegetais getVegetais() {
        return vegetais;
    }

    public void setVegetais(Vegetais vegetais) {
        this.vegetais = vegetais;
    }

    public Composto(Animais animais, Crianca crianca, Medicamento medicamento, Sintomas sintomas, Vegetais vegetais) {
        this.animais = animais;
        this.crianca = crianca;
        this.medicamento = medicamento;
        this.sintomas = sintomas;
        this.vegetais = vegetais;
    }


}
