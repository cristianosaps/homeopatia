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
        public static final String DESCRICAO = "descricao";

        //DEFININDO CODIGO SQL DA TABELA ANIMAIS
        public static final String CRIADOR_TABELA_ANIMAIS =
                "CREATE TABLE "+NOME_TABELA+" ("
                        +COLUNA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                        DESCRICAO+" INTEGER"+
                        ");";

 }

}
