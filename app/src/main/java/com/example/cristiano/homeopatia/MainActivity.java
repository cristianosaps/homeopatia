package com.example.cristiano.homeopatia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cristiano.homeopatia.Entidades.Composto;
import com.example.cristiano.homeopatia.adapter.MedAdapter;
import com.example.cristiano.homeopatia.banco_de_dados.BancoDeDadosHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BancoDeDadosHelper db = new BancoDeDadosHelper(this);
        List<Composto> list = db.busca_tudo();

        recView = (RecyclerView) findViewById(R.id.recicleMed);

        recView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recView.setLayoutManager(layoutManager);

        mAdapter = new MedAdapter(list, this);

        recView.setAdapter(mAdapter);
    }
}