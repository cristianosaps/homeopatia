package com.example.cristiano.homeopatia.Entidades;

/**
 * Created by cristiano on 31/10/16.
 */

public class Sintomas {
    private long sintomasId;

    private String energeticos;
    private String metais;
    private String emocionais;
    private String fisicos;
    private String especificos;

    public String getEnergeticos() {
        return energeticos;
    }

    public void setEnergeticos(String energeticos) {
        this.energeticos = energeticos;
    }

    public String getMetais() {
        return metais;
    }

    public void setMetais(String metais) {
        this.metais = metais;
    }

    public String getEmocionais() {
        return emocionais;
    }

    public void setEmocionais(String emocionais) {
        this.emocionais = emocionais;
    }

    public String getFisicos() {
        return fisicos;
    }

    public void setFisicos(String fisicos) {
        this.fisicos = fisicos;
    }

    public String getEspecificos() {
        return especificos;
    }

    public void setEspecificos(String especificos) {
        this.especificos = especificos;
    }

    public long getSintomasId() {
        return sintomasId;
    }

    public void setSintomasId(long sintomasId) {
        this.sintomasId = sintomasId;
    }

}
