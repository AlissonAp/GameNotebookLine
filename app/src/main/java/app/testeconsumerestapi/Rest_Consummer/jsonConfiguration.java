package app.testeconsumerestapi.Rest_Consummer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alisson on 30/09/2017.
 */

public class jsonConfiguration {


    public RetrofitService jsonServiceConfiguration(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .disableHtmlEscaping()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);

        return service;
    }
}
