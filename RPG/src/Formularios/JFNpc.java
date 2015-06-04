/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import dao.GenericDAO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tabelas.Falas;
import tabelas.Npcs;
import tabelas.NpcsFalas;

/**
 *
 * @author Leonardo
 */
public class JFNpc extends javax.swing.JFrame {

    /**
     * Creates new form JFNpc
     */
    public void centralizarComponente() {
        
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dw = getSize();
        setLocation ((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);
    }
    
    public JFNpc() {
        initComponents();
        centralizarComponente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelNomeNpc = new javax.swing.JLabel();
        LabelTipoNpc = new javax.swing.JLabel();
        JTFNomeNpc = new javax.swing.JTextField();
        LabelNpc = new javax.swing.JLabel();
        LabelDescricaoNpc = new javax.swing.JLabel();
        LabelFala = new javax.swing.JLabel();
        LabelRespostaPositiva = new javax.swing.JLabel();
        LabelRespostaNegativa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricaoNpc = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAFalaNpc = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTARespostaNegativa = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTARespostaPositiva = new javax.swing.JTextArea();
        jBCadastrar = new javax.swing.JButton();
        jBAdicionarFala = new javax.swing.JButton();
        jCBTipoNpc = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Npc's");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(788, 405));

        LabelNomeNpc.setText("Nome:");

        LabelTipoNpc.setText("Tipo:");

        LabelNpc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabelNpc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelNpc.setText("Npc's");
        LabelNpc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        LabelDescricaoNpc.setText("Descrição Npc:");

        LabelFala.setText("Fala:");

        LabelRespostaPositiva.setText("Resposta Positiva:");

        LabelRespostaNegativa.setText("Resposta Negativa:");

        jTADescricaoNpc.setColumns(20);
        jTADescricaoNpc.setLineWrap(true);
        jTADescricaoNpc.setRows(5);
        jScrollPane1.setViewportView(jTADescricaoNpc);

        jTAFalaNpc.setColumns(20);
        jTAFalaNpc.setLineWrap(true);
        jTAFalaNpc.setRows(5);
        jScrollPane2.setViewportView(jTAFalaNpc);

        jTARespostaNegativa.setColumns(20);
        jTARespostaNegativa.setLineWrap(true);
        jTARespostaNegativa.setRows(5);
        jScrollPane3.setViewportView(jTARespostaNegativa);

        jTARespostaPositiva.setColumns(20);
        jTARespostaPositiva.setLineWrap(true);
        jTARespostaPositiva.setRows(5);
        jScrollPane4.setViewportView(jTARespostaPositiva);

        jBCadastrar.setText("Cadastrar");
        jBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarActionPerformed(evt);
            }
        });

        jBAdicionarFala.setText("Adicionar Fala");

        jCBTipoNpc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Combatente", "Comerciante", "Guia", "Missão", "Coletável" }));
        jCBTipoNpc.setSelectedIndex(-1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(LabelTipoNpc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelNomeNpc)
                                .addGap(3, 3, 3)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBTipoNpc, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFNomeNpc, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAdicionarFala))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelDescricaoNpc)
                            .addComponent(LabelRespostaPositiva))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelRespostaNegativa)
                            .addComponent(LabelFala)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(LabelNpc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LabelNpc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNomeNpc)
                    .addComponent(JTFNomeNpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTipoNpc)
                    .addComponent(jCBTipoNpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDescricaoNpc, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelFala))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelRespostaPositiva))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelRespostaNegativa)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAdicionarFala, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarActionPerformed
        // TODO add your handling code here:
        
        try {
        
        Npcs npc = new Npcs();
        Falas fala = new Falas();   
        NpcsFalas npcfala = new NpcsFalas();
        
        GenericDAO gDao = new GenericDAO();
                
        npc.setNome_npc(JTFNomeNpc.getText()); 
        npc.setTipo_npc(String.valueOf(jCBTipoNpc.getSelectedItem()));  // cadastra base NPCS            
        npc.setDescricao_npc(jTADescricaoNpc.getText());
        
        gDao.adicionar(npc); 
        int codMaxNPC = gDao.codigoMax(Npcs.class);
            System.out.println(codMaxNPC);
        
        fala.setDescricao_fala(jTAFalaNpc.getText());
        fala.setResposta_positivo_fala(jTARespostaPositiva.getText());  // cadastra fala NPC
        fala.setResposta_negativo_fala(jTARespostaNegativa.getText());

        gDao.adicionar(fala);
        int codMaxFala = gDao.codigoMax(Falas.class);
            System.out.println(codMaxFala);

            System.out.println("Cadastro de Npc efetuado com muita dor!");
            
        npcfala.setCodigo_npc(codMaxNPC);
        npcfala.setCodigo_fala(codMaxFala);             // cadastra N/N NPCS e Falas
        
        gDao.adicionar(npcfala);
   
        } catch (SQLException ex) {
            Logger.getLogger(JFNpc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFNpc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JFNpc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JFNpc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(JFNpc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JFNpc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JFNpc.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_jBCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(JFNpc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFNpc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFNpc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFNpc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFNpc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTFNomeNpc;
    private javax.swing.JLabel LabelDescricaoNpc;
    private javax.swing.JLabel LabelFala;
    private javax.swing.JLabel LabelNomeNpc;
    private javax.swing.JLabel LabelNpc;
    private javax.swing.JLabel LabelRespostaNegativa;
    private javax.swing.JLabel LabelRespostaPositiva;
    private javax.swing.JLabel LabelTipoNpc;
    private javax.swing.JButton jBAdicionarFala;
    private javax.swing.JButton jBCadastrar;
    private javax.swing.JComboBox jCBTipoNpc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTADescricaoNpc;
    private javax.swing.JTextArea jTAFalaNpc;
    private javax.swing.JTextArea jTARespostaNegativa;
    private javax.swing.JTextArea jTARespostaPositiva;
    // End of variables declaration//GEN-END:variables
}
