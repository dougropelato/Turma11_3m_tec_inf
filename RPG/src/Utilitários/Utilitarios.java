/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitários;

import Formularios.JFPrincipal;
import Tabelas.Autenticacao;
import Tabelas.PericiaPersonagem;
import Tabelas.PericiasPosicoes;
import Tabelas.TalentosPersonagem;
import Tabelas.Temporario;
import Tabelas.Vwposicoes;
import dao.GenericDAO;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tabelas.Caminhos;
import tabelas.Campanhas;
import tabelas.Falas;
import tabelas.Npcs;
import tabelas.NpcsFalas;
import tabelas.Pericias;
import tabelas.Personagens;
import tabelas.Posicoes;
import tabelas.PosicoesNpcs;
import tabelas.Talentos;

/**
 *
 * @author Alexjonas
 */
public class Utilitarios {

    public String juntarStr(String[] fala) {
        String junta = fala[1];

        for (int i = 0; i < fala.length; i++) {

            if (i > 1) {
                junta += " " + fala[i];
            }
        }
        return junta;
    }

    public String falanpcs(int codigo_npc, String falanpc) throws SQLException, IllegalAccessException, NoSuchMethodException,
            IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        String fala = "";
        GenericDAO gDAO = new GenericDAO();
        Npcs npcs = new Npcs();
        Falas falas = new Falas();

        List lista = new ArrayList();

        List<Falas> lf = new ArrayList();

        npcs.setCodigo_npc(codigo_npc);

        lista = gDAO.listar3(npcs, Falas.class, NpcsFalas.class);

        lf = (List<Falas>) lista.get(1);

        for (Falas lf1 : lf) {
            Falas lll = (Falas) lf1;

            if (falanpc.equalsIgnoreCase("fala")) {
                fala = lll.getDescricao_fala();
            }
            if (falanpc.equalsIgnoreCase("sim")) {
                fala = lll.getResposta_positivo_fala();
            }
            if (falanpc.equalsIgnoreCase("não")) {
                fala = lll.getResposta_negativo_fala();
            }
        }

