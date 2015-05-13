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
public class Armas {

    int codigo_arma;
    String nome_arma;
    int tipo_arma;
    double preco_arma;
    int quantidade_dado_arma;
    int tipo_do_dado_arma;

    public int getCodigo_arma() {
        return codigo_arma;
    }

    public String getNome_arma() {
        return nome_arma;
    }

    public void setCodigo_arma(int codigo_arma) {
        this.codigo_arma = codigo_arma;
    }

    public void setNome_arma(String nome_arma) {
        this.nome_arma = nome_arma;
    }

    public void setTipo_arma(int tipo_arma) {
        this.tipo_arma = tipo_arma;
    }

    public void setPreco_arma(double preco_arma) {
        this.preco_arma = preco_arma;
    }

    public void setQuantidade_dado_arma(int quantidade_dado_arma) {
        this.quantidade_dado_arma = quantidade_dado_arma;
    }

    public void setTipo_do_dado_arma(int tipo_do_dado_arma) {
        this.tipo_do_dado_arma = tipo_do_dado_arma;
    }

    public int getTipo_arma() {
        return tipo_arma;
    }

    public double getPreco_arma() {
        return preco_arma;
    }

    public int getQuantidade_dado_arma() {
        return quantidade_dado_arma;
    }

    public int getTipo_do_dado_arma() {
        return tipo_do_dado_arma;
    }

}
