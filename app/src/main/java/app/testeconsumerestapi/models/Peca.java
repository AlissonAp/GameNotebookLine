package app.testeconsumerestapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Alisson on 18/09/2017.
 */

public class Peca {

    @SerializedName("_id")
    @Expose
    public String _id;

    @SerializedName("descricao")
    @Expose
    public String descricao;

    @SerializedName("categoria")
    @Expose
    public Number categoria;

    @SerializedName("informacoes")
    @Expose
    public String informacoes;

    @SerializedName("preco")
    @Expose
    public Number preco;

    @SerializedName("propriedades")
    @Expose
    public String propriedades;

    @SerializedName("nivel")
    @Expose
    public Number nivel;

    @SerializedName("imagem")
    @Expose
    public String imagem;

    @SerializedName("JsonPropriedades")
    @Expose
    public String JsonPropriedades;

    @SerializedName("dataCadastro")
    @Expose
    public Date dataCadastro;


}
