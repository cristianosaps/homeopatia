package com.example.cristiano.homeopatia.banco_de_dados;

import android.provider.BaseColumns;

/**
 * Created by cristiano on 09/10/16.
 */

public final class MedicamentoContract {
    public MedicamentoContract() {
    }
 public static abstract class MedicamentoEntry implements BaseColumns{
     public static final String NOME_TABELA = "Medicamento";
     public static final String COLUNA_ID = "idMedicamento";
     public static final String SINTOMAS_IDSINTOMAS = "idSintomas";
     public static final String ANIMAIS_IDANIMAIS = "idAnimais";
     public static final String CRIANCA_IDCRIANCA = "idCrianca";
     public static final String VEGETAIS_IDVEGETAIS = "idVegetais";
     public static final String NOME_MED = "Nome_Medicamento";
     public static final String HISTORICO_MED = "Historico_Medicamento";


     //DEFININDO CODIGO SQL DA TABELA MEDICAMENTO
     public static final String CRIADOR_TABELA_MEDICAMENTO =
             "CREATE TABLE "+NOME_TABELA+" ("
                     +COLUNA_ID+" INTEGER UNSIGNED NOT NULL AUTOINCREMENT,"+
                     SINTOMAS_IDSINTOMAS+" INTEGER,"+
                     ANIMAIS_IDANIMAIS+" INTEGER,"+
                     CRIANCA_IDCRIANCA+" INTEGER,"+
                     VEGETAIS_IDVEGETAIS+" INTEGER,"+
                     NOME_MED+" TETXT NULL,"+
                     HISTORICO_MED+" TEXT NULL,"+
                     "PRIMARY KEY("+COLUNA_ID+"));";

 }

}
