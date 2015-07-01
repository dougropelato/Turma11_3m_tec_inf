/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Tabelas.Raca;
import dao.GenericDAO;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tabelas.Classes;
import tabelas.Pericias;

/**
 *
 * @author Fabio
 */
public class JFPericias extends javax.swing.JFrame {

    GenericDAO gDAO;

    /**
     * Creates new form JFPericias
     */
    public JFPericias() throws SQLException {
        this.gDAO = new GenericDAO();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLPerícia = new javax.swing.JLabel();
        jLDescrição = new javax.swing.JLabel();
        jTNomePerícia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescrição = new javax.swing.JTextArea();
        jBSalvar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jLCadastroPerícias = new javax.swing.JLabel();
        jCBAtributo = new javax.swing.JComboBox();
        jLAtributoPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLPerícia.setText("Perícia:");

        jLDescrição.setText("Descrição:");

        jTNomePerícia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNomePeríciaActionPerformed(evt);
            }
        });

        jTADescrição.setColumns(20);
        jTADescrição.setRows(5);
        jScrollPane1.setViewportView(jTADescrição);

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jLCadastroPerícias.setText("CADASTRO DE PERÍCIAS");

        jCBAtributo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Força", "Destreza", "Constituição", "Inteligência", "Sabedoria", "Carisma" }));
        jCBAtributo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAtributoActionPerformed(evt);
            }
        });

        jLAtributoPrincipal.setText("Atributo Principal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLCadastroPerícias)
                        .addGap(123, 123, 123))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLDescrição)
                                    .addComponent(jLPerícia))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTNomePerícia)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLAtributoPrincipal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCBAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(50, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLCadastroPerícias)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLPerícia)
                            .addComponent(jTNomePerícia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLDescrição)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jCBAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLAtributoPrincipal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBCancelar))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed

        if (jTNomePerícia.getText().equalsIgnoreCase("") || jTADescrição.getText().equalsIgnoreCase("") || jCBAtributo.getSelectedIndex() != 0) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            try {
                GenericDAO gDao = new GenericDAO();

                Pericias p = new Pericias();
                p.setNome_pericia(jTNomePerícia.getText());
                p.setDescricao_pericia(jTADescrição.getText());
                p.setAtributo_principal_pericia(String.valueOf(jCBAtributo.getSelectedItem()));
                gDAO.adicionar(p);

                JOptionPane.showMessageDialog(null, " Salvou, manda nude!"); // Após clicar no botão salvar, aparece tal mensagem

            } catch (SQLException | ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        setVisible(false); // quando o botão cancelar for precionado, a janela fechará
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jTFNomePericiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNomePericiaActionPerformed

    }//GEN-LAST:event_jTFNomePericiaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jCBAtributoPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAtributoPrincipalActionPerformed

    }//GEN-LAST:event_jCBAtributoPrincipalActionPerformed

    private void jCBAtributoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAtributoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBAtributoActionPerformed

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
            java.util.logging.Logger.getLogger(JFPericias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPericias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPericias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPericias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFPericias().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox jCBAtributo;
    private javax.swing.JLabel jLAtributoPrincipal;
    private javax.swing.JLabel jLCadastroPerícias;
    private javax.swing.JLabel jLDescrição;
    private javax.swing.JLabel jLPerícia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTADescrição;
    private javax.swing.JTextField jTNomePerícia;
    // End of variables declaration//GEN-END:variables
}
