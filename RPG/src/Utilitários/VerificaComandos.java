/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitários;

import Formularios.JFMestre;
import java.sql.SQLException;

/**
 *
 * @author Alexjonas
 */
public class VerificaComandos {

    Autenticacao auth = new Autenticacao();
    // clase criada so para amanter a autenticação

    public String verificaComando(String[] aux) throws SQLException {

        String res = "";
        Buscas bsk = new Buscas();
        
        // feito apra logar sem banco
        if (aux[0].equalsIgnoreCase("thedoctor")) {
            auth.setCodigo_jogador(1);
            auth.setMestre_jogador(true);
            auth.setCodigo_personagem(1);
            auth.setSenha_jogador("123");
            auth.setJogador_logado(true);
            res = "doctor who ?";
        } // modo adm

        if (!auth.isJogador_logado()) {// se não estiver logado entra

            if (auth.getCodigo_jogador() == 0) {// verifica se falta logar

                if (aux[0].equalsIgnoreCase("login")) { //verifica se primeira palavra é o login

                    if (bsk.buscaJogador(aux[1]).size() > 0) {//virifica se volta algo da pesquisa

                        res = "digite a senha - EX: senha Minhasenha"; // seta a resposta do "mestre"
                        auth.setNome_jogador(aux[1]); // seta nome do jogador logado
                        auth.setCodigo_jogador(bsk.buscaJogador(aux[1]).get(0).getCodigo_jogador());// seta codigo do jogador logado

                    } else {
                        res = "Login invalido tente novamente - EX: login Usuario "; // causo a pesquisa não retornar é pra exibir o erro 
                    }
                } else {// caso comando não for login
                    res = "Faça o login para entrar - EX: login Usuario";
                }

            } else {//caso ja tenha o login do usuario / jogador

                if (aux[0].equalsIgnoreCase("senha")) {

                    if (bsk.buscaJogador(auth.getNome_jogador()).get(0).getSenha_jogador().equals(aux[1])) {

                        // seta como logado
                        auth.setJogador_logado(true);
                        // busca e seta o mestre jogador
                        auth.setMestre_jogador(bsk.buscaJogador(auth.getNome_jogador()).get(0).getMestre_jogador());

                        //envi resposta que esta logado
                        res = "Logado com sucesso" + '\n'; // +'\n' usado para quebrar linha
                        // chama função que lista os personagens deste jogador
                        res = res + listaPersonagens();

                    } else {// caso a senha não bater exibe erro
                        res = "senha invalida tente novamente - EX: senha Minhasenha";
                    }

                }

            }
        } else {// caso je esteja logado

            // verifica se foi digitado  criar ou  cadastrar
            if (aux[0].equalsIgnoreCase("criar")) {
                //criar / oque ?

            }
            // se vc for cadastrar e se o unuario logado for mestre
            if (aux[0].equalsIgnoreCase("Mestre") && auth.isMestre_jogador() == true) {
                //fazer comandos para cadastro dentro deste if
                JFMestre m = new JFMestre();
                m.setVisible(true);
                res = "abrindo o formulario de cadastro do Mestre";
            }
            if (res.equalsIgnoreCase("")) {// se não encontrar ne um comando a resposta sera vasia
                res = "Comando não encontrado";// avisa que não foi encontrado o comando
            }

        }

        return res;// retorna  a resposta 

    }

    public String listaPersonagens() throws SQLException {
        Buscas bsk = new Buscas();
        String res = "";

        if (bsk.buscaPersonagens(auth.getCodigo_jogador()).size() > 0) {// caso tiver personagem criado exibe
            res = '\n' + "------ Personagens ------" + '\n';
            for (int i = 0; i < bsk.buscaPersonagens(auth.getCodigo_jogador()).size(); i++) {
                res = res + bsk.buscaPersonagens(auth.getCodigo_jogador()).get(i).getCodigo_personagem() + " - ";
                res = res + bsk.buscaPersonagens(auth.getCodigo_jogador()).get(i).getNome_personagem() + "" + '\n';
            }

        } else {//caso não tiver personagem cadastrado
            res = "nenhum personagem digite criar personagem para criar um" + '\n';
        }

        return res;

    }
}