        return fala;
    }

    public String carregaCaminhos() throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException,
            InvocationTargetException, InstantiationException, ClassNotFoundException {
        GenericDAO gDAO = new GenericDAO();
        Caminhos caminhos = new Caminhos();
        Campanhas campanha = new Campanhas();
        Posicoes posicoes = new Posicoes();
        Autenticacao auth = Autenticacao.getInstance();

        String textoCampanha = "";

        //localiza a campanha selecionada
        campanha.setCodigo_campanha(auth.getCodigo_campanha());
        List<Object> list = gDAO.listar2(Campanhas.class, campanha);
        for (Object obj2 : list) {
            Campanhas c = (Campanhas) obj2;

            textoCampanha = " Bem vindo a campanha " + c.getNome_campanha() + " \n "; //mostra nome da campanha

            //setando tamanho do mapa
            auth.setTam_x_mapa(c.getTam_x_campanha());
            auth.setTam_y_mapa(c.getTam_y_campanha());
        }

        textoCampanha += " Deseja seguir que caminho? \n ";

        //Lista os caminhos para o jogador selecionar o desejado
        caminhos.setCodigo_campanha(campanha.getCodigo_campanha());
        List<Object> list2 = gDAO.listar2(Caminhos.class, caminhos);

        for (Object obj3 : list2) {
            Caminhos ca = (Caminhos) obj3;
            textoCampanha += " " + ca.getCodigo_caminho() + " - " + ca.getNome_caminho() + " \n ";
        }
        //auth.setCodigo_caminho(0); //caminho selecionado

        return textoCampanha;
    }

    public void carregaPersonagem(Personagens per, Temporario tem) throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Autenticacao auth = Autenticacao.getInstance();
        GenericDAO gda = new GenericDAO();
        List<Object> lis = new ArrayList();
        utilitários.Dados dad = new utilitários.Dados();

        lis = gda.listar2(Personagens.class, per);

        for (Object li : lis) {
            Personagens pso = (Personagens) li;

            if (pso.getCodigo_personagem() == per.getCodigo_personagem()) {

                per.setAltura_personagem(pso.getAltura_personagem());
                per.setBase_ataque_personagem(pso.getBase_ataque_personagem());
                per.setCarisma_personagem(pso.getCarisma_personagem());
                per.setClasse_armadura_personagem(pso.getClasse_armadura_personagem());
                per.setContituicao_personagem(pso.getContituicao_personagem());
                per.setDestreza_personagem(pso.getDestreza_personagem());
                per.setForca_personagem(pso.getForca_personagem());
                per.setFortitude_personagem(pso.getFortitude_personagem());
                per.setIdade_personagem(pso.getIdade_personagem());
                per.setIniciativa_personagem(pso.getIniciativa_personagem());
                per.setInteligencia_personagem(pso.getInteligencia_personagem());
                per.setNome_personagem(pso.getNome_personagem());
                per.setPeso_personagem(pso.getPeso_personagem());
                per.setPontos_vida_personagem(pso.getPontos_vida_personagem());
                per.setReflexos_personagem(pso.getReflexos_personagem());
                per.setSabedoria_personagem(pso.getSabedoria_personagem());
                per.setVontade_personagem(pso.getVontade_personagem());
            }

        }

        lis = gda.listar2(Temporario.class, tem);

        for (Object li : lis) {
            Temporario tp = (Temporario) li;
            if (tem.getCodigo_personagem() == tp.getCodigo_personagem()) {
                tem.setCa_personagem(tp.getCa_personagem());
                tem.setCodigo_arma(tp.getCodigo_arma());
                tem.setPontos_vida_temporario(tp.getPontos_vida_temporario());
                tem.setCodigo_escudo(tp.getCodigo_escudo());
            }

        }
        tem.setIniciativa_personagem(dad.getDado(20) + per.getDestreza_personagem());
    }

    public String carregaPosicoes() throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Autenticacao auth = Autenticacao.getInstance();
        GenericDAO gg = new GenericDAO();
        Vwposicoes vwp = new Vwposicoes();
        List<Object> lvp = new ArrayList();
        String texto = "";

        vwp.setCodigo_caminho(auth.getCodigo_caminho());

        lvp = gg.listar2(Vwposicoes.class, vwp);

        for (int i = auth.getValida_posicao(); i < lvp.size(); i++) {
            auth.setStatus_atual("Caminhando");
            auth.setValida_posicao(i);
            Vwposicoes vpp = new Vwposicoes();
            vpp = (Vwposicoes) lvp.get(i);

            texto += "  " + vpp.getDescricao_posicao() + "\n";
            if (vpp.getCodigo_pericia() != 0) {
                texto += "--- Pericias disponives ---\n";
                texto += "---  " + vpp.getNome_pericia();
                break;

            }
            if (vpp.getCodigo_npc() != 0) {
                auth.setCodigo_npc(vpp.getCodigo_npc());
                if (vpp.getTipo_npc().equalsIgnoreCase("guia")) {
                    texto += "Você avista: " + vpp.getNome_npc();
                    texto += " " + vpp.getDescricao_npc();
                    auth.setStatus_atual("Guia");
                    break;

                }
                if (vpp.getTipo_npc().equalsIgnoreCase("Combatente")) {
                    texto += "Você avista: " + vpp.getNome_npc();
                    texto += " " + vpp.getDescricao_npc();
                    auth.setStatus_atual("BATALHA");
                    break;

                }
                if (vpp.getTipo_npc().equalsIgnoreCase("Coletavel")) {
                    texto += "Você avista: " + vpp.getNome_npc();
                    texto += " " + vpp.getDescricao_npc();
                    auth.setStatus_atual("Coletavel");
                    break;
                }
            }
        }
        if(auth.getValida_posicao() == lvp.size()){
            auth.setCodigo_campanha(0);
            auth.setCodigo_caminho(0);
            auth.setStatus_atual("logado");
            texto += "---------------------- THE END -------------------------";
        }
            

        return texto;
    }

    public static void aplicaTalento(Personagens pp, Talentos tts) throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        GenericDAO gd = new GenericDAO();

        String sql = "NOK";

        TalentosPersonagem tp = new TalentosPersonagem();

        List<Object> lista = null;
        lista = gd.listar2(Talentos.class, tts);
        String bns = null;
        String pre = null;

        for (Object obj : lista) {
            Talentos tt = (Talentos) obj;
            bns = tt.getBonus_talento();
            pre = tt.getRequisito_talento();

        }

        String[] bonus = bns.split(";");
        String[] req = pre.split(";");

        if (req[0].equalsIgnoreCase("personagens")) {
            lista = gd.listar2(Personagens.class, pp);
            for (Object obj : lista) {
                Personagens pps = (Personagens) obj;

                Class cls = Personagens.class;
                Field listaAtributos[] = cls.getDeclaredFields();

                for (int i = 0; i < listaAtributos.length; i++) {

                    Field fld = listaAtributos[i];
                    fld.setAccessible(true);
                    String campo = fld.getName();

                    if (campo.equalsIgnoreCase(bonus[1])) {
                        if (Integer.getInteger((String) fld.get(pps)) <= Integer.getInteger(req[2])) {
                            sql = "OK";

                        }
                    }
                }
            }
        }
        if (req[0].equalsIgnoreCase("Pericias")) {

            PericiaPersonagem PPS = new PericiaPersonagem();
            PPS.setCodigo_personagem(pp.getCodigo_personagem());
            PPS.setCodigo_pericia(tts.getCodigo_talento());

            lista = gd.listar2(PericiaPersonagem.class, PPS);

            for (Object obj2 : lista) {
                PericiaPersonagem ett1 = (PericiaPersonagem) obj2;

                if (ett1.getPontos_de_pericia() <= Integer.valueOf(req[2])) {
                    sql = "OK";
                }
            }
        }

        if (sql.equalsIgnoreCase("OK")) {

            if (bonus[0].equalsIgnoreCase("personagens")) {
                sql = "UPDATE " + bonus[0] + " SET ";
                int bnn = 0;

                Class cls = Personagens.class;
                Field listaAtributos[] = cls.getDeclaredFields();

                for (int i = 0; i < listaAtributos.length; i++) {

                    Field fld = listaAtributos[i];
                    fld.setAccessible(true);
                    String campo = fld.getName();

                    if (campo.equalsIgnoreCase(bonus[1])) {

                        bnn = Integer.valueOf(fld.get(pp).toString());
                        bnn = bnn + Integer.valueOf(bonus[2]);
                        sql += campo + " = '" + bnn + "'";

                    }
                }

                sql += " WHERE codigo_personagem = " + pp.getCodigo_personagem();

                System.out.println(sql);
                gd.executaSql(sql, "");
            }

            if (bonus[0].equalsIgnoreCase("Pericias")) {
                sql = "UPDATE Periciapersonagem SET ";

                int bnn = Integer.parseInt(bonus[2]);
                int codgobous = 0;
                Pericias pp2 = new Pericias();
                pp2.setNome_pericia(bonus[1]);
                lista = gd.listar2(Pericias.class, pp2);

                for (Object obj : lista) {
                    Pericias ett = (Pericias) obj;
                    codgobous = ett.getCodigo_pericia();
                }

                PericiaPersonagem PPS = new PericiaPersonagem();
                PPS.setCodigo_personagem(pp.getCodigo_personagem());
                PPS.setCodigo_pericia(codgobous);

                lista = gd.listar2(PericiaPersonagem.class, PPS);

                for (Object obj2 : lista) {
                    PericiaPersonagem ett1 = (PericiaPersonagem) obj2;
                    bnn = ett1.getPontos_de_pericia() + bnn;
                }

                PPS.setPontos_de_pericia(bnn);
                gd.alterar(PPS);
            }

        } else {
            System.out.println("Voçe nao tem os requisitos necessarios para este Telento");
        }

    }

}
