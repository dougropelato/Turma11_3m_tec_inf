/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexaoooo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Douglas
 */
public class GenericDAO {
    
     private Connection conexao;

    //Contrutor
    public GenericDAO() throws SQLException {
        this.conexao = Conexaoooo.getConexao();
    }

    public List<Object> listar(Class c)
            throws SQLException, IllegalAccessException, NoSuchMethodException,
            IllegalArgumentException, InvocationTargetException,
            InstantiationException, ClassNotFoundException {

        List<Object> list = new ArrayList<Object>();
        String tabela = c.getSimpleName();
        String sql = "SELECT * FROM " + tabela;
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rset = stmt.executeQuery();

        while (rset.next()) {
            Object obj = c.newInstance();
            for (Method m : c.getMethods()) {
                if (m.getName().substring(0, 3).equals("set")) {
                    Class[] args1 = new Class[1];
                    Class pvec[] = m.getParameterTypes();
                    String s = m.getName().substring(3, m.getName().length());

                    if (pvec[0].getName().equals("java.lang.String")) {
                        args1[0] = String.class;
                        obj.getClass().getMethod(m.getName(), args1).invoke(obj, rset.getString(s));
                    }

                    if (pvec[0].getName().equals("int")) {
                        args1[0] = int.class;
                        obj.getClass().getMethod(m.getName(), args1).invoke(obj, rset.getInt(s));
                    }
                }
            }
            list.add(obj);
        }

        rset.close();
        stmt.close();

        return list;
    }

    
    public void adicionar(Object obj) throws ClassNotFoundException,
            SQLException, IllegalArgumentException, IllegalAccessException {

        String campos = "";
        String dados = "";
        String classe = obj.getClass().getName();
        Class cls = Class.forName(classe);
        Field listaAtributos[] = cls.getDeclaredFields();
        String valorIncluir = "";
        String tipoDado;

        for (int i = 0; i < listaAtributos.length; i++) {
            Field fld = listaAtributos[i];
            fld.setAccessible(true);
            //Testa os tipos de dados. 
            //Falta fazer com todos os tipos utilizados.
            if (i != 0) {
                campos = campos + fld.getName() + ", ";
                tipoDado = fld.getType().toString();
                if (tipoDado.equals("class java.lang.String")) {
                    dados = dados + '"' + fld.get(obj) + '"' + ",";
                }
                if (tipoDado.equals("int")) {
                    dados = dados + fld.get(obj) + ",";
                }
                try {
                    valorIncluir = valorIncluir + (String) fld.get(obj) + " ";
                } catch (ClassCastException e) {
                    valorIncluir = valorIncluir + (int) fld.get(obj) + " ";
                }
            }
        }
        campos = campos.substring(0, campos.length() - 2);
        String tabela = cls.getSimpleName();
        dados = dados.substring(0, dados.length() - 1); //tira a última vírgula
        String sql = "INSERT INTO " + tabela + " (" + campos + ") VALUES (" + dados + ")";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            //Executa o código sql
            stmt.execute();
        }
        System.out.println("Registro ADICIONADO ao banco!");
    }

    public void excluir(Object obj) throws ClassNotFoundException,
            NoSuchFieldException, SQLException {
        String campoTeste = null;
        String campo = null;
        int valorExcluir = 0;
        String classe = obj.getClass().getName();
        Class cls = Class.forName(classe);
        Field listaAtributos[] = cls.getDeclaredFields();
        for (int i = 0; i < listaAtributos.length; i++) {
            Field fld = listaAtributos[i];
            fld.setAccessible(true);
            try {
                System.out.println("Valor...........: " + fld.get(obj));
                campoTeste = fld.get(obj).toString();
                if (!campoTeste.equals("0")) {
                    System.out.println("OK");
                    campo = fld.getName();
                    valorExcluir = (int) fld.get(obj);
                    break;
                }
            } catch (IllegalAccessException ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException ex) {
                campoTeste = null;
            }
        }

        String tabela = cls.getSimpleName();
        String sql = "DELETE FROM " + tabela + " WHERE " + campo + " =?";
        System.out.println("SQL: " + sql);

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, valorExcluir);
        stmt.execute();
        stmt.close();
        System.out.println("Registro EXCLUÍDO no banco!");

    }
    
}
