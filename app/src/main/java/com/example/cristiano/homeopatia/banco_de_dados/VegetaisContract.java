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
     public static final String DESCRICAO = "DESCRICAO";

     //DEFININDO CODIGO SQL DA TABELA VEGETAIS
     public static final String CRIADOR_TABELA_VEGETAIS =
             "CREATE TABLE "+NOME_TABELA+" ("
                 +COLUNA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "+
                 DESCRICAO +" INTEGER"+
                 ");";


 }

}
