package app.testeconsumerestapi.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

import app.testeconsumerestapi.R;
import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.startMissao;

/**
 * Created by Alisson on 09/11/2017.
 */
/********* Adapter class extends with BaseAdapter and implements with OnClickListener ************/
public class missoesAdapter extends BaseAdapter implements View.OnClickListener {

    /*********** Declare Used Variables *********/
    private Activity activity;
    private List<Missao> data;
    private static LayoutInflater inflater=null;
    public Resources res;
    Missao missao = null;
    int i=0;

    /*************  CustomAdapter Constructor *****************/
    public missoesAdapter(Activity a, List<Missao> d, Resources resLocal) {

        /********** Take passed values **********/
        activity = a;
        data=d;
        res = resLocal;

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /******** What is the size of Passed Arraylist Size ************/
    public int getCount() {

        if(data.size()<=0)
            return 1;
        return data.size();
    }

    public Object getItem(int position) {
        return data.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder{

        public TextView nome;
        public TextView informacoes;
        public TextView xp;

    }

    /****** Depends upon data size called for each row , Create each ListView row *****/
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if(convertView==null){

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.adapter_missoes, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.nome = vi.findViewById(R.id.txt_nomeMissao);
            holder.informacoes= vi.findViewById(R.id.txt_infoMissao);
            holder.xp= vi.findViewById(R.id.txt_xpMissao);

            /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else
            holder=(ViewHolder)vi.getTag();

        if(data.size()<=0)
        {
            holder.nome.setText("No Data");

        }
        else
        {
            /***** Get each Model object from Arraylist ********/
            missao =  null;
            missao = data.get(position);

            /************  Set Model values in Holder elements ***********/

            holder.nome.setText(missao.getNome());
            holder.informacoes.setText(missao.getObjetivo());

            if(missao.getXP() != null) {
            holder.xp.setText(missao.getXP().toString());
        }

            /******** Set Item Click Listner for LayoutInflater for each row *******/

            vi.setOnClickListener(new OnItemClickListener(position));
        }
        return vi;
    }

    @Override
    public void onClick(View v) {
        Log.v("CustomAdapter", "=====Row button clicked=====");
    }

    /********* Called when Item click in ListView ************/
    private class OnItemClickListener  implements View.OnClickListener{
        private int mPosition;

        OnItemClickListener(int position){
            mPosition = position;
        }

        @Override
        public void onClick(View view) {

            try {

                    String dadosMissaoBundle;

                    Intent CreateUserScreen = new Intent(view.getContext(), startMissao.class);

                    //Get information of clicked object
                    missao = data.get(mPosition);

                    dadosMissaoBundle = new modelToJson().ConvertMissaoToJson(missao);

                    CreateUserScreen.putExtra("parameters", dadosMissaoBundle);

                    //Start activity
                    view.getContext().startActivity(CreateUserScreen);

            }catch (Exception ex){
                new userFunctions().enviarNotificacao(view.getContext(),ex.toString());
            }
        }
    }
}