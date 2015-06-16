/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitários;

import Tabelas.Autenticacao;
import dao.GenericDAO;
import formularios.JFMestre;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tabelas.Jogadores;

/**
 *
 * @author Alexjonas
 */
public class VerificaComandos {

    Autenticacao auth = new Autenticacao();
    // clase criada so para amanter a autenticação

    public String verificaComando(String[] aux) throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        String res = "";
        GenericDAO bsk = new GenericDAO();

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
            System.out.println(auth.getCodigo_jogador());
            if (auth.getCodigo_jogador() == 0) {// verifica se falta logar

                if (aux[0].equalsIgnoreCase("login")) { //verifica se primeira palavra é o login

                    Jogadores jj = new Jogadores();
                    List<Object> ll = new ArrayList();

                    jj.setNome_jogador(aux[1]);

                    ll = bsk.listar2(Jogadores.class, jj);

                    if (ll.size() > 0) {//virifica se volta algo da pesquisa

                        res = "digite a senha - EX: senha Minhasenha"; // seta a resposta do "mestre"

                        for (Object obj : ll) {
                            Jogadores jog = (Jogadores) obj;
                            auth.setCodigo_jogador(jog.getCodigo_jogador());
                            auth.setNome_jogador(jog.getNome_jogador());
                            auth.setSenha_jogador(jog.getSenha_jogador());
                            System.out.println("senha " + jog.getCodigo_jogador());
                            // auth.setMestre_jogador(jog.getMestre_jogador());
                        }

                    } else {
                        res = "Login invalido tente novamente - EX: login Usuario "; // causo a pesquisa não retornar é pra exibir o erro 
                    }
                } else {// caso comando não for login
                    res = "Faça o login para entrar - EX: login Usuario";
                }

            } else {//caso ja tenha o login do usuario / jogador

                if (aux[0].equalsIgnoreCase("senha")) {

                    if (auth.getSenha_jogador().equals(aux[1])) {

                        // seta como logado
                        auth.setJogador_logado(true);

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
        String res = "";

        // fazer a listagem
        return res;

    }
}
