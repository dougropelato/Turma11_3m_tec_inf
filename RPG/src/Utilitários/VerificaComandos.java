/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitários;

import Formularios.JFPrincipal;
import Formularios.JFSelecaoCampanha;
import Tabelas.Autenticacao;
import dao.GenericDAO;
import formularios.JFMestre;
import formularios.JFPersonagem;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tabelas.Jogadores;
import tabelas.JogadoresPersonagens;
import tabelas.Personagens;

/**
 *
 * @author Alexjonas
 */
public class VerificaComandos {

    Autenticacao auth = Autenticacao.getInstance();
    Utilitários.Batalhas bata = new Utilitários.Batalhas();
    // clase criada so para amanter a autenticação 

    public String verificaComando(String[] aux) throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        JFPrincipal jfp = JFPrincipal.getInstance();
        String res = "";
        GenericDAO bsk = new GenericDAO();
        JFPrincipal jfprim = JFPrincipal.getInstance();

        // feito apra logar sem banco
        if (aux[0].equalsIgnoreCase("thedoctor")) {
            auth.setCodigo_jogador(1);
            auth.setMestre_jogador(true);
            auth.setCodigo_personagem(1);
            auth.setSenha_jogador("123");
            auth.setJogador_logado(true);
            auth.setNome_jogador("Mestre");
            // jfprim.jLnome_jogador.setText("Mestre");

            res = "doctor who ?";
        } // modo adm

        if (aux[0].equalsIgnoreCase("logoff")) {
            auth.setCodigo_jogador(0);
            auth.setMestre_jogador(false);
            auth.setCodigo_personagem(0);
            auth.setSenha_jogador("");
            auth.setJogador_logado(false);
            auth.setNome_jogador("");
            // jfprim.jLnome_jogador.setText("Mestre");

            res = "Você saiu do jogo";
        } // modo adm

        if (!auth.isJogador_logado()) {// se não estiver logado entra

            if (auth.getCodigo_jogador() == 0) {// verifica se falta logar

                if (aux[0].equalsIgnoreCase("login")) { //verifica se primeira palavra é o login

                    Jogadores jj = new Jogadores();
                    List<Object> ll = new ArrayList();

                    jj.setNome_jogador(aux[1]);

                    ll = bsk.listar2(Jogadores.class, jj);

                    if (ll.size() > 0) {//virifica se volta algo da pesquisa                       

                        Jogadores jog = (Jogadores) ll.get(0);

                        auth.setNome_jogador(jog.getNome_jogador());
                        auth.setCodigo_jogador(jog.getCodigo_jogador());
                        auth.setSenha_jogador(jog.getSenha_jogador());
                        auth.setMestre_jogador(true);

                        res = "digite a senha - EX: senha Minhasenha"; // seta a resposta do "mestre"

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
                        jfp.jLnome_jogador.setText("Jogador: " + auth.getNome_jogador());

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

            if (aux[0].equalsIgnoreCase("Mestre") && auth.isMestre_jogador() == true) {
                //fazer comandos para cadastro dentro deste if
                JFMestre m = new JFMestre();
                m.setVisible(true);
                res = "abrindo o formulario de cadastro do Mestre";
            }

            if (auth.getCodigo_personagem() == 0) {

                if (aux[0].equalsIgnoreCase("criar")) {
                    JFPersonagem nper = new JFPersonagem();
                    nper.setVisible(true);
                }
                if (aux[0].equalsIgnoreCase("selecionar")) {

                }

                //lista personagem usando o 
                auth.getCodigo_jogador(); // <-- este

            } else {

                if (auth.getCodigo_campanha() == 0) {
                    JFSelecaoCampanha jsf = new JFSelecaoCampanha();
                    jsf.setVisible(true);
                } else {

                    if (auth.getStatus_atual().equalsIgnoreCase("BATALHA")) {// entra na batalha

                        if (auth.getIniciativa_personagem() == 0) {
                            bata.iniciaBatalha();
                        }

                        if (aux[0].equalsIgnoreCase("atacar")) {//ataca

                        }
                        if (aux[0].equalsIgnoreCase("usar")) {//usa item

                        }
                        if (aux[0].equalsIgnoreCase("fugir")) {//tenta fugir

                        }
                    } else if (auth.getStatus_atual().equalsIgnoreCase("npc")) {
                        if (aux[0].equalsIgnoreCase("falar")) {
                            res = "npc não encontrado";
                        }
                    } else {

                        if (aux[0].equalsIgnoreCase("Pericia")) {
                            res = "pericia";
                        }
                        if (aux[0].equalsIgnoreCase("Usar")) {
                            res = "item / escudos / armas / comsumiveis / armaduras";
                        }

                        if (aux[0].equalsIgnoreCase("coletar")) {
                            res = "nada a coletar aki";
                        }
                    }
                }
            }
        }
        if (res.equalsIgnoreCase("")) {// se não encontrar ne um comando a resposta sera vasia
            res = "Comando não encontrado";// avisa que não foi encontrado o comando
        }

        return res;// retorna  a resposta 

    }

    public String listaPersonagens() throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        String res = "";
        GenericDAO gg = new GenericDAO();
        Jogadores jj = new Jogadores();
        List ll = new ArrayList<>();
        List<Personagens> lp = new ArrayList<>();

        jj.setCodigo_jogador(auth.getCodigo_jogador());

        ll = gg.listar3(jj, Personagens.class, JogadoresPersonagens.class);

        lp = (List<Personagens>) ll.get(1);

        for (Personagens per : lp) {
            Personagens ppr = (Personagens) per;
            res += " " + ppr.getCodigo_personagem() + " - " + ppr.getNome_personagem() + "\n";
        }

        return res;

    }
}
