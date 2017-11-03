package app.testeconsumerestapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import app.testeconsumerestapi.models.request;
import app.testeconsumerestapi.utils.otherFunctions;
import app.testeconsumerestapi.utils.userFunctions;


public class createUserActivity extends AppCompatActivity {


    public static String TAG;

    EditText nome;
    EditText email;
    EditText senha;
    EditText confirmacaoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_new_user);

    }

    public void NovoUsuario(View view){

        String retorno = "";

        nome  = (EditText) findViewById(R.id.txtNome);
        email = (EditText) findViewById(R.id.txtEmail);
        senha = (EditText) findViewById(R.id.txtSenha);
        confirmacaoSenha = (EditText) findViewById(R.id.txtConfSenha);

        userFunctions funcao = new userFunctions();

        if(nome.getText().toString().isEmpty()){
            retorno = "Informe um nome de usuário";
        }else if(email.getText().toString().isEmpty() || !otherFunctions.validarEmail(email.getText().toString())){
            retorno = "Informe um endereço de e-mail válido";
        }else {

            if (!senha.getText().toString().equals(confirmacaoSenha.getText().toString())) {
                retorno = "As senhas não conferem!";
            } else {

                request retornoCadastro = funcao.CadastrarUsuario(view.getContext(), nome, email, senha, confirmacaoSenha);

                if (retornoCadastro.status != 500) {
                    retorno = retornoCadastro.msg;

                    //Direciona para a tela de login
                    Intent LoginScreen = new Intent(this,loginUserActivity.class);
                    startActivity(LoginScreen);

                } else {
                    retorno = "Falha ao cadastrar o usuário";
                }

            }

        }

        funcao.enviarNotificacao(this,retorno);

    }


}
