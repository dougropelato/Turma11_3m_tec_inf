/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitários;

import java.sql.SQLException;

/**
 *
 * @author Alexjonas
 */
public class virificaComandos {

    autenticacao auth = new autenticacao();
    // clase criada so para amanter a autenticação

    public String verificaComando(String[] aux) throws SQLException {
        String res = "";
        buscas bsk = new buscas();

        if (aux[0].equalsIgnoreCase("login")) { //verifica se primeira palavra é o login

            if (bsk.buscaJogador(aux[1]).size() > 0) {//virifica se volta algo da pesquisa

                res = "digite a senha - EX: senha Minhasenha"; // seta a resposta do "mestre"

                auth.setNome_jogador(aux[1]); // seta nome do jogador logado

                auth.setCodigo_jogador(bsk.buscaJogador(aux[1]).get(0).getCodigo_jogador());// seta codigo do jogador logado

            } else {
                res = "Login invalido tente novamente - EX: login Usuario "; // causo a pesquisa não retornar é pra exibir o erro 
            }

        } else {

            if (auth.getCodigo_jogador() == 0) {
                res = "Faça o login - EX: login Usuario"; // 

            } else {
                if (aux[0].equalsIgnoreCase("senha")) {

                    if (bsk.buscaJogador(auth.getNome_jogador()).get(0).getSenha_jogador().equals(aux[1])) {

                        res = "Logado com sucesso" + '\n'; // exibe que vc consegui lugar

                        res = res + listaPersonagens();

                        auth.setMestre_jogador(bsk.buscaJogador(auth.getNome_jogador()).get(0).getMestre_jogador());

                    } else {
                        res = "senha invalida tente novamente - EX: senha Minhasenha"; // caso a senha não bater exibe erro
                    }

                }
                // verifica se foi digitado  criar ou  cadastrar
                if (aux[0].equalsIgnoreCase("criar") || aux[0].equalsIgnoreCase("cadastrar")) {
                    //criar personagem

                }
                // se vc for cadastrar e se o unuario logado for mestre
                if (aux[0].equalsIgnoreCase("cadastrar") && auth.isMestre_jogador() == true) {

                    //fazer comandos para cadastro dentro deste if
                } else {
                    res = " ação negada";  // mostra que foi negado ao acesso
                }

            }

        }

        return res;

    }

    public String listaPersonagens() throws SQLException {
        buscas bsk = new buscas();
        String res = "";

        if (bsk.buscaPersonagens(auth.getCodigo_jogador()).size() > 0) {
            res = '\n' + "------ Personagens ------" + '\n'; //+'\n';
            for (int i = 0; i < bsk.buscaPersonagens(auth.getCodigo_jogador()).size(); i++) {
                res = res + bsk.buscaPersonagens(auth.getCodigo_jogador()).get(i).getCodigo_personagem() + " - ";
                res = res + bsk.buscaPersonagens(auth.getCodigo_jogador()).get(i).getNome_personagem() + "" + '\n';
            }

        } else {
            res = "nenhum personagem digite criar personagem para criar um" + '\n';
        }

        return res;

    }
}
