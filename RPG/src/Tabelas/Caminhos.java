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

    public int getCodigo_caminho() {
        return codigo_caminho;
    }

    public void setCodigo_caminho(int codigo_caminho) {
        this.codigo_caminho = codigo_caminho;
    }
    
    String nome_caminho;
    int codigo_missao;

   
    public String getNome_caminho() {
        return nome_caminho;
    }

    public void setNome_caminho(String nome_caminho) {
        this.nome_caminho = nome_caminho;
    }

    public int getCodigo_missao() {
        return codigo_missao;
    }

    public void setCodigo_missao(int codigo_missao) {
        this.codigo_missao = codigo_missao;
    }
}