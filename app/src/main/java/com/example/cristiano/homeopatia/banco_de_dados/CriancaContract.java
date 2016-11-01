package com.example.cristiano.homeopatia.banco_de_dados;

import android.provider.BaseColumns;

/**
 * Created by cristiano on 09/10/16.
 */

public final class CriancaContract {
    public CriancaContract() {
    }
 public static abstract class CriancaEntry implements BaseColumns{
     public static final String NOME_TABELA = "Crianca";
     public static final String COLUNA_ID = "idCrianca";
     public static final String SINTOMAS_IDSINTOMAS = "Sintomas_Crianca";

     //DEFININDO CODIGO SQL DA TABELA CRIANCA
     public static final String CRIADOR_TABELA_CRIANCA =
             "CREATE TABLE"+NOME_TABELA+" ("
                     +COLUNA_ID+" INTEGER UNSIGNED NOT NULL AUTOINCREMENT,"+
                     SINTOMAS_IDSINTOMAS+" TEXT NULL,"+
                     "PRIMARY KEY("+COLUNA_ID+"));";


 }

}
