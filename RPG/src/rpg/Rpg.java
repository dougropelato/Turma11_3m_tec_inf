/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import Tabelas.Autenticacao;
import formularios.JFMestre;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 *
 * @author Douglas
 */
public class Rpg {

    Autenticacao auth = Autenticacao.getInstance();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        JFMestre m = new JFMestre();
        m.setVisible(true);

    }

}
