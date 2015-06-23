/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitários;

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

    public String iniciaBatalha(Personagens per, NpcsCombatentes npc, Temporario tem) throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        String ini = "";
        utilitários.Dados dad = new utilitários.Dados();
        GenericDAO gda = new GenericDAO();
        Personagens psg = new Personagens();
        Temporario tempnpc = new Temporario();
        int dano = 0;

        if (tem.getIniciativa_personagem() == 0) {

            tem.setIniciativa_personagem(dad.getDado(20) + per.getDestreza_personagem());

            List<Object> lis = new ArrayList();

            psg.setCodigo_personagem(npc.getCodigo_personagem());

            lis = gda.listar2(Personagens.class, psg);

            for (Object li : lis) {
                Personagens pso = (Personagens) li;

                psg.setAltura_personagem(pso.getAltura_personagem());
                psg.setBase_ataque_personagem(pso.getBase_ataque_personagem());
                psg.setCarisma_personagem(pso.getCarisma_personagem());
                psg.setClasse_armadura_personagem(pso.getClasse_armadura_personagem());
                psg.setContituicao_personagem(pso.getContituicao_personagem());
                psg.setDestreza_personagem(pso.getDestreza_personagem());
                psg.setForca_personagem(pso.getForca_personagem());
                psg.setFortitude_personagem(pso.getFortitude_personagem());
                psg.setIdade_personagem(pso.getIdade_personagem());
                psg.setIniciativa_personagem(pso.getIniciativa_personagem());
                psg.setInteligencia_personagem(pso.getInteligencia_personagem());
                psg.setNome_personagem(pso.getNome_personagem());
                psg.setPeso_personagem(pso.getPeso_personagem());
                psg.setPontos_vida_personagem(pso.getPontos_vida_personagem());
                psg.setReflexos_personagem(pso.getReflexos_personagem());
                psg.setSabedoria_personagem(pso.getSabedoria_personagem());
                psg.setVontade_personagem(pso.getVontade_personagem());
            }
            
            tempnpc.setCodigo_personagem(npc.getCodigo_personagem());
            lis = gda.listar2(Temporario.class, tempnpc);

            for (Object li : lis) {
                Temporario tp = (Temporario) li;
                tempnpc.setCa_personagem(tp.getCa_personagem());
                tempnpc.setCodigo_arma(tp.getCodigo_arma());
                tempnpc.setPontos_vida_temporario(tp.getPontos_vida_temporario());
                tempnpc.setCodigo_escudo(tp.getCodigo_escudo());
                tempnpc.setIniciativa_personagem(dad.getDado(20) + psg.getDestreza_personagem());
            }
        }

        if (tem.getIniciativa_personagem() > tempnpc.getIniciativa_personagem()) {
            if (verAcerto(psg, tempnpc) > verDefesa(per, tem)) {
                dano = dano(per, tem);
                psg.setPontos_vida_personagem(psg.getPontos_vida_personagem() - dano);

                if (psg.getPontos_vida_personagem() > 0) {
                    ini = psg.getNome_personagem() + " recebeu um ataque violento \n";
                    ini += dano + " pontos de dano ";
                } else {
                    ini = psg.getNome_personagem() + " recebeu um ataque violento \n";
                    ini += dano + " pontos de dano e morreu";
                }

            } else {
                ini = "Você Errou.";
                return ini;
            }

        } else {
            if (verAcerto(per, tem) > verDefesa(psg, tempnpc)) {

                dano = dano(psg, tempnpc);
                per.setPontos_vida_personagem(per.getPontos_vida_personagem() - dano);

                if (per.getPontos_vida_personagem() > 0) {
                    ini = "voce recebeu um ataque violento";
                } else {

                }

            } else {
                ini = "NPC errou.";
                return ini;
            }
        }
        return ini;
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
