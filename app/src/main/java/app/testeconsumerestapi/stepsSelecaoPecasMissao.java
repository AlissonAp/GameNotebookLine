package app.testeconsumerestapi;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.stetho.common.ArrayListAccumulator;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import app.testeconsumerestapi.Enumerations.categoriasPeca;
import app.testeconsumerestapi.models.EscolhasMissao;
import app.testeconsumerestapi.models.Peca;
import app.testeconsumerestapi.models.Usuario;
import app.testeconsumerestapi.utils.otherFunctions;
import app.testeconsumerestapi.utils.pecasAdapter;
import app.testeconsumerestapi.utils.pecasAdapter.ItemClickListener;
import app.testeconsumerestapi.utils.userFunctions;

/**
 * Created by Alisson on 11/11/2017.
 */

public class stepsSelecaoPecasMissao extends AppCompatActivity{

    private pecasAdapter adapter;
    private int etapaMissao =  1;
    private categoriasPeca categoriaSelecionada = categoriasPeca.Carcaca;
    private Usuario usuario;
    private EscolhasMissao escolhasMissao;
    private List<Peca> pecasEscolhidas = new ArrayList<>();
    private RecyclerView recyclerView;
    private Button btnProsseguir;
    private Peca pecaEscolhida;
    private int etapaAtual = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_steps_missao);

        try {

            // set up the RecyclerView
            recyclerView = (RecyclerView) findViewById(R.id.rvPecas);
            LinearLayoutManager horizontalLayoutManager
                    = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(horizontalLayoutManager);

            usuario = new userFunctions().GetUserSection(this);
            btnProsseguir = (Button) findViewById(R.id.btn_seguir);

            //Initialize with 0
            avancarEtapa(recyclerView);

        }catch(Exception ex){
            new userFunctions().enviarNotificacao(this,ex.toString());
        }

    }

    public void avancarEtapa(View view) {

        try {

            if (etapaAtual != 0) {
                pecasEscolhidas.add(pecaEscolhida);

                //Clear peca data
                pecaEscolhida = new Peca();
            }

            etapaAtual += 1;

            TextView etapa = (TextView) findViewById(R.id.txtDescEtapa);
            TextView nivel = (TextView) findViewById(R.id.txtNivel);
            TextView nomeUsuario = (TextView) findViewById(R.id.txtNomeUser);
            TextView ouros = (TextView) findViewById(R.id.txtOuro);


            nivel.setText(usuario.getNivel().toString());
            nomeUsuario.setText(usuario.getNome());
            ouros.setText(usuario.getDinheiro().toString());

            switch (etapaAtual) {

                case 1:

                    etapa.setText("Etapa 1 - Carcaça");
                    categoriaSelecionada = categoriasPeca.Carcaca;
                    break;

                case 2:
                    etapa.setText("Etapa 2 - Placa mãe");
                    categoriaSelecionada = categoriasPeca.PlacaMae;
                    break;

                case 3:
                    etapa.setText("Etapa 3 - Armazenamento");
                    categoriaSelecionada = categoriasPeca.Armazenamento;
                    break;

                case 4:
                    etapa.setText("Etapa 4 - Processador");
                    categoriaSelecionada = categoriasPeca.Processador;
                    break;

                case 5:
                    etapa.setText("Etapa 5 - Memória");
                    categoriaSelecionada = categoriasPeca.Memoria;
                    break;

                case 6:
                    etapa.setText("Etapa 6 - Wireless");
                    categoriaSelecionada = categoriasPeca.Wireless;
                    break;

                case 7:
                    etapa.setText("Etapa 7 - Bateria");
                    categoriaSelecionada = categoriasPeca.Bateria;
                    break;

                case 8:
                    etapa.setText("Etapa 8 - Periféricos");
                    categoriaSelecionada = categoriasPeca.Perifericos;
                    break;

                case 9:
                    etapa.setText("Etapa 9 - Tela");
                    categoriaSelecionada = categoriasPeca.Tela;
                    break;

                case 10:
                    etapa.setText("Etapa 10 - Sistema Operacional");
                    categoriaSelecionada = categoriasPeca.Sistema;
                    break;
            }

            //Search pecas in the database according the category
            List<Peca> pecas = new otherFunctions().carregarpecas(this, categoriaSelecionada);

            adapter = new pecasAdapter(this, pecas);


            adapter.setClickListener(new ItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {

                    try {

                        pecaEscolhida = adapter.getItem(position);

                        Bitmap bitImage = new otherFunctions().base64ToBitmap(pecaEscolhida.getImagem());

                        ImageView imgBitmap = (ImageView) findViewById(R.id.ImgPecaMaior);

                        imgBitmap.setImageBitmap(bitImage);

                        TextView txtInformacoes = (TextView) findViewById(R.id.txtInformacoesPeca);

                        txtInformacoes.setText(pecaEscolhida.getInformacoes());


                    } catch (Exception ex) {
                        new userFunctions().enviarNotificacao(view.getContext(), ex.toString());
                    }
                }
            });

            recyclerView.setAdapter(adapter);

        }catch(Exception ex){
            new userFunctions().enviarNotificacao(this,ex.toString());
        }

    }

    public void concluirMissao(){

        escolhasMissao.setPecas(pecasEscolhidas);

        //verify rules of the mission with rules of the user choice
      //  new otherFunctions().validateMissao(escolhasMissao,)

    }

}
