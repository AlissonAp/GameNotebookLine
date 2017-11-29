package app.testeconsumerestapi;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import app.testeconsumerestapi.models.request;
import app.testeconsumerestapi.utils.otherFunctions;
import app.testeconsumerestapi.utils.userFunctions;


public class createUserActivity extends AppCompatActivity {

    private static final int SELECT_PICTURE = 100;

    public static String TAG;

    EditText nome;
    EditText email;
    EditText senha;
    EditText confirmacaoSenha;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_new_user);

    }

    public void NovoUsuario(View view) {

        String retorno = "";

        nome = (EditText) findViewById(R.id.txtNome);
        email = (EditText) findViewById(R.id.txtEmail);
        senha = (EditText) findViewById(R.id.txtSenha);
        confirmacaoSenha = (EditText) findViewById(R.id.txtConfSenha);
        img = (ImageView) findViewById(R.id.img);


        userFunctions funcao = new userFunctions();

        if (nome.getText().toString().isEmpty()) {
            retorno = "Informe um nome de usuário";
        } else if (email.getText().toString().isEmpty() || !otherFunctions.validarEmail(email.getText().toString())) {
            retorno = "Informe um endereço de e-mail válido";
        } else {

            if (!senha.getText().toString().equals(confirmacaoSenha.getText().toString())) {
                retorno = "As senhas não conferem!";
            } else {

                request retornoCadastro = funcao.CadastrarUsuario(view.getContext(), nome, email, senha, confirmacaoSenha, img);

                if (retornoCadastro.status != 500) {
                    retorno = retornoCadastro.msg;

                    //Direciona para a tela de login
                    Intent LoginScreen = new Intent(this, loginUserActivity.class);
                    startActivity(LoginScreen);

                } else {
                    retorno = "Falha ao cadastrar o usuário";
                }

            }

        }

        funcao.enviarNotificacao(this, retorno);

    }

    public void SelecionarImg(View view) {
        Intent i = new Intent(
                Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(i, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == 1 && resultCode == RESULT_OK && null != data) {
//            Uri selectedImage = data.getData();
//            String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//            Cursor cursor = getContentResolver().query(selectedImage,
//                    filePathColumn, null, null, null);
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            String picturePath = cursor.getString(columnIndex);
//            cursor.close();
//
//            Uri contentURI = data.getData();
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
//                String path = saveImage(bitmap);
//
//                img.setImageBitmap(bitmap);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//
//            }
//
//            img.setImageBitmap(BitmapFactory.decodeFile(picturePath));
//            // String picturePath contains the path of selected Image
//        }

        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == 1) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    String path = saveImage(bitmap);

                    img.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();

                }
            }

        } else if (requestCode == 2) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(thumbnail);
            saveImage(thumbnail);
        }
    }

    /* Get the real path from the URI */
    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + "/demonuts");
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return null;
    }
}
