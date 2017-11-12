package app.testeconsumerestapi.horizontal;

/**
 * Created by Alisson on 12/11/2017.
 */

public class HorizontalData {
    private String nome;
    private String descricao;

    HorizontalData(String nome, String descricao){
        this.nome       = nome;
        this.descricao  = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
