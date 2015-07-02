package Formularios;

import Tabelas.Autenticacao;
import dao.GenericDAO;
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javax.swing.JPanel;
import tabelas.Caminhos;
import tabelas.Posicoes;

public class jPintar extends JPanel {

    ArrayList posicaoX = new ArrayList();
    ArrayList posicaoY = new ArrayList();

    public void insere() {

        int cont = 1;
        int index = 3;
        posicaoY.add(index);
       posicaoX.add(index);
        while (cont <= 50) {
            posicaoY.add(index);
            posicaoX.add(index);
            index = index + 10;
            cont = cont + 1;
            System.out.println(index);
            //System.out.println("p: " + posicaoX);
        }

    }

    private void pintaJogador(Graphics g, Color cor) {
        //repaint();

        Autenticacao auth = Autenticacao.getInstance();

        //repaint();
        
        g.setColor(Color.RED);

        int x = (int) posicaoY.get(auth.getCoordenadaX_posicao());
        int y = (int) posicaoX.get(auth.getCoordenadaY_posicao());

        g.drawOval(x, y, 6, 6); //pinta jogador
        
        }
        

    
    public Color escolheCor() {
        Random ran = new Random();
        Color cor = null;
        cor = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
        return cor;
    }

    public void criaGrade(Graphics g, Color cor, int tamanhoX,
            int tamanhoY, int tamanhoGrade) throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, IllegalArgumentException, IllegalArgumentException, IllegalArgumentException, InvocationTargetException, InvocationTargetException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        insere();

        g.setColor(cor);

        int xx = 1, yy = 1;

        for (int y = 1; y <= tamanhoY; y++) {
            for (int x = 0; x < tamanhoX; x++) {
                g.drawRect(xx, yy, tamanhoGrade, tamanhoGrade);
                xx = xx + tamanhoGrade;
            }
            yy = yy + tamanhoGrade;
            xx = 1;
        }

        Autenticacao auth = Autenticacao.getInstance();
        GenericDAO gDAO = new GenericDAO();
        Posicoes posicoes = new Posicoes();
        Caminhos caminhos = new Caminhos();

        int f = 4;
        caminhos.setCodigo_campanha(f);
        List<Object> list4 = gDAO.listar2(Caminhos.class, caminhos);
        for (Object obj5 : list4) {
            Caminhos c = (Caminhos) obj5;
            System.out.println(c.getCodigo_caminho());

            posicoes.setCodigo_caminho(c.getCodigo_caminho());
            List<Object> list3 = gDAO.listar2(Posicoes.class, posicoes);
            for (Object obj4 : list3) {
                Posicoes p = (Posicoes) obj4;

                int px = p.getCoordenadaX_posicao();
                int py = p.getCoordenadaY_posicao();
//          
                int coordenadaY = (int) posicaoY.get(py);
                int coordenadaX = (int) posicaoX.get(px);

                g.setColor(Color.BLUE);
                g.drawRect(coordenadaX, coordenadaY, 6, 6); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y
                g.drawRect(coordenadaX, coordenadaY, 5, 5); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y
                g.drawRect(coordenadaX, coordenadaY, 4, 4); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y     
                g.drawRect(coordenadaX, coordenadaY, 3, 3); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y
                g.drawRect(coordenadaX, coordenadaY, 2, 2); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y
                g.drawRect(coordenadaX, coordenadaY, 1, 1); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y

            }

            pintaJogador(g, cor);

        }

    }

    @Override
    public void paintComponent(Graphics g) {

        Autenticacao auth = Autenticacao.getInstance();
        int tamx = auth.getTam_x_mapa();
        int tamy = auth.getTam_y_mapa();

        try {
            criaGrade(g, Color.BLACK, 25, 25, 10);
        } catch (SQLException ex) {
            Logger.getLogger(jPintar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(jPintar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(jPintar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(jPintar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(jPintar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(jPintar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jPintar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
