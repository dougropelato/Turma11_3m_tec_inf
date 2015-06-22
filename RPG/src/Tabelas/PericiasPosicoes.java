/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

/**
 *
 * @author Caio
 */
public class PericiasPosicoes {

    int codigo_pericia;
    int codigo_posicao;
    String descricao_pericia_conseguiu;
    int valor_pericia;

    public String getDescricao_pericia_conseguiu() {
        return descricao_pericia_conseguiu;
    }

    public void setDescricao_pericia_conseguiu(String descricao_pericia_conseguiu) {
        this.descricao_pericia_conseguiu = descricao_pericia_conseguiu;
    }

    public int getValor_pericia() {
        return valor_pericia;
    }

    public void setValor_pericia(int valor_pericia) {
        this.valor_pericia = valor_pericia;
    }

    public int getCodigo_pericia() {
        return codigo_pericia;
    }

    public void setCodigo_pericia(int codigo_pericia) {
        this.codigo_pericia = codigo_pericia;
    }

    public int getCodigo_posicao() {
        return codigo_posicao;
    }

    public void setCodigo_posicao(int codigo_posicao) {
        this.codigo_posicao = codigo_posicao;
    }

}
