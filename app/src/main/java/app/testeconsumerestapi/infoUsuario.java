package app.testeconsumerestapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import app.testeconsumerestapi.models.Usuario;
import app.testeconsumerestapi.utils.userFunctions;

public class infoUsuario extends AppCompatActivity {

    private TextView txtNome;
    private TextView txtPontuacao;
    private TextView txtNivel;
    private TextView txtDinheiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_info_usuario);

        txtNome			= (TextView) findViewById(R.id.txtNome);
        txtPontuacao	= (TextView) findViewById(R.id.txtPontuacao);
        txtDinheiro		= (TextView) findViewById(R.id.txtDinheiro);
        txtNivel		= (TextView) findViewById(R.id.txtNivel);

        Usuario usuario =  new userFunctions().GetUserSection(this);

        txtNome.setText(usuario.getNome());
        txtDinheiro.setText(usuario.getDinheiro().toString());
        txtNivel.setText(String.valueOf(usuario.getNivel()));
        txtPontuacao.setText(String.valueOf(usuario.getPontuacao()));

        finish();


    }
}
