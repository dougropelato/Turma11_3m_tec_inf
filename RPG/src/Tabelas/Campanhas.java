/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

/**
 *
 * @author Orlando
 */
public class Campanhas {
    int codigo_campanha;
    String nome_campanha;
    int tam_x_mapa;
    int tam_y_mapa;

    public int getTam_x_mapa() {
        return tam_x_mapa;
    }

    public void setTam_x_mapa(int tam_x_mapa) {
        this.tam_x_mapa = tam_x_mapa;
    }

    public int getTam_y_mapa() {
        return tam_y_mapa;
    }

    public void setTam_y_mapa(int tam_y_mapa) {
        this.tam_y_mapa = tam_y_mapa;
    }
        

    public int getCodigo_campanha() {
        return codigo_campanha;
    }

    public void setCodigo_campanha(int codigo_campanha) {
        this.codigo_campanha = codigo_campanha;
    }

    public String getNome_campanha() {
        return nome_campanha;
    }

    public void setNome_campanha(String nome_campanha) {
        this.nome_campanha = nome_campanha;
    }
}
