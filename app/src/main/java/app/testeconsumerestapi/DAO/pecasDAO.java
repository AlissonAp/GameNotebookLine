package app.testeconsumerestapi.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import app.testeconsumerestapi.db.BancoDados;
import app.testeconsumerestapi.models.Peca;
import app.testeconsumerestapi.utils.infoSearchAPI;

/**
 * Created by Alisson on 02/10/2017.
 */

public class pecasDAO {

    private SQLiteDatabase db;
    private BancoDados banco;

    public pecasDAO(Context context){
        banco = new BancoDados(context);
    }

    public boolean InsertPecasFromAPI(String query){

        long resultado;
        ContentValues valores;

        int contaErros = 0;

        infoSearchAPI pecasAPI = new infoSearchAPI();
        //Busca todas as peças disponíveis na API Node
        List<Peca> pecas =  pecasAPI.buscarPecas(query);

        db = banco.getWritableDatabase();

        for(Peca p : pecas){

            valores = new ContentValues();

            valores.put(BancoDados.pecaCodigo, p._id);
            valores.put(BancoDados.pecaDescricao, p.descricao);
            valores.put(BancoDados.pecaCategoria, (Integer) p.categoria);
            valores.put(BancoDados.pecaNivel, (Integer) p.nivel);
            valores.put(BancoDados.pecaPreco, (Double) p.preco);
            valores.put(BancoDados.pecaCadastro, String.valueOf(p.dataCadastro));
            valores.put(BancoDados.pecaInformacoes, p.informacoes);
            valores.put(BancoDados.pecaPropriedades, p.propriedades);
            valores.put(BancoDados.pecaImagem, p.imagem);

            resultado = db.insert(BancoDados.tblPecas, null, valores);

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

    public Cursor loadPecas(ArrayList<String> fields){
        return banco.selectDate(banco.tblPecas,fields);
    }

}
