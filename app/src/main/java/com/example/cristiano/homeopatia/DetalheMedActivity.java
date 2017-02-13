package com.example.cristiano.homeopatia;

import android.content.Intent;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalheMedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_med);
        Button btnVoltar = (Button) findViewById(R.id.btnVoltarMedDetalhe);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent it = getIntent();

        Bundle args = it.getBundleExtra("args");

        String nome = args.getString("nome");
        String nomeSintoma = args.getString("nomeSintoma");
        String sintoma = args.getString("sintoma");

        TextView tvNome = (TextView) findViewById(R.id.nomeDetalheMed);
        TextView tvnomeSintoma = (TextView) findViewById(R.id.sintomaDetalheMed);
        TextView tvSintoma = (TextView) findViewById(R.id.detalheSintomaDetalheMed);

        tvNome.setText(nome.equals("null")?"Nome não encontrado":nome);
        tvnomeSintoma.setText(nomeSintoma.equals("null")?" ":nomeSintoma);
        tvSintoma.setText(sintoma.equals("null")?"Sintoma não encontrado":sintoma);
    }
}
