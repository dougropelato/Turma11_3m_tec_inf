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
import tabelas.Personagens;

/**
 *
 * @author mamut
 */
public class Batalhas {

    Personagens npc = new Personagens();
    Temporario tempnpc = new Temporario();

    Personagens per = new Personagens();
    Temporario tem = new Temporario();

    public String iniciaBatalha() throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        Autenticacao auth = Autenticacao.getInstance();
        utilitários.Dados dad = new utilitários.Dados();
        GenericDAO gda = new GenericDAO();
        String res = "";
        Utilitarios ut = new Utilitarios();

        per.setCodigo_personagem(auth.getCodigo_personagem());
        tem.setCodigo_personagem(per.getCodigo_personagem());

        ut.carregaPersonagem(per, tem);

        npc.setCodigo_personagem(auth.getCodigo_npc());
        tempnpc.setCodigo_personagem(npc.getCodigo_personagem());

        ut.carregaPersonagem(npc, tempnpc);

        return res;
    }

    public int verAcerto(Personagens pp, Temporario tp) {
        int res = 0;

        utilitários.Dados dad = new utilitários.Dados();

        if (pp.getModForca() > pp.getModDestreza()) {
            res = dad.getDado(20) + pp.getModForca() + pp.getBase_ataque_personagem();

        } else {
            res = dad.getDado(20) + pp.getModDestreza() + pp.getBase_ataque_personagem();
        }
        return res;
    }

    public String combate() throws SQLException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        int dano = 0;
        String res = "";

        if (tem.getIniciativa_personagem() > tempnpc.getIniciativa_personagem()) {
            if (verAcerto(npc, tempnpc) > verDefesa(per, tem)) {
                dano = dano(per, tem);
                npc.setPontos_vida_personagem(npc.getPontos_vida_personagem() - dano);

                if (npc.getPontos_vida_personagem() > 0) {
                    res = npc.getNome_personagem() + " recebeu um ataque violento \n";
                    res += dano + " pontos de dano ";
                } else {
                    res = npc.getNome_personagem() + " recebeu um ataque violento \n";
                    res += dano + " pontos de dano e morreu";
                }

            } else {
                res = "Você Errou.";
                return res;
            }

        } else {
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
