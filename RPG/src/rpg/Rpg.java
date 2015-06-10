/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import Tabelas.TalentosPersonagem;
import dao.GenericDAO;
import formularios.JFMestre;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import tabelas.Armas;
import tabelas.Personagens;
import tabelas.Talentos;

/**
 *
 * @author Douglas
 */
public class Rpg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

//        JFMestre m = new JFMestre();;
//        m.setVisible(true);
        Personagens pp = new Personagens();
        Talentos tts = new Talentos();

        aplicaTalento(pp, tts);

//        list = gDao.listar3(tt, Personagens.class, TalentosPersonagem.class);;;;;;;
//
//        for (Object obj2 : list.get(0)) {
//            Talentos ttt = (Talentos) obj2;
//            System.out.println(ttt.getDescricao_talento());
//        }
//
//        for (Object obj2 : list.get(1)) {
//            Personagens pp = (Personagens) obj2;
//            System.out.println(pp.getNome_personagem());
//        }
//
//        for (Object obj2 : list.get(2)) {
//            TalentosPersonagem ttp= (TalentosPersonagem) obj2;
//            System.out.println(ttp.getBonus_talento_personagem());
//        }
    }

    public static void aplicaTalento(Personagens pp, Talentos tts) throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        GenericDAO gd = new GenericDAO();
        TalentosPersonagem tp = new TalentosPersonagem();

        List<Object> list = null;
        list = gd.listar(Talentos.class);
        String bns = null;

        for (Object obj : list) {
            Talentos tt = (Talentos) obj;

            bns = tt.getBonus_talento();
        }

        String[] bonus = bns.split(";");

        if (bonus[0].equalsIgnoreCase("personagens")) {

            int bnn = 0;

            Class cls = Personagens.class;
            Field listaAtributos[] = cls.getDeclaredFields();

            for (int i = 0; i < listaAtributos.length; i++) {
                Field fld = listaAtributos[i];
                fld.setAccessible(true);

                String teste = fld.getName();

                if (teste.equalsIgnoreCase(bonus[1])) {                   
                    
                    bnn = Integer.valueOf(fld.get(pp).toString());

                    bnn = bnn + Integer.valueOf(bonus[2]);    
                    
                   
                }

            }

        }

    }

}
