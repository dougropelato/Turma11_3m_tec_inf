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

        jLNomePericia = new javax.swing.JLabel();
        jLDescricao = new javax.swing.JLabel();
        jTFNomePericia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricaoPericia = new javax.swing.JTextArea();
        jBSalvar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jLCadastroPericia = new javax.swing.JLabel();
        jCBAtributoPrincipal = new javax.swing.JComboBox();
        jLAtributoPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLNomePericia.setText("Perícia:");

        jLDescricao.setText("Descrição:");

        jTFNomePericia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNomePericiaActionPerformed(evt);
            }
        });

        jTADescricaoPericia.setColumns(20);
        jTADescricaoPericia.setRows(5);
        jScrollPane1.setViewportView(jTADescricaoPericia);

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

        jLCadastroPericia.setText("CADASTRO DE PERÍCIAS");

        jLAtributoPrincipal.setText("Atributo Principal:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLCadastroPericia))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLNomePericia)
                .addGap(36, 36, 36)
                .addComponent(jTFNomePericia, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLDescricao)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLAtributoPrincipal)
                .addGap(35, 35, 35)
                .addComponent(jCBAtributoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLCadastroPericia)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLNomePericia))
                    .addComponent(jTFNomePericia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLDescricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLAtributoPrincipal))
                    .addComponent(jCBAtributoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(189, 189, 189)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCancelar)
                    .addComponent(jBSalvar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        
        try {
            GenericDAO gDao = new GenericDAO();
            
            Pericias p = new Pericias();
            p.setNome_pericia(jTFNomePericia.getText());
            p.setDescricao_pericia(jTADescricaoPericia.getText());
            p.setAtributo_principal_pericia(String.valueOf(jCBAtributoPrincipal.getSelectedItem()));
            gDAO.adicionar(p);
  
        } catch (SQLException | ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jTFNomePericiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNomePericiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNomePericiaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        try { //lista classes cadastradas no ComboBox
    
        GenericDAO gDao = new GenericDAO();
        
            List<Object> listarClasses = null;
            try {
                listarClasses = gDao.listar(Classes.class);
                } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
                    Logger.getLogger(formularios.JFNpc.class.getName()).log(Level.SEVERE, null, ex);
                }

                for (Object obj2 : listarClasses) {
                    Classes classe = (Classes) obj2;
                    jCBAtributoPrincipal.addItem(classe.getNome_classe());
                }

        } catch (SQLException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_formWindowOpened

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
    private javax.swing.JComboBox jCBAtributoPrincipal;
    private javax.swing.JLabel jLAtributoPrincipal;
    private javax.swing.JLabel jLCadastroPericia;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLNomePericia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTADescricaoPericia;
    private javax.swing.JTextField jTFNomePericia;
    // End of variables declaration//GEN-END:variables
}
