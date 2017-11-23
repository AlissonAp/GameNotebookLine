package app.testeconsumerestapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import app.testeconsumerestapi.models.Usuario;
import app.testeconsumerestapi.utils.userFunctions;
import okhttp3.OkHttpClient;


/**
 * Created by Alisson on 03/11/2017.
 */

public class initialPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_principal);

            Stetho.initializeWithDefaults(this);

            OkHttpClient client = new OkHttpClient();

            client.newBuilder().addInterceptor(new StethoInterceptor()).build();

            //Verify if users session exists
           Usuario usuario =  new userFunctions().GetUserSection(this);

           if(usuario != null){ //if session exists then continue to mission screen
               goToMissionList();
           }

        }catch (Exception ex){
            new userFunctions().enviarNotificacao(this, ex.toString());
        }

    }


    public void goToLogin(View view){

        Intent LoginScreen = new Intent(this,loginUserActivity.class);
        startActivity(LoginScreen);

    }

    public void goToCreateUser(View view){

        Intent CreateUserScreen = new Intent(this,createUserActivity.class);
        startActivity(CreateUserScreen);

    }

    public void goToMissionList(){
        Intent missoesScreen = new Intent(this, listMissaoActivity.class);
        startActivity(missoesScreen);

    }


}
