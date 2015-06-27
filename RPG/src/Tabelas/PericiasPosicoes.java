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
    int dificuldade_pericia;
    String descricao_pericia_sucesso;

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

    public int getDificuldade_pericia() {
        return dificuldade_pericia;
    }

    public void setDificuldade_pericia(int dificuldade_pericia) {
        this.dificuldade_pericia = dificuldade_pericia;
    }

    public String getDescricao_pericia_sucesso() {
        return descricao_pericia_sucesso;
    }

    public void setDescricao_pericia_sucesso(String descricao_pericia_sucesso) {
        this.descricao_pericia_sucesso = descricao_pericia_sucesso;
    }

}
