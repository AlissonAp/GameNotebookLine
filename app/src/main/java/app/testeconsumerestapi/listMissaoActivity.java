package app.testeconsumerestapi;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.List;

import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.models.Usuario;
import app.testeconsumerestapi.utils.missoesAdapter;
import app.testeconsumerestapi.utils.otherFunctions;
import app.testeconsumerestapi.utils.userFunctions;

/**
 * Created by Alisson on 03/11/2017.
 */

public class listMissaoActivity extends AppCompatActivity {


    ListView listViewMissoes;
    private TextView txtNome;
    private TextView txtPontuacao;
    private TextView txtNivel;
    private TextView txtDinheiro;


    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        try {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.layout_list_missoes);

        View geral = findViewById(R.id.geral);
        geral.setVisibility(View.VISIBLE);

        View infoUser = findViewById(R.id.infoUser);
        infoUser.setVisibility(View.VISIBLE);

        View listMissoes = findViewById(R.id.missoes);
        listMissoes.setVisibility(View.VISIBLE);

        PopulateMissoes();
        PopulaUsuario();


        } catch (Exception ex) {

            System.out.println("Excessao");
            new userFunctions().enviarNotificacao(this, ex.toString());

        }
    }

    public void PopulateMissoes() {

        listViewMissoes = (ListView) findViewById(R.id.listView_missoes);

        //Carrega as missões do banco de dados
        List<Missao> missoesFromBD = new otherFunctions().carregarMissoes(this.getApplicationContext());
        Resources res = getResources();
        missoesAdapter missoesAdapter = new missoesAdapter(this, missoesFromBD, res);

        listViewMissoes.setAdapter(missoesAdapter);
    }

    public void PopulaUsuario() {

        txtNome = (TextView) findViewById(R.id.txtNome);
        txtPontuacao = (TextView) findViewById(R.id.txtPontuacao);
        txtDinheiro = (TextView) findViewById(R.id.txtDinheiro);
        txtNivel = (TextView) findViewById(R.id.txtNivel);

        Usuario usuario = new userFunctions().GetUserSection(this);

        if (usuario.getNome() != null) {

            txtNome.setText("Nome: " + usuario.getNome());
            txtDinheiro.setText("Ouros: " + usuario.getDinheiro());
            txtNivel.setText("Nível: " + usuario.getNivel());
            txtPontuacao.setText("Experiência: " + usuario.getPontuacao());

            ImageView image = (ImageView) findViewById(R.id.imgUser);

            byte[] decodedString = {};
            if (usuario.getImagem() != null) {
                decodedString = Base64.decode(usuario.getImagem(), Base64.DEFAULT);
            } else {

                Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.default_img);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bm.compress(Bitmap.CompressFormat.PNG, 0, baos); //bm is the bitmap object
                decodedString = baos.toByteArray();
            }


            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            Bitmap output = Bitmap.createBitmap(decodedByte.getWidth(), decodedByte.getHeight(),
                    Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);

            final int borderSizePx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) 1,
                    image.getResources().getDisplayMetrics());
            final int cornerSizePx = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) 20,
                    image.getResources().getDisplayMetrics());

            final Paint paint = new Paint();
            final Rect rect = new Rect(0, 0, decodedByte.getWidth(), decodedByte.getHeight());
            final RectF rectF = new RectF(rect);

            paint.setAntiAlias(true);
            paint.setColor(0xFFFFFFFF);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawRoundRect(rectF, cornerSizePx, cornerSizePx, paint);

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(decodedByte, rect, rect, paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth((float) borderSizePx);
            canvas.drawRoundRect(rectF, cornerSizePx, cornerSizePx, paint);

            image.setImageBitmap(output);
        }else{

            finish();
        }

    }

    public void Logout(View view){
        new userFunctions().Logout(this);
        Intent login = new Intent(this, initialPageActivity.class);

        startActivity(login);

    }

}
