package app.testeconsumerestapi.models;

import java.util.Date;

/**
 * Created by Alisson on 18/09/2017.
 */

public class Missao {

    private String _id;
    private String nome;
    private String objetivo;
    private Integer XP;
    private regrasMissao regras;
    private String dataCadastro;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public regrasMissao getRegras() {
        return regras;
    }

    public void setRegras(regrasMissao regras) {
        this.regras = regras;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getXP() {
        return XP;
    }

    public void setXP(Integer XP) {
        this.XP = XP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Missao missao = (Missao) o;

        return _id != null ? _id.equals(missao._id) : missao._id == null;

    }

    @Override
    public int hashCode() {
        return _id != null ? _id.hashCode() : 0;
    }
}
