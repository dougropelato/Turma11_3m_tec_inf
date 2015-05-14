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
public class ArmasNpcs {
   int codigo_arma;
   int codigo_npc;
   int quantidade_npc;

    public int getCodigo_arma() {
        return codigo_arma;
    }

    public void setCodigo_arma(int codigo_arma) {
        this.codigo_arma = codigo_arma;
    }

    public int getCodigo_npc() {
        return codigo_npc;
    }

    public void setCodigo_npc(int codigo_npc) {
        this.codigo_npc = codigo_npc;
    }

    public int getQuantidade_npc() {
        return quantidade_npc;
    }

    public void setQuantidade_npc(int quantidade_npc) {
        this.quantidade_npc = quantidade_npc;
    }
}
