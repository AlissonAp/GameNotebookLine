package app.testeconsumerestapi.utils;

import com.google.gson.Gson;

import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.models.Peca;
import app.testeconsumerestapi.models.Usuario;
import app.testeconsumerestapi.models.propriedadesPeca;
import app.testeconsumerestapi.models.regrasMissao;

/**
 * Created by Alisson on 01/11/2017.
 */

public class modelToJson {


    public String ConvertUsuarioToModel(Usuario usuario){

    Gson gson = new Gson();
    String json = gson.toJson(usuario);

        return json;
    }

    public String ConvertPropriedadesToJson(propriedadesPeca props){

        Gson gson = new Gson();
        String json = gson.toJson(props);

        return json;

    }

    public String ConvertRegrasToJson(regrasMissao regras){

        Gson gson = new Gson();
        String json = gson.toJson(regras);

        return json;
    }

    public String ConvertMissaoToJson(Missao missao){

        Gson gson = new Gson();
        String json = gson.toJson(missao);

        return json;
    }


    public String ConvertPecaToJson(Peca peca){

        Gson gson = new Gson();
        String json = gson.toJson(peca);

        return json;
    }

}
