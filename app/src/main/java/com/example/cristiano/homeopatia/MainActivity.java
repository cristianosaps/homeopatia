package com.example.cristiano.homeopatia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.cristiano.homeopatia.Entidades.Sintomas;
import com.example.cristiano.homeopatia.banco_de_dados.BancoDeDadosHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView hello = (TextView) findViewById(R.id.hello);
        hello.setText("Ola !");

        BancoDeDadosHelper db = new BancoDeDadosHelper(this);
        db.insertSintomas();
        db.insertSintomas();

        List<Sintomas> list= db.busca_sintomas();

        Log.e("Homeopatia", "Busca: "+list.get(0).getEmocionais());
    }
}
