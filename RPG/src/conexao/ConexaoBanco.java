/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alexjonas
 */
public class ConexaoBanco {

    public static Connection getConexao() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
           // return DriverManager.getConnection("jdbc:mysql://localhost/rpg", "root", "");
              return DriverManager.getConnection("jdbc:mysql://192.168.2.126/rpg", "cedup", "cedup");
            //return DriverManager.getConnection("jdbc:mysql://db4free.org/ceduprpgturma11", "turma11", "turma111234567890");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }

}
