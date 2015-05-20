/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitários;

/**
 *
 * @author Alexjonas
 */
public class autenticacao {

    int codigo_jogador;
    int codigo_personagem;
    boolean mestre_jogador;
    String nome_jogador;
    String senha_jogaodor;
    String nome_personagem;

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

    public String getSenha_jogaodor() {
        return senha_jogaodor;
    }

    public void setSenha_jogaodor(String senha_jogaodor) {
        this.senha_jogaodor = senha_jogaodor;
    }

    public String getNome_personagem() {
        return nome_personagem;
    }

    public void setNome_personagem(String nome_personagem) {
        this.nome_personagem = nome_personagem;
    }

}
