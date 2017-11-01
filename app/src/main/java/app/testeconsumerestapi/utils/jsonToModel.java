package app.testeconsumerestapi.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.models.Peca;
import app.testeconsumerestapi.models.propriedadesPeca;
import app.testeconsumerestapi.models.regrasMissao;

/**
 * Created by Alisson on 03/10/2017.
 */

public class jsonToModel {

    public propriedadesPeca propriedadesPecaFromJSON(String JSON){

        Gson gson = new Gson();

        try {
           return gson.fromJson(jsonConverter(JSON), propriedadesPeca.class);
        }catch(Exception ex){
            return new propriedadesPeca();
        }
    }

    public regrasMissao regrasMissaoFromJSON(String JSON){

        Gson gson = new Gson();
        try {
            return gson.fromJson(jsonConverter(JSON), regrasMissao.class);
        }catch(Exception ex){
            return new regrasMissao();
        }
    }

    public List<Missao> MissoesFromJSON(String JSON){

        Gson gson = new Gson();
        try {
            ArrayList<Missao> missoes  = gson.fromJson(jsonConverter(JSON), ArrayList.class);
            return missoes;
        }catch(Exception ex){
            return new ArrayList<Missao>();
        }
    }

    public List<Peca> PecasFromJSON(String JSON){

        Gson gson = new Gson();
        try {
            ArrayList<Peca> pecas  = gson.fromJson(jsonConverter(JSON), ArrayList.class);
            return pecas;
        }catch(Exception ex){
            return new ArrayList<Peca>();
        }
    }

    public JsonElement jsonConverter(String JSON){

        try{

            JsonParser parser = new JsonParser();
            JsonElement mJson =  parser.parse(JSON);

            return mJson;

        }catch(Exception ex){
            return null;
        }

    }

}
