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
public class Consumiveis {

    int codigo_consumivel;
    String nome_consumivel;
    double preco_consumivel;
    int quantidade_dados_consumivel;
    int tipo_dado_consumivel;

    public int getCodigo_consumivel() {
        return codigo_consumivel;
    }

    public void setCodigo_consumivel(int codigo_consumivel) {
        this.codigo_consumivel = codigo_consumivel;
    }

    public void setNome_consumivel(String nome_consumivel) {
        this.nome_consumivel = nome_consumivel;
    }

    public void setPreco_consumivel(double preco_consumivel) {
        this.preco_consumivel = preco_consumivel;
    }

    public void setQuantidade_dados_consumivel(int quantidade_dados_consumivel) {
        this.quantidade_dados_consumivel = quantidade_dados_consumivel;
    }

    public void setTipo_dado_consumivel(int tipo_dado_consumivel) {
        this.tipo_dado_consumivel = tipo_dado_consumivel;
    }

    public String getNome_consumivel() {
        return nome_consumivel;
    }

    public double getPreco_consumivel() {
        return preco_consumivel;
    }

    public int getQuantidade_dados_consumivel() {
        return quantidade_dados_consumivel;
    }

    public int getTipo_dado_consumivel() {
        return tipo_dado_consumivel;
    }

}
