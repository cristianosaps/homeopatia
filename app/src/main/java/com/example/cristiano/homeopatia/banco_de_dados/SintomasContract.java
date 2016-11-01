package com.example.cristiano.homeopatia.banco_de_dados;

import android.provider.BaseColumns;

/**
 * Created by cristiano on 09/10/16.
 */

public final class SintomasContract {
    public SintomasContract() {
    }
 public static abstract class SintomasEntry implements BaseColumns{
     public static final String NOME_TABELA = "Sintomas";
     public static final String COLUNA_ID = "idSintomas";
     public static final String COLUNA_ENERGETICOS = "Energeticos";
     public static final String COLUNA_MENTAIS = "Metais";
     public static final String COLUNA_EMOCIONAIS = "Emocionais";
     public static final String COLUNA_FISICOS = "Fisicos";
     public static final String COLUNA_ESPECIFICOS = "Especificos";

     //DEFININDO CODIGO SQL DA TABELA SINTOMAS
     public static final String CRIADOR_TABELA_SINTOMAS =
             "CREATE TABLE"+NOME_TABELA+" ("
                 +COLUNA_ID+" INTEGER UNSIGNED NOT NULL AUTOINCREMENT,"+
                 COLUNA_ENERGETICOS+" TEXT NULL,"+
                 COLUNA_MENTAIS+" TEXT NULL,"+
                 COLUNA_EMOCIONAIS+" TETXT NULL,"+
                 COLUNA_FISICOS+" TEXT NULL,"+
                 COLUNA_ESPECIFICOS+" TEXT NULL,"+
                 "PRIMARY KEY("+COLUNA_ID+"));";

 }

}
