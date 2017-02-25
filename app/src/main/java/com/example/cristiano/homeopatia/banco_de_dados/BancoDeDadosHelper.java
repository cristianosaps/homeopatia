package com.example.cristiano.homeopatia.banco_de_dados;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.cristiano.homeopatia.Entidades.Animais;
import com.example.cristiano.homeopatia.Entidades.Composto;
import com.example.cristiano.homeopatia.Entidades.Crianca;
import com.example.cristiano.homeopatia.Entidades.Medicamento;
import com.example.cristiano.homeopatia.Entidades.Sintomas;
import com.example.cristiano.homeopatia.Entidades.Vegetais;
import com.example.cristiano.homeopatia.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;




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

        db.execSQL(VegetaisContract.VegetaisEntry.CRIADOR_TABELA_VEGETAIS);

        db.execSQL(CriancaContract.CriancaEntry.CRIADOR_TABELA_CRIANCA);

        db.execSQL(MedicamentoContract.MedicamentoEntry.CRIADOR_TABELA_MEDICAMENTO);

        Resources resources = ctx.getResources();
        InputStream in = resources.openRawResource(R.raw.dados);
        String json = null;
        try{
            byte[] data = new byte[in.available()];
            in.read(data);
            in.close();

            json = new String(data);

            Log.i("JSON MED", json);

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
                    vegetais.setDescricao(med.getJSONObject("vegetal").getString("descricao"));
                    medToSalve.setVegetais_idvegetais(Long.toString(salvaVegetais(vegetais, db)));

                    Sintomas sint = new Sintomas();
                    sint.setEmocionais(med.getJSONObject("sintomas").getString("emocionais"));
                    sint.setEnergeticos(med.getJSONObject("sintomas").getString("energetico"));
                    sint.setEspecificos(med.getJSONObject("sintomas").getString("especificos"));
                    sint.setMetais(med.getJSONObject("sintomas").getString("mentais"));
                    sint.setFisicos(med.getJSONObject("sintomas").getString("fisicos"));
                    medToSalve.setSintomas_idsintomas(Long.toString(salvaSintomas(sint, db)));

                    medToSalve.setHistorico_med(med.getString("historico_med"));
                    medToSalve.setNome_med(med.getString("nome_med"));

                    salvaMed(medToSalve, db);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i("Banco Home", "Banco de dados iniciado e com dados inseridos com sucesso");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }


    /*
                    SALVA
     */


    private long salvaMed(Medicamento medToSalve, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(MedicamentoContract.MedicamentoEntry.ANIMAIS_IDANIMAIS, medToSalve.getAnimais_idanimais());
        values.put(MedicamentoContract.MedicamentoEntry.CRIANCA_IDCRIANCA, medToSalve.getCrianca_idcrianca());
        values.put(MedicamentoContract.MedicamentoEntry.HISTORICO_MED, medToSalve.getHistorico_med());
        values.put(MedicamentoContract.MedicamentoEntry.NOME_MED, medToSalve.getNome_med());
        values.put(MedicamentoContract.MedicamentoEntry.VEGETAIS_IDVEGETAIS, medToSalve.getVegetais_idvegetais());
        values.put(MedicamentoContract.MedicamentoEntry.SINTOMAS_IDSINTOMAS, medToSalve.getSintomas_idsintomas());

        return db.insert(MedicamentoContract.MedicamentoEntry.NOME_TABELA, "", values);
    }

    private long salvaVegetais(Vegetais vegetais, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(VegetaisContract.VegetaisEntry.DESCRICAO, vegetais.getDescricao());

        return db.insert(VegetaisContract.VegetaisEntry.NOME_TABELA, "", values);
    }

    private long salvaCrianca(Crianca crianca, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(CriancaContract.CriancaEntry.DESCRICAO, crianca.getDescricao());

        return db.insert(CriancaContract.CriancaEntry.NOME_TABELA, "", values);
    }

    private long salvaAnimais(Animais animais, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(AnimaisContract.AnimaisEntry.DESCRICAO, animais.getDescricao());

        return db.insert(AnimaisContract.AnimaisEntry.NOME_TABELA, "", values);
    }

    public long salvaSintomas(Sintomas sintoma, SQLiteDatabase db){

        ContentValues values = new ContentValues();
        values.put(SintomasContract.SintomasEntry.COLUNA_ENERGETICOS, sintoma.getEnergeticos());
        values.put(SintomasContract.SintomasEntry.COLUNA_EMOCIONAIS, sintoma.getEmocionais());
        values.put(SintomasContract.SintomasEntry.COLUNA_ESPECIFICOS, sintoma.getEspecificos());
        values.put(SintomasContract.SintomasEntry.COLUNA_FISICOS, sintoma.getFisicos());
        values.put(SintomasContract.SintomasEntry.COLUNA_MENTAIS, sintoma.getMetais());

        return db.insert(SintomasContract.SintomasEntry.NOME_TABELA, "", values);
    }

        /*
                    BUSCA
     */


    public Sintomas busca_sintoma(long id){
        SQLiteDatabase db = getWritableDatabase();
        Sintomas sintomas = new Sintomas();

        try{
            //select * from Sintomas
            Cursor resultado = db.query(SintomasContract.SintomasEntry.NOME_TABELA, null, SintomasContract.SintomasEntry.COLUNA_ID +" = "+id, null, null, null, null, null);

            if(resultado.moveToFirst()) {
                sintomas.setEnergeticos(resultado.getString(resultado.getColumnIndex(SintomasContract.SintomasEntry.COLUNA_ENERGETICOS)));
                sintomas.setEmocionais(resultado.getString(resultado.getColumnIndex(SintomasContract.SintomasEntry.COLUNA_EMOCIONAIS)));
                sintomas.setMetais(resultado.getString(resultado.getColumnIndex(SintomasContract.SintomasEntry.COLUNA_MENTAIS)));
                sintomas.setFisicos(resultado.getString(resultado.getColumnIndex(SintomasContract.SintomasEntry.COLUNA_FISICOS)));
                sintomas.setEspecificos(resultado.getString(resultado.getColumnIndex(SintomasContract.SintomasEntry.COLUNA_ESPECIFICOS)));
                sintomas.setSintomasId(resultado.getInt(resultado.getColumnIndex(SintomasContract.SintomasEntry.COLUNA_ID)));
            }
        }finally {
            db.close();
        }

        return sintomas;
    }

    public Medicamento busca_medicamentos(long id){
        SQLiteDatabase db = getWritableDatabase();

        Medicamento med = new Medicamento();

        try{
            Cursor resultado = db.query(MedicamentoContract.MedicamentoEntry.NOME_TABELA, null, MedicamentoContract.MedicamentoEntry.COLUNA_ID + " = "+ id, null, null, null, null, null);

            if(resultado.moveToFirst()){
                do{
                    med.setHistorico_med(resultado.getString(resultado.getColumnIndex(MedicamentoContract.MedicamentoEntry.HISTORICO_MED)));
                    med.setAnimais_idanimais(resultado.getString(resultado.getColumnIndex(MedicamentoContract.MedicamentoEntry.ANIMAIS_IDANIMAIS)));
                    med.setCrianca_idcrianca(resultado.getString(resultado.getColumnIndex(MedicamentoContract.MedicamentoEntry.CRIANCA_IDCRIANCA)));
                    med.setNome_med(resultado.getString(resultado.getColumnIndex(MedicamentoContract.MedicamentoEntry.NOME_MED)));
                    med.setSintomas_idsintomas(resultado.getString(resultado.getColumnIndex(MedicamentoContract.MedicamentoEntry.SINTOMAS_IDSINTOMAS)));
                    med.setVegetais_idvegetais(resultado.getString(resultado.getColumnIndex(MedicamentoContract.MedicamentoEntry.VEGETAIS_IDVEGETAIS)));
                    med.setMedicamentoId(resultado.getInt(resultado.getColumnIndex(MedicamentoContract.MedicamentoEntry.COLUNA_ID)));

                }while(resultado.moveToNext());
            }
        }finally {
            db.close();
        }

        return med;
    }

    public Vegetais busca_vegetais(long id){
        SQLiteDatabase db = getWritableDatabase();
        Vegetais vegetais = new Vegetais();

        try{
            //select * from Sintomas
            Cursor resultado = db.query(VegetaisContract.VegetaisEntry.NOME_TABELA, null, VegetaisContract.VegetaisEntry.COLUNA_ID +" = "+id, null, null, null, null, null);

            if(resultado.moveToFirst()) {
                vegetais.setDescricao(resultado.getString(resultado.getColumnIndex(VegetaisContract.VegetaisEntry.DESCRICAO)));
                vegetais.setVegetaisId(resultado.getInt(resultado.getColumnIndex(VegetaisContract.VegetaisEntry.COLUNA_ID)));
            }
        }finally {
            db.close();
        }

        return vegetais;
    }

    public Crianca busca_crianca(long id){
        SQLiteDatabase db = getWritableDatabase();
        Crianca crianca = new Crianca();

        try{
            //select * from Sintomas
            Cursor resultado = db.query(CriancaContract.CriancaEntry.NOME_TABELA, null, CriancaContract.CriancaEntry.COLUNA_ID +" = "+id, null, null, null, null, null);

            if(resultado.moveToFirst()) {
                crianca.setDescricao(resultado.getString(resultado.getColumnIndex(CriancaContract.CriancaEntry.DESCRICAO)));
                crianca.setCriacaId(resultado.getInt(resultado.getColumnIndex(CriancaContract.CriancaEntry.COLUNA_ID)));
            }
        }finally {
            db.close();
        }

        return crianca;
    }

    public Animais busca_animais(long id){
        SQLiteDatabase db = getWritableDatabase();
        Animais animais = new Animais();

        try{
            //select * from Sintomas
            Cursor resultado = db.query(AnimaisContract.AnimaisEntry.NOME_TABELA, null, AnimaisContract.AnimaisEntry.COLUNA_ID +" = "+id, null, null, null, null, null);

            if(resultado.moveToFirst()) {
                animais.setDescricao(resultado.getString(resultado.getColumnIndex(AnimaisContract.AnimaisEntry.DESCRICAO)));
                animais.setAnimaisId(resultado.getInt(resultado.getColumnIndex(AnimaisContract.AnimaisEntry.COLUNA_ID)));
            }
        }finally {
            db.close();
        }

        return animais;
    }

    public Composto busca_tudo(long idMed){
        SQLiteDatabase db = getWritableDatabase();
        Composto composto;
        try{
            //select * from Sintomas
            Medicamento result = busca_medicamentos(idMed);
            Sintomas sintomas = busca_sintoma(Long.decode(result.getSintomas_idsintomas()));
            Vegetais vegetais = busca_vegetais(Long.decode(result.getVegetais_idvegetais()));
            Crianca crianca = busca_crianca(Long.decode(result.getCrianca_idcrianca()));
            Animais animais = busca_animais(Long.decode(result.getAnimais_idanimais()));

            composto = new Composto(animais, crianca, result, sintomas, vegetais);

        }finally {
            db.close();
        }

        return composto;
    }

    public List<Composto> busca_tudo(){
        SQLiteDatabase db = getWritableDatabase();
        List<Composto> listCcomposto = new ArrayList<>();
        try{
            Cursor res = db.query(MedicamentoContract.MedicamentoEntry.NOME_TABELA, null, null, null,null,null,null);
            if(res.moveToFirst()) {
                do {
                    //select * from Sintomas
                    Medicamento result = busca_medicamentos(res.getLong(res.getColumnIndex(MedicamentoContract.MedicamentoEntry.COLUNA_ID)));
                    Sintomas sintomas = busca_sintoma(Long.decode(result.getSintomas_idsintomas()));
                    Vegetais vegetais = busca_vegetais(Long.decode(result.getVegetais_idvegetais()));
                    Crianca crianca = busca_crianca(Long.decode(result.getCrianca_idcrianca()));
                    Animais animais = busca_animais(Long.decode(result.getAnimais_idanimais()));

                    listCcomposto.add(new Composto(animais, crianca, result, sintomas, vegetais));
                } while (res.moveToNext());
            }
        }finally {
            db.close();
        }

        return listCcomposto;
    }
}

