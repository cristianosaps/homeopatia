package com.example.cristiano.homeopatia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.BuddhistCalendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.cristiano.homeopatia.Entidades.Composto;
import com.example.cristiano.homeopatia.banco_de_dados.BancoDeDadosHelper;

public class MedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med);

        final SharedPreferences shaPrefs = getApplicationContext().getSharedPreferences("favoritos", 0);
        final SharedPreferences.Editor sharedEdit = shaPrefs.edit();

        BancoDeDadosHelper bd = new BancoDeDadosHelper(this);

        Intent it = getIntent();
        Bundle bundle = it.getExtras();
        long idMed = bundle.getLong("idMed");
        final Composto med = bd.busca_tudo(idMed);
        final boolean favorito = shaPrefs.contains(Long.toString(med.getMedicamento().getMedicamentoId()));

        Log.w("MED Busca", med.getMedicamento().getNome_med());

        final ImageButton imgStar = (ImageButton) findViewById(R.id.btnStar);
        if(favorito){
            imgStar.setImageResource(R.drawable.ic_star_black_24dp);
        }
        imgStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(favorito){
                    sharedEdit.remove(Long.toString(med.getMedicamento().getMedicamentoId()));
                    sharedEdit.commit();
                    imgStar.setImageResource(R.drawable.ic_star_border_black_24dp);
                }else{
                    sharedEdit.putString(Long.toString(med.getMedicamento().getMedicamentoId()), "true");
                    sharedEdit.commit();
                    imgStar.setImageResource(R.drawable.ic_star_black_24dp);
                }
            }
        });

        TextView title = (TextView) findViewById(R.id.medTitle);
        title.setText(med.getMedicamento().getNome_med());

        TextView his = (TextView) findViewById(R.id.medHistoria);
        his.setText(med.getMedicamento().getHistorico_med());

        Button btnFisico = (Button) findViewById(R.id.btnFisicos);
        btnFisico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MedActivity.this, DetalheMedActivity.class);
                Bundle extras = new Bundle();
                extras.putString("nome", med.getMedicamento().getNome_med());
                extras.putString("nomeSintoma", "Sintomas Físicos");
                extras.putString("sintoma", med.getSintomas().getFisicos());

                it.putExtra("args", extras);

                startActivity(it);
            }
        });

        Button btnAnimais = (Button) findViewById(R.id.btnAnimais);
        btnAnimais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MedActivity.this, DetalheMedActivity.class);
                Bundle extras = new Bundle();
                extras.putString("nome", med.getMedicamento().getNome_med());
                extras.putString("nomeSintoma", "Sintomas em Animais");
                extras.putString("sintoma", med.getAnimais().getDescricao());

                it.putExtra("args", extras);

                startActivity(it);
            }
        });

        Button btnCriancas = (Button) findViewById(R.id.btnCriancas);
        btnCriancas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MedActivity.this, DetalheMedActivity.class);
                Bundle extras = new Bundle();
                extras.putString("nome", med.getMedicamento().getNome_med());
                extras.putString("nomeSintoma", "Sintomas em Crianças");
                extras.putString("sintoma", med.getCrianca().getDescricao());

                it.putExtra("args", extras);

                startActivity(it);
            }
        });

        Button btnEmocionais = (Button) findViewById(R.id.btnEmocionais);
        btnEmocionais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MedActivity.this, DetalheMedActivity.class);
                Bundle extras = new Bundle();
                extras.putString("nome", med.getMedicamento().getNome_med());
                extras.putString("nomeSintoma", "Sintomas Emocionais");
                extras.putString("sintoma", med.getSintomas().getEmocionais());

                it.putExtra("args", extras);

                startActivity(it);
            }
        });

        Button btnEnergetico = (Button) findViewById(R.id.btnEnergetico);
        btnEnergetico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MedActivity.this, DetalheMedActivity.class);
                Bundle extras = new Bundle();
                extras.putString("nome", med.getMedicamento().getNome_med());
                extras.putString("nomeSintoma", "Sintomas Energéticos");
                extras.putString("sintoma", med.getSintomas().getEnergeticos());

                it.putExtra("args", extras);
                startActivity(it);
            }
        });

        Button btnEspecifico = (Button) findViewById(R.id.btnEspecificos);
        btnEspecifico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MedActivity.this, DetalheMedActivity.class);
                Bundle extras = new Bundle();
                extras.putString("nome", med.getMedicamento().getNome_med());
                extras.putString("nomeSintoma", "Sintomas Chave");
                extras.putString("sintoma", med.getSintomas().getEspecificos());

                it.putExtra("args", extras);

                startActivity(it);
            }
        });

        Button btnMentais = (Button) findViewById(R.id.btnMentais);
        btnMentais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MedActivity.this, DetalheMedActivity.class);
                Bundle extras = new Bundle();
                extras.putString("nome", med.getMedicamento().getNome_med());
                extras.putString("nomeSintoma", "Sintomas Mentais");
                extras.putString("sintoma", med.getSintomas().getMetais());

                it.putExtra("args", extras);

                startActivity(it);
            }
        });

        Button btnVegetais = (Button) findViewById(R.id.btnVegetais);
        btnVegetais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MedActivity.this, DetalheMedActivity.class);
                Bundle extras = new Bundle();
                extras.putString("nome", med.getMedicamento().getNome_med());
                extras.putString("nomeSintoma", "Sintomas em Vegetais");
                extras.putString("sintoma", med.getVegetais().getDescricao());

                it.putExtra("args", extras);

                startActivity(it);
            }
        });

    }
}
