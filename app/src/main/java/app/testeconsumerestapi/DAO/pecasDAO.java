package app.testeconsumerestapi.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import app.testeconsumerestapi.db.BancoDados;
import app.testeconsumerestapi.models.Peca;
import app.testeconsumerestapi.utils.Rest_API;

/**
 * Created by Alisson on 02/10/2017.
 */

public class pecasDAO {

    private SQLiteDatabase db;
    private BancoDados banco;

    public pecasDAO(Context context){
        banco = new BancoDados(context);
    }

    public boolean InsertPecasFromAPI(String query, Context context){

        long resultado;
        ContentValues cv;

        int contaErros = 0;

        Rest_API pecasAPI = new Rest_API();
        //Busca todas as peças disponíveis na API Node
        List<Peca> pecas =  pecasAPI.buscarPecas(query,context);

        try {

            db = banco.getWritableDatabase();

            for (Peca peca : pecas) {

                cv = new ContentValues();

                cv.put(BancoDados.pecaCodigo, peca.get_id());
                cv.put(BancoDados.pecaCategoria, peca.getCategoria());
                cv.put(BancoDados.pecaDescricao, peca.getDescricao());
                cv.put(BancoDados.pecaInformacoes, peca.getInformacoes());
                cv.put(BancoDados.pecaPropriedades, peca.getPropriedades());
                cv.put(BancoDados.pecaImagem, peca.getImagem());
                cv.put(BancoDados.pecaNivel, peca.getNivel());
                cv.put(BancoDados.pecaPreco, peca.getPreco());
                cv.put(BancoDados.pecaCadastro, peca.getDataCadastro());

                resultado = db.insert(BancoDados.tblPecas, null, cv);

                if (resultado == -1) {
                    contaErros++;
                }
            }

            db.close();

        }catch(Exception ex){
            System.out.println(ex);
        }

        if(contaErros == 0){
            return true;
        }else{
            return false;
        }

    }

    public Cursor loadPecas(ArrayList<String> fields){
        return banco.selectDate(banco.tblPecas,fields);
    }

}
