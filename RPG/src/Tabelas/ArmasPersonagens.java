/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

/**
 *
 * @author Ricardo Figurski
 */
public class ArmasPersonagens {

    int codigo_arma;
    int quantidade_arma;
    int codigo_personagem;

    public int getCodigo_arma() {
        return codigo_arma;
    }

    public void setCodigo_arma(int codigo_arma) {
        this.codigo_arma = codigo_arma;
    }

    public void setQuantidade_arma(int quantidade_arma) {
        this.quantidade_arma = quantidade_arma;
    }

    public void setCodigo_personagem(int codigo_personagem) {
        this.codigo_personagem = codigo_personagem;
    }

    public int getQuantidade_arma() {
        return quantidade_arma;
    }

    public int getCodigo_personagem() {
        return codigo_personagem;
    }

}
