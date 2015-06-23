/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import Tabelas.PericiasPosicoes;
import dao.GenericDAO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tabelas.Caminhos;
import tabelas.Npcs;
import tabelas.Pericias;
import tabelas.Posicoes;
import tabelas.PosicoesNpcs;

/**
 *
 * @author Orlando
 */
public class JFPosicoes extends javax.swing.JFrame {

    ArrayList arrayListNpc = new ArrayList(); //salva todos os codigos de npc do combobox
    ArrayList arrayListCaminhos = new ArrayList(); //salva todos os codigos de caminhos do combobox
    ArrayList arrayListCampanhas = new ArrayList(); //salva todos os codigos de campanhas do combobox   
    ArrayList arrayListPosicoes = new ArrayList(); //salva todos os codigos de Caminhos do combobox 
    ArrayList arrayListPericias = new ArrayList(); //salva todos os codigos de Pericias no combobox

    public void centralizarComponente() {
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dw = getSize();
        setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);
    }

    public void carregaComboCaminhos() throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        GenericDAO gDAO = new GenericDAO();
        Caminhos caminho = new Caminhos();
        List<Object> list = gDAO.listar(Caminhos.class);

        for (Object obj : list) {
            Caminhos c = (Caminhos) obj;

            System.out.println("cod caminho " + c.getCodigo_caminho());
            System.out.println("cod missao " + c.getCodigo_campanha());
            System.out.println("nome caminho " + c.getNome_caminho());

            arrayListCaminhos.add(c.getCodigo_caminho());
            arrayListCampanhas.add(c.getCodigo_campanha());
            jcbCaminho.addItem(c.getNome_caminho());
        }
    }

    public void carregaComboNpc() throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        GenericDAO gDAO = new GenericDAO();
        Npcs npc = new Npcs();
        List<Object> list = gDAO.listar(Npcs.class);

        for (Object obj2 : list) {
            Npcs n = (Npcs) obj2;

            System.out.println("cod npc " + n.getCodigo_npc());
            System.out.println("nome npc " + n.getNome_npc());

            arrayListNpc.add(npc.getCodigo_npc());
            jcbNpc.addItem(n.getNome_npc());
        }
    }

    public void carregaComboPericia() throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        GenericDAO gDAO2 = new GenericDAO();
        Pericias pericia = new Pericias();
        List<Object> list = gDAO2.listar(Pericias.class);

        for (Object obj3 : list) {
            Pericias p = (Pericias) obj3;

            System.out.println("cod pericia " + p.getCodigo_pericia());
            System.out.println("Nome pericia " + p.getNome_pericia());

            arrayListPericias.add(pericia.getCodigo_pericia());
            jcbPericias.addItem(p.getNome_pericia());
        }
    }

    /**
     * Creates new form JFPosicoes
     */
    public JFPosicoes() {
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

        jScrollBar1 = new javax.swing.JScrollBar();
        jcbCaminho = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlTamMapa = new javax.swing.JLabel();
        jtfTamMapa = new javax.swing.JTextField();
        jtfValorX = new javax.swing.JTextField();
        jlValorX = new javax.swing.JLabel();
        jlValorY = new javax.swing.JLabel();
        jtfValorY = new javax.swing.JTextField();
        jcbNpc = new javax.swing.JComboBox();
        jlSelecNpc = new javax.swing.JLabel();
        jbSalvar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaDescricaoCaminho = new javax.swing.JTextArea();
        jcbPericias = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescricaoPericia = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jtfValPericia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jcbCaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCaminhoActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecionar Caminho");

        jLabel2.setText("Descrição do Caminho");

        jlTamMapa.setText("Tamanho Mapa (X, Y):");

        jtfTamMapa.setText("20x20");
        jtfTamMapa.setEnabled(false);
        jtfTamMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfTamMapaActionPerformed(evt);
            }
        });

        jlValorX.setText("Insira Valor da Posição X:");

        jlValorY.setText("Insira Valor da Posição Y:");

        jcbNpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNpcActionPerformed(evt);
            }
        });

        jlSelecNpc.setText("Selecionar NPC");

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");

        jtaDescricaoCaminho.setColumns(20);
        jtaDescricaoCaminho.setRows(5);
        jScrollPane2.setViewportView(jtaDescricaoCaminho);

        jLabel3.setText("Perícia Personagem");

        jLabel4.setText("Dificuldade Perícia (Valor Inteiro)");

        jtaDescricaoPericia.setColumns(20);
        jtaDescricaoPericia.setRows(5);
        jScrollPane1.setViewportView(jtaDescricaoPericia);

        jLabel5.setText("Descrição Perícia Caso Personagem Consiga Utilizá-la");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlTamMapa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTamMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlValorX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfValorX, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlValorY)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfValorY, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlSelecNpc, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbSalvar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(16, 16, 16)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbCancelar)
                            .addComponent(jcbPericias, 0, 180, Short.MAX_VALUE)
                            .addComponent(jcbNpc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfValPericia, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTamMapa)
                    .addComponent(jtfTamMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfValorX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlValorX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlValorY)
                    .addComponent(jtfValorY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbNpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSelecNpc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbPericias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfValPericia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbSalvar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfTamMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfTamMapaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfTamMapaActionPerformed

    private void jcbNpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNpcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbNpcActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed

        try {
            //if (jtaDescricaoCaminho.getText().equals("") || jtaDescricaoPericia.getText().equals("") || jtfValPericia.getText().equals("") || jtfValorX.getText().equals("") || jtfValorY.getText().equals("")) {
            //JOptionPane.showMessageDialog(null, "Insira uma descrição para esta posição!");
            //} else {
            GenericDAO gDAO = new GenericDAO();
            Posicoes posicoes = new Posicoes();
            PosicoesNpcs posicaoNpc = new PosicoesNpcs();
            Npcs npc = new Npcs();
            Pericias pericias = new Pericias();
            PericiasPosicoes periciaPosicao = new PericiasPosicoes();
            Caminhos caminhos = new Caminhos();

            //Insertes tabela 'Posicoes'
            posicoes.setCodigo_caminho((int) (arrayListCaminhos.get(jcbCaminho.getSelectedIndex())));
            posicoes.setDescricao_posicao(jtaDescricaoCaminho.getText());
            posicoes.setCoordenadaX_posicao(Integer.parseInt(jtfValorX.getText()));
            posicoes.setCoordenadaY_posicao(Integer.parseInt(jtfValorY.getText()));
            gDAO.adicionar(posicoes); //adicionando posicao
            posicoes.setCodigo_posicao(gDAO.codigoMax(Posicoes.class));//Pega o código da última posição cadastrada
            System.out.println("Posição Cadastradacom Sucesso!");

            npc.setNome_npc(jcbNpc.getSelectedItem().toString());
            List<Object> list = gDAO.listar2(Npcs.class, npc);

            for (Object obj4 : list) {
                Npcs npcc = (Npcs) obj4;

                posicaoNpc.setCodigo_npc(npcc.getCodigo_npc());
            }

            //Inserts Tabela N/N 'PosicoesNpcs'
            posicaoNpc.setCodigo_posicao(posicoes.getCodigo_posicao());
            System.out.println(arrayListNpc.get(jcbNpc.getSelectedIndex()));
            System.out.println(posicaoNpc.getCodigo_npc());
            System.out.println(jcbNpc.getSelectedItem());
            System.out.println(arrayListNpc);
            gDAO.adicionar(posicaoNpc);

                //Inserts Tabela N/N 'PericiasPosicoes'
            //periciaPosicao.setCodigo_pericia((int) arrayListPericias.get(jcbPericias.getSelectedIndex()));
            //periciaPosicao.setCodigo_posicao(posicoes.getCodigo_posicao());
            //periciaPosicao.setDescricao_pericia_conseguiu(jtaDescricaoPericia.getText());
            //periciaPosicao.setValor_pericia(Integer.parseInt(jtfValPericia.getText()));
            //gDAO.adicionar(periciaPosicao);
            /*    
             PosicoesNpcs posicoesNpcs = new PosicoesNpcs();
             //tabela N pra N
             posicoesNpcs.setCodigo_posicoes(posicoes.getCodigo_posicao());
             posicoesNpcs.setCodigo_npc(((int) ((arrayListNpc.get(jcbNpc.getSelectedIndex())))));
            
             gDAO.adicionar(posicoesNpcs); //adicionando tabela n-n posicoesNpcs
             */
            //mensagem de cadastro
            JOptionPane.showMessageDialog(null, "Posição cadastrada!");
            //limpando campos apos cadastro
            jtaDescricaoCaminho.setText("");
            jtfValorX.setText("");
            jtfValorY.setText("");
            // }

        } catch (SQLException ex) {
            Logger.getLogger(JFPosicoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPosicoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JFPosicoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JFPosicoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(JFPosicoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JFPosicoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JFPosicoes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbSalvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        try {
            carregaComboCaminhos();
            carregaComboNpc();
            carregaComboPericia();

        } catch (SQLException ex) {
            Logger.getLogger(JFPosicoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JFPosicoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(JFPosicoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JFPosicoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JFPosicoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JFPosicoes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPosicoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jcbCaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCaminhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCaminhoActionPerformed

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
            java.util.logging.Logger.getLogger(JFPosicoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPosicoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPosicoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPosicoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPosicoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox jcbCaminho;
    private javax.swing.JComboBox jcbNpc;
    private javax.swing.JComboBox jcbPericias;
    private javax.swing.JLabel jlSelecNpc;
    private javax.swing.JLabel jlTamMapa;
    private javax.swing.JLabel jlValorX;
    private javax.swing.JLabel jlValorY;
    private javax.swing.JTextArea jtaDescricaoCaminho;
    private javax.swing.JTextArea jtaDescricaoPericia;
    private javax.swing.JTextField jtfTamMapa;
    private javax.swing.JTextField jtfValPericia;
    private javax.swing.JTextField jtfValorX;
    private javax.swing.JTextField jtfValorY;
    // End of variables declaration//GEN-END:variables
}
