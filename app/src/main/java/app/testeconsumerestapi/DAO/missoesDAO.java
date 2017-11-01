package app.testeconsumerestapi.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import app.testeconsumerestapi.db.BancoDados;
import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.utils.Rest_API;

/**
 * Created by Alisson on 02/10/2017.
 */

public class missoesDAO {

    private SQLiteDatabase db;
    private BancoDados banco;

    public missoesDAO(Context context){
        banco = new BancoDados(context);
    }

    public boolean InsertPecasFromAPI(String query){

        long resultado;
        ContentValues valores;

        int contaErros = 0;

        Rest_API pecasAPI = new Rest_API();
        //Busca todas as peças disponíveis na API Node
        List<Missao> missoes =  pecasAPI.buscarMissoes(query);

        db = banco.getWritableDatabase();

        for(Missao m : missoes){

            valores = new ContentValues();

            valores.put(BancoDados.missaoCodigo, m.id );
            valores.put(BancoDados.missaoNome, m.nome);
            valores.put(BancoDados.missaoObjetivo, m.objetivo);
            valores.put(BancoDados.missaoRegras, m.regras);
            valores.put(BancoDados.missaoCadastro, String.valueOf(m.dataCadastro));

            resultado = db.insert(BancoDados.tblMissoes, null, valores);

            if (resultado ==-1) {
                contaErros++;
            }

        }

        db.close();

        if(contaErros == 0){
            return true;
        }else{
            return false;
        }

    }

    public Cursor loadMissoes(ArrayList<String> fields){
        return banco.selectDate(banco.tblMissoes,fields);
    }

}
