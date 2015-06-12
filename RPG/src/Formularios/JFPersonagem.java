/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import Tabelas.Raca;
import conexao.ConexaoBanco;
import dao.GenericDAO;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tabelas.Classes;
import tabelas.Personagens;

/**
 *
 * @author Adriel
 */
public class JFPersonagem extends javax.swing.JFrame {
    int forca;
    int destreza;
    int constituicao;
    int inteligencia;
    int sabedoria;
    int carisma;
    
    ArrayList listRaca = new ArrayList();
    ArrayList listClasse = new ArrayList();
    /**
     * Creates new form JFPersonagem
     */
    public JFPersonagem() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfNomePersonagem = new javax.swing.JTextField();
        jCClasse = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jtfIdadePersonagem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfPesoPersonagem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfAlturaPersonagem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtfForcaPersonagem = new javax.swing.JTextField();
        jtfDestrezaPersonagem = new javax.swing.JTextField();
        jtfConstituicaoPersonagem = new javax.swing.JTextField();
        jtfInteligenciaPersonagem = new javax.swing.JTextField();
        jtfSabedoriaPersonagem = new javax.swing.JTextField();
        jtfCarismaPersonagem = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfFortitudePersonagem = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtfRefexoPersonagem = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtfVontadePersonagem = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtfClasseArmaduraPersonagem = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtfPontosDeVidaPersonagem = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jtfIniciativaPersonagem = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jtfBaseDeAtaquePersonagem = new javax.swing.JTextField();
        jBSalvar = new javax.swing.JButton();
        jCRaca = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Nome");

        jLabel2.setText("Idade");

        jLabel3.setText("Peso");

        jtfPesoPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPesoPersonagemActionPerformed(evt);
            }
        });

        jLabel4.setText("Altura");

        jLabel5.setText("Força");

        jLabel6.setText("Destreza");

        jLabel7.setText("Constituição");

        jLabel8.setText("Inteligência");

        jLabel9.setText("Sabedoria");

        jLabel10.setText("Carisma");

        jtfDestrezaPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDestrezaPersonagemActionPerformed(evt);
            }
        });

        jtfConstituicaoPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfConstituicaoPersonagemActionPerformed(evt);
            }
        });

        jtfInteligenciaPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfInteligenciaPersonagemActionPerformed(evt);
            }
        });

        jLabel11.setText("Fortitude");

        jLabel13.setText("Refexos");

        jLabel14.setText("Vontade");

        jLabel15.setText("Cls.Armadura (CA)");

        jtfClasseArmaduraPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfClasseArmaduraPersonagemActionPerformed(evt);
            }
        });

        jLabel16.setText("Pontos de Vida");

        jLabel17.setText("Iniciativa");

        jLabel18.setText("Base de Ataque");

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jLabel19.setText("Classe");

        jLabel20.setText("Raça");

        jButton1.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfIdadePersonagem)
                            .addComponent(jtfNomePersonagem)
                            .addComponent(jCRaca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)))
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfPesoPersonagem)
                            .addComponent(jtfInteligenciaPersonagem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfConstituicaoPersonagem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfForcaPersonagem, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(jtfAlturaPersonagem)
                            .addComponent(jtfDestrezaPersonagem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfSabedoriaPersonagem)
                            .addComponent(jtfFortitudePersonagem))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jtfClasseArmaduraPersonagem))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(222, 222, 222))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel19)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCClasse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfIniciativaPersonagem)
                                    .addComponent(jtfVontadePersonagem)
                                    .addComponent(jtfRefexoPersonagem, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfCarismaPersonagem, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jBSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtfPontosDeVidaPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(jtfBaseDeAtaquePersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfVontadePersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfRefexoPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCarismaPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jCRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jCClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfNomePersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jtfClasseArmaduraPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfIdadePersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfBaseDeAtaquePersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfPesoPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jtfPontosDeVidaPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfIniciativaPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jtfAlturaPersonagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfForcaPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfDestrezaPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfConstituicaoPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfInteligenciaPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSabedoriaPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jtfFortitudePersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfPesoPersonagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesoPersonagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPesoPersonagemActionPerformed

    private void jtfDestrezaPersonagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDestrezaPersonagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDestrezaPersonagemActionPerformed

    private void jtfConstituicaoPersonagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfConstituicaoPersonagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfConstituicaoPersonagemActionPerformed

    private void jtfInteligenciaPersonagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfInteligenciaPersonagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfInteligenciaPersonagemActionPerformed

    private void jtfClasseArmaduraPersonagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfClasseArmaduraPersonagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfClasseArmaduraPersonagemActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        try {
            GenericDAO aDao = new GenericDAO();
            
            Personagens pers = new Personagens();
            Raca rc = new Raca ();
            
            
            
            List<Object> list = aDao.listar2(Raca.class, rc);
            for (Object obj3 : list) {

                Raca r = (Raca) obj3;
                            
                forca = (r.getForca_raca());
                //System.out.println("forca raca : "+ forca);
                destreza = (r.getDestreza_raca());
                constituicao = (r.getConstituicao_raca());
                inteligencia = (r.getInteligencia_raca());
                sabedoria = (r.getSabedoria_raca());
                carisma = (r.getCarisma_raca());
            }
                
               
                
                //System.out.println("forca personagem " + forcaPersonagem);
                //totalForca = (forca+forcaPersonagem);
                //System.out.println("total: " + (forca + (Integer.parseInt(jtfForcaPersonagem.getText()))));
                
                
            pers.setNome_personagem("");
            pers.setIdade_personagem(0);
            pers.setPeso_personagem(0);
            pers.setAltura_personagem(0);
            pers.setForca_personagem(0);
            pers.setForca_personagem(0);
            pers.setDestreza_personagem(0);
            pers.setContituicao_personagem(0);
            pers.setInteligencia_personagem(0);
            pers.setSabedoria_personagem(0);
            pers.setCarisma_personagem(0);
            pers.setFortitude_personagem(0);
            pers.setReflexos_personagem(0);
            pers.setVontade_personagem(0);
            pers.setClasse_armadura_personagem(0);
            pers.setPontos_vida_personagem(0);
            pers.setIniciativa_personagem(0);
            pers.setBase_ataque_personagem(0);

            pers.setNome_personagem(jtfNomePersonagem.getText());
            pers.setIdade_personagem(Integer.parseInt(jtfIdadePersonagem.getText()));
            pers.setPeso_personagem(Integer.parseInt(jtfPesoPersonagem.getText()));
            pers.setAltura_personagem(Integer.parseInt(jtfAlturaPersonagem.getText()));
            pers.setForca_personagem(forca + (Integer.parseInt(jtfForcaPersonagem.getText())));
            pers.setDestreza_personagem(destreza + (Integer.parseInt(jtfDestrezaPersonagem.getText())));
            pers.setContituicao_personagem(constituicao + (Integer.parseInt(jtfConstituicaoPersonagem.getText())));
            pers.setInteligencia_personagem(inteligencia + (Integer.parseInt(jtfInteligenciaPersonagem.getText())));
            pers.setSabedoria_personagem(sabedoria + (Integer.parseInt(jtfSabedoriaPersonagem.getText())));
            pers.setCarisma_personagem(carisma + (Integer.parseInt(jtfCarismaPersonagem.getText())));
            pers.setFortitude_personagem(Integer.parseInt(jtfFortitudePersonagem.getText()));
            pers.setReflexos_personagem(Integer.parseInt(jtfRefexoPersonagem.getText()));
            pers.setVontade_personagem(Integer.parseInt(jtfVontadePersonagem.getText()));
            pers.setClasse_armadura_personagem(Integer.parseInt(jtfClasseArmaduraPersonagem.getText()));
            pers.setPontos_vida_personagem(Integer.parseInt(jtfPontosDeVidaPersonagem.getText()));
            pers.setIniciativa_personagem(Integer.parseInt(jtfIniciativaPersonagem.getText()));
            pers.setBase_ataque_personagem(Integer.parseInt(jtfBaseDeAtaquePersonagem.getText()));
            pers.setCodigo_raca((int) listRaca.get(jCRaca.getSelectedIndex()));
            pers.setCodigo_raca((int) listClasse.get(jCClasse.getSelectedIndex()));
            aDao.adicionar(pers);

        } catch (SQLException ex) {
            Logger.getLogger(JFPersonagem.class.getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JFPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JFPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(JFPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JFPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JFPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        GenericDAO aDao;
        try {
            aDao = new GenericDAO();

            List<Object> list = aDao.listar(Classes.class);//lista classe

            for (Object obj2 : list) {

                Classes cl = (Classes) obj2;
                            
                String Classe = "";
                Classe = cl.getNome_classe();
                jCClasse.addItem(Classe);
                listClasse.add(cl.getCodigo_classe());
                

            }

              
        
             List<Object> list2 = aDao.listar(Raca.class);
        
             for (Object obj2 : list2) {
            
             Raca rc = (Raca) obj2;
             String Raca = "";
             Raca = rc.getNome_raca();
             listRaca.add(rc.getCodigo_raca());
             jCRaca.addItem(Raca);
             }
             
        } catch (SQLException ex) {
            Logger.getLogger(JFPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JFPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(JFPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JFPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JFPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JFPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPersonagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(JFPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPersonagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPersonagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jCClasse;
    private javax.swing.JComboBox jCRaca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jtfAlturaPersonagem;
    private javax.swing.JTextField jtfBaseDeAtaquePersonagem;
    private javax.swing.JTextField jtfCarismaPersonagem;
    private javax.swing.JTextField jtfClasseArmaduraPersonagem;
    private javax.swing.JTextField jtfConstituicaoPersonagem;
    private javax.swing.JTextField jtfDestrezaPersonagem;
    private javax.swing.JTextField jtfForcaPersonagem;
    private javax.swing.JTextField jtfFortitudePersonagem;
    private javax.swing.JTextField jtfIdadePersonagem;
    private javax.swing.JTextField jtfIniciativaPersonagem;
    private javax.swing.JTextField jtfInteligenciaPersonagem;
    private javax.swing.JTextField jtfNomePersonagem;
    private javax.swing.JTextField jtfPesoPersonagem;
    private javax.swing.JTextField jtfPontosDeVidaPersonagem;
    private javax.swing.JTextField jtfRefexoPersonagem;
    private javax.swing.JTextField jtfSabedoriaPersonagem;
    private javax.swing.JTextField jtfVontadePersonagem;
    // End of variables declaration//GEN-END:variables
}
