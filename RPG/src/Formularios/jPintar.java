package Formularios;

import Tabelas.Autenticacao;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class jPintar extends JPanel {

    
    
    
    
    public Color escolheCor() {
        Random ran = new Random();
        Color cor = null;
        cor = new Color(ran.nextInt(255), ran.nextInt(255), ran.nextInt(255));
        return cor;
    }

    public void criaGrade(Graphics g, Color cor, int tamanhoX,
            int tamanhoY, int tamanhoGrade) {

       
        
        
        
        
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
        
        g.drawRect(13, 23, 6, 6); //13 e 23 é equivalente a posição do jogador 2,3 nas coordenadas x,y
    }

    @Override
    public void paintComponent(Graphics g) {
        
         Autenticacao auth = Autenticacao.getInstance();
         int tamx = auth.getTam_x_mapa();
         int tamy = auth.getTam_y_mapa();
         
        criaGrade(g, Color.BLACK, 25, 25, 10);
    }
}
