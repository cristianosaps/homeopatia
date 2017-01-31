package com.example.cristiano.homeopatia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.cristiano.homeopatia.Entidades.Composto;
import com.example.cristiano.homeopatia.banco_de_dados.BancoDeDadosHelper;

public class MedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med);
        BancoDeDadosHelper bd = new BancoDeDadosHelper(this);

        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        long idMed = bundle.getLong("idMed");
        Composto med = bd.busca_tudo(idMed);

        Log.w("MED Busca", med.getMedicamento().getNome_med());

        TextView title = (TextView) findViewById(R.id.medTitle);
        title.setText(med.getMedicamento().getNome_med());

        TextView his = (TextView) findViewById(R.id.medHistoria);
        his.setText(med.getMedicamento().getHistorico_med());

        TextView fisico = (TextView) findViewById(R.id.medFisico);
        fisico.setText(med.getSintomas().getFisicos());

        TextView especifico = (TextView) findViewById(R.id.medEspecifico);
        especifico.setText(med.getSintomas().getEspecificos());

        TextView mentais = (TextView) findViewById(R.id.medMentais);
        mentais.setText(med.getSintomas().getMetais());

        TextView energetico = (TextView) findViewById(R.id.medEnergetico);
        energetico.setText(med.getSintomas().getEnergeticos());

        TextView vegetais = (TextView) findViewById(R.id.medVegetais);
        vegetais.setText(med.getVegetais().getDescricao());

        TextView crianca = (TextView) findViewById(R.id.medCrianca);
        crianca.setText(med.getCrianca().getDescricao());

        TextView animais = (TextView) findViewById(R.id.medAnimal);
        animais.setText(med.getAnimais().getDescricao());


    }
}
