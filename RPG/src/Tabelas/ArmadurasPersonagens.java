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
public class ArmadurasPersonagens {

    int codigo_armadura;
    int quantidade_armadura;
    int codigo_personagem;

    public int getCodigo_armadura() {
        return codigo_armadura;
    }

    public void setCodigo_armadura(int codigo_armadura) {
        this.codigo_armadura = codigo_armadura;
    }

    public void setQuantidade_armadura(int quantidade_armadura) {
        this.quantidade_armadura = quantidade_armadura;
    }

    public void setCodigo_personagem(int codigo_personagem) {
        this.codigo_personagem = codigo_personagem;
    }

    public int getQuantidade_armadura() {
        return quantidade_armadura;
    }

    public int getCodigo_personagem() {
        return codigo_personagem;
    }

}
