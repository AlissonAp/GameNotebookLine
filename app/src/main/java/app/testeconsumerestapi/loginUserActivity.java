package app.testeconsumerestapi;

import android.content.Intent;
import android.content.SharedPreferences;
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

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);


        email = (EditText) findViewById(R.id.txtEmail);
        senha = (EditText) findViewById(R.id.txtSenha);

        email.setText("aaphardware@gmail.com");
        senha.setText("1234");

    }


    public void EfetuarLogin(View view){

        String retorno = "";

        email = (EditText) findViewById(R.id.txtEmail);
        senha = (EditText) findViewById(R.id.txtSenha);

        userFunctions function = new userFunctions();

        if(!email.getText().toString().isEmpty() && !senha.getText().toString().isEmpty()) {

            request retornoAPI = function.FazerLogin(email, senha, view.getContext());

            if (retornoAPI.status != 500) {

                if (retornoAPI.ok == true) { //user validate success

                    retorno = "Usuário validado com sucesso!";

                    if(!retornoAPI.msg.isEmpty()) {

                        //Load mission date
                        new otherFunctions().LoadData(view.getContext());

                        // Start user session
                        new userFunctions().SetUserSection(this, retornoAPI.msg);

                        //redirect to next screen
                        Intent missoesScreen = new Intent(this, listMissaoActivity.class);

                        startActivity(missoesScreen);

                    }
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
