/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabelas;

/**
 *
 * @author Alexjonas
 */
public class Pericias {
    
    int codigo_pericia;
    String nome_pericia; 
    String descricao_pericia;


    public String getDescricao_pericia() {
        return descricao_pericia;
    }

    public void setDescricao_pericia(String descricao_pericia) {
        this.descricao_pericia = descricao_pericia;
    }
    

    public int getCodigo_pericia() {
        return codigo_pericia;
    }

    public void setCodigo_pericia(int codigo_pericia) {
        this.codigo_pericia = codigo_pericia;
    }

    public String getNome_pericia() {
        return nome_pericia;
    }

    public void setNome_pericia(String nome_pericia) {
        this.nome_pericia = nome_pericia;
    }
    
}
