/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

/**
 *
 * @author Orlando
 */
public class Missoes {
    int codigo_missao;
    String nome_missao;
    int codigo_campanha;
    int codigo_mapa;

    public int getCodigo_missao() {
        return codigo_missao;
    }

    public void setCodigo_missao(int codigo_missao) {
        this.codigo_missao = codigo_missao;
    }

    public String getNome_missao() {
        return nome_missao;
    }

    public void setNome_missao(String nome_missao) {
        this.nome_missao = nome_missao;
    }

    public int getCodigo_campanha() {
        return codigo_campanha;
    }

    public void setCodigo_campanha(int codigo_campanha) {
        this.codigo_campanha = codigo_campanha;
    }

    public int getCodigo_mapa() {
        return codigo_mapa;
    }

    public void setCodigo_mapa(int codigo_mapa) {
        this.codigo_mapa = codigo_mapa;
    }
}
