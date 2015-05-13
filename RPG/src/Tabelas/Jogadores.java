/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

/**
 *
 * @author Felipe e Adriel
 */
public class Jogadores {

    public int getCodigo_jogador() {
        return codigo_jogador;
    }

    public void setCodigo_jogador(int codigo_jogador) {
        this.codigo_jogador = codigo_jogador;
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

    public void setSenha_jogador(String senha_jogador) {
        this.senha_jogador = senha_jogador;
    }

    public Boolean getMestre_jogador() {
        return mestre_jogador;
    }

    public void setMestre_jogador(Boolean mestre_jogador) {
        this.mestre_jogador = mestre_jogador;
    }
    
 int codigo_jogador;
 String nome_jogador;
 String senha_jogador;
 Boolean mestre_jogador;
    
}
