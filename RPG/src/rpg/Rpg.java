/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import Tabelas.TalentosPersonagem;
import dao.GenericDAO;
import formularios.JFMestre;
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
        GenericDAO gd = new GenericDAO();
        List<List> list = null;

        TalentosPersonagem tp = new TalentosPersonagem();

        tp.setCodigo_talento(1);
        tp.setCodigo_personagem(1);
        tp.setBonus_talento_personagem(10);
        
        
        gd.adicionar(tp);
        
        

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

}
