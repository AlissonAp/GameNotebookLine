package app.testeconsumerestapi.utils;

import android.util.Log;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import app.testeconsumerestapi.R;
import app.testeconsumerestapi.Rest_Consummer.RetrofitService;
import app.testeconsumerestapi.Rest_Consummer.jsonConfiguration;
import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.models.Peca;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alisson on 30/09/2017.
 */

/* Esta classe contém os métodos de busca de informações, tanto na API Rest quanto no banco de dados local do app */

public class infoSearchAPI {

    List<Peca> pecas = new ArrayList<>();
    List<Missao> missoes = new ArrayList<>();


    public List<Peca> buscarPecas(String query){

        pecas.clear();

        RetrofitService service =  new jsonConfiguration().jsonServiceConfiguration();

        try {

            Call<List<Peca>> requestPecas = service.buscarInfoPecas();

            requestPecas.enqueue(new Callback<List<Peca>>() {

                @Override
                public void onResponse(Call<List<Peca>> call, Response<List<Peca>> response) {
                    pecas = response.body();
                }
                @Override
                public void onFailure(Call<List<Peca>> call, Throwable t) {
                    pecas = new ArrayList<>();
                }
            });

        }catch(Exception ex){
            return null;
        }

        return pecas;
    }

    public List<Missao> buscarMissoes(String query){

        missoes.clear();

        RetrofitService service =  new jsonConfiguration().jsonServiceConfiguration();

        try {

            Call<List<Missao>> requestMissoes = service.buscarInfoMissoes();

            requestMissoes.enqueue(new Callback<List<Missao>>() {
                @Override
                public void onResponse(Call<List<Missao>> call, Response<List<Missao>> response) {
                    missoes = response.body();
                }
                @Override
                public void onFailure(Call<List<Missao>> call, Throwable t) {
                    missoes = new ArrayList<>();
                }
            });

        }catch(Exception ex){
            return null;
        }
        return missoes;
    }

}
