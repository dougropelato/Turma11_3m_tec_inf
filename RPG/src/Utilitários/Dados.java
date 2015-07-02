/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitários;

import java.util.Random;

/**
 *
 * @author Eduardo
 */
public class Dados {

   //Os Dados do Jogo são: //
   //          d4          //
   //          d6          //
   //          d8          //
   //          d10         //
   //          d12         //
   //          d20         //
     
   //O Código funciona assim, sempre que precisar utilizar um dado será 
   //necessário chamá-lo da seguinte maneira na classe:
        
   //Dados dAD = new Dados();          //chamar a classe Dados
    
   //System.out.println(dAD.getDado(20)); //Dentro do getDado() será necessário
                                          //informar o valor correspondente ao 
                                          //dado que voce precisa, por exemplo,
                                          //um d20 (dAD.getDado(20));
       
    public int getDado(int ladosDado) {
              //ladosDado é  igual a quantidades de lados do dado que voce precisa 
        
        Random Dado = new Random();
        int numeroAleatorio = 0;
        for (int i = 0; i < 1; i++) {//mostra sequencia de um numero aleatorio
            numeroAleatorio = Dado.nextInt(ladosDado) + 1;  
                            //numero entre 1 e a quantidade que voce informou
           
        }
         return numeroAleatorio; // retorna o valor que voce tirou no dado 
    }
}
