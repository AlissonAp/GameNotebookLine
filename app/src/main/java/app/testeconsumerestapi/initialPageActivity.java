package app.testeconsumerestapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Alisson on 03/11/2017.
 */

public class initialPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);

    }


    public void goToLogin(View view){

        Intent LoginScreen = new Intent(this,loginUserActivity.class);
        startActivity(LoginScreen);

    }

    public void goToCreateUser(View view){

        Intent CreateUserScreen = new Intent(this,createUserActivity.class);
        startActivity(CreateUserScreen);

    }


}
