package com.example.cristiano.homeopatia.banco_de_dados;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.cristiano.homeopatia.Entidades.Animais;
import com.example.cristiano.homeopatia.Entidades.Crianca;
import com.example.cristiano.homeopatia.Entidades.Medicamento;
import com.example.cristiano.homeopatia.Entidades.Sintomas;
import com.example.cristiano.homeopatia.Entidades.Vegetais;
import com.example.cristiano.homeopatia.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristiano on 09/10/16.
 */

public class BancoDeDadosHelper extends SQLiteOpenHelper {

    //atualização de versao do banco de dados
    public static final int DATABASE_VERSION = 1;
    //definição do nome do arquivo
    public static final String NOMEBANCO = "HOMEOPATIA.sqlite";
    private Context ctx;

    public BancoDeDadosHelper(Context context) {
        super(context, NOMEBANCO, null, DATABASE_VERSION);
        ctx = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SintomasContract.SintomasEntry.CRIADOR_TABELA_SINTOMAS);

        db.execSQL(AnimaisContract.AnimaisEntry.CRIADOR_TABELA_ANIMAIS);

        //   db.execSQL(VegetaisContract.VegetaisEntry.CRIADOR_TABELA_VEGETAIS);

        // db.execSQL(CriancaContract.CriancaEntry.CRIADOR_TABELA_CRIANCA);

        // db.execSQL(MedicamentoContract.MedicamentoEntry.CRIADOR_TABELA_MEDICAMENTO);

        Resources resources = ctx.getResources();
        InputStream in = resources.openRawResource(R.raw.dados);
        String json = null;
        try{
            byte[] data = new byte[in.available()];
            in.read(data);
            in.close();

            json = new String(data);

            List<Medicamento> listMed = new ArrayList<>();
            try {
                JSONObject root = new JSONObject(json);
                JSONArray meds = root.getJSONArray("medicamentos");
                for(int i=0; i<meds.length();i++){
                    JSONObject med = meds.getJSONObject(i);

                    Medicamento medToSalve = new Medicamento();

                    Animais animais = new Animais();
                    animais.setDescricao(med.getJSONObject("animais").getString("descricao"));
                    medToSalve.setAnimais_idanimais(Long.toString(salvaAnimais(animais, db)));

                    Crianca crianca = new Crianca();
                    crianca.setDescricao(med.getJSONObject("crianca").getString("descricao"));
                    medToSalve.setCrianca_idcrianca(Long.toString(salvaCrianca(crianca, db)));

                    Vegetais vegetais = new Vegetais();
                    vegetais.setDescricao(med.getJSONObject("vegetais").getString("descricao"));
                    medToSalve.setVegetais_idvegetais(Long.toString(salvaVegetais(vegetais, db)));

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private long salvaVegetais(Vegetais vegetais, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(VegetaisContract.VegetaisEntry.DESCRICAO, vegetais.getDescricao());
        long id = db.insert(VegetaisContract.VegetaisEntry.NOME_TABELA, "", values);

        return id;
    }

    private long salvaCrianca(Crianca crianca, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(CriancaContract.CriancaEntry.DESCRICAO, crianca.getDescricao());
        long id = db.insert(CriancaContract.CriancaEntry.NOME_TABELA, "", values);

        return id;
    }

    private long salvaAnimais(Animais animais, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(AnimaisContract.AnimaisEntry.DESCRICAO, animais.getDescricao());
        long id = db.insert(AnimaisContract.AnimaisEntry.NOME_TABELA, "", values);

        return id;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertSintomas(){
        SQLiteDatabase db = getWritableDatabase();
        try{
            ContentValues values = new ContentValues();
            values.put(SintomasContract.SintomasEntry.COLUNA_ENERGETICOS, "");
            values.put(SintomasContract.SintomasEntry.COLUNA_EMOCIONAIS, "emocionais");
            values.put(SintomasContract.SintomasEntry.COLUNA_ESPECIFICOS, "especificos");
            values.put(SintomasContract.SintomasEntry.COLUNA_FISICOS, "fisicos");
            values.put(SintomasContract.SintomasEntry.COLUNA_MENTAIS, "mentais");

            long id = db.insert(SintomasContract.SintomasEntry.NOME_TABELA, "", values);

            Log.i("Homeopatia", "ID: "+id);
            return id;
        }finally {
            db.close();
        }
    }

    public List<Sintomas> busca_sintomas(){
        SQLiteDatabase db = getWritableDatabase();

        List<Sintomas> retorno = new ArrayList<>();

        try{
            //select * from Sintomas
            Cursor resultado = db.query(SintomasContract.SintomasEntry.NOME_TABELA, null, null, null, null, null, null, null);


            if(resultado.moveToFirst()){
                do{
                    Sintomas sintomas = new Sintomas();
                    sintomas.setEnergeticos(resultado.getString(resultado.getColumnIndex(SintomasContract.SintomasEntry.COLUNA_ENERGETICOS)));
                    sintomas.setEmocionais(resultado.getString(resultado.getColumnIndex(SintomasContract.SintomasEntry.COLUNA_EMOCIONAIS)));
                    sintomas.setMetais(resultado.getString(resultado.getColumnIndex(SintomasContract.SintomasEntry.COLUNA_MENTAIS)));
                    sintomas.setFisicos(resultado.getString(resultado.getColumnIndex(SintomasContract.SintomasEntry.COLUNA_FISICOS)));

                    retorno.add(sintomas);
                }while(resultado.moveToNext());
            }
        }finally {
            db.close();
        }

        return retorno;
    }
}

