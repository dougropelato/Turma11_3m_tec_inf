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
import formularios.JFJogador;
import formularios.JFMestre;
import formularios.JFPersonagem;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tabelas.Jogadores;
import tabelas.JogadoresPersonagens;
import tabelas.Personagens;
import java.awt.Color;

/**
 *
 * @author Alexjonas
 */
public class VerificaComandos {

    Autenticacao auth = Autenticacao.getInstance();
    Utilitários.Batalhas bata = new Utilitários.Batalhas();
    Utilitários.Utilitarios utt = new Utilitários.Utilitarios();
    // clase criada so para amanter a autenticação 

    public String verificaComando(String[] aux) throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        String res = "";
        GenericDAO bsk = new GenericDAO();
        JFPrincipal jfprim = JFPrincipal.getInstance();

        if (aux[0].equalsIgnoreCase("novo") && aux[1].equalsIgnoreCase("jogador")) {
            JFJogador jog = new JFJogador();
            jog.setVisible(true);
            res = "Abrindo Criação de usuarios \n";
        }

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
        // lista comandos
        if (aux[0].equalsIgnoreCase("Comandos")) {
            jfprim.jTextArea3.setText(listaComando());

            res = "lista dos comandos";
        } // modo adm

        if (aux[0].equalsIgnoreCase("logoff")) {
            auth.setCodigo_jogador(0);
            auth.setMestre_jogador(false);
            auth.setCodigo_personagem(0);
            auth.setSenha_jogador("");
            auth.setJogador_logado(false);
            auth.setNome_jogador("");
            jfprim.jTextArea1.setText("");

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
                    res += "Faça o login para entrar - EX: login Usuario";
                }

            } else {//caso ja tenha o login do usuario / jogador

                if (aux[0].equalsIgnoreCase("senha")) {

                    if (auth.getSenha_jogador().equals(aux[1])) {

                        String lp = "";
                        jfprim.jTextArea1.setText("");//limpa a tela

                        auth.setJogador_logado(true); // seta como logado
                        jfprim.jLnome_jogador.setText("Jogador: " + auth.getNome_jogador());

                        //envi resposta que esta logado
                        res = "Logado com sucesso" + '\n'; // +'\n' usado para quebrar linha
                        // chama função que lista os personagens deste jogador
                        lp = listaPersonagens();

                        System.out.println(lp);
                        if (lp.equalsIgnoreCase("NOK")) {
                            res += "Digite CRIAR  para criar um novo personagem \n";
                        } else {
                            res += lp;
                        }

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
                    res = "Crie seu personagem";
                }
                if (aux[0].equalsIgnoreCase("selecionar")) {

                    Personagens pp = new Personagens();
                    List<Object> ll = new ArrayList();

                    pp.setNome_personagem(aux[1]);

                    // ll = bsk.listar2(Jogadores.class, jj);
                    String sql = "SELECT * "
                            + "FROM personagens pp "
                            + ", jogadorespersonagens jp "
                            + "where jp.codigo_jogador = " + auth.getCodigo_jogador() + " "
                            + "AND pp.codigo_personagem = jp.codigo_personagem "
                            + "AND pp.nome_personagem like '" + aux[1] + "'";

                    res = bsk.executaSql(sql, "codigo_personagem");

                    try {
                        auth.setCodigo_personagem(Integer.valueOf(res));

                        pp.setCodigo_personagem(auth.getCodigo_personagem());
                        ll = bsk.listar2(Personagens.class, pp);

                        for (Object ll1 : ll) {
                            Personagens pps = (Personagens) ll1;
                            auth.setNome_personagem(pps.getNome_personagem());
                            auth.setPontos_vida_personagem(pps.getPontos_vida_personagem());
                        }

                        res = "Personagem - " + auth.getNome_personagem() + " - selecionado";
                        jfprim.jLnome_personagem.setText("Personagem: " + auth.getNome_personagem());
                        jfprim.jLvida_personagem.setBackground(Color.red);
                        jfprim.jLvida_personagem.setForeground(Color.red);
                        jfprim.jLvida_personagem.setText("Pontos de vida: " + auth.getPontos_vida_personagem());

                    } catch (NumberFormatException ex) {
                        res = "Este personagem não existe \n";
                        res += "Digite CRIAR  para criar um novo personagem \n";

                    }

                }

            } else {

                if (auth.getCodigo_campanha() == 0 ) {

                    if (aux[0].equalsIgnoreCase("Campanhas")) {

                        JFSelecaoCampanha jfsl = new JFSelecaoCampanha();
                        jfsl.setVisible(true);
                        res = "Selecione sua camanha";
                    }

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
                    } else if (auth.getStatus_atual().equalsIgnoreCase("npc")) {// couse estiver falando com o npc
                        if (aux[0].equalsIgnoreCase("falar")) { // fala com o npc disponivel
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
        if (aux[0].equalsIgnoreCase("limpar") || aux[0].equalsIgnoreCase("cls") || aux[0].equalsIgnoreCase("limpatela") || aux[0].equalsIgnoreCase("lptl")) {
            res = "lpt";
        }

        return res;// retorna  a resposta 

    }

    public String listaPersonagens() throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        String res = "NOK";
        GenericDAO gg = new GenericDAO();
        Jogadores jj = new Jogadores();
        List ll = new ArrayList<>();
        List<Personagens> lp = new ArrayList<>();

        jj.setCodigo_jogador(auth.getCodigo_jogador());

        ll = gg.listar3(jj, Personagens.class, JogadoresPersonagens.class);

        lp = (List<Personagens>) ll.get(1);

        if (lp.size() > 0) {

            res = "-- Listando Personagens de " + auth.getNome_jogador() + " --\n";

            for (Personagens per : lp) {
                Personagens ppr = (Personagens) per;
                res += " " + ppr.getCodigo_personagem() + " - " + ppr.getNome_personagem() + "\n";
            }
        }

        return res;

    }

    public String listaComando() {
        String res = "LOGOFF - sai da sessão\n"
                + "\n"
                + "LOGIN seunome\n"
                + "SENHA suasenha\n"
                + "MESTRE - abre janela mestre\n"
                + "CRIAR - abre criação de personagem\n"
                + "SELECIONAR nomePersonagem - seleciona personagem \n"
                + "\n"
                + "---- DURANTE A BATALHA ----\n"
                + "\n"
                + "ATACAR - ataca\n"
                + "USAR - usa poção de vida\n"
                + "FUGIR - tenta   fugir da batalha\n"
                + "--------------------------\n"
                + "\n"
                + "---- Falando com um NPC ---\n"
                + "\n"
                + "FALAR nomedonpc  \n"
                + "\n"
                + "SIM - responde o npc\n"
                + "\n"
                + "NAO - responde o npc\n"
                + "\n"
                + "-------------------------\n"
                + "\n"
                + "PERICIA nomedapericia - executa pericia\n"
                + "USAR quantidade nome tipo -\n"
                + "COLETAR";

        return res;

    }
}
