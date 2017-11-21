package app.testeconsumerestapi.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import app.testeconsumerestapi.db.BancoDados;
import app.testeconsumerestapi.models.Usuario;


/**
 * Created by Alisson on 02/10/2017.
 */

public class usuariosDAO {

    private SQLiteDatabase db;
    private BancoDados banco;

    public usuariosDAO(Context context){
        banco = new BancoDados(context);
    }

    public boolean InsertNewUser(Usuario usuario) {

        long resultado;
        ContentValues valores;

        db = banco.getWritableDatabase();

        valores = new ContentValues();

        valores.put(BancoDados.usuarioNome, usuario.getNome());
        valores.put(BancoDados.usuarioEmail, usuario.getEmail());
        valores.put(BancoDados.usuarioSenha, usuario.getSenha());
        valores.put(BancoDados.usuarioDinheiro, (Double) usuario.getDinheiro());
        valores.put(BancoDados.usuarioNivel, (Integer) usuario.getNivel());
        valores.put(BancoDados.usuarioPontuacao, (Integer) usuario.getPontuacao());
        valores.put(BancoDados.usuarioUltMissao, (Integer) usuario.getUltimaMissao());
        valores.put(BancoDados.usuarioUltAcesso, String.valueOf(usuario.getUltimoAcesso()));
        valores.put(BancoDados.usuarioNome, usuario.getNome());

        resultado = db.insert(BancoDados.tblUsuarios, null, valores);


        return resultado != -1;

    }

    public Cursor loadPecas(ArrayList<String> fields){
        return banco.selectDate(BancoDados.tblUsuarios,fields);
    }

}
