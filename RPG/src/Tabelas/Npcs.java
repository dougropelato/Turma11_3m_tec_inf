/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

/**
 *
 * @author Leonardo
 */
public class Npcs {
    int codigo_npc;
    String nome_npc;
    String descricao_npc;
    int tipo_npc;
    boolean inicio_missao;
    boolean fim_missao;

    public int getCodigo_npc() {
        return codigo_npc;
    }

    public void setCodigo_npc(int codigo_npc) {
        this.codigo_npc = codigo_npc;
    }

    public String getNome_npc() {
        return nome_npc;
    }

    public void setNome_npc(String nome_npc) {
        this.nome_npc = nome_npc;
    }

    public String getDescricao_npc() {
        return descricao_npc;
    }

    public void setDescricao_npc(String descricao_npc) {
        this.descricao_npc = descricao_npc;
    }

    public int getTipo_npc() {
        return tipo_npc;
    }

    public void setTipo_npc(int tipo_npc) {
        this.tipo_npc = tipo_npc;
    }

    public boolean isInicio_missao() {
        return inicio_missao;
    }

    public void setInicio_missao(boolean inicio_missao) {
        this.inicio_missao = inicio_missao;
    }

    public boolean isFim_missao() {
        return fim_missao;
    }

    public void setFim_missao(boolean fim_missao) {
        this.fim_missao = fim_missao;
    }
}