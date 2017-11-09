package app.testeconsumerestapi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.utils.otherFunctions;

/**
 * Created by Alisson on 03/11/2017.
 */

public class listMissaoActivity extends AppCompatActivity {


    ListView listViewMissoes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_missoes);

        PopulateMissoes();
    }

    public void PopulateMissoes(){

        listViewMissoes = (ListView) findViewById(R.id.listMissoes);

        //Carrega as missões do banco de dados
        List<Missao> missoesFromBD = new otherFunctions().carregarMissoes(this.getApplicationContext());

        ArrayList<String> missoes = new ArrayList<>();

        for (Missao m : missoesFromBD) {

            missoes.add(m.getNome());

        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                missoes

        );

        listViewMissoes.setAdapter(arrayAdapter);
    }



}
