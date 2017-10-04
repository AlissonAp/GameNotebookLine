package app.testeconsumerestapi.models;

import java.util.Date;

/**
 * Created by Alisson on 30/09/2017.
 */

public class Usuario {

    private String id;
    private String nome;
    private String email;
    private String senha;
    private Number nivel;
    private Number pontuacao;
    private Number ultimaMissao;
    private Number dinheiro;
    private Date ultimoAcesso;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Number getNivel() {
        return nivel;
    }

    public void setNivel(Number nivel) {
        this.nivel = nivel;
    }

    public Number getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Number pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Number getUltimaMissao() {
        return ultimaMissao;
    }

    public void setUltimaMissao(Number ultimaMissao) {
        this.ultimaMissao = ultimaMissao;
    }

    public Number getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Number dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }
}
