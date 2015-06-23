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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tabelas.Armaduras;
import tabelas.Armas;
import tabelas.Classes;
import tabelas.Consumiveis;
import tabelas.Escudos;
import tabelas.Jogadores;
import tabelas.Personagens;
import tabelas.PersonagensArmaduras;
import tabelas.PersonagensArmas;
import tabelas.PersonagensConsumiveis;
import tabelas.PersonagensEscudos;

/**
 *
 * @author Micro10
 */
public class JFVendaItens extends javax.swing.JFrame {

    /**
     * Creates new form JFVendaItens
     */
    public void centralizarComponente() {

        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dw = getSize();
        setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);

    }

    public void VerificarDinheiro() {

        double dinheiroTotal = (Double.parseDouble(lbDinheiroPersonagem.getText()));
        double QuantItens = (Double.parseDouble(QuantComprar.getText()));
        double PrecoUnidade = (Double.parseDouble(jlListPreçoComprar.getText()));

        double Result = PrecoUnidade * QuantItens;

    }

    public void ListarDinheiro() {

        try {

            GenericDAO gDao = new GenericDAO();
            Personagens personagem = new Personagens();
            List<Object> ListarCodClasse = new ArrayList<>();
            List<Object> ListarDinheiroPersonagem = new ArrayList<>();

            personagem.setNome_personagem((String) jcPersonagem.getSelectedItem());

            ListarCodClasse = gDao.listar2(Personagens.class, personagem);    ////compara o item selecionado no combobox e procura o codigo da classe

            for (Object obj : ListarCodClasse) {
                Personagens pp = (Personagens) obj;
                Classes classe = new Classes();

                int codClasse = pp.getCodigo_classe();
                classe.setCodigo_classe(codClasse);

                ListarDinheiroPersonagem = gDao.listar2(Classes.class, classe);    ////pega o codigo da classe e procura o dinheiro da mesma

                for (Object obj2 : ListarDinheiroPersonagem) {
                    Classes cc = (Classes) obj2;

                    lbDinheiroClasse.setText(String.valueOf(cc.getDinheiro_classe()));
                    lbDinheiroPersonagem.setText(lbDinheiroClasse.getText());

                }

            }

        } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            Logger.getLogger(JFNpc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CarregaComboboxPersonagem() {

        List<Object> list = null;

        try {

            GenericDAO gDao = new GenericDAO();
            list = gDao.listar(Personagens.class);

            for (Object obj2 : list) {
                Personagens personagem = (Personagens) obj2;
                jcPersonagem.addItem(personagem.getNome_personagem());
            }

        } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void OcultarObjetos() { //////Oculta objetos setados antes de abrir o form

        jbComprar.setVisible(false);
        lbComprar.setVisible(false);
        lbPrecoComprar.setVisible(false);
        jcbVenderConsumiveis.setVisible(false);
        jcbVenderEscudos.setVisible(false);
        jcbVenderArmaduras.setVisible(false);
        jcbVenderArmas.setVisible(false);
        jcVenderConsumiveis.setVisible(false);
        jcVenderEscudos.setVisible(false);
        jcVenderArmaduras.setVisible(false);
        jcVenderArmas.setVisible(false);
        jlQuantComprar.setVisible(false);
        jlQuantVender.setVisible(false);
        QuantComprar.setVisible(false);
        QuantVender.setVisible(false);

        jbVender.setVisible(false);
        lbVender.setVisible(false);
        jcbComprarConsumiveis.setVisible(false);
        jcbComprarEscudos.setVisible(false);
        jcbComprarArmaduras.setVisible(false);
        jcbComprarArmas.setVisible(false);
        jcComprarConsumiveis.setVisible(false);
        jcComprarEscudos.setVisible(false);
        jcComprarArmaduras.setVisible(false);
        jcComprarArmas.setVisible(false);
    }

    public JFVendaItens() {
        initComponents();
        centralizarComponente();
        CarregaComboboxPersonagem();
        OcultarObjetos();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        lbComprar = new java.awt.Label();
        jcComprarArmas = new javax.swing.JComboBox();
        lbVender = new java.awt.Label();
        jcVenderArmas = new javax.swing.JComboBox();
        jcComprarArmaduras = new javax.swing.JComboBox();
        jcComprarEscudos = new javax.swing.JComboBox();
        jcComprarConsumiveis = new javax.swing.JComboBox();
        jcVenderArmaduras = new javax.swing.JComboBox();
        jcVenderEscudos = new javax.swing.JComboBox();
        jcVenderConsumiveis = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        lbPrecoComprar = new java.awt.Label();
        jbComprar = new javax.swing.JButton();
        jbVender = new javax.swing.JButton();
        jcbComprar = new javax.swing.JCheckBox();
        jcbVender = new javax.swing.JCheckBox();
        jcbComprarArmas = new javax.swing.JCheckBox();
        jcbComprarArmaduras = new javax.swing.JCheckBox();
        jcbComprarEscudos = new javax.swing.JCheckBox();
        jcbComprarConsumiveis = new javax.swing.JCheckBox();
        jcbVenderArmas = new javax.swing.JCheckBox();
        jcbVenderArmaduras = new javax.swing.JCheckBox();
        jcbVenderEscudos = new javax.swing.JCheckBox();
        jcbVenderConsumiveis = new javax.swing.JCheckBox();
        jlQuantComprar = new javax.swing.JLabel();
        jlQuantVender = new javax.swing.JLabel();
        QuantComprar = new javax.swing.JTextField();
        QuantVender = new javax.swing.JTextField();
        jlListPreçoComprar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcPersonagem = new javax.swing.JComboBox();
        lbDinheiroClasse = new javax.swing.JLabel();
        lbDinheiroPersonagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbComprar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbComprar.setText("O que você deseja comprar?");
        getContentPane().add(lbComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jcComprarArmas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcComprarArmasItemStateChanged(evt);
            }
        });
        jcComprarArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcComprarArmasActionPerformed(evt);
            }
        });
        getContentPane().add(jcComprarArmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 171, -1));

        lbVender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbVender.setText("O que você deseja vender?");
        getContentPane().add(lbVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        jcVenderArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcVenderArmasActionPerformed(evt);
            }
        });
        getContentPane().add(jcVenderArmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 171, -1));

        jcComprarArmaduras.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcComprarArmadurasItemStateChanged(evt);
            }
        });
        jcComprarArmaduras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcComprarArmadurasActionPerformed(evt);
            }
        });
        getContentPane().add(jcComprarArmaduras, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 171, -1));

        jcComprarEscudos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcComprarEscudosItemStateChanged(evt);
            }
        });
        getContentPane().add(jcComprarEscudos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 171, -1));

        jcComprarConsumiveis.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcComprarConsumiveisItemStateChanged(evt);
            }
        });
        jcComprarConsumiveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcComprarConsumiveisActionPerformed(evt);
            }
        });
        getContentPane().add(jcComprarConsumiveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 171, -1));

        getContentPane().add(jcVenderArmaduras, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 171, -1));

        getContentPane().add(jcVenderEscudos, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 171, -1));

        getContentPane().add(jcVenderConsumiveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 171, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel1.setText("Olá viajante você deseja comprar ou vender itens?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        lbPrecoComprar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbPrecoComprar.setText("Preço:");
        getContentPane().add(lbPrecoComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        jbComprar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbComprar.setText("Comprar");
        jbComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComprarActionPerformed(evt);
            }
        });
        getContentPane().add(jbComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 112, 39));

        jbVender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbVender.setText("Vender");
        jbVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVenderActionPerformed(evt);
            }
        });
        getContentPane().add(jbVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 112, 39));

        jcbComprar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbComprar.setText("Comprar");
        jcbComprar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jcbComprarComponentHidden(evt);
            }
        });
        jcbComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbComprarActionPerformed(evt);
            }
        });
        getContentPane().add(jcbComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        jcbVender.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbVender.setText("Vender");
        jcbVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbVenderActionPerformed(evt);
            }
        });
        getContentPane().add(jcbVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));

        jcbComprarArmas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbComprarArmas.setText("Armas");
        jcbComprarArmas.setHideActionText(true);
        jcbComprarArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbComprarArmasActionPerformed(evt);
            }
        });
        getContentPane().add(jcbComprarArmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jcbComprarArmaduras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbComprarArmaduras.setText("Armaduras");
        jcbComprarArmaduras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbComprarArmadurasActionPerformed(evt);
            }
        });
        getContentPane().add(jcbComprarArmaduras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jcbComprarEscudos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbComprarEscudos.setText("Escudos");
        jcbComprarEscudos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbComprarEscudosActionPerformed(evt);
            }
        });
        getContentPane().add(jcbComprarEscudos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jcbComprarConsumiveis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbComprarConsumiveis.setText("Consumiveis");
        jcbComprarConsumiveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbComprarConsumiveisActionPerformed(evt);
            }
        });
        getContentPane().add(jcbComprarConsumiveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jcbVenderArmas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbVenderArmas.setText("Armas");
        jcbVenderArmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbVenderArmasActionPerformed(evt);
            }
        });
        getContentPane().add(jcbVenderArmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        jcbVenderArmaduras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbVenderArmaduras.setText("Armaduras");
        jcbVenderArmaduras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbVenderArmadurasActionPerformed(evt);
            }
        });
        getContentPane().add(jcbVenderArmaduras, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        jcbVenderEscudos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbVenderEscudos.setText("Escudos");
        jcbVenderEscudos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbVenderEscudosActionPerformed(evt);
            }
        });
        getContentPane().add(jcbVenderEscudos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, -1, -1));

        jcbVenderConsumiveis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jcbVenderConsumiveis.setText("Consumiveis");
        jcbVenderConsumiveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbVenderConsumiveisActionPerformed(evt);
            }
        });
        getContentPane().add(jcbVenderConsumiveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, -1, -1));

        jlQuantComprar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlQuantComprar.setText("Quantidade:");
        getContentPane().add(jlQuantComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jlQuantVender.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlQuantVender.setText("Quantidade:");
        getContentPane().add(jlQuantVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, -1, -1));

        QuantComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantComprarActionPerformed(evt);
            }
        });
        getContentPane().add(QuantComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 40, -1));
        getContentPane().add(QuantVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 40, -1));
        getContentPane().add(jlListPreçoComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 40, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Personagem:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("P.O Disponiveis:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jcPersonagem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcPersonagemItemStateChanged(evt);
            }
        });
        jcPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcPersonagemActionPerformed(evt);
            }
        });
        getContentPane().add(jcPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 110, -1));
        getContentPane().add(lbDinheiroClasse, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 60, 20));
        getContentPane().add(lbDinheiroPersonagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 50, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jcComprarArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcComprarArmasActionPerformed

    }//GEN-LAST:event_jcComprarArmasActionPerformed

    private void jbComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComprarActionPerformed

        if (QuantComprar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor escolha a quantidade do item que deseja comprar!!!");
        } else {

            if (jcbComprarArmaduras.isSelected()) {

                PersonagensArmaduras comprar = new PersonagensArmaduras();
                int varComprarQuant = (Integer.parseInt(QuantComprar.getText()));

                try {

                    GenericDAO gDAO = new GenericDAO();
                    Armaduras armadura = new Armaduras();
                    List<Object> ListarArmaduras = new ArrayList<>();

                    armadura.setNome_armadura((String) jcComprarArmaduras.getSelectedItem());

                    ListarArmaduras = gDAO.listar2(Armaduras.class, armadura);

                    for (Object ll1 : ListarArmaduras) {  //// pega o nome da armadura no combobox e procura pelo codigo da mesma
                        Armaduras aa = (Armaduras) ll1;
                        comprar.setCodigo_armadura(aa.getCodigo_armadura()); /// cadastra na tabela N/N o codigo da armadura
                    }
////////////////////////////////////////
                    Personagens personagem = new Personagens();
                    List<Object> ProcurarCodPersonagem = new ArrayList<>();

                    personagem.setNome_personagem((String) jcPersonagem.getSelectedItem());

                    ProcurarCodPersonagem = gDAO.listar2(Personagens.class, personagem);

                    for (Object ll1 : ProcurarCodPersonagem) {  //// pega o nome do personagem no combobox e procura pelo codigo do mesmo
                        Personagens pp = (Personagens) ll1;
                        comprar.setCodigo_personagem(pp.getCodigo_personagem()); /// cadastra na tabela N/N o codigo do personagem
                    }

                    comprar.setQuantidade_armadura(varComprarQuant); /// cadastra na tabela N/N a quantidade de armaduras compradas 

///////////////////////////////// Verificação de Peças de Ouro                    
                    double dinheiroTotal = (Double.parseDouble(lbDinheiroPersonagem.getText()));
                    double QuantItens = (Double.parseDouble(QuantComprar.getText()));
                    double PrecoUnidade = (Double.parseDouble(jlListPreçoComprar.getText()));
                    double Result = PrecoUnidade * QuantItens;
                    double ResultDinheiro = dinheiroTotal - Result;

                    System.out.println("Total compras" + Result);

                    if (dinheiroTotal < Result) {
                        JOptionPane.showMessageDialog(null, "Não há Peças de Ouro disponiveis para efetuar a compra!!!");
                    } else {
                        lbDinheiroPersonagem.setText(String.valueOf(ResultDinheiro));
                        gDAO.adicionar(comprar);
                        JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!!!");
                    }

                } catch (ClassNotFoundException | SQLException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException ex) {
                    Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            if (jcbComprarArmas.isSelected()) {

                PersonagensArmas comprar = new PersonagensArmas();
                int varComprarQuant = (Integer.parseInt(QuantComprar.getText()));
                comprar.setQuantidade_arma(varComprarQuant);

                try {

                    GenericDAO gDAO = new GenericDAO();
                    Armas arma = new Armas();
                    List<Object> ListarArmas = new ArrayList<>();

                    arma.setNome_arma((String) jcComprarArmas.getSelectedItem());

                    ListarArmas = gDAO.listar2(Armas.class, arma);

                    for (Object ll1 : ListarArmas) { //// pega o nome da arma no combobox e procura pelo codigo da mesma
                        Armas aa = (Armas) ll1;
                        comprar.setCodigo_arma(aa.getCodigo_arma()); /// cadastra na tabela N/N o codigo da arma
                    }

                    Personagens personagem = new Personagens();
                    List<Object> ProcurarCodPersonagem = new ArrayList<>();

                    personagem.setNome_personagem((String) jcPersonagem.getSelectedItem());

                    ProcurarCodPersonagem = gDAO.listar2(Personagens.class, personagem);

                    for (Object ll1 : ProcurarCodPersonagem) {  //// pega o nome do personagem no combobox e procura pelo codigo do mesmo
                        Personagens pp = (Personagens) ll1;
                        comprar.setCodigo_personagem(pp.getCodigo_personagem()); /// cadastra na tabela N/N o codigo do personagem
                    }

                    comprar.setQuantidade_arma(varComprarQuant); /// cadastra na tabela N/N a quantidade de armas compradas 

///////////////////////////////// Verificação de Peças de Ouro
                    double dinheiroTotal = (Double.parseDouble(lbDinheiroPersonagem.getText()));
                    double QuantItens = (Double.parseDouble(QuantComprar.getText()));
                    double PrecoUnidade = (Double.parseDouble(jlListPreçoComprar.getText()));
                    double Result = PrecoUnidade * QuantItens;
                    double ResultDinheiro = dinheiroTotal - Result;

                    System.out.println("Total compras" + Result);

                    if (dinheiroTotal < Result) {
                        JOptionPane.showMessageDialog(null, "Não há Peças de Ouro disponiveis para efetuar a compra!!!");
                    } else {
                        lbDinheiroPersonagem.setText(String.valueOf(ResultDinheiro));
                        gDAO.adicionar(comprar);
                        JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!!!");
                    }

                } catch (ClassNotFoundException | SQLException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException ex) {
                    Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (jcbComprarEscudos.isSelected()) {

                PersonagensEscudos comprar = new PersonagensEscudos();
                int varComprarQuant = (Integer.parseInt(QuantComprar.getText()));
                comprar.setQuantidade_escudo(varComprarQuant);

                try {

                    GenericDAO gDAO = new GenericDAO();
                    Escudos escudo = new Escudos();
                    List<Object> ListarEscudos = new ArrayList<>();

                    escudo.setNome_escudo((String) jcComprarEscudos.getSelectedItem());

                    ListarEscudos = gDAO.listar2(Escudos.class, escudo);

                    for (Object ll1 : ListarEscudos) {   //// pega o nome do escudo no combobox e procura pelo codigo da mesmo
                        Escudos ee = (Escudos) ll1;
                        comprar.setCodigo_escudo(ee.getCodigo_escudo()); /// cadastra na tabela N/N o codigo do escudo
                    }

                    Personagens personagem = new Personagens();
                    List<Object> ProcurarCodPersonagem = new ArrayList<>();

                    personagem.setNome_personagem((String) jcPersonagem.getSelectedItem());

                    ProcurarCodPersonagem = gDAO.listar2(Personagens.class, personagem);

                    for (Object ll1 : ProcurarCodPersonagem) {  //// pega o nome do personagem no combobox e procura pelo codigo do mesmo
                        Personagens pp = (Personagens) ll1;
                        comprar.setCodigo_personagem(pp.getCodigo_personagem()); /// cadastra na tabela N/N o codigo do personagem
                    }

                    comprar.setQuantidade_escudo(varComprarQuant); /// cadastra na tabela N/N a quantidade de escudos comprados
                    
///////////////////////////////// Verificação de Peças de Ouro
                    double dinheiroTotal = (Double.parseDouble(lbDinheiroPersonagem.getText()));
                    double QuantItens = (Double.parseDouble(QuantComprar.getText()));
                    double PrecoUnidade = (Double.parseDouble(jlListPreçoComprar.getText()));
                    double Result = PrecoUnidade * QuantItens;
                    double ResultDinheiro = dinheiroTotal - Result;

                    System.out.println("Total compras" + Result);

                    if (dinheiroTotal < Result) {
                        JOptionPane.showMessageDialog(null, "Não há Peças de Ouro disponiveis para efetuar a compra!!!");
                    } else {
                        lbDinheiroPersonagem.setText(String.valueOf(ResultDinheiro));
                        gDAO.adicionar(comprar);
                        JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!!!");
                    }

                } catch (ClassNotFoundException | SQLException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException ex) {
                    Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (jcbComprarConsumiveis.isSelected()) {

                PersonagensConsumiveis comprar = new PersonagensConsumiveis();
                int varComprarQuant = (Integer.parseInt(QuantComprar.getText()));
                comprar.setQuantidade_consumivel(varComprarQuant);

                try {

                    GenericDAO gDAO = new GenericDAO();
                    Consumiveis consumivel = new Consumiveis();
                    List<Object> ListarConsumiveis = new ArrayList<>();

                    consumivel.setNome_consumivel((String) jcComprarConsumiveis.getSelectedItem());

                    ListarConsumiveis = gDAO.listar2(Consumiveis.class, consumivel);

                    for (Object ll1 : ListarConsumiveis) {  //// pega o nome do consumivel no combobox e procura pelo codigo do mesmo
                        Consumiveis cc = (Consumiveis) ll1;
                        comprar.setCodigo_consumivel(cc.getCodigo_consumivel()); /// cadastra na tabela N/N o codigo do consumivel
                    }

                    Personagens personagem = new Personagens();
                    List<Object> ProcurarCodPersonagem = new ArrayList<>();

                    personagem.setNome_personagem((String) jcPersonagem.getSelectedItem());

                    ProcurarCodPersonagem = gDAO.listar2(Personagens.class, personagem);

                    for (Object ll1 : ProcurarCodPersonagem) {  //// pega o nome do personagem no combobox e procura pelo codigo do mesmo
                        Personagens pp = (Personagens) ll1;
                        comprar.setCodigo_personagem(pp.getCodigo_personagem()); /// cadastra na tabela N/N o codigo do personagem
                    }

                    comprar.setQuantidade_consumivel(varComprarQuant); /// cadastra na tabela N/N a quantidade de consumiveis comprados
                    
///////////////////////////////// Verificação de Peças de Ouro
                    double dinheiroTotal = (Double.parseDouble(lbDinheiroPersonagem.getText()));
                    double QuantItens = (Double.parseDouble(QuantComprar.getText()));
                    double PrecoUnidade = (Double.parseDouble(jlListPreçoComprar.getText()));
                    double Result = PrecoUnidade * QuantItens;
                    double ResultDinheiro = dinheiroTotal - Result;

                    System.out.println("Total compras" + Result);

                    if (dinheiroTotal < Result) {
                        JOptionPane.showMessageDialog(null, "Não há Peças de Ouro disponiveis para efetuar a compra!!!");
                    } else {
                        
                        lbDinheiroPersonagem.setText(String.valueOf(ResultDinheiro));
                        gDAO.adicionar(comprar);
                        JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso!!!");
                    }

                } catch (ClassNotFoundException | SQLException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException ex) {
                    Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jbComprarActionPerformed

    private void jcbVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbVenderActionPerformed
        if (jcbVender.isSelected()) {
            lbVender.setVisible(true);
            jcbVenderArmas.setVisible(true);
            jcbVenderConsumiveis.setVisible(true);
            jcbVenderEscudos.setVisible(true);
            jcbVenderArmaduras.setVisible(true);
            jcbComprar.setEnabled(false);
            jcbVenderArmaduras.setEnabled(true);
            jcbVenderEscudos.setEnabled(true);
            jcbVenderArmas.setEnabled(true);
            jcbVenderConsumiveis.setEnabled(true);
            jcbVenderArmaduras.setSelected(false);
            jcbVenderEscudos.setSelected(false);
            jcbVenderArmas.setSelected(false);
            jcbVenderConsumiveis.setSelected(false);
        } else {
            lbVender.setVisible(false);
            jcbVenderConsumiveis.setVisible(false);
            jcbVenderEscudos.setVisible(false);
            jcbVenderArmaduras.setVisible(false);
            jcbVenderArmas.setVisible(false);
            jcVenderConsumiveis.setVisible(false);
            jcVenderEscudos.setVisible(false);
            jcVenderArmaduras.setVisible(false);
            jcVenderArmas.setVisible(false);
            jbVender.setVisible(false);
            jlQuantVender.setVisible(false);
            QuantVender.setVisible(false);
            jcbComprar.setEnabled(true);
        }
    }//GEN-LAST:event_jcbVenderActionPerformed

    private void jcbComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbComprarActionPerformed
        if (jcbComprar.isSelected()) {
            lbComprar.setVisible(true);
            jcbComprarArmas.setVisible(true);
            jcbComprarConsumiveis.setVisible(true);
            jcbComprarEscudos.setVisible(true);
            jcbComprarArmaduras.setVisible(true);
            jcbVender.setEnabled(false);
            jcbComprarArmaduras.setEnabled(true);
            jcbComprarEscudos.setEnabled(true);
            jcbComprarArmas.setEnabled(true);
            jcbComprarConsumiveis.setEnabled(true);
            jcbComprarArmaduras.setSelected(false);
            jcbComprarEscudos.setSelected(false);
            jcbComprarArmas.setSelected(false);
            jcbComprarConsumiveis.setSelected(false);

        } else {
            lbComprar.setVisible(false);
            jcbComprarConsumiveis.setVisible(false);
            jcbComprarEscudos.setVisible(false);
            jcbComprarArmaduras.setVisible(false);
            jcbComprarArmas.setVisible(false);
            jcComprarConsumiveis.setVisible(false);
            jcComprarEscudos.setVisible(false);
            jcComprarArmaduras.setVisible(false);
            jcComprarArmas.setVisible(false);
            jbComprar.setVisible(false);
            lbPrecoComprar.setVisible(false);
            jlQuantComprar.setVisible(false);
            QuantComprar.setVisible(false);
            jcbVender.setEnabled(true);
            jlListPreçoComprar.setEnabled(false);
            jlListPreçoComprar.setText("");

        }
    }//GEN-LAST:event_jcbComprarActionPerformed

    private void jcbComprarArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbComprarArmasActionPerformed

        List<Object> list = null;

        try {

            GenericDAO gDao = new GenericDAO();
            list = gDao.listar(Armas.class);

            for (Object obj2 : list) {   ///// carrega combobox com armas
                Armas arma = (Armas) obj2;
                jcComprarArmas.addItem(arma.getNome_arma());
            }

        } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (jcbComprarArmas.isSelected()) {
            jcComprarArmas.setVisible(true);
            jbComprar.setVisible(true);
            lbPrecoComprar.setVisible(true);
            jlQuantComprar.setVisible(true);
            QuantComprar.setVisible(true);

            jcbComprarArmaduras.setEnabled(false);
            jcbComprarEscudos.setEnabled(false);
            jcbComprarConsumiveis.setEnabled(false);
            jlListPreçoComprar.setEnabled(true);

        } else {
            jcComprarArmas.setVisible(false);
            jbComprar.setVisible(false);
            lbPrecoComprar.setVisible(false);
            jlQuantComprar.setVisible(false);
            QuantComprar.setVisible(false);
            jcComprarArmas.removeAllItems();
            jcbComprarArmaduras.setEnabled(true);
            jcbComprarEscudos.setEnabled(true);
            jcbComprarConsumiveis.setEnabled(true);
            jlListPreçoComprar.setEnabled(false);
            jlListPreçoComprar.setText("");
        }
    }//GEN-LAST:event_jcbComprarArmasActionPerformed

    private void jcbComprarArmadurasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbComprarArmadurasActionPerformed

        List<Object> list = null;
        try {

            GenericDAO gDao = new GenericDAO();
            list = gDao.listar(Armaduras.class);

            for (Object obj2 : list) {                  ////carrega combobox com armaduras
                Armaduras armadura = (Armaduras) obj2;
                jcComprarArmaduras.addItem(armadura.getNome_armadura());
            }

        } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* try    
         {    
             
         Connection cConnectiononn;    
         conn = Conexao.getConexao();//classe de conexao com banco  
         Statement st = conn.createStatement();    
         ResultSet rs = st.executeQuery("SELECT nome_armadura FROM armaduras" );    
         while(rs.next())    
         {   
         jcComprarArmaduras.addItem(rs.getString("nome_armadura"));    
         }    
         rs.close();    
         conn.close();    
         }    
         catch(Exception e)    
         {    
         JOptionPane.showMessageDialog(null,     
         "Ocorreu erro ao carregar a Combo Box", "Erro",    
         JOptionPane.ERROR_MESSAGE);    
         } 
        
         */
        if (jcbComprarArmaduras.isSelected()) {
            jcComprarArmaduras.setVisible(true);
            jbComprar.setVisible(true);
            lbPrecoComprar.setVisible(true);
            jlQuantComprar.setVisible(true);
            QuantComprar.setVisible(true);
            jcbComprarArmas.setEnabled(false);
            jcbComprarEscudos.setEnabled(false);
            jcbComprarConsumiveis.setEnabled(false);
            jlListPreçoComprar.setEnabled(true);
        } else {
            jcComprarArmaduras.setVisible(false);
            jbComprar.setVisible(false);
            lbPrecoComprar.setVisible(false);
            jlQuantComprar.setVisible(false);
            QuantComprar.setVisible(false);
            jcComprarArmaduras.removeAllItems();
            jcbComprarArmas.setEnabled(true);
            jcbComprarEscudos.setEnabled(true);
            jcbComprarConsumiveis.setEnabled(true);
            jlListPreçoComprar.setEnabled(false);
            jlListPreçoComprar.setText("");
        }
    }//GEN-LAST:event_jcbComprarArmadurasActionPerformed

    private void jcbComprarEscudosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbComprarEscudosActionPerformed

        List<Object> list = null;

        try {

            GenericDAO gDao = new GenericDAO();
            list = gDao.listar(Escudos.class);

            for (Object obj2 : list) {                          ////carrega combobox com escudos
                Escudos escudo = (Escudos) obj2;
                jcComprarEscudos.addItem(escudo.getNome_escudo());

            }

        } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (jcbComprarEscudos.isSelected()) {
            jcComprarEscudos.setVisible(true);
            jbComprar.setVisible(true);
            lbPrecoComprar.setVisible(true);
            jlQuantComprar.setVisible(true);
            QuantComprar.setVisible(true);
            jcbComprarArmas.setEnabled(false);
            jcbComprarArmaduras.setEnabled(false);
            jcbComprarConsumiveis.setEnabled(false);
            jlListPreçoComprar.setEnabled(true);
        } else {
            jcComprarEscudos.setVisible(false);
            jbComprar.setVisible(false);
            lbPrecoComprar.setVisible(false);
            jlQuantComprar.setVisible(false);
            QuantComprar.setVisible(false);
            jcComprarEscudos.removeAllItems();
            jcbComprarArmas.setEnabled(true);
            jcbComprarArmaduras.setEnabled(true);
            jcbComprarConsumiveis.setEnabled(true);
            jlListPreçoComprar.setEnabled(false);
            jlListPreçoComprar.setText("");

        }
    }//GEN-LAST:event_jcbComprarEscudosActionPerformed

    private void jcbComprarConsumiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbComprarConsumiveisActionPerformed

        List<Object> list = null;
        try {

            GenericDAO gDao = new GenericDAO();
            list = gDao.listar(Consumiveis.class);

            for (Object obj2 : list) {              ////carrega combobox consumiveis
                Consumiveis consumivel = (Consumiveis) obj2;
                jcComprarConsumiveis.addItem(consumivel.getNome_consumivel());
            }

        } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (jcbComprarConsumiveis.isSelected()) {
            jcComprarConsumiveis.setVisible(true);
            jbComprar.setVisible(true);
            lbPrecoComprar.setVisible(true);
            QuantComprar.setVisible(true);
            jlQuantComprar.setVisible(true);
            jcbComprarArmas.setEnabled(false);
            jcbComprarArmaduras.setEnabled(false);
            jcbComprarEscudos.setEnabled(false);
            jlListPreçoComprar.setEnabled(true);
        } else {
            jcComprarConsumiveis.setVisible(false);
            jbComprar.setVisible(false);
            lbPrecoComprar.setVisible(false);
            QuantComprar.setVisible(false);
            jcComprarConsumiveis.removeAllItems();
            jcbComprarArmas.setEnabled(true);
            jcbComprarArmaduras.setEnabled(true);
            jcbComprarEscudos.setEnabled(true);
            jlListPreçoComprar.setEnabled(false);
            jlListPreçoComprar.setText("");
        }
    }//GEN-LAST:event_jcbComprarConsumiveisActionPerformed

    private void jcbVenderArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbVenderArmasActionPerformed

        GenericDAO gDao = null;
        try {
            gDao = new GenericDAO();
        } catch (SQLException ex) {
            Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Object> list = null;

        try {

            list = gDao.listar(PersonagensArmas.class);

        } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Object obj2 : list) {

            PersonagensArmas armaNN = (PersonagensArmas) obj2; ////lista todos os codigos das armas da tabela N/N
            Armas arma = new Armas();
            List<Object> ListarArmas = new ArrayList<>();

            int mostrarCodigo = (armaNN.getCodigo_arma());
            arma.setCodigo_arma(mostrarCodigo);     /////seta o codigo da arma da tabela N/N

            try {

                ListarArmas = gDao.listar2(Armas.class, arma);

            } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
                Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (Object ll1 : ListarArmas) { /////compara o codigo setado com a tabela Armas e procura o nome da arma

                Armas aa = (Armas) ll1;
                jcVenderArmas.addItem(aa.getNome_arma()); /// adiciona no combobox o nome da arma
                ///jcVenderArmas.addItem(mostrarCodigo + " - " + aa.getNome_arma()); /// adiciona no combo o codigo + nome

            }

        }

        if (jcbVenderArmas.isSelected()) {
            jcVenderArmas.setVisible(true);
            jbVender.setVisible(true);
            jlQuantVender.setVisible(true);
            QuantVender.setVisible(true);
            jcbVenderArmaduras.setEnabled(false);
            jcbVenderEscudos.setEnabled(false);
            jcbVenderConsumiveis.setEnabled(false);

        } else {
            jcVenderArmas.setVisible(false);
            jbVender.setVisible(false);
            jlQuantVender.setVisible(false);
            QuantVender.setVisible(false);
            jcVenderArmas.removeAllItems();
            jcbVenderArmaduras.setEnabled(true);
            jcbVenderEscudos.setEnabled(true);
            jcbVenderConsumiveis.setEnabled(true);
        }
    }//GEN-LAST:event_jcbVenderArmasActionPerformed

    private void jcbVenderArmadurasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbVenderArmadurasActionPerformed

        GenericDAO gDao = null;
        try {
            gDao = new GenericDAO();
        } catch (SQLException ex) {
            Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Object> list = null;

        try {

            list = gDao.listar(PersonagensArmaduras.class);

        } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Object obj2 : list) {   ////lista todos os codigos das armaduras da tabela N/N

            PersonagensArmaduras armadurasNN = (PersonagensArmaduras) obj2;
            Armaduras armadura = new Armaduras();
            List<Object> ListarArmaduras = new ArrayList<>();

            int mostrarCodigo = (armadurasNN.getCodigo_armadura());
            armadura.setCodigo_armadura(mostrarCodigo);  /////seta o codigo da armadura da tabela N/N

            try {

                ListarArmaduras = gDao.listar2(Armaduras.class, armadura);
                /////compara o codigo setado com a tabela armadura e procura o nome da armadura

            } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
                Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (Object ll1 : ListarArmaduras) {

                Armaduras aa = (Armaduras) ll1;
                jcVenderArmaduras.addItem(aa.getNome_armadura()); /// adiciona no combobox o nome da armadura
                // jcVenderArmaduras.addItem(mostrarCodigo + " - " + aa.getNome_armadura());

            }

        }

        if (jcbVenderArmaduras.isSelected()) {
            jcVenderArmaduras.setVisible(true);
            jbVender.setVisible(true);
            jlQuantVender.setVisible(true);
            QuantVender.setVisible(true);
            jcbVenderArmas.setEnabled(false);
            jcbVenderEscudos.setEnabled(false);
            jcbVenderConsumiveis.setEnabled(false);
        } else {
            jcVenderArmaduras.setVisible(false);
            jbVender.setVisible(false);
            jlQuantVender.setVisible(false);
            QuantVender.setVisible(false);
            jcVenderArmaduras.removeAllItems();
            jcbVenderArmas.setEnabled(true);
            jcbVenderEscudos.setEnabled(true);
            jcbVenderConsumiveis.setEnabled(true);
        }
    }//GEN-LAST:event_jcbVenderArmadurasActionPerformed

    private void jcbVenderEscudosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbVenderEscudosActionPerformed

        GenericDAO gDao = null;
        try {
            gDao = new GenericDAO();
        } catch (SQLException ex) {
            Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Object> list = null;

        try {

            list = gDao.listar(PersonagensEscudos.class);

        } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Object obj2 : list) {   ////lista todos os codigos dos escudos da tabela N/N

            PersonagensEscudos escudosNN = (PersonagensEscudos) obj2;
            Escudos escudo = new Escudos();
            List<Object> ListarEscudos = new ArrayList<>();

            int mostrarCodigo = (escudosNN.getCodigo_escudo());
            escudo.setCodigo_escudo(mostrarCodigo);  /////seta o codigo do escudo da tabela N/N

            try {

                ListarEscudos = gDao.listar2(Escudos.class, escudo);
                /////compara o codigo setado com a tabela escudos e procura o nome do escudo

            } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
                Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (Object ll1 : ListarEscudos) {

                Escudos ee = (Escudos) ll1;
                jcVenderEscudos.addItem(ee.getNome_escudo()); /// adiciona no combobox o nome do escudo
                // jcVenderEscudos.addItem(mostrarCodigo + " - " + ee.getNome_escudo());

            }

        }

        if (jcbVenderEscudos.isSelected()) {
            jcVenderEscudos.setVisible(true);
            jbVender.setVisible(true);
            jlQuantVender.setVisible(true);
            QuantVender.setVisible(true);
            jcbVenderArmas.setEnabled(false);
            jcbVenderArmaduras.setEnabled(false);
            jcbVenderConsumiveis.setEnabled(false);
        } else {
            jcVenderEscudos.setVisible(false);
            jbVender.setVisible(false);
            jlQuantVender.setVisible(false);
            QuantVender.setVisible(false);
            jcVenderEscudos.removeAllItems();
            jcbVenderArmas.setEnabled(true);
            jcbVenderArmaduras.setEnabled(true);
            jcbVenderConsumiveis.setEnabled(true);
        }
    }//GEN-LAST:event_jcbVenderEscudosActionPerformed

    private void jcbVenderConsumiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbVenderConsumiveisActionPerformed

        GenericDAO gDao = null;
        try {
            gDao = new GenericDAO();
        } catch (SQLException ex) {
            Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Object> list = null;

        try {

            list = gDao.listar(PersonagensConsumiveis.class);

        } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Object obj2 : list) {   ////lista todos os codigos dos consumiveis da tabela N/N

            PersonagensConsumiveis consumiveisNN = (PersonagensConsumiveis) obj2;
            Consumiveis consumivel = new Consumiveis();
            List<Object> ListarConsumiveis = new ArrayList<>();

            int mostrarCodigo = (consumiveisNN.getCodigo_consumivel());
            consumivel.setCodigo_consumivel(mostrarCodigo);  /////seta o codigo do consumivel da tabela N/N

            try {

                ListarConsumiveis = gDao.listar2(Consumiveis.class, consumivel);
                /////compara o codigo setado com a tabela consumiveis e procura o nome do consumivel

            } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
                Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (Object ll1 : ListarConsumiveis) {

                Consumiveis cc = (Consumiveis) ll1;
                jcVenderConsumiveis.addItem(cc.getNome_consumivel()); /// adiciona no combobox o nome do consumivel
                // jcVenderConsumiveis.addItem(mostrarCodigo + " - " + cc.getNome_consumivel());

            }

        }

        if (jcbVenderConsumiveis.isSelected()) {
            jcVenderConsumiveis.setVisible(true);
            jbVender.setVisible(true);
            jlQuantVender.setVisible(true);
            QuantVender.setVisible(true);
            jcbVenderArmas.setEnabled(false);
            jcbVenderArmaduras.setEnabled(false);
            jcbVenderEscudos.setEnabled(false);
        } else {
            jcVenderConsumiveis.setVisible(false);
            jbVender.setVisible(false);
            jlQuantVender.setVisible(false);
            QuantVender.setVisible(false);
            jcVenderConsumiveis.removeAllItems();
            jcbVenderArmas.setEnabled(true);
            jcbVenderArmaduras.setEnabled(true);
            jcbVenderEscudos.setEnabled(true);
        }
    }//GEN-LAST:event_jcbVenderConsumiveisActionPerformed

    private void jcbComprarComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jcbComprarComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbComprarComponentHidden

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void jbVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVenderActionPerformed
        int varVender = (Integer.parseInt(QuantVender.getText()));

        if (jcbVenderArmaduras.isSelected()) {
            PersonagensArmaduras vender = new PersonagensArmaduras();
            vender.setQuantidade_armadura(varVender);
        }
        if (jcbVenderArmas.isSelected()) {
            PersonagensArmas vender = new PersonagensArmas();
            vender.setQuantidade_arma(varVender);
        }
        if (jcbVenderEscudos.isSelected()) {
            PersonagensEscudos vender = new PersonagensEscudos();
            vender.setQuantidade_escudo(varVender);
        }
        if (jcbVenderConsumiveis.isSelected()) {
            PersonagensConsumiveis vender = new PersonagensConsumiveis();
            vender.setQuantidade_consumivel(varVender);
        }
    }//GEN-LAST:event_jbVenderActionPerformed

    private void QuantComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantComprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantComprarActionPerformed

    private void jcComprarArmadurasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcComprarArmadurasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcComprarArmadurasActionPerformed

    private void jcVenderArmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcVenderArmasActionPerformed
        /* GenericDAO gDao = null;
         try {
         gDao = new GenericDAO();
         } catch (SQLException ex) {
         Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
         }
        
         //Armas arma = new Armas();
         PersonagensArmas armaNN = new PersonagensArmas();
         armaNN.setCodigo_arma((int) jcVenderArmas.getSelectedItem());
            
         List<Object> ListarArmas = new ArrayList<>();

            

         try {
         ListarArmas = gDao.listar2(Armas.class, armaNN);
         } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
         Logger.getLogger(JFVendaItens.class.getName()).log(Level.SEVERE, null, ex);
         }

         for (Object ll1 : ListarArmas) {
         Armas aa = (Armas) ll1;
         System.out.println(aa.getNome_arma());   /// mostra o nome
                
         }
        
         */


    }//GEN-LAST:event_jcVenderArmasActionPerformed

    private void jcComprarArmasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcComprarArmasItemStateChanged
        try {

            GenericDAO gDao = new GenericDAO();
            Armas arma = new Armas();
            List<Object> ListarPreçoArma = new ArrayList<>();

            arma.setNome_arma((String) jcComprarArmas.getSelectedItem());

            ListarPreçoArma = gDao.listar2(Armas.class, arma);    ////compara o item selecionado no combobox e procura seu preço

            for (Object cod : ListarPreçoArma) {
                Armas aa = (Armas) cod;

                jlListPreçoComprar.setText(String.valueOf(aa.getPreco_arma())); //// lista preço arma
            }

        } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            Logger.getLogger(JFNpc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcComprarArmasItemStateChanged

    private void jcComprarArmadurasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcComprarArmadurasItemStateChanged
        try {

            GenericDAO gDao = new GenericDAO();
            Armaduras armadura = new Armaduras();
            List<Object> ListarPreçoArmadura = new ArrayList<>();

            armadura.setNome_armadura((String) jcComprarArmaduras.getSelectedItem());

            ListarPreçoArmadura = gDao.listar2(Armaduras.class, armadura); ////compara o item selecionado no combobox e procura seu preço

            for (Object cod : ListarPreçoArmadura) {
                Armaduras aa = (Armaduras) cod;

                jlListPreçoComprar.setText(String.valueOf(aa.getPreco_armadura())); ////lista preço armadura
            }

        } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            Logger.getLogger(JFNpc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcComprarArmadurasItemStateChanged

    private void jcComprarEscudosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcComprarEscudosItemStateChanged
        try {

            GenericDAO gDao = new GenericDAO();
            Escudos escudo = new Escudos();
            List<Object> ListarPreçoEscudo = new ArrayList<>();

            escudo.setNome_escudo((String) jcComprarEscudos.getSelectedItem());

            ListarPreçoEscudo = gDao.listar2(Escudos.class, escudo); ////compara o item selecionado no combobox e procura seu preço

            for (Object cod : ListarPreçoEscudo) {
                Escudos aa = (Escudos) cod;

                jlListPreçoComprar.setText(String.valueOf(aa.getPreco_escudo())); ///lista preço escudo
            }

        } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            Logger.getLogger(JFNpc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcComprarEscudosItemStateChanged

    private void jcComprarConsumiveisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcComprarConsumiveisItemStateChanged
        try {

            GenericDAO gDao = new GenericDAO();
            Consumiveis consumivel = new Consumiveis();

            List<Object> ListarPreçoConsumivel = new ArrayList<>();

            consumivel.setNome_consumivel((String) jcComprarConsumiveis.getSelectedItem());

            ListarPreçoConsumivel = gDao.listar2(Consumiveis.class, consumivel); ////compara o item selecionado no combobox e procura seu preço

            for (Object cod : ListarPreçoConsumivel) {
                Consumiveis aa = (Consumiveis) cod;

                jlListPreçoComprar.setText(String.valueOf(aa.getPreco_consumivel())); ///lista preço consumivel
            }

        } catch (SQLException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            Logger.getLogger(JFNpc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcComprarConsumiveisItemStateChanged

    private void jcComprarConsumiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcComprarConsumiveisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcComprarConsumiveisActionPerformed

    private void jcPersonagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcPersonagemActionPerformed

    }//GEN-LAST:event_jcPersonagemActionPerformed

    private void jcPersonagemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcPersonagemItemStateChanged

        ListarDinheiro();
    }//GEN-LAST:event_jcPersonagemItemStateChanged

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
            java.util.logging.Logger.getLogger(JFVendaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFVendaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFVendaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFVendaItens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFVendaItens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField QuantComprar;
    private javax.swing.JTextField QuantVender;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbComprar;
    private javax.swing.JButton jbVender;
    private javax.swing.JComboBox jcComprarArmaduras;
    private javax.swing.JComboBox jcComprarArmas;
    private javax.swing.JComboBox jcComprarConsumiveis;
    private javax.swing.JComboBox jcComprarEscudos;
    private javax.swing.JComboBox jcPersonagem;
    private javax.swing.JComboBox jcVenderArmaduras;
    private javax.swing.JComboBox jcVenderArmas;
    private javax.swing.JComboBox jcVenderConsumiveis;
    private javax.swing.JComboBox jcVenderEscudos;
    private javax.swing.JCheckBox jcbComprar;
    private javax.swing.JCheckBox jcbComprarArmaduras;
    private javax.swing.JCheckBox jcbComprarArmas;
    private javax.swing.JCheckBox jcbComprarConsumiveis;
    private javax.swing.JCheckBox jcbComprarEscudos;
    private javax.swing.JCheckBox jcbVender;
    private javax.swing.JCheckBox jcbVenderArmaduras;
    private javax.swing.JCheckBox jcbVenderArmas;
    private javax.swing.JCheckBox jcbVenderConsumiveis;
    private javax.swing.JCheckBox jcbVenderEscudos;
    private javax.swing.JLabel jlListPreçoComprar;
    private javax.swing.JLabel jlQuantComprar;
    private javax.swing.JLabel jlQuantVender;
    private java.awt.Label lbComprar;
    private javax.swing.JLabel lbDinheiroClasse;
    private javax.swing.JLabel lbDinheiroPersonagem;
    private java.awt.Label lbPrecoComprar;
    private java.awt.Label lbVender;
    // End of variables declaration//GEN-END:variables
}
