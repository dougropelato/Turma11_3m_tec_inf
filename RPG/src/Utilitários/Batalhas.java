/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitários;

import Tabelas.Autenticacao;
import Tabelas.NpcsCombatentes;
import Tabelas.Temporario;
import dao.GenericDAO;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tabelas.Armas;
import tabelas.Escudos;
import tabelas.Npcs;
import tabelas.Personagens;

/**
 *
 * @author mamut
 */
public class Batalhas {

    Autenticacao auth = Autenticacao.getInstance();
    Personagens npc = new Personagens();
    Temporario tempnpc = new Temporario();

    Personagens per = new Personagens();
    Temporario tem = new Temporario();

    public String iniciaBatalha() throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        Npcs nn = new Npcs();
        GenericDAO gd = new GenericDAO();
        String res = "";
        Utilitarios ut = new Utilitarios();

        Personagens pno = new Personagens();

        per.setCodigo_personagem(auth.getCodigo_personagem());
        tem.setCodigo_personagem(per.getCodigo_personagem());

        ut.carregaPersonagem(per, tem);

        nn.setCodigo_npc(auth.getCodigo_npc());
        List asd = new ArrayList();

        asd = gd.listar3(nn, Personagens.class, NpcsCombatentes.class);
        try {
            pno = (Personagens) asd.get(1);
        } catch (Exception e) {

        }

        npc.setCodigo_personagem(pno.getCodigo_personagem());
        tempnpc.setCodigo_personagem(npc.getCodigo_personagem());

        ut.carregaPersonagem(npc, tempnpc);

        res = "Seu inimigo é: " + npc.getNome_personagem();

        if (tem.getIniciativa_personagem() > tempnpc.getIniciativa_personagem()) {
            auth.setIniciativa_personagem(2);
            auth.setIniciativa_npc(1);
        } else {
            auth.setIniciativa_personagem(1);
            auth.setIniciativa_npc(2);
        }

        return res;
    }

    public List fugir() {

        utilitários.Dados dad = new utilitários.Dados();

        List<String> res = new ArrayList();
        int i;
        i = dad.getDado(20);

        res.add("você tenta fugir mas é encurralado pelo seu inimigo dado = " + i);

        if (i > 15) {
            res.add("você corre velozmente para o lado oposto do seu inimigo deixando-o para tráz  dado = " + i);

        }

        return res;
    }

    public String combate() throws SQLException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        int dano = 0;
        String res = "";

        if (auth.getIniciativa_personagem() > auth.getIniciativa_npc()) {
            auth.setIniciativa_personagem(1);
            auth.setIniciativa_npc(2);

            if (verAcerto(npc, tempnpc) > verDefesa(per, tem)) {
                dano = dano(per, tem);
                npc.setPontos_vida_personagem(npc.getPontos_vida_personagem() - dano);

                if (npc.getPontos_vida_personagem() > 0) {
                    res = npc.getNome_personagem() + " recebeu um ataque violento \n";
                    res += "de " + dano + " pontos de dano ";
                } else {
                    res = npc.getNome_personagem() + " recebeu um ataque violento \n";
                    res += "de " + dano + " pontos de dano e morre";
                }

            } else {
                res = "Você Errou.";
            }

        } else {
            auth.setIniciativa_npc(1);
            auth.setIniciativa_personagem(2);

            if (verAcerto(per, tem) > verDefesa(npc, tempnpc)) {

                dano = dano(npc, tempnpc);
                per.setPontos_vida_personagem(per.getPontos_vida_personagem() - dano);

                if (per.getPontos_vida_personagem() > 0) {
                    res = "voce recebeu um ataque violento";
                } else {

                }

            } else {
                res = "NPC errou.";
                return res;
            }
        }

        return res;
    }

    public int verAcerto(Personagens pp, Temporario tp) {
        int res = 0;

        utilitários.Dados dad = new utilitários.Dados();

        if (pp.getModForca() > pp.getModDestreza()) {
            res = dad.getDado(20) + pp.getModForca() + pp.getBase_ataque_personagem() + 15;

        } else {
            res = dad.getDado(20) + pp.getModDestreza() + pp.getBase_ataque_personagem() + 15;
        }
        return res;
    }

    public int verDefesa(Personagens pp, Temporario tp) throws SQLException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        int res = 0;

        utilitários.Dados dad = new utilitários.Dados();
        GenericDAO gda = new GenericDAO();
        Escudos es = new Escudos();

        es.setCodigo_escudo(tp.getCodigo_arma());

        List<Object> escudoss = gda.listar2(Escudos.class, es);

        for (Object ess : escudoss) {
            Escudos es1 = (Escudos) ess;
            es.setBonus_maximo_escudo(es1.getBonus_maximo_escudo());
        }

        res = (int) (10 + pp.getModDestreza() + es.getBonus_maximo_escudo());

        return res;
    }

    public int dano(Personagens pp, Temporario tp) throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        int res = 0;
        GenericDAO gda = new GenericDAO();
        Armas arm = new Armas();
        utilitários.Dados dad = new utilitários.Dados();
        arm.setCodigo_arma(tp.getCodigo_arma());

        List<Object> aAs = gda.listar2(Armas.class, arm);

        for (Object ar : aAs) {
            Armas ars = (Armas) ar;
            arm.setNome_arma(arm.getNome_arma());
            arm.setQuantidade_dado_arma(ars.getQuantidade_dado_arma());
            arm.setTipo_do_dado_arma(ars.getTipo_do_dado_arma());
        }

        for (int i = 0; i < arm.getQuantidade_dado_arma(); i++) {

            res += dad.getDado(arm.getTipo_do_dado_arma());
        }

        res += pp.getModForca();

        return res;
    }

}
