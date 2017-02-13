package com.example.cristiano.homeopatia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

import com.example.cristiano.homeopatia.Entidades.Composto;
import com.example.cristiano.homeopatia.adapter.MedAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lfelipeeb on 12/02/17.
 */

public class PesquisaBotton implements SearchView.OnQueryTextListener, SearchView.OnCloseListener {

    static private List<Composto> medOriginais, medTemp;
    private RecyclerView lista;
    private Context ctx;
    private RecyclerView.Adapter adapter;

    public PesquisaBotton(RecyclerView lista, Context ctx, RecyclerView.Adapter adapter, List<Composto> listMed) {
        this.lista = lista;
        this.ctx = ctx;
        this.adapter = adapter;
        medTemp = new ArrayList<>();
        medOriginais = listMed;
    }

    @Override
    public boolean onClose() {
        lista.setAdapter(new MedAdapter(medOriginais, ctx));
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        medTemp.clear();

        for(Composto temp : medOriginais){
            if(temp.getMedicamento().getNome_med().toUpperCase().contains(newText.toUpperCase())){
                medTemp.add(temp);
            }
        }

        lista.setAdapter(new MedAdapter(medTemp, ctx));

        return false;
    }
}
