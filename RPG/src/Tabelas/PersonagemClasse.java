/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tabelas;

/**
 *
 * @author Jefferson
 */
public class PersonagemClasse {
    int codigo_classe;
    int codigo_personagem;
    int nivel_personagem_classe;

    public int getCodigo_classe() {
        return codigo_classe;
    }

    public void setCodigo_classe(int codigo_classe) {
        this.codigo_classe = codigo_classe;
    }

    public int getCodigo_personagem() {
        return codigo_personagem;
    }

    public void setCodigo_personagem(int codigo_personagem) {
        this.codigo_personagem = codigo_personagem;
    }

    public int getNivel_personagem_classe() {
        return nivel_personagem_classe;
    }

    public void setNivel_personagem_classe(int nivel_personagem_classe) {
        this.nivel_personagem_classe = nivel_personagem_classe;
    }
}
