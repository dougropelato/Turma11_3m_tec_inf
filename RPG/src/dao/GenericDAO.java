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
 * @author Douglas / Alex jonas
 */
/**
 * *************************************************************************
 * Método ALTERAR passar o objeto que vai ser alterado
 * **************************************************************************
 * Método LISTAR - passar a classe EX listar(Armas.class);
 * *************************************************************************
 * Método LISTAR2 passar como parametro a classe e o objeto com algo dentro
 * *************************************************************************
 * Método LISTAR3 passar como parametro o objeto com algo dentro uma classe que
 * é o outro lado da n pra n e a classe n pra n
 * ****************************************************************************************
 * Função codigoMax passar como parametro a classe e ele vai retornar o valor da
 * maior pk
 * *************************************************************************
 * Método ADICIONAR passar o objeto com os valeores para serem adicionados
 * **************************************************************************
 * Método executaSql passar como parametro uma sting com o sql monta dentro ela
 * não lista nada so altera e ou deleta
 * **************************************************************************
 */
public class GenericDAO {

    private Connection conexao;

    //Contrutor
    public GenericDAO() throws SQLException {
        this.conexao = ConexaoBanco.getConexao();
    }

    /**
     * *************************************************************************
     * Método ALTERAR passar o objeto que vai ser alterado
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
        System.out.println(sql);
        stmt.execute();
        stmt.close();
        System.out.println("deu certo essa porra");
    }

    /**
     * *************************************************************************
     * Método ALTERAR passar o objeto que vai ser alterado
     * **************************************************************************
     */
    public void alterar2(Object obj) throws ClassNotFoundException,
            SQLException, IllegalArgumentException,
            IllegalAccessException {

        String classe = obj.getClass().getName();
        Class cls = Class.forName(classe);
        String campos = "";
        String[] codigos;

        String lugar = "";
        String tabela = cls.getSimpleName();
        String baseDados = conexao.getCatalog();

        Field listaAtributos[] = cls.getDeclaredFields();

        for (int i = 0; i < listaAtributos.length; i++) {
            Field fld = listaAtributos[i];
            fld.setAccessible(true);
            campos += fld.getName() + " = '" + fld.get(obj) + "'";
            if (i != (listaAtributos.length - 1)) {
                campos += ", ";
            }

            if (fld.getType().toString().equals("int")) {

                codigos = fld.getName().split("_");

                if (codigos[0].equalsIgnoreCase("codigo")) {
                    if (lugar.equalsIgnoreCase("")) {
                        lugar = fld.getName() + " = '" + fld.get(obj) + "' ";
                    } else {
                        lugar += " AND " + fld.getName() + " = '" + fld.get(obj) + "'";
                    }
                }
            }
        }
        String sql = "UPDATE " + tabela + " SET " + campos + " WHERE " + lugar + "";
        PreparedStatement stmt = conexao.prepareCall(sql);
        System.out.println(sql);
        stmt.execute();
        stmt.close();
        System.out.println("deu certo essa porra");
    }

