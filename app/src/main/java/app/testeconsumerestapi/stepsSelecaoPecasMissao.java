package app.testeconsumerestapi;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import app.testeconsumerestapi.models.Peca;
import app.testeconsumerestapi.utils.otherFunctions;
import app.testeconsumerestapi.utils.pecasAdapter;

/**
 * Created by Alisson on 11/11/2017.
 */

public class stepsSelecaoPecasMissao extends AppCompatActivity{

    private pecasAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_pecas);

        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvPecas);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);

        //Busca pecas do Banco

        List<Peca> pecas = new otherFunctions().carregarpecas(this);

        adapter = new pecasAdapter(this,pecas);

        recyclerView.setAdapter(adapter);

    }



    public void inicializaEtapas(){




    }


}
