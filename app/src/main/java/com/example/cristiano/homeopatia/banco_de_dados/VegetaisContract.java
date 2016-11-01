package com.example.cristiano.homeopatia.banco_de_dados;

import android.provider.BaseColumns;

/**
 * Created by cristiano on 09/10/16.
 */

public final class VegetaisContract {
    public VegetaisContract() {
    }
 public static abstract class VegetaisEntry implements BaseColumns{
     public static final String NOME_TABELA = "Vegetais";
     public static final String COLUNA_ID = "idVegetais";
     public static final String SINTOMAS_IDSINTOMAS = "Sintomas_Vegetais";

     //DEFININDO CODIGO SQL DA TABELA VEGETAIS
     public static final String CRIADOR_TABELA_VEGETAIS =
             "CREATE TABLE"+NOME_TABELA+" ("
                 +COLUNA_ID+" INTEGER UNSIGNED NOT NULL AUTOINCREMENT,"+
                 SINTOMAS_IDSINTOMAS+" TEXT NULL,"+
                 "PRIMARY KEY("+COLUNA_ID+"));";


 }

}