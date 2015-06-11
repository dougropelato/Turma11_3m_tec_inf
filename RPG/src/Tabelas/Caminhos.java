/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

/**
 *
 * @author Caio
 */
public class Caminhos {
    int codigo_caminho;
    String nome_caminho;
    int codigo_campanha;

    public int getCodigo_caminho() {
        return codigo_caminho;
    }

    public void setCodigo_caminho(int codigo_caminho) {
        this.codigo_caminho = codigo_caminho;
    }
    
    public int getCodigo_campanha() {
        return codigo_campanha;
    }

    public void setCodigo_campanha(int codigo_campanha) {
        this.codigo_campanha = codigo_campanha;
    }

   
    public String getNome_caminho() {
        return nome_caminho;
    }

    public void setNome_caminho(String nome_caminho) {
        this.nome_caminho = nome_caminho;
    }
}