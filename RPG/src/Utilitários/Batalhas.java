/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitários;

import Tabelas.NpcsCombatentes;
import dao.GenericDAO;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tabelas.Personagens;

/**
 *
 * @author mamut
 */
public class Batalhas {
    
    public String ParametroBatalho(Personagens per, NpcsCombatentes npc) throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {
    String ini = "";

    utilitários.Dados dad = new utilitários.Dados();
    GenericDAO gda = new GenericDAO();
    Personagens psg = new Personagens();

    int vlriniciativaper;
    int vlriniciativanpc = 0;

    vlriniciativaper = dad.getDado(20) + per.getDestreza_personagem();

    List<Object> lis = new ArrayList();

    psg.setCodigo_personagem(npc.getCodigo_personagem());

    lis = gda.listar2(Personagens.class, psg);

    for (Object li : lis) {
        Personagens pso = (Personagens) li;
        vlriniciativanpc = dad.getDado(20) + pso.getDestreza_personagem();
    }

    if (vlriniciativaper > vlriniciativanpc) {

    } else {

    }
       
                
                
                
                
                
                
                
                return ini;

    }

    
    
    
}