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

        pp.setCodigo_personagem(1);

        Talentos tts = new Talentos();

        tts.setCodigo_talento(5);

        aplicaTalento(pp, tts);

    }

    public static void aplicaTalento(Personagens pp, Talentos tts) throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        GenericDAO gd = new GenericDAO();
        String sql = "";

        TalentosPersonagem tp = new TalentosPersonagem();

        List<Object> list = null;
        list = gd.listar2(Talentos.class, tts);
        String bns = null;

        for (Object obj : list) {
            Talentos tt = (Talentos) obj;

            bns = tt.getBonus_talento();
        }

        String[] bonus = bns.split(";");

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
        }

        if (bonus[0].equalsIgnoreCase("talentos")) {
            sql = "UPDATE talentospersonagem SET ";
            int bnn = 0;

            Class cls = Talentos.class;
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
        }

        System.out.println(sql);
        gd.executaSql(sql);
    }
}
