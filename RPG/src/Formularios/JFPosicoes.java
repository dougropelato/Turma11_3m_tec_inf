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
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import static java.rmi.Naming.list;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.net.www.content.text.Generic;
import tabelas.Caminhos;
import tabelas.Campanhas;
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

    public void LimpaCamposPosicoes() {
        jtaDescricaoCaminho.setText("");
        jtaDescricaoPericia.setText("");
        jtfValorX.setText("");
        jtfValorY.setText("");
    }

    /**
     * Creates new form JFPosicoes
     */
    public JFPosicoes() {
        initComponents();
        centralizarComponente();

        jtaDescricaoCaminho.setLineWrap(true);//Adiciona quebra de linha no Campo 'Descrição Perícia'
        jcbNpc.setVisible(false); //Seta o JComboBox NPC como Invisível
        jcbPericias.setVisible(false); //Seta o JComboBox Perícia como Invisível
        jlSelecNpc.setVisible(false);
        jlSelectPericia.setVisible(false);

        jcbPericias.setVisible(false);
        jlSelectPericia.setVisible(false);

        jcbValorPericia.setVisible(false);
        jlTituloDificuldadePericia.setVisible(false);

        jtaDescricaoPericia.setVisible(false);

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
        jlSelectPericia = new javax.swing.JLabel();
        jlTituloDificuldadePericia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescricaoPericia = new javax.swing.JTextArea();
        jcheckNpc = new javax.swing.JCheckBox();
        jcheckPericia = new javax.swing.JCheckBox();
        jcbValorPericia = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jlY = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlX = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jcbCaminho.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCaminhoItemStateChanged(evt);
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

        jtfValorX.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfValorXKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfValorXKeyTyped(evt);
            }
        });

        jlValorX.setText("Insira Valor da Posição X:");

        jlValorY.setText("Insira Valor da Posição Y:");

        jtfValorY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfValorYKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfValorYKeyTyped(evt);
            }
        });

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
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jtaDescricaoCaminho.setColumns(20);
        jtaDescricaoCaminho.setRows(5);
        jScrollPane2.setViewportView(jtaDescricaoCaminho);

        jlSelectPericia.setText("Selecionar Perícia");

        jlTituloDificuldadePericia.setText("Dificuldade Perícia (Valor)");

        jtaDescricaoPericia.setColumns(20);
        jtaDescricaoPericia.setRows(5);
        jScrollPane1.setViewportView(jtaDescricaoPericia);

        jcheckNpc.setText("NPC");
        jcheckNpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcheckNpcActionPerformed(evt);
            }
        });

        jcheckPericia.setText("Perícia");
        jcheckPericia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcheckPericiaActionPerformed(evt);
            }
        });

        jcbValorPericia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fácil (5)", "Médio (10)", "Difícil (15)", "Desafiador (20)", "Formidável (25)", "Heróico (30)", "Impossível (40)" }));

        jLabel3.setText("Opcional:");

        jlY.setText("Y");

        jLabel7.setText("x");

        jlX.setText("X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 101, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlValorY)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfValorY))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlValorX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfValorX, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlTamMapa)
                        .addGap(10, 10, 10)
                        .addComponent(jlX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlY, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlTituloDificuldadePericia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbValorPericia, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jcheckNpc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlSelecNpc, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jcheckPericia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jlSelectPericia)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbPericias, 0, 180, Short.MAX_VALUE)
                                    .addComponent(jcbNpc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTamMapa)
                    .addComponent(jlY, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jlX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfValorX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlValorX))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlValorY)
                            .addComponent(jtfValorY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbNpc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlSelecNpc)
                            .addComponent(jcheckNpc))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbPericias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlSelectPericia)
                            .addComponent(jcheckPericia))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlTituloDificuldadePericia)
                            .addComponent(jcbValorPericia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbNpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNpcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbNpcActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            if (jtaDescricaoCaminho.getText().equals("") || jtfValorY.getText().equals("") || jtfValorX.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos!");
            } else {
                if (jcheckNpc.isSelected() && (jcheckPericia.isSelected()) && jtaDescricaoPericia.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha Todos os Campos!");
                } else {
                    if (jcheckNpc.isSelected() && (jcheckPericia.isSelected()) && !jtaDescricaoPericia.getText().equals("")) {
                        GenericDAO gDAO = new GenericDAO();
                        Posicoes posicoes = new Posicoes();
                        PosicoesNpcs posicaoNpc = new PosicoesNpcs();
                        Npcs npc = new Npcs();
                        Pericias pericias = new Pericias();
                        PericiasPosicoes periciaPosicao = new PericiasPosicoes();

                        //Insertes tabela 'Posicoes'
                        posicoes.setCodigo_caminho((int) (arrayListCaminhos.get(jcbCaminho.getSelectedIndex())));
                        posicoes.setDescricao_posicao(jtaDescricaoCaminho.getText());
                        posicoes.setCoordenadaX_posicao(Integer.parseInt(jtfValorX.getText()));
                        posicoes.setCoordenadaY_posicao(Integer.parseInt(jtfValorY.getText()));
                        gDAO.adicionar(posicoes); //cadastrando posicao
                        posicoes.setCodigo_posicao(gDAO.codigoMax(Posicoes.class));//Pega o código da última posição cadastrada
                        System.out.println("Posição Cadastrada com Sucesso!");//
                        ////////////////////////////////////////////////////
                        //Inserts Tabela N/N 'PosicoesNpcs'
                        npc.setNome_npc(jcbNpc.getSelectedItem().toString());
                        List<Object> list = gDAO.listar2(Npcs.class, npc);

                        for (Object obj4 : list) {
                            Npcs npcc = (Npcs) obj4;
                            posicaoNpc.setCodigo_npc(npcc.getCodigo_npc());
                        }
                        posicaoNpc.setCodigo_posicao(posicoes.getCodigo_posicao());
                        System.out.println(posicoes.getCodigo_posicao());
                        gDAO.adicionar(posicaoNpc);//Cadastrando npc
                        System.out.println("NPC Cadastrado com Sucesso!");
                        /////////////////////////////////////////////////////////////
                        //Inserts Tabela N/N 'PericiasPosicoes'
                        int varDificuldadePericia = (0);

                        if (jcbValorPericia.getSelectedIndex() == 0) { //Fácil
                            varDificuldadePericia = 5;
                        }
                        if (jcbValorPericia.getSelectedIndex() == 1) { //Médio
                            varDificuldadePericia = 10;
                        }
                        if (jcbValorPericia.getSelectedIndex() == 2) { //Difícil
                            varDificuldadePericia = 15;
                        }
                        if (jcbValorPericia.getSelectedIndex() == 3) { //Formidável
                            varDificuldadePericia = 20;
                        }
                        if (jcbValorPericia.getSelectedIndex() == 4) { //Desafiador
                            varDificuldadePericia = 25;
                        }
                        if (jcbValorPericia.getSelectedIndex() == 5) { //Heróico
                            varDificuldadePericia = 30;
                        }
                        if (jcbValorPericia.getSelectedIndex() == 6) { //Impossível
                            varDificuldadePericia = 40;
                        }

                        pericias.setNome_pericia(jcbPericias.getSelectedItem().toString());
                        List<Object> list2 = gDAO.listar2(Pericias.class, pericias);
                        //System.out.println("Estou aqui deeerrreeentroooo!!!");

                        for (Object obj5 : list2) {
                            Pericias peric = (Pericias) obj5;
                            periciaPosicao.setCodigo_pericia(peric.getCodigo_pericia());
                        }
                        periciaPosicao.setCodigo_posicao(posicoes.getCodigo_posicao());
                        periciaPosicao.setDificuldade_pericia(varDificuldadePericia);
                        periciaPosicao.setDescricao_pericia_sucesso(jtaDescricaoPericia.getText());
                        System.out.println(posicoes.getCodigo_posicao());

                        gDAO.adicionar(periciaPosicao);
                        System.out.println("Pericia Cadastrados com Sucesso! " + varDificuldadePericia + "");
                        LimpaCamposPosicoes();//Limpa Posicoes
                        JOptionPane.showMessageDialog(null, "Posição, NPC e Perícia Cadastrados com Sucesso!");

                    } else {

                        if (jcheckNpc.isSelected()) {

                            GenericDAO gDAO = new GenericDAO();
                            Posicoes posicoes = new Posicoes();
                            PosicoesNpcs posicaoNpc = new PosicoesNpcs();
                            Npcs npc = new Npcs();

                            //Insertes tabela 'Posicoes'
                            posicoes.setCodigo_caminho((int) (arrayListCaminhos.get(jcbCaminho.getSelectedIndex())));
                            posicoes.setDescricao_posicao(jtaDescricaoCaminho.getText());
                            posicoes.setCoordenadaX_posicao(Integer.parseInt(jtfValorX.getText()));
                            posicoes.setCoordenadaY_posicao(Integer.parseInt(jtfValorY.getText()));
                            gDAO.adicionar(posicoes); //cadastrando posicao
                            posicoes.setCodigo_posicao(gDAO.codigoMax(Posicoes.class));//Pega o código da última posição cadastrada
                            System.out.println("Posição Cadastrada com Sucesso!");//
                            ////////////////////////////////////////////////////
                            //Inserts Tabela 'PosicoesNpcs'
                            npc.setNome_npc(jcbNpc.getSelectedItem().toString());
                            List<Object> list = gDAO.listar2(Npcs.class, npc);

                            for (Object obj4 : list) {
                                Npcs npcc = (Npcs) obj4;
                                posicaoNpc.setCodigo_npc(npcc.getCodigo_npc());
                            }
                            posicaoNpc.setCodigo_posicao(posicoes.getCodigo_posicao());
                            System.out.println(posicoes.getCodigo_posicao());
                            gDAO.adicionar(posicaoNpc);//Cadastrando npc
                            System.out.println("NPC Cadastrado com Sucesso!");
                            LimpaCamposPosicoes();//Limpa Posicoes
                            JOptionPane.showMessageDialog(null, "Posição e NPC Cadastrados com Sucesso!");
                        } else {
                            if (jcheckPericia.isSelected()) {
                                if (jtaDescricaoPericia.getText().equals("")) {
                                    JOptionPane.showMessageDialog(null, "Preencha Todos os Campos!");
                                } else {
                                    GenericDAO gDAO = new GenericDAO();
                                    Posicoes posicoes = new Posicoes();
                                    Pericias pericias = new Pericias();
                                    PericiasPosicoes periciaPosicao = new PericiasPosicoes();

                                    //Insertes tabela 'Posicoes'
                                    posicoes.setCodigo_caminho((int) (arrayListCaminhos.get(jcbCaminho.getSelectedIndex())));
                                    posicoes.setDescricao_posicao(jtaDescricaoCaminho.getText());
                                    posicoes.setCoordenadaX_posicao(Integer.parseInt(jtfValorX.getText()));
                                    posicoes.setCoordenadaY_posicao(Integer.parseInt(jtfValorY.getText()));
                                    gDAO.adicionar(posicoes); //cadastrando posicao
                                    posicoes.setCodigo_posicao(gDAO.codigoMax(Posicoes.class));//Pega o código da última posição cadastrada
                                    System.out.println("Posição Cadastrada com Sucesso!");//
                                    ////////////////////////////////////////////////////

                                    int varDificuldadePericia = (0);

                                    if (jcbValorPericia.getSelectedIndex() == 0) { //Fácil
                                        varDificuldadePericia = 5;
                                    }
                                    if (jcbValorPericia.getSelectedIndex() == 1) { //Médio
                                        varDificuldadePericia = 10;
                                    }
                                    if (jcbValorPericia.getSelectedIndex() == 2) { //Difícil
                                        varDificuldadePericia = 15;
                                    }
                                    if (jcbValorPericia.getSelectedIndex() == 3) { //Formidável
                                        varDificuldadePericia = 20;
                                    }
                                    if (jcbValorPericia.getSelectedIndex() == 4) { //Desafiador
                                        varDificuldadePericia = 25;
                                    }
                                    if (jcbValorPericia.getSelectedIndex() == 5) { //Heróico
                                        varDificuldadePericia = 30;
                                    }
                                    if (jcbValorPericia.getSelectedIndex() == 6) { //Impossível
                                        varDificuldadePericia = 40;
                                    }
                                    //Inserts Tabela N/N 'PericiasPosicoes'
                                    pericias.setNome_pericia(jcbPericias.getSelectedItem().toString());
                                    List<Object> list2 = gDAO.listar2(Pericias.class, pericias);
                                    //System.out.println("Estou aqui deeerrreeentroooo!!!");

                                    for (Object obj5 : list2) {
                                        Pericias peric = (Pericias) obj5;
                                        periciaPosicao.setCodigo_pericia(peric.getCodigo_pericia());
                                    }
                                    periciaPosicao.setCodigo_posicao(posicoes.getCodigo_posicao());
                                    periciaPosicao.setDificuldade_pericia(varDificuldadePericia);
                                    periciaPosicao.setDescricao_pericia_sucesso(jtaDescricaoPericia.getText());
                                    System.out.println(posicoes.getCodigo_posicao());

                                    gDAO.adicionar(periciaPosicao);
                                    System.out.println("Pericia Cadastrados com Sucesso! " + varDificuldadePericia + "");
                                    LimpaCamposPosicoes();//Limpa Posicoes
                                    JOptionPane.showMessageDialog(null, "Posição e Perícia Cadastrados com Sucesso!");

                                }
                            } else {
                                //Cadastra Posições Vazias (Sem NPC e Sem Perícia)
                                GenericDAO gDAO = new GenericDAO();
                                Posicoes posicoes = new Posicoes();

                                //Insertes tabela 'Posicoes'
                                posicoes.setCodigo_caminho((int) (arrayListCaminhos.get(jcbCaminho.getSelectedIndex())));
                                posicoes.setDescricao_posicao(jtaDescricaoCaminho.getText());
                                posicoes.setCoordenadaX_posicao(Integer.parseInt(jtfValorX.getText()));
                                posicoes.setCoordenadaY_posicao(Integer.parseInt(jtfValorY.getText()));
                                gDAO.adicionar(posicoes); //cadastrando posicao
                                posicoes.setCodigo_posicao(gDAO.codigoMax(Posicoes.class));//Pega o código da última posição cadastrada
                                System.out.println("Posição Cadastrada com Sucesso!");//
                                ////////////////////////////////////////////////////

                                LimpaCamposPosicoes();//Limpa Posicoes

                                JOptionPane.showMessageDialog(null, "Posição Cadastrada com Sucesso!");

                            }

                        }//

                        ///
                    }
                }
            }
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
            Logger.getLogger(JFPosicoes.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JFPosicoes.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(JFPosicoes.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JFPosicoes.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JFPosicoes.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JFPosicoes.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPosicoes.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jcbCaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCaminhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCaminhoActionPerformed

    private void jcheckNpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcheckNpcActionPerformed
        if (jcheckNpc.isSelected()) {
            jcbNpc.setVisible(true);
            jlSelecNpc.setVisible(true);
        } else {
            jcbNpc.setVisible(false);
            jlSelecNpc.setVisible(false);
        }
    }//GEN-LAST:event_jcheckNpcActionPerformed

    private void jcheckPericiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcheckPericiaActionPerformed
        if (jcheckPericia.isSelected()) {
            jcbPericias.setVisible(true);
            jlSelectPericia.setVisible(true);

            jcbValorPericia.setVisible(true);
            jlTituloDificuldadePericia.setVisible(true);

            jtaDescricaoPericia.setVisible(true);

        } else {
            jcbPericias.setVisible(false);
            jlSelectPericia.setVisible(false);

            jcbValorPericia.setVisible(false);
            jlTituloDificuldadePericia.setVisible(false);

            jtaDescricaoPericia.setVisible(false);
        }

    }//GEN-LAST:event_jcheckPericiaActionPerformed

    private void jtfValorXKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorXKeyTyped
        String caracteres = "0987654321 "; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();
            JOptionPane.showMessageDialog(null, "Apenas Números");
            jtfValorX.setText("");

        }
        /*else {
         int label_X = Integer.parseInt(jlX.getText());
         int campo_x = Integer.parseInt(jtfValorX.getText());

         if (label_X < campo_x) {

         JOptionPane.showMessageDialog(null, "Valor Informado Excede o Tamanho do Mapa!, Insira um Valor Menor");
             
         }}*/


    }//GEN-LAST:event_jtfValorXKeyTyped

    private void jtfValorYKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorYKeyTyped
        String caracteres = "0987654321"; //apenas numeros podem ser digitados
        if (!caracteres.contains(evt.getKeyChar() + "")) { //se algo diferente que "caracteres" for digitado
            evt.consume();
            JOptionPane.showMessageDialog(null, "Apenas Números");
            jtfValorY.setText("");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jtfValorYKeyTyped

    private void jcbCaminhoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCaminhoItemStateChanged
        // TODO add your handling code here:

        int recebe_cod_campanha = 0;
        recebe_cod_campanha = (int) arrayListCampanhas.get(jcbCaminho.getSelectedIndex());

        try {
            Campanhas cmp = new Campanhas();
            GenericDAO gDAO = new GenericDAO();

            cmp.setCodigo_campanha(recebe_cod_campanha);

            List<Object> list = gDAO.listar2(Campanhas.class, cmp);

            for (Object obj5 : list) {
                Campanhas camp = (Campanhas) obj5;
                //camp.getTam_x_campanha();
                //camp.getTam_y_campanha();
                jlX.setText(String.valueOf(camp.getTam_x_campanha()));
                System.out.println(camp.getTam_x_campanha());
                jlY.setText(String.valueOf(camp.getTam_y_campanha()));

            }
            jtfValorX.setText("");
            jtfValorY.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(JFPosicoes.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JFPosicoes.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(JFPosicoes.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(JFPosicoes.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(JFPosicoes.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JFPosicoes.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JFPosicoes.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        List<Object> list;


    }//GEN-LAST:event_jcbCaminhoItemStateChanged

    private void jtfValorXKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorXKeyReleased
        int label_X = Integer.parseInt(jlX.getText());
        int campo_x = Integer.parseInt(jtfValorX.getText());

        if (label_X < campo_x) {

            JOptionPane.showMessageDialog(null, "Valor de X Informado Excede o Tamanho do Mapa!, Insira um Valor Menor");
            jtfValorX.setText("");
        }       // TODO add your handling code here:
    }//GEN-LAST:event_jtfValorXKeyReleased

    private void jtfValorYKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfValorYKeyReleased
        int label_y = Integer.parseInt(jlY.getText());
        int campo_y = Integer.parseInt(jtfValorY.getText());

        if (label_y < campo_y) {

            JOptionPane.showMessageDialog(null, "Valor de Y Informado Excede o Tamanho do Mapa!, Insira um Valor Menor");
            jtfValorY.setText("");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jtfValorYKeyReleased

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        jtaDescricaoCaminho.setText("");
        jtaDescricaoPericia.setText("");
        jtfValorX.setText("");
        jtfValorY.setText("");
        this.dispose();


    }//GEN-LAST:event_jbCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(JFPosicoes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPosicoes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPosicoes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPosicoes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox jcbCaminho;
    private javax.swing.JComboBox jcbNpc;
    private javax.swing.JComboBox jcbPericias;
    private javax.swing.JComboBox jcbValorPericia;
    private javax.swing.JCheckBox jcheckNpc;
    private javax.swing.JCheckBox jcheckPericia;
    private javax.swing.JLabel jlSelecNpc;
    private javax.swing.JLabel jlSelectPericia;
    private javax.swing.JLabel jlTamMapa;
    private javax.swing.JLabel jlTituloDificuldadePericia;
    private javax.swing.JLabel jlValorX;
    private javax.swing.JLabel jlValorY;
    private javax.swing.JLabel jlX;
    private javax.swing.JLabel jlY;
    private javax.swing.JTextArea jtaDescricaoCaminho;
    private javax.swing.JTextArea jtaDescricaoPericia;
    private javax.swing.JTextField jtfValorX;
    private javax.swing.JTextField jtfValorY;
    // End of variables declaration//GEN-END:variables
}
