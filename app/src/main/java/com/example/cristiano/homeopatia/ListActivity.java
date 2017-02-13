package com.example.cristiano.homeopatia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.cristiano.homeopatia.Entidades.Composto;
import com.example.cristiano.homeopatia.adapter.MedAdapter;
import com.example.cristiano.homeopatia.banco_de_dados.BancoDeDadosHelper;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Composto> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        BancoDeDadosHelper db = new BancoDeDadosHelper(this);
        list = db.busca_tudo();

        Intent it = getIntent();

        if(it.hasExtra("args")){
            final SharedPreferences shaPrefs = getApplicationContext().getSharedPreferences("favoritos", 0);

            List<Composto> tmp =  new ArrayList<>();
            for(Composto temp : list){
                if(shaPrefs.contains(Long.toString(temp.getMedicamento().getMedicamentoId()))){
                    tmp.add(temp);
                }
            }

            list = tmp;
        }

        recView = (RecyclerView) findViewById(R.id.recicleMed);

        recView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recView.setLayoutManager(layoutManager);

        mAdapter = new MedAdapter(list, this);

        recView.setAdapter(mAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Catálogo de Homeeopatias");

        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.menuBusca);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new PesquisaBotton(ListActivity.this.recView, ListActivity.this, ListActivity.this.mAdapter, list));

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return true;
    }
}
