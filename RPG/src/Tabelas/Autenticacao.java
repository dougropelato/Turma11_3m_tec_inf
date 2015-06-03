/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

/**
 *
 * @author Alexjonas
 */
public class Autenticacao {

    int codigo_jogador;
    int codigo_personagem;
    boolean mestre_jogador;
    boolean jogador_logado;
    String nome_jogador;
    String senha_jogador;
    String nome_personagem;

    public boolean isJogador_logado() {
        return jogador_logado;
    }

    public void setJogador_logado(boolean jogador_logado) {
        this.jogador_logado = jogador_logado;
    }

    public boolean isMestre_jogador() {
        return mestre_jogador;
    }

    public void setMestre_jogador(boolean mestre_jogador) {
        this.mestre_jogador = mestre_jogador;
    }

    public int getCodigo_jogador() {
        return codigo_jogador;
    }

    public void setCodigo_jogador(int codigo_jogador) {
        this.codigo_jogador = codigo_jogador;
    }

    public int getCodigo_personagem() {
        return codigo_personagem;
    }

    public void setCodigo_personagem(int codigo_personagem) {
        this.codigo_personagem = codigo_personagem;
    }

    public String getNome_jogador() {
        return nome_jogador;
    }

    public void setNome_jogador(String nome_jogador) {
        this.nome_jogador = nome_jogador;
    }

    public String getSenha_jogador() {
        return senha_jogador;
    }

    public void setSenha_jogador(String senha_jogaodor) {
        this.senha_jogador = senha_jogaodor;
    }

    public String getNome_personagem() {
        return nome_personagem;
    }

    public void setNome_personagem(String nome_personagem) {
        this.nome_personagem = nome_personagem;
    }

}
