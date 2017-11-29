package app.testeconsumerestapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import app.testeconsumerestapi.models.Usuario;
import app.testeconsumerestapi.models.request;
import app.testeconsumerestapi.utils.otherFunctions;
import app.testeconsumerestapi.utils.userFunctions;
import okhttp3.OkHttpClient;


/**
 * Created by Alisson on 03/11/2017.
 */

public class initialPageActivity extends AppCompatActivity {

    private EditText email;
    private EditText senha;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_principal);

            Stetho.initializeWithDefaults(this);

            OkHttpClient client = new OkHttpClient();

            client.newBuilder().addInterceptor(new StethoInterceptor()).build();


            //Verify if users session exists
           Usuario usuario =  new userFunctions().GetUserSection(this);

           if(usuario != null){ //if session exists then continue to mission screen
               goToMissionList();

           }else{


               email = (EditText) findViewById(R.id.txtEmail);
               senha = (EditText) findViewById(R.id.txtSenha);

               email.setText("aaphardware@gmail.com");
               senha.setText("1234");

           }

        }catch (Exception ex){
            new userFunctions().enviarNotificacao(this, ex.toString());
        }

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

    public void goToLogin(View view){

        Intent LoginScreen = new Intent(this,loginUserActivity.class);
        startActivity(LoginScreen);

    }

    public void goToCreateUser(View view){

        Intent CreateUserScreen = new Intent(this,createUserActivity.class);
        startActivity(CreateUserScreen);

    }

    public void goToMissionList(){
        Intent missoesScreen = new Intent(this, listMissaoActivity.class);
        startActivity(missoesScreen);

    }


}
