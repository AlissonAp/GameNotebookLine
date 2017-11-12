package app.testeconsumerestapi;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import app.testeconsumerestapi.models.Peca;
import app.testeconsumerestapi.utils.otherFunctions;
import app.testeconsumerestapi.utils.pecasAdapter;

/**
 * Created by Alisson on 11/11/2017.
 */

public class listPecasActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);

    }

    public void carregarPecas(){

        otherFunctions function = new otherFunctions();

        List<Peca> pecas = function.carregarpecas(this);

        Resources rs = getResources();

        pecasAdapter adapter = new pecasAdapter(this,pecas,rs);



    }


}
