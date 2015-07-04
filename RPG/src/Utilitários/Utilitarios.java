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

    public String falanpcs(int codigo_npc, String falanpc) throws SQLException, IllegalAccessException, NoSuchMethodException,
            IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        String fala = "";
        GenericDAO gDAO = new GenericDAO();
        Npcs npcs = new Npcs();
        NpcsFalas npcsFalas = new NpcsFalas();
        Falas falas = new Falas();
        ArrayList arrayListCodFala = new ArrayList();
        int index = 0;
        int cont = 1;
        
        //lista codigo da fala
        npcsFalas.setCodigo_npc(codigo_npc);
        List<Object> list = gDAO.listar2(NpcsFalas.class, npcsFalas);
        for (Object obj2 : list) {
            NpcsFalas nf = (NpcsFalas) obj2;
            arrayListCodFala.add(nf.getCodigo_fala());
        }
        
        while (index < arrayListCodFala.size()){
            //pega a fala desejada
            falas.setCodigo_fala((int) arrayListCodFala.get(cont));
            List<Object> list1 = gDAO.listar2(Falas.class, falas);
            for (Object obj3 : list1) {
                Falas f = (Falas) obj3;
                //verifica o tipo de fala desejado
                if (falanpc.equals("fala")){
                    fala=("Npc: " + f.getDescricao_fala() + " \n ");
                }else if (falanpc.equals("sim")) {
                    fala=("Npc: " +f.getResposta_positivo_fala() + " \n ");
                }else if (falanpc.equals("nao")){
                    fala=("Npc: " +f.getResposta_negativo_fala() + " \n ");
                }
            }
            cont++;
            index++;
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

        lis = gda.listar2(Temporario.class, tem);

        for (Object li : lis) {
            Temporario tp = (Temporario) li;
            tem.setCa_personagem(tp.getCa_personagem());
            tem.setCodigo_arma(tp.getCodigo_arma());
            tem.setPontos_vida_temporario(tp.getPontos_vida_temporario());
            tem.setCodigo_escudo(tp.getCodigo_escudo());
        }
        tem.setIniciativa_personagem(dad.getDado(20) + per.getDestreza_personagem());
    }

    public String carregaPosicoes() throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException,
            InvocationTargetException, InstantiationException, ClassNotFoundException {
        Posicoes posicoes = new Posicoes();
        PericiasPosicoes periciasPosicoes = new PericiasPosicoes();
        GenericDAO gDAO = new GenericDAO();
        ArrayList arrayListPosicao = new ArrayList(); //aqui todos os codigos de carregaPosicoes do caminho selecionado ficam
        ArrayList arrayListDescPosicao = new ArrayList();
        Autenticacao auth = Autenticacao.getInstance();
        String textoPosicoes = "";

        //limpando arrays
        arrayListDescPosicao.clear();
        arrayListPosicao.clear();

        //salva os dados da posicao
        posicoes.setCodigo_caminho(auth.getCodigo_caminho());
        List<Object> list3 = gDAO.listar2(Posicoes.class, posicoes);
        for (Object obj4 : list3) {
            Posicoes p = (Posicoes) obj4;

            arrayListPosicao.add(posicoes.getCodigo_posicao());
            arrayListDescPosicao.add(posicoes.getDescricao_posicao());
        }

        //verifica se a posicao validada é 0
        if (auth.getValida_posicao() == 0) {
            auth.setValida_posicao(1);
        }

        while (auth.getValida_posicao() <= arrayListPosicao.size()) {

            auth.setCodigo_posicao((int) arrayListPosicao.get(auth.getValida_posicao())); //posição atual

            textoPosicoes = " " + arrayListDescPosicao.get(auth.getValida_posicao()) + " /n";

            //pegando npcs dessa posicao
            PosicoesNpcs posicoesNpcs = new PosicoesNpcs();
            posicoesNpcs.setCodigo_posicao(posicoes.getCodigo_posicao());
            List<Object> list7 = gDAO.listar2(PosicoesNpcs.class, posicoesNpcs);
            for (Object obj7 : list7) {
                Npcs npcs = new Npcs();

                npcs.setCodigo_npc(posicoesNpcs.getCodigo_npc());
                List<Object> list8 = gDAO.listar2(Npcs.class, npcs);
                for (Object obj8 : list8) {
                    textoPosicoes = " " + npcs.getNome_npc() + " ";
                    textoPosicoes = " " + npcs.getDescricao_npc() + " /n";

                    //setando tipos de npcs
                    if (npcs.getTipo_npc().equals("combatente")) {
                        auth.setStatus_atual("Batalha");
                        auth.setCodigo_npc(npcs.getCodigo_npc());
                    }
                    if (npcs.getTipo_npc().equals("comerciante")) {
                        auth.setStatus_atual("Comercio");
                        auth.setCodigo_npc(npcs.getCodigo_npc());
                    }
                }
            }

            //pega todas as pericias dessa posição
            periciasPosicoes.setCodigo_posicao(auth.getCodigo_posicao());
            List<Object> list4 = gDAO.listar2(PericiasPosicoes.class, periciasPosicoes);
            for (Object obj5 : list4) {
                PericiasPosicoes pp = new PericiasPosicoes();

                Pericias ps = new Pericias();
                ps.setCodigo_pericia(pp.getCodigo_pericia());
                List<Object> list6 = gDAO.listar2(Pericias.class, ps);
                for (Object obj6 : list6) {
                    textoPosicoes = " " + ps.getNome_pericia() + "; ";
                }
            }

            auth.setValida_posicao(auth.getValida_posicao() + 1);
            break;
        }

        return textoPosicoes;
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
                gd.executaSql(sql,"");
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