    /**
     * *************************************************************************
     * Método LISTAR - passar a classe EX listar(Armas.class);
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
                    if (pvec[0].getName().equals("double")) {
                        args1[0] = double.class;
                        obj.getClass().getMethod(m.getName(), args1).invoke(obj, rset.getDouble(s));
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
     * Método LISTAR2 passar como parametro a classe e o objeto com algo dentro
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
                tipoDado = fld.get(lugar).toString();

                if (!tipoDado.equalsIgnoreCase("0") && !tipoDado.equalsIgnoreCase("0.0")) {

                    if (onde.equalsIgnoreCase("")) {
                        System.out.println(fld.get(lugar));
                        onde = " WHERE " + fld.getName().toString() + " = '" + fld.get(lugar).toString() + "'";
                    } else {
                        onde += " AND " + fld.getName().toString() + " = '" + fld.get(lugar).toString() + "'";
                    }
                }
            }

        }

        String sql = "SELECT * FROM " + tabela + onde;
        System.out.println(sql);
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
                    if (pvec[0].getName().equals("double")) {
                        args1[0] = double.class;
                        obj.getClass().getMethod(m.getName(), args1).invoke(obj, rset.getDouble(s));
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
     * Método LISTAR3 passar como parametro o objeto com algo dentro uma classe
     * que é o outro lado da n pra n e a classe n pra n
     * **************************************************************************
     */
    public List<List> listar3(Object TabelaA, Class TabelaB, Class nN)
            throws SQLException, IllegalAccessException, NoSuchMethodException,
            IllegalArgumentException, InvocationTargetException,
            InstantiationException, ClassNotFoundException {

        Class c = TabelaA.getClass();

        String tA = c.getSimpleName();
        String tB = TabelaB.getSimpleName();
        String tC = nN.getSimpleName();

        List<List> list = new ArrayList<>();

        List<Object> listA = new ArrayList<Object>();
        List<Object> listB = new ArrayList<Object>();
        List<Object> listC = new ArrayList<Object>();

        String tabela = tA + " tA, " + tB + " tB, " + tC + " tC";

        String onde = "";
        String daOnde = "";

        String classe = TabelaA.getClass().getName();
        Class cls = Class.forName(classe);
        Field listaAtributos[] = cls.getDeclaredFields();

        for (int i = 0; i < listaAtributos.length; i++) {
            Field fld = listaAtributos[i];
            fld.setAccessible(true);

            if (fld.get(TabelaA) != null && fld.getName().equalsIgnoreCase(retornaPK(tA))) {

                daOnde = "'" + fld.get(TabelaA) + "'";

            }

        }

        onde = " WHERE ";

        onde += "tC." + retornaPK(tA);

        if (!daOnde.equalsIgnoreCase("")) {
            onde += " = " + daOnde;
        } else {
            onde += " = tA." + retornaPK(tA);
        }

        onde += " AND ";
        onde += "tC." + retornaPK(tB) + " = tB." + retornaPK(tB);

        String sql = "SELECT * FROM " + tabela + onde;

        System.out.println(sql);

        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        ResultSet rset = stmt.executeQuery();

        while (rset.next()) {
            Object objA = c.newInstance();
            Object objB = TabelaB.newInstance();
            Object objC = nN.newInstance();

            for (Method m : c.getMethods()) {
                if (m.getName().substring(0, 3).equals("set")) {
                    Class[] args1 = new Class[1];
                    Class pvec[] = m.getParameterTypes();
                    String s = m.getName().substring(3, m.getName().length());

                    if (pvec[0].getName().equals("java.lang.String")) {
                        args1[0] = String.class;

                        objA.getClass().getMethod(m.getName(), args1).invoke(objA, rset.getString(s));
                    }

                    if (pvec[0].getName().equals("int")) {
                        args1[0] = int.class;
                        objA.getClass().getMethod(m.getName(), args1).invoke(objA, rset.getInt(s));
                    }
                }
            }
            listA.add(objA);

            for (Method m : TabelaB.getMethods()) {
                if (m.getName().substring(0, 3).equals("set")) {
                    Class[] args1 = new Class[1];
                    Class pvec[] = m.getParameterTypes();
                    String s = m.getName().substring(3, m.getName().length());

                    if (pvec[0].getName().equals("java.lang.String")) {
                        args1[0] = String.class;

                        objB.getClass().getMethod(m.getName(), args1).invoke(objB, rset.getString(s));
                    }

                    if (pvec[0].getName().equals("int")) {
                        args1[0] = int.class;
                        objB.getClass().getMethod(m.getName(), args1).invoke(objB, rset.getInt(s));
                    }
                }
            }
            listB.add(objB);

            for (Method m : nN.getMethods()) {
                if (m.getName().substring(0, 3).equals("set")) {
                    Class[] args1 = new Class[1];
                    Class pvec[] = m.getParameterTypes();
                    String s = m.getName().substring(3, m.getName().length());

                    if (pvec[0].getName().equals("java.lang.String")) {
                        args1[0] = String.class;

                        objC.getClass().getMethod(m.getName(), args1).invoke(objC, rset.getString(s));
                    }

                    if (pvec[0].getName().equals("int")) {
                        args1[0] = int.class;
                        objC.getClass().getMethod(m.getName(), args1).invoke(objC, rset.getInt(s));
                    }
                }
            }
            listC.add(objC);

        }

        list.add(listA);
        list.add(listB);
        list.add(listC);

        rset.close();
        stmt.close();

        return list;
    }

    /**
     * ****************************************************************************************
     * Função codigoMax passar como parametro a classe e ele vai retornar o
     * valor da maior pk
     * ****************************************************************************************
     */
    public int codigoMax(Class c)
            throws SQLException, IllegalAccessException, NoSuchMethodException,
            IllegalArgumentException, InvocationTargetException,
            InstantiationException, ClassNotFoundException {

        int max = 0;

        String tabela = c.getSimpleName();

        String sql = "SELECT MAX(" + retornaPK(tabela) + ") maior FROM " + tabela;

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
     * Método ADICIONAR passar o objeto com os valeores para serem adicionados
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

            campos = campos + fld.getName() + ", ";

            dados = dados + "'" + fld.get(obj) + "'" + ",";

        }
        campos = campos.substring(0, campos.length() - 2);
        String tabela = cls.getSimpleName();
        dados = dados.substring(0, dados.length() - 1); //tira a última vírgula
        String sql = "INSERT INTO " + tabela + " (" + campos + ") VALUES (" + dados + ")";

        System.out.println(sql);

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            //Executa o código sql
            stmt.execute();
        }
        System.out.println("Registro ADICIONADO ao banco!");
    }

    /**
     * *************************************************************************
     * Método EXCLUIR passar o objeto com o codigo setado para excluir
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
     * Método retornaPK passar como parametro o nome da tabela e ela retorna o
     * nome do compo que é PK
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

    /**
     * *************************************************************************
     * Método executaSql passar como parametro uma sting com o sql monta dentro
     * ela não lista nada so altera e ou deleta
     * **************************************************************************
     */
    public String executaSql(String sql) throws SQLException {
        String res = "O Sql foi executado";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.execute();
        stmt.close();

        return res;

    }

}
