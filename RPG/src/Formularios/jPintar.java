package Formularios;

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
        g.drawRect(32, 32, 10, 10);
    }

    @Override
    public void paintComponent(Graphics g) {
        criaGrade(g, Color.BLACK, 10, 10, 15);
    }
}
