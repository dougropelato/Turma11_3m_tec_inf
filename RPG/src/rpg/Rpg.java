/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import dao.GenericDAO;
import formularios.JFMestre;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
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
       
        JFMestre m = new JFMestre();
        m.setVisible(true);

    }

}
