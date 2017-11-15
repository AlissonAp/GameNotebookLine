package app.testeconsumerestapi.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.testeconsumerestapi.DAO.missoesDAO;
import app.testeconsumerestapi.DAO.pecasDAO;
import app.testeconsumerestapi.Rest_Consummer.comunicaWSRest;
import app.testeconsumerestapi.db.BancoDados;
import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.models.Peca;
import app.testeconsumerestapi.models.propriedadesPeca;

/**
 * Created by Alisson on 01/11/2017.
 */

public class otherFunctions {


    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);


    public static boolean validarEmail(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void LoadData(Context contexto){

       new pecasDAO(contexto).InsertPecasFromAPI("",contexto);
       new missoesDAO(contexto).InsertMissoesFromAPI("",contexto);

    }

    public List<Missao> carregarMissoes(Context contexto){

        ArrayList<String> campos = new ArrayList<>();

        campos.add(BancoDados.missaoCodigo);
        campos.add(BancoDados.missaoNome);
        campos.add(BancoDados.missaoObjetivo);

        Cursor c = new missoesDAO(contexto).loadMissoes(campos);

        List<Missao> missoes = new ArrayList<>();

        try{
            while(c.moveToNext()){

                Missao missao = new Missao();

                missao.setNome(c.getString(c.getColumnIndex(BancoDados.missaoNome)));
                missao.setObjetivo(c.getString(c.getColumnIndex(BancoDados.missaoObjetivo)));

                missoes.add(missao);
            }

            return missoes;

        }catch (Exception ex){
            System.out.println("Excessao");
            return new ArrayList<Missao>();
        }

    }

    public List<Peca> carregarpecas(Context contexto){

        BancoDados bd = new BancoDados(contexto);

        Cursor c = bd.getReadableDatabase().rawQuery(BancoDados.selectPeca,null);

        List<Peca> pecas = new ArrayList<>();

        try{
            while(c.moveToNext()){

                Peca peca = new Peca();

                peca.set_id(c.getString(c.getColumnIndex(BancoDados.pecaCodigo)));
                peca.setCategoria(c.getInt(c.getColumnIndex(BancoDados.pecaCategoria)));
                peca.setDescricao(c.getString(c.getColumnIndex(BancoDados.pecaDescricao)));
                peca.setInformacoes(c.getString(c.getColumnIndex(BancoDados.pecaInformacoes)));

                propriedadesPeca propsPeca;

                propsPeca = new jsonToModel().propriedadesPecaFromJSON(c.getString(c.getColumnIndex(BancoDados.pecaPropriedades)));

                peca.setPropriedades(propsPeca);
                peca.setImagem(c.getString(c.getColumnIndex(BancoDados.pecaImagem)));
                peca.setNivel(c.getInt(c.getColumnIndex(BancoDados.pecaNivel)));
                peca.setPreco(c.getInt(c.getColumnIndex(BancoDados.pecaPreco)));
                peca.setDataCadastro(c.getString(c.getColumnIndex(BancoDados.pecaCadastro)));

                pecas.add(peca);
            }

            return pecas;

        }catch (Exception ex){
            return new ArrayList<Peca>();
        }

    }

    public Bitmap base64ToBitmap(String base64Image){

        byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return decodedByte;

    }


}
