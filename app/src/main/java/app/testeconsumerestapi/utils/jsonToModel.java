package app.testeconsumerestapi.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.models.Missoes;
import app.testeconsumerestapi.models.Peca;
import app.testeconsumerestapi.models.Pecas;
import app.testeconsumerestapi.models.propriedadesPeca;
import app.testeconsumerestapi.models.regrasMissao;
import app.testeconsumerestapi.models.request;

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

    public request requestFromJSON(String JSON){

        Gson gson = new Gson();
        try {
            return gson.fromJson(jsonConverter(JSON), request.class);
        }catch(Exception ex){
            return new request();
        }
    }


    public List<Missao> MissoesFromJSON(String JSON){

        Gson gson = new Gson();
        Type type = new TypeToken<List<Missao>>(){}.getType();
        try {
            List<Missao> missoes  = gson.fromJson(jsonConverter(JSON),type);
            return missoes;
        }catch(Exception ex){
            System.out.println(ex);
            return new ArrayList<Missao>();
        }
    }

    public List<Peca> PecasFromJSON(String JSON){

        Gson gson = new Gson();

        Type type = new TypeToken<List<Peca>>(){}.getType();

        try {
            List<Peca> pecas  = gson.fromJson(jsonConverter(JSON), type);

            System.out.println(pecas);

            return pecas;
        }catch(Exception ex){
            System.out.println(ex);
            return new ArrayList<Peca>();

        }
    }

    public Missao MissaoFromJson(String JSON){

        Gson gson = new Gson();

        try {
            Missao missao = gson.fromJson(jsonConverter(JSON), Missao.class);

            return missao;
        }catch(Exception ex){

           return null;

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
