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
public class Escudos {

    int codigo_escudo;
    String nome_escudo;
    double preco_escudo;
    double bonus_maximo_escudo;
    int penalidade_destreza_escudo;

    public int getCodigo_escudo() {
        return codigo_escudo;
    }

    public void setCodigo_escudo(int codigo_escudo) {
        this.codigo_escudo = codigo_escudo;
    }

    public void setNome_escudo(String nome_escudo) {
        this.nome_escudo = nome_escudo;
    }

    public void setPreco_escudo(double preco_escudo) {
        this.preco_escudo = preco_escudo;
    }

    public void setBonus_maximo_escudo(double bonus_maximo_escudo) {
        this.bonus_maximo_escudo = bonus_maximo_escudo;
    }

    public void setPenalidade_destreza_escudo(int penalidade_destreza_escudo) {
        this.penalidade_destreza_escudo = penalidade_destreza_escudo;
    }

    public String getNome_escudo() {
        return nome_escudo;
    }

    public double getPreco_escudo() {
        return preco_escudo;
    }

    public double getBonus_maximo_escudo() {
        return bonus_maximo_escudo;
    }

    public int getPenalidade_destreza_escudo() {
        return penalidade_destreza_escudo;
    }

}
