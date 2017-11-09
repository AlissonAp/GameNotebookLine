package app.testeconsumerestapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Alisson on 18/09/2017.
 */

public class Peca {


    private String _id;
    private String  descricao;
    private Integer categoria;
    private String  informacoes;
    private Integer preco;
    private propriedadesPeca  propriedades;
    private Integer nivel;
    private String  imagem;
    private String  dataCadastro;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }


    public propriedadesPeca getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(propriedadesPeca propriedades) {
        this.propriedades = propriedades;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Peca peca = (Peca) o;

        return _id != null ? _id.equals(peca._id) : peca._id == null;

    }

    @Override
    public int hashCode() {
        return _id != null ? _id.hashCode() : 0;
    }
}
