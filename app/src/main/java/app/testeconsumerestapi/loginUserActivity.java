package app.testeconsumerestapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import app.testeconsumerestapi.models.request;
import app.testeconsumerestapi.utils.otherFunctions;
import app.testeconsumerestapi.utils.userFunctions;


/**
 * Created by Alisson on 02/11/2017.
 */

public class loginUserActivity  extends AppCompatActivity{

    EditText email;
    EditText senha;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        this.deleteDatabase("bd_notebookline_new");
        this.deleteDatabase("bd_notebookline");
        this.deleteDatabase("bd_notebookline2");
    }


    public void EfetuarLogin(View view){

        String retorno = "";

        email = (EditText) findViewById(R.id.txtEmail);
        senha = (EditText) findViewById(R.id.txtSenha);

        userFunctions function = new userFunctions();


        if(!email.getText().toString().isEmpty() && !senha.getText().toString().isEmpty()) {

            request retornoAPI = function.FazerLogin(email, senha, view.getContext());

            if (retornoAPI.status != 500) {
                retorno = retornoAPI.msg;

                if (retornoAPI.ok == true) { //Se entrou aqui pode seguir adiante, o usuário foi validado com sucesso
                    //Carrega dados de missoes e peças para salvar localmente
                    new otherFunctions().LoadData(view.getContext());

                    //Aqui vai dimensionar para a tela de listagem das missoes
                    Intent missoesScreen = new Intent(this, listMissaoActivity.class);

                    startActivity(missoesScreen);

                } else {
                    retorno = retornoAPI.msg;
                }
            } else {
                retorno = "Houve uma falha ao validar o usuário";
            }
        }else{
            retorno = "É necessário informar o e-mail e a senha!";
        }

        function.enviarNotificacao(view.getContext(),retorno);

    }




}
