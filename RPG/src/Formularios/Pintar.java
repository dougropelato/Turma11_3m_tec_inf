/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 * Cores RGb
 * http://www.uff.br/cdme/matrix/matrix-html/matrix_color_cube/matrix_color_cube_br.html
 */
package Formularios;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class Pintar  {
    public static void main(String[] args) {
        try {
            JFPrincipal f = new JFPrincipal();  
            f.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Pintar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Pintar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Pintar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Pintar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Pintar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Pintar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Pintar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

/*


painel.setPreferredSize(new Dimension(600,450));  
  
painel.setLayout(new FlowLayout(0));  
scroll.setBounds(50, 50, 650, 450);  
scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);  
scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
scroll.setViewportBorder(BorderFactory.createLoweredBevelBorder());  
scroll.setAutoscrolls(true);  
scroll.setViewportView(painel);  
  
getContentPane().add(scroll);  










 bbg.setColor(new Color(100, 90, 200));	//muda a cor!
 bbg.drawRect(50, 75, 100, 100);	        //desenha um retângulo sem preenchimento
 bbg.setColor(new Color(200, 0, 200));	//muda a cor
 bbg.drawOval(50, 200, 100, 100);	//desenha uma elipse sem preenchimento
 bbg.drawLine(250, 250, 300, 300);	//desenha uma linha reta
 bbg.setColor(new Color(100, 200, 100));	//muda a cor
 bbg.fillRect(50, 350, 100, 100);	//Desenhando um retângulo preenchido!
 bbg.setColor(new Color(255, 255, 0));	//muda a cor
        
 */
