/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

import Formularios.JFPrincipal;

/**
 *
 * @author Alexjonas
 */
public class Autenticacao extends Temporario {

    public static Autenticacao instance;

    public static Autenticacao getInstance() {
        if (instance == null) {
            instance = new Autenticacao();
        }
        return instance;
    }

    String status_atual = "";
    boolean mestre_jogador;
    boolean jogador_logado;
    String nome_jogador;
    String senha_jogador;
    int codigo_jogador;
    int codigo_campanha;
    int codigo_caminho;

    public int getCodigo_caminho() {
        return codigo_caminho;
    }

    public void setCodigo_caminho(int codigo_caminho) {
        this.codigo_caminho = codigo_caminho;
    }
    
    public int getCodigo_campanha() {
        return codigo_campanha;
    }

    public void setCodigo_campanha(int codigo_campanha) {
        this.codigo_campanha = codigo_campanha;
    }

    public int getCodigo_jogador() {
        return codigo_jogador;
    }

    public void setCodigo_jogador(int codigo_jogador) {
        this.codigo_jogador = codigo_jogador;
    }

    public String getStatus_atual() {
        return status_atual;
    }

    public void setStatus_atual(String status_atual) {
        this.status_atual = status_atual;
    }

    public boolean isMestre_jogador() {
        return mestre_jogador;
    }

    public void setMestre_jogador(boolean mestre_jogador) {
        this.mestre_jogador = mestre_jogador;
    }

    public boolean isJogador_logado() {
        return jogador_logado;
    }

    public void setJogador_logado(boolean jogador_logado) {
        this.jogador_logado = jogador_logado;
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

}
