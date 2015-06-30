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
    int codigo_posicao;
    int tam_x_mapa;
    int tam_y_mapa;
    int coordenadaX_posicao;    //coordenadas da posicao em que o jogador está
    int coordenadaY_posicao;
    int valida_posicao;
    int iniciativa_personagem;
    int iniciativa_npc;
    int codigo_npc;

    public int getCodigo_npc() {
        return codigo_npc;
    }

    public void setCodigo_npc(int codigo_npc) {
        this.codigo_npc = codigo_npc;
    }

    public int getIniciativa_npc() {
        return iniciativa_npc;
    }

    public void setIniciativa_npc(int iniciativa_npc) {
        this.iniciativa_npc = iniciativa_npc;
    }

    public int getValida_posicao() {
        return valida_posicao;
    }

    public void setValida_posicao(int valida_posicao) {
        this.valida_posicao = valida_posicao;
    }

    public int getCoordenadaX_posicao() {
        return coordenadaX_posicao;
    }

    public void setCoordenadaX_posicao(int coordenadaX_posicao) {
        this.coordenadaX_posicao = coordenadaX_posicao;
    }

    public int getCoordenadaY_posicao() {
        return coordenadaY_posicao;
    }

    public void setCoordenadaY_posicao(int coordenadaY_posicao) {
        this.coordenadaY_posicao = coordenadaY_posicao;
    }
    
    public int getTam_x_mapa() {
        return tam_x_mapa;
    }

    public void setTam_x_mapa(int tam_x_mapa) {
        this.tam_x_mapa = tam_x_mapa;
    }

    public int getTam_y_mapa() {
        return tam_y_mapa;
    }

    public void setTam_y_mapa(int tam_y_mapa) {
        this.tam_y_mapa = tam_y_mapa;
    }

    public int getCodigo_posicao() {
        return codigo_posicao;
    }

    public void setCodigo_posicao(int codigo_posicao) {
        this.codigo_posicao = codigo_posicao;
    }
    
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
