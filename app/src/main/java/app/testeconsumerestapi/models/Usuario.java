package app.testeconsumerestapi.models;

import java.util.Date;

import static android.os.Build.VERSION_CODES.N;

/**
 * Created by Alisson on 30/09/2017.
 */

public class Usuario {

    private String id;
    private String nome;
    private String email;
    private String senha;
    private long nivel;
    private long pontuacao;
    private long ultimaMissao;
    private Double dinheiro;
    private String ultimoAcesso;
    private String imagem;

    public void addDinheiro(Double valor){

        this.dinheiro += valor;
    }

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

    public long getNivel() {
        return nivel;
    }

    public void setNivel(long nivel) {
        this.nivel = nivel;
    }

    public long getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(long pontuacao) {
        this.pontuacao = pontuacao;
    }

    public long getUltimaMissao() {
        return ultimaMissao;
    }

    public void setUltimaMissao(long ultimaMissao) {
        this.ultimaMissao = ultimaMissao;
    }

    public Double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public String getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(String ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
