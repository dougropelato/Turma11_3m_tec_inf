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
public class ConsumiveisPersonagens {

    int codigo_consumivel;
    int quantidade_consumivel;
    int codigo_personagem;

    public int getCodigo_consumivel() {
        return codigo_consumivel;
    }

    public void setCodigo_consumivel(int codigo_consumivel) {
        this.codigo_consumivel = codigo_consumivel;
    }

    public void setQuantidade_consumivel(int quantidade_consumivel) {
        this.quantidade_consumivel = quantidade_consumivel;
    }

    public void setCodigo_personagem(int codigo_personagem) {
        this.codigo_personagem = codigo_personagem;
    }

    public int getQuantidade_consumivel() {
        return quantidade_consumivel;
    }

    public int getCodigo_personagem() {
        return codigo_personagem;
    }

}
