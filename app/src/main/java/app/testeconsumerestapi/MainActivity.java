package app.testeconsumerestapi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    public static String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);

    }


    public void enviarNotificacao(String texto){

        Context context = getApplicationContext();
        CharSequence text = texto;


        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.show();

    }

}
