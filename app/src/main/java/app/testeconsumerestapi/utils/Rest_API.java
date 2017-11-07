package app.testeconsumerestapi.utils;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import app.testeconsumerestapi.Rest_Consummer.comunicaWSRest;
import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.models.Peca;
import app.testeconsumerestapi.models.Usuario;
import app.testeconsumerestapi.models.request;


/**
 * Created by Alisson on 30/09/2017.
 */

/* Esta classe contém os métodos de busca de informações, tanto na API Rest quanto no banco de dados local do app */

public class Rest_API {

    List<Peca> pecas = new ArrayList<>();
    List<Missao> missoes = new ArrayList<>();
    String baseURL = "http://localhost:3000";

    public List<Peca> buscarPecas(String query, Context contexto) {

        pecas.clear();

        try {

            comunicaWSRest ws = new comunicaWSRest();

            //Seta configurações de comunicação
            String url = config_urls_rest.baseURL;
            url += config_urls_rest.urlBuscarPecas;
            url += query;

            ws.setUrl(url);

            ws.setMetodo("GET");

            ws.execute();
            ws.get();

            if(ws.getHttpCode() != 500){ //Internal error

                List<Peca> pecas = new jsonToModel().PecasFromJSON(ws.getRetorno());
                return pecas;
            }else{
                return new ArrayList<Peca>();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return new ArrayList<Peca>();
        }

    }

    public List<Missao> buscarMissoes(String id, Context contexto) {

        missoes.clear();
        try {
            comunicaWSRest ws = new comunicaWSRest();

            //Seta configurações de comunicação
            String url = config_urls_rest.baseURL;
            url += config_urls_rest.urlBuscarMissoes;
            url += id;

            ws.setUrl(url);

            ws.setMetodo("GET");

            ws.execute();

            ws.get();


            if (ws.getHttpCode() != 500) { //Internal error

                List<Missao> missoes = new jsonToModel().MissoesFromJSON(ws.getRetorno());
                return missoes;
            } else {
                return new ArrayList<>();
            }

        }catch(Exception ex){
            System.out.println("Excessao" +ex);
            return new ArrayList<>();
        }

    }

    public request criarAtualizarUsuario(Usuario usuario, Context contexto) {

        try {
            comunicaWSRest ws = new comunicaWSRest();
            //Seta configurações de comunicação
            String url = config_urls_rest.baseURL;
            url += config_urls_rest.urlCriarUsuario;
            ws.setUrl(url);

            ws.setMetodo("POST");

            String data = new modelToJson().ConvertUsuarioToModel(usuario);

            ws.setData(data);

            ws.execute();
            ws.get();

            return new jsonToModel().requestFromJSON(ws.getRetorno());

        } catch (Exception e) {
            e.printStackTrace();
            return new request();
        }


    }

    public request Login(Usuario usuario, Context contexto){

        try {
            comunicaWSRest ws = new comunicaWSRest();
            //Seta configurações de comunicação
            String url = config_urls_rest.baseURL;

            //Seta email e senha como parametro na URL
            url += config_urls_rest.urlValidarUsuario.replace("@email",usuario.getEmail()).replace("@senha",usuario.getSenha());

            ws.setUrl(url);

            ws.execute();
            ws.get();

            return new jsonToModel().requestFromJSON(ws.getRetorno());

        } catch (Exception e) {
            e.printStackTrace();
            return new request();
        }


    }



}
