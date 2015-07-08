
package Formularios;

import Tabelas.Raca;
import dao.GenericDAO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class JFRaca extends javax.swing.JFrame {

    public void centralizarComponente() { 
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dw = getSize();
        setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);
    }

  
    public JFRaca() {
        initComponents();
        centralizarComponente();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfNome_raca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescricao_raca = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jtfForca_raca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfDestreza_raca = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfConstituicao_raca = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfInteligencia_raca = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfSabedoria_raca = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfCarisma_raca = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfqtd_adicionais_raca = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jCBoxUsoArmadura = new javax.swing.JComboBox();
        jbCadastrar_raca = new javax.swing.JButton();
        jComboBoxUsoArma = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("CADASTRO DE RAÇAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 230, 50));

        jLabel2.setText("Nome Raça:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        getContentPane().add(jtfNome_raca, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 150, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("DESCRIÇÃO DA RAÇA:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

        jtaDescricao_raca.setColumns(20);
        jtaDescricao_raca.setRows(5);
        jScrollPane1.setViewportView(jtaDescricao_raca);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 370, 130));

        jLabel4.setText("Força Raca:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jtfForca_raca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfForca_racaKeyTyped(evt);
            }
        });
        getContentPane().add(jtfForca_raca, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 60, -1));

        jLabel5.setText("Destreza Raca:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jtfDestreza_raca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDestreza_racaKeyTyped(evt);
            }
        });
        getContentPane().add(jtfDestreza_raca, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 60, -1));

        jLabel6.setText("Constituição Raça:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, -1));

        jtfConstituicao_raca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfConstituicao_racaKeyTyped(evt);
            }
        });
        getContentPane().add(jtfConstituicao_raca, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 59, -1));

        jLabel7.setText("Inteligencia Raça:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, -1));

        jtfInteligencia_raca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfInteligencia_racaKeyTyped(evt);
            }
        });
        getContentPane().add(jtfInteligencia_raca, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 60, -1));

        jLabel8.setText("Sabedoria Raça:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jtfSabedoria_raca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfSabedoria_racaKeyTyped(evt);
            }
        });
        getContentPane().add(jtfSabedoria_raca, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 60, -1));

        jLabel9.setText("Carisma Raça:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jtfCarisma_raca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCarisma_racaKeyTyped(evt);
            }
        });
        getContentPane().add(jtfCarisma_raca, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 60, -1));

        jLabel10.setText("Quantidade Talentos Adc:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));

        jtfqtd_adicionais_raca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfqtd_adicionais_racaKeyTyped(evt);
            }
        });
        getContentPane().add(jtfqtd_adicionais_raca, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 30, -1));

        jLabel11.setText("Uso Arma:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        jLabel13.setText("Uso Armadura:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, -1, -1));

        jCBoxUsoArmadura.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Armadura Leve", "Armadura Média", "Armadura Pesada" }));
        getContentPane().add(jCBoxUsoArmadura, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, -1, -1));

        jbCadastrar_raca.setText("Cadastrar");
        jbCadastrar_raca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrar_racaActionPerformed(evt);
            }
        });
        getContentPane().add(jbCadastrar_raca, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 90, 40));

        jComboBoxUsoArma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Armas Simples", "Armas Comuns", "Armas Exóticas ", " " }));
        getContentPane().add(jComboBoxUsoArma, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        jCheckBox1.setText("Usa Escudo");
        getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrar_racaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrar_racaActionPerformed
        try {         
            
            if (jtaDescricao_raca.getText().equalsIgnoreCase("") || jtfCarisma_raca.getText().equalsIgnoreCase("") || jtfConstituicao_raca.getText().equalsIgnoreCase("") || jtfDestreza_raca.getText().equalsIgnoreCase("") || jtfInteligencia_raca.getText().equalsIgnoreCase("") || jtfSabedoria_raca.getText().equalsIgnoreCase("") || jtfqtd_adicionais_raca.getText().equalsIgnoreCase("") || jtfForca_raca.getText().equalsIgnoreCase("") || jtfConstituicao_raca.getText().equalsIgnoreCase("")){
             
             JOptionPane.showMessageDialog(null, " Preencha todos os campos!" );
                
            } else{
                  
            GenericDAO gDao = new GenericDAO ();
            Raca rc = new Raca();
            
            rc.setNome_raca(jtfNome_raca.getText());
            rc.setConstituicao_raca(Integer.parseInt(jtfConstituicao_raca.getText()));
            rc.setCarisma_raca(Integer.parseInt(jtfCarisma_raca.getText()));
            rc.setDescricao_raca(jtaDescricao_raca.getText());
            rc.setDestreza_raca(Integer.parseInt(jtfDestreza_raca.getText()));
            rc.setForca_raca(Integer.parseInt(jtfForca_raca.getText()));
            rc.setInteligencia_raca(Integer.parseInt(jtfInteligencia_raca.getText()));
            rc.setQtd_talen_raca_adc(Integer.parseInt(jtfqtd_adicionais_raca.getText()));
            rc.setSabedoria_raca(Integer.parseInt(jtfSabedoria_raca.getText()));
            rc.setUso_armadura_raca(jCBoxUsoArmadura.getSelectedIndex());
          
            
            if (jCheckBox1.isSelected())  {
                rc.setUso_escudo_raca(1);
                                
            }
            else {
               rc.setUso_escudo_raca(0); 
            }
          
            gDao.adicionar(rc);
            
            JOptionPane.showMessageDialog(null, " Raça "+jtfNome_raca.getText()+" cadastrada com total sucesso!" );
            
            jtfCarisma_raca.setText(null);
            jtfConstituicao_raca.setText(null);
            jtfInteligencia_raca.setText(null);
            jtfSabedoria_raca.setText(null);
            jtfNome_raca.setText(null);
            jtfForca_raca.setText(null);
            jtfqtd_adicionais_raca.setText(null);
            jtfDestreza_raca.setText(null);
            jtaDescricao_raca.setText(null);
            
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JFRaca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFRaca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JFRaca.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JFRaca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbCadastrar_racaActionPerformed

    private void jtfForca_racaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfForca_racaKeyTyped
        // TODO add your handling code here:
         String caracteres = "0987654321"; //apenas numeros podem ser digitados
        if(!caracteres.contains(evt.getKeyChar()+"")){ //se algo diferente que "caracteres" for digitado
            evt.consume();
        }
    }//GEN-LAST:event_jtfForca_racaKeyTyped

    private void jtfDestreza_racaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDestreza_racaKeyTyped
        // TODO add your handling code here:
         String caracteres = "0987654321"; //apenas numeros podem ser digitados
        if(!caracteres.contains(evt.getKeyChar()+"")){ //se algo diferente que "caracteres" for digitado
            evt.consume();
        }
    }//GEN-LAST:event_jtfDestreza_racaKeyTyped

    private void jtfConstituicao_racaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfConstituicao_racaKeyTyped
        // TODO add your handling code here:
         String caracteres = "0987654321"; //apenas numeros podem ser digitados
        if(!caracteres.contains(evt.getKeyChar()+"")){ //se algo diferente que "caracteres" for digitado
            evt.consume();
        }
    }//GEN-LAST:event_jtfConstituicao_racaKeyTyped

    private void jtfInteligencia_racaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfInteligencia_racaKeyTyped
        // TODO add your handling code here:
         String caracteres = "0987654321"; //apenas numeros podem ser digitados
        if(!caracteres.contains(evt.getKeyChar()+"")){ //se algo diferente que "caracteres" for digitado
            evt.consume();
        }
    }//GEN-LAST:event_jtfInteligencia_racaKeyTyped

    private void jtfSabedoria_racaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSabedoria_racaKeyTyped
        // TODO add your handling code here:
         String caracteres = "0987654321"; //apenas numeros podem ser digitados
        if(!caracteres.contains(evt.getKeyChar()+"")){ //se algo diferente que "caracteres" for digitado
            evt.consume();
        }
    }//GEN-LAST:event_jtfSabedoria_racaKeyTyped

    private void jtfCarisma_racaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCarisma_racaKeyTyped
        // TODO add your handling code here:
         String caracteres = "0987654321"; //apenas numeros podem ser digitados
        if(!caracteres.contains(evt.getKeyChar()+"")){ //se algo diferente que "caracteres" for digitado
            evt.consume();
        }
    }//GEN-LAST:event_jtfCarisma_racaKeyTyped

    private void jtfqtd_adicionais_racaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfqtd_adicionais_racaKeyTyped
        // TODO add your handling code here:
         String caracteres = "0987654321"; //apenas numeros podem ser digitados
        if(!caracteres.contains(evt.getKeyChar()+"")){ //se algo diferente que "caracteres" for digitado
            evt.consume();
        }
    }//GEN-LAST:event_jtfqtd_adicionais_racaKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFRaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFRaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFRaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFRaca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFRaca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jCBoxUsoArmadura;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBoxUsoArma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbCadastrar_raca;
    private javax.swing.JTextArea jtaDescricao_raca;
    private javax.swing.JTextField jtfCarisma_raca;
    private javax.swing.JTextField jtfConstituicao_raca;
    private javax.swing.JTextField jtfDestreza_raca;
    private javax.swing.JTextField jtfForca_raca;
    private javax.swing.JTextField jtfInteligencia_raca;
    private javax.swing.JTextField jtfNome_raca;
    private javax.swing.JTextField jtfSabedoria_raca;
    private javax.swing.JTextField jtfqtd_adicionais_raca;
    // End of variables declaration//GEN-END:variables
}
