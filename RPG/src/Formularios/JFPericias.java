/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Tabelas.PericiasPosicoes;
import Tabelas.Raca;
import dao.GenericDAO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
    //criado uma arraylist para cadastro de perícias
    GenericDAO gDAO;
    
    
    ArrayList arrayListPericia = new ArrayList();
    ArrayList arrayListDescricao = new ArrayList();
    ArrayList arrayListAtributo = new ArrayList();
    
    public void CarregaComboPericias() throws SQLException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException, InstantiationException, ClassNotFoundException{
        GenericDAO genericDAO = new GenericDAO();
        
        //Limpa todos os campos
        arrayListPericia.clear();
        arrayListDescricao.clear();
        arrayListAtributo.clear();
        
        //limpa os campos onde tem ComboBox
        jCBNomePericiaAlt.removeAllItems();
        jCBNomePericiaExc.removeAllItems();
        
        //limpa os campos de TextField
        jTFAtributoExc.setText(null);
        jTFNomePericiaExc.setText(null);
        jTADescricaoExc.setText(null);
        jTFPericiaAlt.setText(null);
        jTADescricaoAlt.setText(null);
        jTFAtributoPAlt.setText(null);
        
        List<Object> list = genericDAO.listar(Pericias.class);
        for (Object obj : list) {
            Pericias p = (Pericias) obj;
            arrayListPericia.add(p.getCodigo_pericia());
            arrayListDescricao.add(p.getDescricao_pericia());
            arrayListAtributo.add(p.getAtributo_principal_pericia());
            jCBNomePericiaAlt.addItem(p.getNome_pericia());
            jCBNomePericiaExc.addItem(p.getNome_pericia());
        }
    }
    
    
    //centraliza todas as telas
    public JFPericias() throws SQLException {
        this.gDAO = new GenericDAO();
        initComponents();
        centralizarcomponente();
    }
    
    public void centralizarcomponente(){
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dw = getSize();
        setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) /2);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLPericiaCad = new javax.swing.JLabel();
        jLDescricaoCad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jBSalvarCad = new javax.swing.JButton();
        jBCancelarCad = new javax.swing.JButton();
        jCBAtributo = new javax.swing.JComboBox();
        jLAtributoPrincipalCad = new javax.swing.JLabel();
        jTNomePericia = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jCBNomePericiaAlt = new javax.swing.JComboBox();
        jLSelecionarPericiaAlt = new javax.swing.JLabel();
        jLNovoNomePericiaAlt = new javax.swing.JLabel();
        jTFPericiaAlt = new javax.swing.JTextField();
        jLDescricaoPericiaAlt = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTADescricaoAlt = new javax.swing.JTextArea();
        jBSalvarAlt = new javax.swing.JButton();
        jBCancelarAlt = new javax.swing.JButton();
        jLNovoAtributoPericiaAlt = new javax.swing.JLabel();
        jCBAtributoAlt = new javax.swing.JComboBox();
        jTFAtributoPAlt = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jBExcluirExc = new javax.swing.JButton();
        jBCancelarExc = new javax.swing.JButton();
        jCBNomePericiaExc = new javax.swing.JComboBox();
        jTFNomePericiaExc = new javax.swing.JTextField();
        jTFAtributoExc = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTADescricaoExc = new javax.swing.JTextArea();
        jLSelecionePericiaExc = new javax.swing.JLabel();
        jLPerciaExc = new javax.swing.JLabel();
        jLAtributoPrincipalExc = new javax.swing.JLabel();
        jLDescricaoPericiaExc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLPericiaCad.setText("Perícia:");

        jLDescricaoCad.setText("Descrição:");

        jTADescricao.setColumns(20);
        jTADescricao.setRows(5);
        jScrollPane1.setViewportView(jTADescricao);

        jBSalvarCad.setText("Salvar");
        jBSalvarCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarCadActionPerformed(evt);
            }
        });

        jBCancelarCad.setText("Cancelar");
        jBCancelarCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarCadActionPerformed(evt);
            }
        });

        jCBAtributo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Força", "Destreza", "Constituição", "Inteligência", "Sabedoria", "Carisma" }));
        jCBAtributo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAtributoActionPerformed(evt);
            }
        });

        jLAtributoPrincipalCad.setText("Atributo Principal:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLPericiaCad)
                        .addGap(32, 32, 32)
                        .addComponent(jTNomePericia, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLAtributoPrincipalCad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCBAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLDescricaoCad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jBSalvarCad, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jBCancelarCad, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPericiaCad)
                    .addComponent(jTNomePericia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLDescricaoCad)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAtributoPrincipalCad)
                    .addComponent(jCBAtributo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvarCad)
                    .addComponent(jBCancelarCad))
                .addGap(54, 54, 54))
        );

        jTabbedPane1.addTab("Cadastrar", jPanel1);

        jCBNomePericiaAlt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBNomePericiaAltItemStateChanged(evt);
            }
        });

        jLSelecionarPericiaAlt.setText("Selecione a Perícia:");

        jLNovoNomePericiaAlt.setText("Novo nome da Perícia:");

        jTFPericiaAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFPericiaAltActionPerformed(evt);
            }
        });

        jLDescricaoPericiaAlt.setText("Descrição da Perícia: ");

        jTADescricaoAlt.setColumns(20);
        jTADescricaoAlt.setRows(5);
        jScrollPane2.setViewportView(jTADescricaoAlt);

        jBSalvarAlt.setText("Salvar Alterações");
        jBSalvarAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarAltActionPerformed(evt);
            }
        });

        jBCancelarAlt.setText("Cancelar");
        jBCancelarAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarAltActionPerformed(evt);
            }
        });

        jLNovoAtributoPericiaAlt.setText("Novo Atributo Principal:");

        jCBAtributoAlt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Força", "Destreza", "Constituição", "Inteligência", "Sabedoria", "Carisma" }));

        jTFAtributoPAlt.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jBSalvarAlt)
                        .addGap(61, 61, 61)
                        .addComponent(jBCancelarAlt))
                    .addComponent(jLDescricaoPericiaAlt)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLNovoAtributoPericiaAlt)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTFAtributoPAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCBAtributoAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLNovoNomePericiaAlt)
                                .addComponent(jLSelecionarPericiaAlt))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCBNomePericiaAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFPericiaAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSelecionarPericiaAlt)
                    .addComponent(jCBNomePericiaAlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNovoNomePericiaAlt)
                    .addComponent(jTFPericiaAlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNovoAtributoPericiaAlt)
                    .addComponent(jTFAtributoPAlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBAtributoAlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLDescricaoPericiaAlt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvarAlt)
                    .addComponent(jBCancelarAlt))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Alterar", jPanel2);

        jBExcluirExc.setText("Excluir");
        jBExcluirExc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirExcActionPerformed(evt);
            }
        });

        jBCancelarExc.setText("Cancelar");
        jBCancelarExc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarExcActionPerformed(evt);
            }
        });

        jCBNomePericiaExc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBNomePericiaExcItemStateChanged(evt);
            }
        });

        jTFNomePericiaExc.setEnabled(false);

        jTFAtributoExc.setEnabled(false);

        jTADescricaoExc.setColumns(20);
        jTADescricaoExc.setRows(5);
        jTADescricaoExc.setEnabled(false);
        jScrollPane3.setViewportView(jTADescricaoExc);

        jLSelecionePericiaExc.setText("Selecione a Perícia:");

        jLPerciaExc.setText("Perícia:");

        jLAtributoPrincipalExc.setText("Atributo Principal:");

        jLDescricaoPericiaExc.setText("Descrição Perícia:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLPerciaExc, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLSelecionePericiaExc, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLDescricaoPericiaExc)
                        .addComponent(jLAtributoPrincipalExc)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFNomePericiaExc, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBNomePericiaExc, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFAtributoExc, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jBExcluirExc, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jBCancelarExc))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSelecionePericiaExc)
                    .addComponent(jCBNomePericiaExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNomePericiaExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPerciaExc))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAtributoPrincipalExc)
                    .addComponent(jTFAtributoExc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jLDescricaoPericiaExc)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCancelarExc)
                    .addComponent(jBExcluirExc))
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("Excluir", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarCadActionPerformed
        //quando falta preencher algum campo aparece uma mensagem
        if (jTNomePericia.getText().equalsIgnoreCase("") || jTADescricao.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Necessário preencher todos os campos!");
        } else {
            try {
                GenericDAO gDao = new GenericDAO();
                //adiciona os campos de cadastrar
                Pericias p = new Pericias();
                p.setNome_pericia(jTNomePericia.getText());
                p.setDescricao_pericia(jTADescricao.getText());
                p.setAtributo_principal_pericia(String.valueOf(jCBAtributo.getSelectedItem()));
                gDAO.adicionar(p);
                
                // Após clicar no botão salvar, aparece tal mensagem
                JOptionPane.showMessageDialog(null, "Perícia salva com sucesso!"); 
                   
                //Limpando campos
                jTNomePericia.setText(null);
                jTADescricao.setText(null);
                CarregaComboPericias();
            } catch (SQLException | ClassNotFoundException | IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBSalvarCadActionPerformed

    private void jBCancelarCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarCadActionPerformed
     JFPericias.this.dispose(); //fecha apenas a tela, mas não o programa em geral
    }//GEN-LAST:event_jBCancelarCadActionPerformed

    private void jTFNomePericiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNomePericiaActionPerformed

    }//GEN-LAST:event_jTFNomePericiaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            CarregaComboPericias();
        } catch (SQLException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jCBAtributoPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAtributoPrincipalActionPerformed

    }//GEN-LAST:event_jCBAtributoPrincipalActionPerformed

    private void jCBAtributoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAtributoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBAtributoActionPerformed

    private void jBSalvarAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarAltActionPerformed
        try {
            int cod = 1;
            GenericDAO genericDAO = new GenericDAO();
            Pericias p = new Pericias();
            
            //aviso casoalgum campo da aba alterar não foir preenchido
            if (jTFPericiaAlt.getText().equals("") || jTADescricaoAlt.getText().equals("") || jTFAtributoPAlt.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, insira todas as informações!"); 
            } else {
                cod=(int) arrayListPericia.get(jCBNomePericiaAlt.getSelectedIndex());    
            
                p.setCodigo_pericia(cod);
                p.setNome_pericia(jTFPericiaAlt.getText());
                p.setDescricao_pericia(jTADescricaoAlt.getText());
                p.setAtributo_principal_pericia(jCBAtributoAlt.getItemAt(jCBAtributoAlt.getSelectedIndex()).toString());
                genericDAO.alterar(p);
                //todo procedimento de alterar
                CarregaComboPericias();
                JOptionPane.showMessageDialog(null, "Alterado com sucesso!"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBSalvarAltActionPerformed

    private void jBExcluirExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirExcActionPerformed
        try {
            GenericDAO genericDAO = new GenericDAO();
            Pericias pericia = new Pericias();
            PericiasPosicoes periciasPosicoes = new PericiasPosicoes();
            
            //exclui da tabela n para n (Perícias Posições)
            periciasPosicoes.setCodigo_pericia((int) arrayListPericia.get(jCBNomePericiaExc.getSelectedIndex()));
            genericDAO.excluir(periciasPosicoes);
            
            //exclui da tabela Perícia
            pericia.setCodigo_pericia((int) arrayListPericia.get(jCBNomePericiaExc.getSelectedIndex()));
            genericDAO.excluir(pericia);
            
            //mensagem avisando a exclusão bem sucedida
            JOptionPane.showMessageDialog(null, "Perícia excluída com sucesso!");
            CarregaComboPericias();
        } catch (SQLException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBExcluirExcActionPerformed

    private void jCBNomePericiaAltItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBNomePericiaAltItemStateChanged
        //faz a aba de alteração vir com os campos limpos
        if (!arrayListPericia.isEmpty()) {
            try {
                GenericDAO genericDAO = new GenericDAO();
                Pericias p = new Pericias();
                
                jTADescricaoAlt.setText(null);
                jTFPericiaAlt.setText(null);
                jTFAtributoPAlt.setText(null);
                
                jTFPericiaAlt.setText((String) jCBNomePericiaAlt.getItemAt(jCBNomePericiaAlt.getSelectedIndex()));
                jTADescricaoAlt.setText((String) arrayListDescricao.get(jCBNomePericiaAlt.getSelectedIndex()));
                jTFAtributoPAlt.setText(arrayListAtributo.get(jCBNomePericiaAlt.getSelectedIndex()).toString());
            } catch (SQLException ex) {
                Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jCBNomePericiaAltItemStateChanged

    private void jTFPericiaAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFPericiaAltActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFPericiaAltActionPerformed

    private void jCBNomePericiaExcItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBNomePericiaExcItemStateChanged
        //faz a aba de exclusão vir com os campos limpos
        if (!arrayListPericia.isEmpty()) {
            try {
                GenericDAO genericDAO = new GenericDAO();
                Pericias p = new Pericias();
                
                jTADescricaoExc.setText(null);
                jTFAtributoExc.setText(null);
                jTFNomePericiaExc.setText(null);
                
                jTFNomePericiaExc.setText((String) jCBNomePericiaExc.getItemAt(jCBNomePericiaExc.getSelectedIndex()));
                jTADescricaoExc.setText((String) arrayListDescricao.get(jCBNomePericiaExc.getSelectedIndex()));
                jTFAtributoExc.setText(arrayListAtributo.get(jCBNomePericiaExc.getSelectedIndex()).toString());
            } catch (SQLException ex) {
                Logger.getLogger(JFPericias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jCBNomePericiaExcItemStateChanged

    private void jBCancelarAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarAltActionPerformed
        JFPericias.this.dispose(); // fecha a tela mas não o programa em si
    }//GEN-LAST:event_jBCancelarAltActionPerformed

    private void jBCancelarExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarExcActionPerformed
        JFPericias.this.dispose(); // fecha a tela mas não o programa em si
    }//GEN-LAST:event_jBCancelarExcActionPerformed

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
    private javax.swing.JButton jBCancelarAlt;
    private javax.swing.JButton jBCancelarCad;
    private javax.swing.JButton jBCancelarExc;
    private javax.swing.JButton jBExcluirExc;
    private javax.swing.JButton jBSalvarAlt;
    private javax.swing.JButton jBSalvarCad;
    private javax.swing.JComboBox jCBAtributo;
    private javax.swing.JComboBox jCBAtributoAlt;
    private javax.swing.JComboBox jCBNomePericiaAlt;
    private javax.swing.JComboBox jCBNomePericiaExc;
    private javax.swing.JLabel jLAtributoPrincipalCad;
    private javax.swing.JLabel jLAtributoPrincipalExc;
    private javax.swing.JLabel jLDescricaoCad;
    private javax.swing.JLabel jLDescricaoPericiaAlt;
    private javax.swing.JLabel jLDescricaoPericiaExc;
    private javax.swing.JLabel jLNovoAtributoPericiaAlt;
    private javax.swing.JLabel jLNovoNomePericiaAlt;
    private javax.swing.JLabel jLPerciaExc;
    private javax.swing.JLabel jLPericiaCad;
    private javax.swing.JLabel jLSelecionarPericiaAlt;
    private javax.swing.JLabel jLSelecionePericiaExc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTADescricao;
    private javax.swing.JTextArea jTADescricaoAlt;
    private javax.swing.JTextArea jTADescricaoExc;
    private javax.swing.JTextField jTFAtributoExc;
    private javax.swing.JTextField jTFAtributoPAlt;
    private javax.swing.JTextField jTFNomePericiaExc;
    private javax.swing.JTextField jTFPericiaAlt;
    private javax.swing.JTextField jTNomePericia;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
