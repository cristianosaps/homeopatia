package com.example.cristiano.homeopatia.banco_de_dados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cristiano on 09/10/16.
 */

public class BancoDeDadosHelper extends SQLiteOpenHelper {

    //atualização de versao do banco de dados
    public static final int DATABASE_VERSION = 1;
    //definição do nome do arquivo
    public static final String NOMEBANCO = "HOMEOPATIA.sqlite"

    public BancoDeDadosHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, NOMEBANCO, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SintomasContract.SintomasEntry.CRIADOR_TABELA_SINTOMAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



}

