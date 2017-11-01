package app.testeconsumerestapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import app.testeconsumerestapi.utils.userFunctions;


public class MainActivity extends AppCompatActivity {


    public static String TAG;

    EditText nome;
    EditText email;
    EditText senha;
    EditText confirmacaoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);

    }

    public void NovoUsuario(View view){

        nome = (EditText) findViewById(R.id.txtNome);
        email = (EditText) findViewById(R.id.txtEmail);
        senha = (EditText) findViewById(R.id.txtSenha);
        confirmacaoSenha = (EditText) findViewById(R.id.txtConfSenha);

        userFunctions funcao = new userFunctions();

        String retornoCadastro = funcao.CadastrarUsuario(view.getContext(),nome,email,senha,confirmacaoSenha);

        if(retornoCadastro.indexOf("Este e-mail já está cadastrado") > 0){
            funcao.enviarNotificacao(this,"Este e-mail já está sendo utilizado por outro usuário!");

        }else{
            funcao.enviarNotificacao(this,retornoCadastro);

        }

    }


}
