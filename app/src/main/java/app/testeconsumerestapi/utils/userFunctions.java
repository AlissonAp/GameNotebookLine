package app.testeconsumerestapi.utils;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import app.testeconsumerestapi.models.Usuario;

/**
 * Created by Alisson on 30/09/2017.
 */

public class userFunctions {

    public void enviarNotificacao(Context contexto, String texto){

        Context context = contexto.getApplicationContext();
        CharSequence text = texto;

        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.show();

    }

    public String CadastrarUsuario(Context contexto, EditText nome, EditText email, EditText senha, EditText confirmacaoSenha){

        userFunctions funcoes = new userFunctions();

        //Validação da senha informada
        if(senha.toString().trim().equals(confirmacaoSenha.toString().trim())){
            return "As senhas informadas não conferem!";
        }else{

            Usuario usuario = new Usuario();

            usuario.setEmail(email.toString().trim());
            usuario.setNome(nome.toString().trim());
            usuario.setSenha(senha.toString().trim());
            usuario.setDinheiro(10000);
            usuario.setNivel(1);
            usuario.setPontuacao(0);
            usuario.setUltimaMissao(0);
            usuario.setUltimoAcesso(0);

            //Realiza comunicação com a API para cadastrar o usuário
            Rest_API api_communication = new Rest_API();

            return api_communication.criarUsuario(usuario,contexto);

        }
    }



}
