package Formularios;

import Tabelas.Autenticacao;
import dao.GenericDAO;
import java.awt.Color;
import java.awt.Graphics;
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
import tabelas.Posicoes;

public class jPintar extends JPanel {

    
    ArrayList  posicaoX = new ArrayList ();
    ArrayList  posicaoY = new ArrayList ();
    
    
    public void insere (){
    
        int cont = 1;
        int index = 3;
        while (cont <= 20 ){
           posicaoY.add(index);
           posicaoX.add(index);
           index =index+10;
           cont = cont + 1;
        
        }
        
    }
    
    public Color escolheCor() {
        Random ran = new Random();
        Color cor = null;
        cor = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
        return cor;
    }

    public void criaGrade(Graphics g, Color cor, int tamanhoX,
            int tamanhoY, int tamanhoGrade) throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, IllegalArgumentException, IllegalArgumentException, IllegalArgumentException, InvocationTargetException, InvocationTargetException, InvocationTargetException, InstantiationException, ClassNotFoundException {

       
        
        
        
        
        g.setColor(cor);
           
        //g.drawOval(x, y, tamX, tamY);
        int xx = 1, yy = 1;

        for (int y = 1; y <= tamanhoY; y++) {
            for (int x = 0; x < tamanhoX; x++) {
                g.drawRect(xx, yy, tamanhoGrade, tamanhoGrade);
                xx = xx + tamanhoGrade;
            }
            yy = yy + tamanhoGrade;
            xx = 1;
        } 

        //jogador
        
        
        g.setColor(Color.RED);
        
        g.drawRect(13, 23, 6, 6); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y
        g.drawRect(13, 23, 5, 5); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y
        g.drawRect(13, 23, 4, 4); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y
        g.drawRect(13, 23, 3, 3); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y
        g.drawRect(13, 23, 2, 2); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y
        g.drawRect(13, 23, 1, 1); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y
        
        
        
        
        
        Autenticacao auth = Autenticacao.getInstance();
        GenericDAO gDAO = new GenericDAO();
        Posicoes posicoes = new Posicoes();
        
        posicoes.setCodigo_caminho(auth.getCodigo_caminho());
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
           
           
           
           
//           g.drawRect(23, 33, 6, 6); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y
////g.drawRect(23, 43, 6, 6); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y
////g.drawRect(23, 53, 6, 6); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y
////g.drawRect(23, 63, 6, 6); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y
////g.drawRect(23, 73, 6, 6); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y

            //arrayListPosicao.add(posicoes.getCodigo_posicao());
            //textoPosicoes=posicoes.getDescricao_posicao() +" ";
            //System.out.println(posicoes.getDescricao_posicao());
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
