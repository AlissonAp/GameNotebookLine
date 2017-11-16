package app.testeconsumerestapi;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.utils.missoesAdapter;
import app.testeconsumerestapi.utils.otherFunctions;
import app.testeconsumerestapi.utils.userFunctions;

/**
 * Created by Alisson on 03/11/2017.
 */

public class listMissaoActivity extends AppCompatActivity {


    ListView listViewMissoes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

       try {

           super.onCreate(savedInstanceState);
           setContentView(R.layout.layout_list_missoes);

           PopulateMissoes();

       }catch(Exception ex){

           System.out.println("Excessao");
            new userFunctions().enviarNotificacao(this, ex.toString());

       }
    }

    public void PopulateMissoes(){

        listViewMissoes = (ListView) findViewById(R.id.listView_missoes);

        //Carrega as missões do banco de dados
        List<Missao> missoesFromBD = new otherFunctions().carregarMissoes(this.getApplicationContext());
        Resources res =getResources();
        missoesAdapter missoesAdapter = new missoesAdapter(this,missoesFromBD,res);

        listViewMissoes.setAdapter(missoesAdapter);
    }



}
