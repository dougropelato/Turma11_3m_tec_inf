/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Formularios.JFRaca;
import conexao.ConexaoBanco;
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
        this.conexao = ConexaoBanco.getConexao();
    }

    /**
     * *************************************************************************
     * Método ALTERAR
     * **************************************************************************
     */
    public void alterar(Object obj) throws ClassNotFoundException,
            SQLException, IllegalArgumentException,
            IllegalAccessException {

        String classe = obj.getClass().getName();
        Class cls = Class.forName(classe);
        String pK = "";
        String campos = "";
        String lugar = "";
        String tabela = cls.getSimpleName();
        String baseDados = conexao.getCatalog();

        Field listaAtributos[] = cls.getDeclaredFields();

        String sql3 = "SELECT information_schema.KEY_COLUMN_USAGE.COLUMN_NAME as \"chave\" \n"
                + "FROM information_schema.KEY_COLUMN_USAGE \n"
                + "WHERE information_schema.KEY_COLUMN_USAGE.CONSTRAINT_NAME LIKE \"PRIMARY\" \n"
                + "AND information_schema.KEY_COLUMN_USAGE.TABLE_SCHEMA LIKE \"" + baseDados + "\""
                + " AND information_schema.KEY_COLUMN_USAGE.TABLE_NAME LIKE \"" + tabela + "\"";

        for (int i = 0; i < listaAtributos.length; i++) {
            Field fld = listaAtributos[i];
            fld.setAccessible(true);
            campos += fld.getName() + " = '" + fld.get(obj) + "'";
            if (i != (listaAtributos.length - 1)) {
                campos += ", ";
            }
            PreparedStatement stmt = conexao.prepareCall(sql3);
            ResultSet RS = stmt.executeQuery();

            while (RS.next()) {
                // Object nextElement = en.nextElement();
                pK = RS.getString("chave");
            }
            if (fld.getType().toString().equals("int")) {
                if (fld.getName().equalsIgnoreCase(pK)) {
                    lugar = fld.getName() + " = '" + fld.get(obj) + "'";
                }
            }
        }
        String sql = "UPDATE " + tabela + " SET " + campos + " WHERE " + lugar + "";
        PreparedStatement stmt = conexao.prepareCall(sql);
        stmt.execute();
        stmt.close();
        System.out.println("deu certo essa porra");
    }

    /**
     * *************************************************************************
     * Método LISTAR
     * **************************************************************************
     */
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

    /**
     * *************************************************************************
     * Método LISTAR2 passar como parame tro a classe e o objeto com algo dentro
     * **************************************************************************
     */
    public List<Object> listar2(Class c, Object lugar)
            throws SQLException, IllegalAccessException, NoSuchMethodException,
            IllegalArgumentException, InvocationTargetException,
            InstantiationException, ClassNotFoundException {

        List<Object> list = new ArrayList<Object>();
        String tabela = c.getSimpleName();

        String onde = "";

        String classe = lugar.getClass().getName();
        Class cls = Class.forName(classe);
        Field listaAtributos[] = cls.getDeclaredFields();
        String valorIncluir = "";
        String tipoDado;

        for (int i = 0; i < listaAtributos.length; i++) {
            Field fld = listaAtributos[i];
            fld.setAccessible(true);

            if (fld.get(lugar) != null) {
                if (onde.equalsIgnoreCase("")) {
                    System.out.println(fld.get(lugar));
                    onde = " WHERE " + fld.getName().toString() + " = '" + fld.get(lugar).toString() + "'";
                } else {
                    onde += " AND " + fld.getName().toString() + " = '" + fld.get(lugar).toString() + "'";
                }
            }

        }

        String sql = "SELECT * FROM " + tabela + onde;

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

    public int codigoMax(Class c)
            throws SQLException, IllegalAccessException, NoSuchMethodException,
            IllegalArgumentException, InvocationTargetException,
            InstantiationException, ClassNotFoundException {            
        
        int max = 0;
        
        String tabela = c.getSimpleName(); 

        String sql = "SELECT MAX(" + retornaPK(tabela) + ") maior FROM " + tabela ;

        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        ResultSet rset = stmt.executeQuery();

        while (rset.next()) {
            
            max = rset.getInt("maior");
        }

        rset.close();
        stmt.close();

        return max;
    }

    /**
     * *************************************************************************
     * Método ADICIONAR
     * **************************************************************************
     */
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

    /**
     * *************************************************************************
     * Método EXCLUIR
     * **************************************************************************
     */
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
       /**
     * *************************************************************************
     * Método EXCLUIR
     * **************************************************************************
     */
    public String retornaPK(String tabela) throws SQLException {
        String pK = "";
        String baseDados = conexao.getCatalog();

        String sql = "SELECT information_schema.KEY_COLUMN_USAGE.COLUMN_NAME as \"chave\" \n"
                + "FROM information_schema.KEY_COLUMN_USAGE \n"
                + "WHERE information_schema.KEY_COLUMN_USAGE.CONSTRAINT_NAME LIKE \"PRIMARY\" \n"
                + "AND information_schema.KEY_COLUMN_USAGE.TABLE_SCHEMA LIKE \"" + baseDados + "\""
                + " AND information_schema.KEY_COLUMN_USAGE.TABLE_NAME LIKE \"" + tabela + "\"";

        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        ResultSet rset = stmt.executeQuery();

        while (rset.next()) {
            
            pK = rset.getString("chave");
        }

        return pK;

    }
}
