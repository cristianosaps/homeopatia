package com.example.cristiano.homeopatia.banco_de_dados;

import android.provider.BaseColumns;

/**
 * Created by cristiano on 09/10/16.
 */

public final class AnimaisContract {
    public AnimaisContract() {
    }
    public static abstract class AnimaisEntry implements BaseColumns{
        public static final String NOME_TABELA = "Animais";
        public static final String COLUNA_ID = "idAnimais";
        public static final String SINTOMAS_IDSINTOMAS = "Sintomas_Animais";

        //DEFININDO CODIGO SQL DA TABELA ANIMAIS
        public static final String CRIADOR_TABELA_ANIMAIS =
                "CREATE TABLE"+NOME_TABELA+" ("
                        +COLUNA_ID+" INTEGER UNSIGNED NOT NULL AUTOINCREMENT,"+
                        SINTOMAS_IDSINTOMAS+" TEXT NULL,"+
                        "PRIMARY KEY("+COLUNA_ID+"));";

 }

}
