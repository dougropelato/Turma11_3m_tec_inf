/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

/**
 *
 * @author Alexjonas
 */
public class talentos {

    int codigo_talento;
    String nome_talento;
    String descricao_talento;
    String requisito_talento;
    String bonus_talento;

    public String getRequisito_talento() {
        return requisito_talento;
    }

    public void setRequisito_talento(String requisito_talento) {
        this.requisito_talento = requisito_talento;
    }

    public String getBonus_talento() {
        return bonus_talento;
    }

    public void setBonus_talento(String bonus_talento) {
        this.bonus_talento = bonus_talento;
    }

    public int getCodigo_talento() {
        return codigo_talento;
    }

    public void setCodigo_talento(int codigo_talento) {
        this.codigo_talento = codigo_talento;
    }

    public String getNome_talento() {
        return nome_talento;
    }

    public void setNome_talento(String nome_talento) {
        this.nome_talento = nome_talento;
    }

    public String getDescricao_talento() {
        return descricao_talento;
    }

    public void setDescricao_talento(String descricao_talento) {
        this.descricao_talento = descricao_talento;
    }

}
