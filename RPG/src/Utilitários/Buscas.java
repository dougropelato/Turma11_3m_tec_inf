/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitários;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import tabelas.Jogadores;
import tabelas.Personagens;
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

/**
 *
 * @author Alexjonas
 */
public class Buscas {

    private final Connection conecta;
    private Object rs;

    public Buscas() throws SQLException {
        this.conecta = Conexaoooo.getConexao();

    }

    public List<Object> listar(Class c)
            throws SQLException, IllegalAccessException, NoSuchFieldException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchMethodException {

        List<Object> list = new ArrayList<Object>();
        String tabela = c.getSimpleName();
        String sql = "SELECT * FROM " + tabela;
        PreparedStatement stmt = this.conecta.prepareStatement(sql);
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
                        Object Object = obj.getClass().getMethod(m.getName(), args1).invoke(obj, rset.getString(s));
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

    // busca jogador apartir do nome para login
    public List<Jogadores> buscaJogador(String nomJog) throws SQLException {

        String sql = "SELECT * FROM jogadores where nome_jogador like ? ";
        List<Jogadores> lista;

        PreparedStatement stmt = this.conecta.prepareStatement(sql);
        stmt.setString(1, nomJog);
        ResultSet RS = stmt.executeQuery();
        {

            lista = new ArrayList<>();

            while (RS.next()) {

                Jogadores jog = new Jogadores();

                jog.setCodigo_jogador(RS.getInt("codigo_jogador"));
                jog.setNome_jogador(RS.getString("nome_jogador"));
                jog.setSenha_jogador(RS.getString("senha_jogador"));
                jog.setMestre_jogador(RS.getBoolean("mestre_jogador"));

                lista.add(jog);

            }
        }
        return lista;
    }
    //buscaPersonagens apartid do codigo do jogador

    public List<Personagens> buscaPersonagens(int codJog) throws SQLException {

        String sql = "SELECT *"
                + "  FROM jogadores_personagens jogper"
                + "     , personagens per"
                + " WHERE jogper.codigo_jogador = ? "
                + "   AND per.codigo_personagem = jogper.codigo_personagem";
        List<Personagens> lista;

        PreparedStatement stmt = this.conecta.prepareStatement(sql);
        stmt.setInt(1, codJog);
        ResultSet RS = stmt.executeQuery();
        {

            lista = new ArrayList<>();

            while (RS.next()) {

                Personagens per = new Personagens();

                per.setCodigo_personagem(RS.getInt("codigo_personagem"));
                per.setNome_personagem(RS.getString("nome_personagem"));

                lista.add(per);

            }
        }
        return lista;
    }

    // cadastraTudo funciaonado feito um relogio
    public void cadastraTudo(Object obj) throws ClassNotFoundException, SQLException, IllegalArgumentException, IllegalAccessException {

        String classe = obj.getClass().getName();
        Class cls = Class.forName(classe);

        String campos = "";
        String valores = "";

        Field listaAtributos[] = cls.getDeclaredFields();

        for (int i = 0; i < listaAtributos.length; i++) {

            Field fld = listaAtributos[i];
            fld.setAccessible(true);

            campos += fld.getName();
            valores += "'" + fld.get(obj) + "'";

            if (i != (listaAtributos.length - 1)) {
                campos += ", ";
                valores += ", ";
            }

        }

        String sql = "INSERT INTO " + cls.getSimpleName() + " (" + campos + ") VALUES (" + valores + ")";
        System.out.println(sql);

        PreparedStatement stmt = conecta.prepareCall(sql);

        stmt.execute();
        stmt.close();
        System.out.println("deu certo essa porra");

    }

    public void alteraTudo(Object obj) throws ClassNotFoundException, SQLException, IllegalArgumentException, IllegalAccessException {

        String classe = obj.getClass().getName();
        Class cls = Class.forName(classe);

        String campos = "";
        String lugar = "";
        String tabela = cls.getSimpleName();

        Field listaAtributos[] = cls.getDeclaredFields();

        for (int i = 0; i < listaAtributos.length; i++) {

            Field fld = listaAtributos[i];
            fld.setAccessible(true);

            campos += fld.getName() + " = '" + fld.get(obj) + "'";

            if (i != (listaAtributos.length - 1)) {
                campos += ", ";
            }

            if (fld.getType().toString().equals("int")) {
                if (fld.getName().equalsIgnoreCase(retornaPkey(tabela))) {
                    lugar = fld.getName() + " = '" + fld.get(obj) + "'";
                }
            }

        }

        String sql = "UPDATE " + tabela + " SET " + campos + " WHERE " + lugar + "";
        System.out.println(sql);

        PreparedStatement stmt = conecta.prepareCall(sql);
        stmt.execute();
        stmt.close();
        System.out.println("deu certo essa porra");
    }

    public String retornaPkey(String tabela) throws SQLException {

        String sql = "SELECT information_schema.KEY_COLUMN_USAGE.COLUMN_NAME as collp\n"
                + "FROM information_schema.KEY_COLUMN_USAGE\n"
                + "WHERE information_schema.KEY_COLUMN_USAGE.CONSTRAINT_NAME LIKE \"PRIMARY\"  AND\n"
                + "information_schema.KEY_COLUMN_USAGE.TABLE_NAME LIKE \"" + tabela + "\"";
        PreparedStatement stmt = conecta.prepareCall(sql);

        ResultSet RS = stmt.executeQuery();

        String pK = "";

        while (RS.next()) {
            // Object nextElement = en.nextElement();
            pK = RS.getString("collp");

        }

        return pK;

    }

}
