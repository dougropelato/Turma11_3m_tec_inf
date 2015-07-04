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
import javax.swing.JOptionPane;
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nome");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));
        getContentPane().add(jtfNomePersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 49, 120, -1));

        getContentPane().add(jCClasse, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 11, 120, -1));

        jLabel2.setText("Idade");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 78, -1, -1));

        jtfIdadePersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfIdadePersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfIdadePersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 75, 120, -1));

        jLabel3.setText("Peso");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 104, -1, -1));

        jtfPesoPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPesoPersonagemActionPerformed(evt);
            }
        });
        jtfPesoPersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPesoPersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfPesoPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 101, 120, -1));

        jLabel4.setText("Altura");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 135, -1, -1));

        jtfAlturaPersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAlturaPersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfAlturaPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 129, 120, -1));

        jLabel5.setText("Força");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 158, -1, -1));

        jLabel6.setText("Destreza");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 184, -1, -1));

        jLabel7.setText("Constituição");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 70, -1));

        jLabel8.setText("Inteligência");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 236, -1, -1));

        jLabel9.setText("Sabedoria");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 262, -1, -1));

        jLabel10.setText("Carisma");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 213, -1, -1));

        jtfForcaPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfForcaPersonagemActionPerformed(evt);
            }
        });
        jtfForcaPersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfForcaPersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfForcaPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 155, 120, -1));

        jtfDestrezaPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDestrezaPersonagemActionPerformed(evt);
            }
        });
        jtfDestrezaPersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfDestrezaPersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfDestrezaPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 181, 120, -1));

        jtfConstituicaoPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfConstituicaoPersonagemActionPerformed(evt);
            }
        });
        jtfConstituicaoPersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfConstituicaoPersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfConstituicaoPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 207, 120, -1));

        jtfInteligenciaPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfInteligenciaPersonagemActionPerformed(evt);
            }
        });
        jtfInteligenciaPersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfInteligenciaPersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfInteligenciaPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 233, 120, -1));

        jtfSabedoriaPersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfSabedoriaPersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfSabedoriaPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 259, 120, -1));

        jtfCarismaPersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCarismaPersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfCarismaPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 210, 120, -1));

        jLabel11.setText("Fortitude");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 285, -1, -1));

        jtfFortitudePersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfFortitudePersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfFortitudePersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 285, 120, -1));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 16, -1, -1));

        jLabel13.setText("Refexos");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 187, -1, -1));

        jtfRefexoPersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfRefexoPersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfRefexoPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 184, 120, -1));

        jLabel14.setText("Vontade");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 161, -1, -1));

        jtfVontadePersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfVontadePersonagemActionPerformed(evt);
            }
        });
        jtfVontadePersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfVontadePersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfVontadePersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 158, 120, -1));

        jLabel15.setText("Cls.Armadura (CA)");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 52, -1, -1));

        jtfClasseArmaduraPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfClasseArmaduraPersonagemActionPerformed(evt);
            }
        });
        jtfClasseArmaduraPersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfClasseArmaduraPersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfClasseArmaduraPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 49, 120, -1));

        jLabel16.setText("Pontos de Vida");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 109, -1, -1));

        jtfPontosDeVidaPersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPontosDeVidaPersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfPontosDeVidaPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 106, 120, -1));

        jLabel17.setText("Iniciativa");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 135, -1, -1));

        jtfIniciativaPersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfIniciativaPersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfIniciativaPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 132, 120, -1));

        jLabel18.setText("Base de Ataque");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 78, -1, -1));

        jtfBaseDeAtaquePersonagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfBaseDeAtaquePersonagemKeyTyped(evt);
            }
        });
        getContentPane().add(jtfBaseDeAtaquePersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 75, 120, -1));

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jBSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 260, 120, -1));

        getContentPane().add(jCRaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 11, 130, -1));

        jLabel19.setText("Classe");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 14, -1, -1));

        jLabel20.setText("Raça");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 14, -1, -1));

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 289, 120, -1));

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

            if (jtfAlturaPersonagem.getText().equals("")    ||      jtfBaseDeAtaquePersonagem.getText().equals("")    ||   jtfCarismaPersonagem.getText().equals("")||jtfClasseArmaduraPersonagem.getText().equals("")||jtfConstituicaoPersonagem.getText().equals("")||jtfDestrezaPersonagem.getText().equals("")||jtfForcaPersonagem.getText().equals("") || jtfFortitudePersonagem.getText().equals("") || jtfIdadePersonagem.getText().equals("") || jtfIniciativaPersonagem.getText().equals("") || jtfInteligenciaPersonagem.getText().equals("") || jtfNomePersonagem.getText().equals("") || jtfPesoPersonagem.getText().equals("") || jtfPontosDeVidaPersonagem.getText().equals("") || jtfRefexoPersonagem.getText().equals(""
                    + "") || jtfSabedoriaPersonagem.getText().equals("")|| jtfVontadePersonagem.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Favor Preencher todos os campos!");

            } else {
                GenericDAO aDao = new GenericDAO();

                Personagens pers = new Personagens();
                Raca rc = new Raca();

                rc.setCodigo_raca((int) listRaca.get(jCRaca.getSelectedIndex()));
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
                pers.setCodigo_classe((int) listClasse.get(jCClasse.getSelectedIndex()));

                aDao.adicionar(pers);

            }
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

            List<Object> list = aDao.listar(Classes.class);// listar generico

            for (Object obj2 : list) {

                Classes cl = (Classes) obj2;

                String Classe = "";
                Classe = cl.getNome_classe();
                jCClasse.addItem(Classe);// adiciona nome da classe no comboBox
                listClasse.add(cl.getCodigo_classe());//adiciona o codigo da classe no array classe

            }

            List<Object> list2 = aDao.listar(Raca.class);

            for (Object obj2 : list2) {

                Raca rc = (Raca) obj2;
                String Raca = "";
                Raca = rc.getNome_raca();
                listRaca.add(rc.getCodigo_raca());// adiciona o nome da raca no comboBox
                jCRaca.addItem(Raca);//adiciona o codigo da raca no array raca
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

    private void jtfVontadePersonagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfVontadePersonagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfVontadePersonagemActionPerformed

    private void jtfForcaPersonagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfForcaPersonagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfForcaPersonagemActionPerformed

    private void jtfForcaPersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfForcaPersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfForcaPersonagemKeyTyped

    private void jtfIdadePersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIdadePersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIdadePersonagemKeyTyped

    private void jtfPesoPersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesoPersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPesoPersonagemKeyTyped

    private void jtfAlturaPersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfAlturaPersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAlturaPersonagemKeyTyped

    private void jtfDestrezaPersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDestrezaPersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDestrezaPersonagemKeyTyped

    private void jtfConstituicaoPersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfConstituicaoPersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfConstituicaoPersonagemKeyTyped

    private void jtfInteligenciaPersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfInteligenciaPersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfInteligenciaPersonagemKeyTyped

    private void jtfSabedoriaPersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSabedoriaPersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfSabedoriaPersonagemKeyTyped

    private void jtfFortitudePersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfFortitudePersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfFortitudePersonagemKeyTyped

    private void jtfClasseArmaduraPersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfClasseArmaduraPersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfClasseArmaduraPersonagemKeyTyped

    private void jtfBaseDeAtaquePersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBaseDeAtaquePersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBaseDeAtaquePersonagemKeyTyped

    private void jtfPontosDeVidaPersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPontosDeVidaPersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPontosDeVidaPersonagemKeyTyped

    private void jtfIniciativaPersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIniciativaPersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIniciativaPersonagemKeyTyped

    private void jtfVontadePersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfVontadePersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfVontadePersonagemKeyTyped

    private void jtfRefexoPersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfRefexoPersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfRefexoPersonagemKeyTyped

    private void jtfCarismaPersonagemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCarismaPersonagemKeyTyped
 String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();}        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCarismaPersonagemKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jtfNomePersonagem.setText(null);
        jtfAlturaPersonagem.setText(null);
        jtfBaseDeAtaquePersonagem.setText(null);
        jtfCarismaPersonagem.setText(null);
        jtfClasseArmaduraPersonagem.setText(null);
        jtfConstituicaoPersonagem.setText(null);
        jtfDestrezaPersonagem.setText(null);
        jtfForcaPersonagem.setText(null);
        jtfFortitudePersonagem.setText(null);
        jtfIdadePersonagem.setText(null);
        jtfIniciativaPersonagem.setText(null);
        jtfInteligenciaPersonagem.setText(null);
        jtfPesoPersonagem.setText(null);
        jtfPontosDeVidaPersonagem.setText(null);
        jtfRefexoPersonagem.setText(null);
        jtfSabedoriaPersonagem.setText(null);
        jtfVontadePersonagem.setText(null);
        JFPersonagem.this.dispose();

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
