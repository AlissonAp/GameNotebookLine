package app.testeconsumerestapi.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import app.testeconsumerestapi.db.BancoDados;
import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.models.regrasMissao;
import app.testeconsumerestapi.utils.Rest_API;
import app.testeconsumerestapi.utils.jsonToModel;
import app.testeconsumerestapi.utils.modelToJson;
import app.testeconsumerestapi.utils.otherFunctions;

/**
 * Created by Alisson on 02/10/2017.
 */

public class missoesDAO {

    private SQLiteDatabase db;
    private BancoDados banco;

    public missoesDAO(Context context){
        banco = new BancoDados(context);
    }

    public boolean InsertMissoesFromAPI(String query, Context context){

        long resultado;
        ContentValues cv;

        int contaErros = 0;

        Rest_API pecasAPI = new Rest_API();

        //Busca todas as peças disponíveis na API Node
        List<Missao> missoes =  pecasAPI.buscarMissoes(query,context);

        if(!missoes.isEmpty() && missoes != null) {

            //Carrega missoes já existentes no bd
            List<Missao> missoesExistentes = new otherFunctions().carregarMissoes(context);

            db = banco.getWritableDatabase();

            for (Missao missao : missoes) {

                //Insere somente as missões que ainda não estão no BD
                if (!missoesExistentes.contains(missao)) {

                    cv = new ContentValues();

                    cv.put(BancoDados.missaoCodigo, missao.get_id());
                    cv.put(BancoDados.missaoNome, missao.getNome());
                    cv.put(BancoDados.missaoObjetivo, missao.getObjetivo());
                    cv.put(BancoDados.missaoRegras, new modelToJson().ConvertRegrasToJson(missao.getRegras()));
                    cv.put(BancoDados.missaoCadastro, missao.getDataCadastro());


                    resultado = db.insert(BancoDados.tblMissoes, null, cv);

                    if (resultado == -1) {
                        contaErros++;
                    }

                }

            }

            db.close();
        }

            if (contaErros == 0) {
                return true;
            } else {
                return false;
            }

    }

    public Cursor loadMissoes(ArrayList<String> fields){
        return banco.selectDate(banco.tblMissoes,fields);
    }

}
