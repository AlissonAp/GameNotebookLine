package app.testeconsumerestapi.utils;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import app.testeconsumerestapi.models.Usuario;
import app.testeconsumerestapi.models.request;

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

    public request CadastrarUsuario(Context contexto, EditText nome, EditText email, EditText senha, EditText confirmacaoSenha){

        userFunctions funcoes = new userFunctions();

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

            Usuario usuario = new Usuario();

            usuario.setEmail(email.getText().toString().trim());
            usuario.setNome(nome.getText().toString().trim());
            usuario.setSenha(senha.getText().toString().trim());
            usuario.setDinheiro(10000);
            usuario.setNivel(1);
            usuario.setPontuacao(0);
            usuario.setUltimaMissao(0);
            usuario.setUltimoAcesso(timeStamp);

            //Realiza comunicação com a API para cadastrar o usuário
            Rest_API api_communication = new Rest_API();

            return api_communication.criarAtualizarUsuario(usuario, contexto);

    }


    public request FazerLogin(EditText email,EditText senha, Context contexto){

        Usuario usuario = new Usuario();

        usuario.setEmail(email.getText().toString());
        usuario.setSenha(senha.getText().toString());

        //Realiza comunicação com a API para cadastrar o usuário
        Rest_API api_communication = new Rest_API();

        return api_communication.Login(usuario,contexto);

    }






}
