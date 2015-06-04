/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitários;

import java.util.Random;

/**
 *
 * @author mamut
 */
public class Dados {

    public int getDado(int ladosDado) {//ladoDados é  igual a quantidades de lados do dado que vc quer 
        Random Dado = new Random();
        int numeroAleatorio = 0;
        for (int i = 0; i < 1; i++) {//mostra sequencia de um numero aleatorio
            numeroAleatorio = Dado.nextInt(ladosDado) + 1;  //numero entre 1 e a quantidade que vc informou
           
        }
         return numeroAleatorio; // retorna o valor que voce tirou no dado 
    }
}
