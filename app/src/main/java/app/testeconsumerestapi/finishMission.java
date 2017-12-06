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

import app.testeconsumerestapi.models.Usuario;
import app.testeconsumerestapi.utils.otherFunctions;
import app.testeconsumerestapi.utils.userFunctions;

/**
 * Created by Alisson on 28/11/2017.
 */

public class finishMission extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_finish_mission);

        ArrayList<String> results =  this.getIntent().getStringArrayListExtra("results");

        int totalgasto = this.getIntent().getIntExtra("valorGasto",0);
        int totalXPMissao = this.getIntent().getIntExtra("XPGanho",0);

        Usuario usuario = new Usuario();
        usuario = new userFunctions().GetUserSection(this);


        TextView txtStatusMissao = (TextView) findViewById(R.id.txtStatusMissao);
        LinearLayout background = (LinearLayout) findViewById(R.id.layoutBackground);

        if(results.size() == 0){ //Sucesso na missao
            txtStatusMissao.setText("Parabéns, você concluiu a missão com sucesso e ganhou "+totalXPMissao+ " de experiência e "+totalgasto+ " de ouros!");

            Double ouros = usuario.getDinheiro();

            usuario.setDinheiro(totalgasto + ouros + (totalXPMissao * 4));

            long experiencia = usuario.getPontuacao();

            usuario.setPontuacao(experiencia + totalXPMissao);

            final Usuario finalUsuario = usuario;

            Thread thread = new Thread(){
                public void run(){
                    new userFunctions().UpdateUserSection(finishMission.this, finalUsuario);

                    //Atualiza usuário na API
                    new userFunctions().CadastrarUsuario(finishMission.this, finalUsuario.getNome(), finalUsuario.getEmail(), finalUsuario.getSenha(), finalUsuario.getSenha(),null, finalUsuario.getDinheiro().intValue(), finalUsuario.getNivel(), finalUsuario.getPontuacao());

                }
            };

            thread.start();




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
