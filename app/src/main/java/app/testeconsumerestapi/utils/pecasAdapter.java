package app.testeconsumerestapi.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import app.testeconsumerestapi.R;
import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.models.Peca;

/**
 * Created by Alisson on 09/11/2017.
 */

/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class pecasAdapter {

    /*********** Declare Used Variables *********/
    private Activity activity;
    private List<Peca> data;
    private static LayoutInflater inflater=null;
    public Resources res;
    Missao missao = null;
    int i=0;

    /*************  CustomAdapter Constructor *****************/
    public pecasAdapter(Activity a, List<Peca> d, Resources resLocal) {

        /********** Take passed values **********/
        activity = a;
        data=d;
        res = resLocal;

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public void createLayoutInflater(){

    //create LayoutInflator class
    LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    int size = data.size();

    for (int i = 0; i < size; i++) {

        Peca peca = data.get(i);

        // create dynamic LinearLayout and set Image on it.

        if (peca != null) {

            LinearLayout clickableColumn = (LinearLayout) inflater.inflate(

                    R.layout.clickable_column, null);

            ImageView thumbnailImage = (ImageView) clickableColumn

                    .findViewById(R.id.thumbnail_image);

            TextView Nome = (TextView) clickableColumn

                    .findViewById(R.id.txt_NomePeca);

            Nome.setText(peca.getDescricao());

            byte[] decodedString = Base64.decode(peca.getImagem(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0,decodedString.length);

            thumbnailImage.setImageBitmap(decodedByte);
        }
}}}