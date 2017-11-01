package app.testeconsumerestapi.utils;

import com.google.gson.Gson;

import app.testeconsumerestapi.models.Usuario;

/**
 * Created by Alisson on 01/11/2017.
 */

public class modelToJson {


    public String ConvertUsuarioToModel(Usuario usuario){

    Gson gson = new Gson();
    String json = gson.toJson(usuario);

        return json;
    }

}
