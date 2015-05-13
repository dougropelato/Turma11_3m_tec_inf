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
public class Armaduras {

    int codigo_armadura;
    String nome_armadura;
    int tipo_armadura;
    double preco_armadura;
    double bonus_maximo_armadura;
    int penalidade_destreza_armadura;

    public int getCodigo_armadura() {
        return codigo_armadura;
    }

    public String getNome_armadura() {
        return nome_armadura;
    }

    public int getTipo_armadura() {
        return tipo_armadura;
    }

    public double getPreco_armadura() {
        return preco_armadura;
    }

    public double getBonus_maximo_armadura() {
        return bonus_maximo_armadura;
    }

    public int getPenalidade_destreza_armadura() {
        return penalidade_destreza_armadura;
    }

    public void setCodigo_armadura(int codigo_armadura) {
        this.codigo_armadura = codigo_armadura;
    }

    public void setNome_armadura(String nome_armadura) {
        this.nome_armadura = nome_armadura;
    }

    public void setTipo_armadura(int tipo_armadura) {
        this.tipo_armadura = tipo_armadura;
    }

    public void setPreco_armadura(double preco_armadura) {
        this.preco_armadura = preco_armadura;
    }

    public void setBonus_maximo_armadura(double bonus_maximo_armadura) {
        this.bonus_maximo_armadura = bonus_maximo_armadura;
    }

    public void setPenalidade_destreza_armadura(int penalidade_destreza_armadura) {
        this.penalidade_destreza_armadura = penalidade_destreza_armadura;
    }

}
