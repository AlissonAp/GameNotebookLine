package app.testeconsumerestapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.utils.jsonToModel;
import app.testeconsumerestapi.utils.otherFunctions;
import app.testeconsumerestapi.utils.userFunctions;

/**
 * Created by Alisson on 15/11/2017.
 */

public class startMissao extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        try {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_start_missao);

            preencheInfoMissaoTela();

        }catch (Exception ex){

            new userFunctions().enviarNotificacao(this,ex.toString());

        }

    }


    public void preencheInfoMissaoTela(){

        TextView txtHeader           = (TextView) findViewById(R.id.txtHeader);
        TextView txtInfoMissao       = (TextView) findViewById(R.id.txtInformacaoesMissao);
        TextView txtRecompensaMissao = (TextView) findViewById(R.id.txtRecompensas);

        String JsonMissao = this.getIntent().getStringExtra("parameters");

        if (JsonMissao != null) {


            //Convert JSON to Object Missao
            Missao missao = new jsonToModel().MissaoFromJson(JsonMissao);


            String textoHeader      = "Olá, você selecionou a missão "+missao.getNome()+ ", veja mais detalhes abaixo..";
            String textoInfoMissao  = missao.getObjetivo();
            String textoRecompensa  = "Ao concluir essa missão você ganhará "+missao.getXP().toString()+" de experiência e 2000 ouros";

            txtHeader.setText(textoHeader);
            txtInfoMissao.setText(textoInfoMissao);
            txtRecompensaMissao.setText(textoRecompensa);


        }

    }

    public void iniciarMissao(View view){

        //redirect to next screen
        Intent startScreen = new Intent(this, stepsSelecaoPecasMissao.class);

        startActivity(startScreen);

    }

}
