package app.testeconsumerestapi.Rest_Consummer;

import org.json.JSONObject;

import java.util.List;

import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.models.Peca;
import app.testeconsumerestapi.models.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by Alisson on 18/09/2017.
 */

public interface RetrofitService {

    public static final String BASE_URL = "https://apinode20171234.herokuapp.com/";

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @GET("Pecas")
    Call<List<Peca>> buscarInfoPecas();

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @GET("Missoes")
    Call<List<Missao>> buscarInfoMissoes(@Path("id") String idMissao);

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("usuarios/cadastrar")
    Call<JSONObject> criarUsuario (@Body Usuario usuario);

}
