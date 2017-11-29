package app.testeconsumerestapi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alisson on 28/11/2017.
 */

public class finishMission extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_finish_mission);

        ArrayList<String> results =  this.getIntent().getStringArrayListExtra("results");

        TextView txtStatusMissao = (TextView) findViewById(R.id.txtStatusMissao);
        LinearLayout background = (LinearLayout) findViewById(R.id.layoutBackground);

        if(results.size() == 0){ //Sucesso na missao
            txtStatusMissao.setText("Parabéns, você concluiu a missão com sucesso! Bom trabalho");

        }else{ //Falha na missao

            String erros = "Ops, você não conseguiu atingir os objetivos da missão ...";

            for(String erro : results){
                erros += erro + "\n";
            }

            txtStatusMissao.setText(erros);
        }

    }

    public void Concluir(View view){
        Intent missoesScreen = new Intent(this, listMissaoActivity.class);

        startActivity(missoesScreen);

    }

}
