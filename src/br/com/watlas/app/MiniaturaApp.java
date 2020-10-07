/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.watlas.app;

import br.com.watlas.bll.FabricanteBll;
import br.com.watlas.bll.FotoBll;
import br.com.watlas.bll.MiniaturaBll;
import br.com.watlas.bll.TemaBll;
import br.com.watlas.bll.Tipo_MiniaturaBll;
import br.com.watlas.model.Fabricante;
import br.com.watlas.model.Foto;
import br.com.watlas.model.Miniatura;
import br.com.watlas.model.Tema;
import br.com.watlas.model.Tipo_Miniatura;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author watla
 */
public class MiniaturaApp extends javax.swing.JFrame {

    /**
     * Creates new form MiniaturaApp
     */
    //OBJETOS DA CLASSE CONCRETA
    private Miniatura miniatura;
    private Fabricante fabricante;
    private Tema temas;
    private Tipo_Miniatura tipo_Miniatura;
    private Foto foto;
    //OBJETO DA CLASSE BLL
    private FotoBll fotoBll;
    private MiniaturaBll miniaturaBll;
    private TemaBll temabll;
    private Tipo_MiniaturaBll tipo_MiniaturaBll;
    private FabricanteBll fabricanteBll;
    //OBJETO DE CONTROLE DE FOTOS
    private int indiceFoto = 0;

    //INSTACIA TODOS OS OBJETOS USADOS NESSA CLASSE
    private void instaciarObjetos() throws Exception {
        fabricante = new Fabricante();
        temas = new Tema();
        tipo_Miniatura = new Tipo_Miniatura();
        miniatura = new Miniatura();
        foto = new Foto();
        miniaturaBll = new MiniaturaBll();
        fotoBll = new FotoBll();
        temabll = new TemaBll();
        tipo_MiniaturaBll = new Tipo_MiniaturaBll();
        fabricanteBll = new FabricanteBll();

    }

    private void popularComboxFabricante() throws Exception {
        List<Fabricante> lista = fabricanteBll.getallFabricante();
        jComboBoxFabricantes.removeAllItems();
        jComboBoxFabricantes.addItem("<SELECIONE>");
        
        for (Fabricante fabricante : lista) {
            jComboBoxFabricantes.addItem(fabricante.getFab_nome());
        }

    }

    private void popularComboxTema() throws Exception {
        List<Tema> lista = temabll.getallTemas();

        jComboBoxTemas.removeAllItems();
        jComboBoxTemas.addItem("<SELECIONE>");

        for (Tema tema : lista) {
            jComboBoxTemas.addItem(tema.getTema_nome());
        }
    }

    private void popularComboxTipo() throws Exception {
        List<Tipo_Miniatura> Lista = tipo_MiniaturaBll.getallTiposMiniatura();
        jComboBoxTipo.removeAllItems();
        jComboBoxTipo.addItem("<SELECIONE>");

        for (Tipo_Miniatura tipo_Miniatura : Lista) {
            jComboBoxTipo.addItem(tipo_Miniatura.getTipo_miniatura());
        }
    }

    //POPULA TODAS AS COMBOBOX
    private void popularAllCampos() throws Exception {
        popularComboxFabricante();
        popularComboxTema();
        popularComboxTipo();
    }

    //IMPRIME NA GRID
    private void atualizarGrid() throws Exception {
        DefaultTableModel model = (DefaultTableModel) jTableMiniatuas.getModel();
        model.setRowCount(0);
        Object[] linha;

        List<Miniatura> min = miniaturaBll.getAllMiniaturas();
        for (Miniatura miniatura : min) {
            linha = new Object[]{
                miniatura.getMin_iden(),
                miniatura.getMin_modelo(),
                miniatura.getMin_ano(),
                miniatura.getMin_observacoes(),
                miniatura.getMin_escala(),
                miniatura.getMin_edicao(),
                String.format("%.2f", miniatura.getMin_valor())

            };
            model.addRow(linha);

        }
    }

    //METODO VOID PARA LIMPAR CAMPOS
    private void limparCampos() {
        jTextFieldAno.setText("");
        jTextFieldEdicao.setText("");
        jTextFieldEscala.setText("");
        jTextFieldModelo.setText("");
        jTextFieldObeservacoes.setText("");
        jTextFieldValor.setText("");
        jTextFieldDescricao.setText("");
    }

    //METODO VOID PARA PREENCHER CAMPOS
    private void preenchercampos() throws Exception {

        //pegando os ID'S  
        int id = Integer.parseInt(jTableMiniatuas.getValueAt(jTableMiniatuas.getSelectedRow(), 0).toString());
        int idFab = miniaturaBll.getMiniaturaById(id).getFabricante().getFab_iden();
        int idTema = miniaturaBll.getMiniaturaById(id).getTema().getTema_iden();
        int idTipo = miniaturaBll.getMiniaturaById(id).getTipo_miniatura().getTipo_idem();
        //Setando na table
        //parte mais dificil do trabalho
        jTextFieldModelo.setText(jTableMiniatuas.getValueAt(jTableMiniatuas.getSelectedRow(), 1).toString());
        jTextFieldAno.setText(jTableMiniatuas.getValueAt(jTableMiniatuas.getSelectedRow(), 2).toString());
        jTextFieldEscala.setText(jTableMiniatuas.getValueAt(jTableMiniatuas.getSelectedRow(), 4).toString());
        jTextFieldEdicao.setText(jTableMiniatuas.getValueAt(jTableMiniatuas.getSelectedRow(), 5).toString());
        jTextFieldValor.setText(jTableMiniatuas.getValueAt(jTableMiniatuas.getSelectedRow(), 6).toString().replace(",", "."));
        jTextFieldObeservacoes.setText(jTableMiniatuas.getValueAt(jTableMiniatuas.getSelectedRow(), 3).toString());
        //fim da parte mais dificil
       
        jComboBoxFabricantes.setSelectedItem(fabricanteBll.getFabricantebyId(idFab).getFab_nome());
        jComboBoxTemas.setSelectedItem(temabll.getTemaById(idTema).getTema_nome());
        jComboBoxTipo.setSelectedItem(tipo_MiniaturaBll.getTipoMiniaturaById(idTipo).getTipo_miniatura());

    }
    //CONSTRUTOR DA TELA

    public MiniaturaApp() {
        initComponents();
        this.setLocationRelativeTo(null);
        try {

            instaciarObjetos();
            popularAllCampos();
            atualizarGrid();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonIncluir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jTextFieldModelo = new javax.swing.JTextField();
        jTextFieldAno = new javax.swing.JTextField();
        jTextFieldObeservacoes = new javax.swing.JTextField();
        jTextFieldEscala = new javax.swing.JTextField();
        jTextFieldEdicao = new javax.swing.JTextField();
        jTextFieldValor = new javax.swing.JTextField();
        jComboBoxFabricantes = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxTemas = new javax.swing.JComboBox<>();
        jButtonLimpar = new javax.swing.JButton();
        jButtonCadastroFabricante = new javax.swing.JButton();
        jButtonMaisTipo = new javax.swing.JButton();
        jButtonMaisTema = new javax.swing.JButton();
        jButtonAdicionarFotos = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabelFoto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMiniatuas = new javax.swing.JTable();
        jTextFieldDescricao = new javax.swing.JTextField();
        jButtonFotoProxima = new javax.swing.JButton();
        jButtonFotoMenos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CONTROLE DE MINIATURAS");

        jLabel2.setText("MODELO");
        jLabel2.setToolTipText("");

        jLabel3.setText("ANO");

        jLabel4.setText("OBSERVAÇOES");

        jLabel5.setText("ESCALA");

        jLabel6.setText("EDICAO");

        jLabel7.setText("VALOR");

        jButtonIncluir.setText("INCLUIR");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("ALTERAR");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("EXCLUIR");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jTextFieldAno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAnoKeyTyped(evt);
            }
        });

        jTextFieldValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldValorKeyTyped(evt);
            }
        });

        jLabel8.setText("FABRICANTE");

        jLabel9.setText("TIPO MINIATURA");

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel10.setText("TEMAS");

        jComboBoxTemas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Selecione um tema>" }));

        jButtonLimpar.setText("LIMPAR");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonCadastroFabricante.setText("+");
        jButtonCadastroFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastroFabricanteActionPerformed(evt);
            }
        });

        jButtonMaisTipo.setText("+");
        jButtonMaisTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMaisTipoActionPerformed(evt);
            }
        });

        jButtonMaisTema.setText("+");
        jButtonMaisTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMaisTemaActionPerformed(evt);
            }
        });

        jButtonAdicionarFotos.setText("ADICIONAR FOTO");
        jButtonAdicionarFotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarFotosActionPerformed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("FOTO DA MINIATURA");

        jTableMiniatuas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MODELO", "ANO", "OBESERVAÇOES", "ESCALA", "EDICAO", "VALOR"
            }
        ));
        jTableMiniatuas.getTableHeader().setReorderingAllowed(false);
        jTableMiniatuas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableMiniatuasMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMiniatuas);

        jButtonFotoProxima.setText(">>");
        jButtonFotoProxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFotoProximaActionPerformed(evt);
            }
        });

        jButtonFotoMenos.setText("<<");
        jButtonFotoMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFotoMenosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldEscala, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldObeservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(61, 61, 61)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(27, 27, 27))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxTemas, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jComboBoxFabricantes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonMaisTema)
                                        .addComponent(jButtonMaisTipo)
                                        .addComponent(jButtonCadastroFabricante)))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1)
                            .addGap(134, 134, 134)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonLimpar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonIncluir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonAdicionarFotos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonFotoMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonFotoProxima, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldObeservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldEdicao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxTemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxFabricantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonMaisTipo)
                                    .addGap(7, 7, 7)
                                    .addComponent(jButtonCadastroFabricante))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonMaisTema)
                                    .addGap(77, 77, 77))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldEscala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonFotoProxima)
                            .addComponent(jButtonFotoMenos))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonIncluir)
                                .addComponent(jButtonAlterar)
                                .addComponent(jButtonExcluir)
                                .addComponent(jButtonLimpar))
                            .addComponent(jButtonAdicionarFotos))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //DECREMENTA A FOTO PARA A FOTO ANTETIR
    private void jButtonFotoMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFotoMenosActionPerformed
        try {
            List<Foto> fotos = miniatura.getFotos();
            //VERIFICA SE EXISTE FOTO NA MINIATURA SELECIONADA
            if (fotos.size() == 0) {
                return;
            } else {
                if (indiceFoto == 0) {
                    return;
                } else {

                    indiceFoto--;

                }

            }

            exibirfoto(indiceFoto, fotos);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButtonFotoMenosActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        try {

            int id = Integer.parseInt(jTableMiniatuas.getValueAt(jTableMiniatuas.getSelectedRow(), 0).toString());
            fotoBll.deleteFoto(id);
            miniaturaBll.deleteMiniatura(id);

            atualizarGrid();
            limparCampos();
            jLabelFoto.setIcon(null);

            JOptionPane.showMessageDialog(this, "EXCLUIDO");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        try {

            int id = Integer.parseInt(jTableMiniatuas.getValueAt(jTableMiniatuas.getSelectedRow(), 0).toString());

            miniatura.setMin_iden(id);
            miniatura.setMin_modelo(jTextFieldModelo.getText());
            miniatura.setMin_ano(Integer.parseInt(jTextFieldAno.getText()));
            miniatura.setMin_observacoes(jTextFieldObeservacoes.getText());
            miniatura.setMin_escala(jTextFieldEscala.getText());
            miniatura.setMin_edicao(jTextFieldEdicao.getText());
            miniatura.setMin_valor(Double.parseDouble(jTextFieldValor.getText()));
            String nome = jComboBoxFabricantes.getSelectedItem().toString();
            fabricante = fabricanteBll.getFabricantebyNome(nome);
            miniatura.setFabricante(fabricante);
            miniatura.setTema(temas = temabll.getTemaByNome(jComboBoxTemas.getSelectedItem().toString()));
            miniatura.setTipo_miniatura(tipo_Miniatura = tipo_MiniaturaBll.getTipoMiniaturaByNome(jComboBoxTipo.getSelectedItem().toString()));
            miniaturaBll.updateminiatura(miniatura);
            atualizarGrid();
            limparCampos();
            JOptionPane.showMessageDialog(this, "ALTERADO COM EXITO"
                    + "");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        try {

            miniatura.setMin_modelo(jTextFieldModelo.getText());
            miniatura.setMin_ano(Integer.parseInt(jTextFieldAno.getText()));
            miniatura.setMin_observacoes(jTextFieldObeservacoes.getText());
            miniatura.setMin_escala(jTextFieldEscala.getText());
            miniatura.setMin_edicao(jTextFieldEdicao.getText());
            miniatura.setMin_valor(Double.parseDouble(jTextFieldValor.getText()));

            String nome = jComboBoxFabricantes.getSelectedItem().toString();
            fabricante = fabricanteBll.getFabricantebyNome(nome);
            miniatura.setFabricante(fabricante);

            String nome2 = jComboBoxTipo.getSelectedItem().toString();
            tipo_Miniatura = tipo_MiniaturaBll.getTipoMiniaturaByNome(nome2);
            miniatura.setTipo_miniatura(tipo_Miniatura);

            String nome3 = jComboBoxTemas.getSelectedItem().toString();
            temas = temabll.getTemaByNome(nome3);
            miniatura.setTema(temas);

            miniaturaBll.addMiniatura(miniatura);

            atualizarGrid();
            limparCampos();
            JOptionPane.showMessageDialog(this, "INCLUIU");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonFotoProximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFotoProximaActionPerformed
        try {
            List<Foto> fotos = miniatura.getFotos();
            if (fotos.size() == 0) {
                return;
            } else {
                if (indiceFoto == fotos.size() - 1) {
                    return;
                } else {

                    indiceFoto++;

                }

            }

            exibirfoto(indiceFoto, fotos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_jButtonFotoProximaActionPerformed

    private void jTableMiniatuasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMiniatuasMouseReleased
        try {
            preenchercampos();
            indiceFoto = 0;
            jTextFieldDescricao.setText("");

            int idminiatura = Integer.parseInt(jTableMiniatuas.getValueAt(jTableMiniatuas.getSelectedRow(), 0).toString());

            miniatura = miniaturaBll.getMiniaturaById(idminiatura);

            List<Foto> fotos = miniatura.getFotos();

            if (fotos.size() == 0) {
                jLabelFoto.setIcon(null);
            } else {

                exibirfoto(indiceFoto, fotos);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jTableMiniatuasMouseReleased

    private void jButtonAdicionarFotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarFotosActionPerformed
        try {
            if (jTableMiniatuas.getSelectedRow() == -1) {
                throw new Exception("SELECIONE UMA MINIATURA");
            }
            FotosApp tela = new FotosApp(null, true);
            int idminiatura = Integer.parseInt(jTableMiniatuas.getValueAt(jTableMiniatuas.getSelectedRow(), 0).toString());
            tela.setMiniatura(miniaturaBll.getMiniaturaById(idminiatura));

            tela.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonAdicionarFotosActionPerformed

    private void jButtonMaisTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMaisTemaActionPerformed
        TemaApp tela = null;
        try {
            tela = new TemaApp(null, true);
            tela.setVisible(true);
            popularComboxTema();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(tela, ex.getMessage());
        }

    }//GEN-LAST:event_jButtonMaisTemaActionPerformed

    private void jButtonMaisTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMaisTipoActionPerformed
        Tipo_MinuaturaApp tela = new Tipo_MinuaturaApp(null, true);

        tela.setVisible(true);

        try {
            popularComboxTipo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(tela, ex.getMessage());

        }
    }//GEN-LAST:event_jButtonMaisTipoActionPerformed

    private void jButtonCadastroFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastroFabricanteActionPerformed
        // TODO add your handling code here:
        FabricanteApp tela = new FabricanteApp(null, true);

        tela.setVisible(true);

        try {
            popularComboxFabricante();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(tela, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonCadastroFabricanteActionPerformed

    private void jTextFieldValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorKeyTyped
        String caracteres = "0987654321.";
        if (!caracteres.contains(evt.getKeyChar() + "")
                && (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE
                && evt.getKeyCode() != KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        int k = evt.getKeyChar();
        if (jTextFieldValor.getText().length() <= 10 - 1) {

        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_jTextFieldValorKeyTyped

    private void jTextFieldAnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAnoKeyTyped
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")
                && (evt.getKeyCode() != KeyEvent.VK_BACK_SPACE
                && evt.getKeyCode() != KeyEvent.VK_DELETE)) {
            evt.consume();
        }
        int k = evt.getKeyChar();
        if (jTextFieldAno.getText().length() <= 4) {
            //deixe passar
        } else {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_jTextFieldAnoKeyTyped

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void exibirfoto(int i, List<Foto> fotos) {
        try {
            
            int idFot = fotos.get(i).getFoto_iden();
            jTextFieldDescricao.setText(fotoBll.getTipoFotosById(idFot).getFoto_descricao());
            
            String local = fotos.get(i).getFoto_caminho();

            //fonte na classe FotosApp
            ImageIcon imageIcon = new ImageIcon(local); // carrega a imagem
            Image image = imageIcon.getImage(); // tranforma a imagem
            Image newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            /* Fim do código do redimensionamento */

            ImageIcon icon = new ImageIcon(newimg);
            jLabelFoto.setIcon(icon);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }

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
            java.util.logging.Logger.getLogger(MiniaturaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiniaturaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiniaturaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiniaturaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiniaturaApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarFotos;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCadastroFabricante;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonFotoMenos;
    private javax.swing.JButton jButtonFotoProxima;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonMaisTema;
    private javax.swing.JButton jButtonMaisTipo;
    private javax.swing.JComboBox<String> jComboBoxFabricantes;
    private javax.swing.JComboBox<String> jComboBoxTemas;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMiniatuas;
    private javax.swing.JTextField jTextFieldAno;
    private javax.swing.JTextField jTextFieldDescricao;
    private javax.swing.JTextField jTextFieldEdicao;
    private javax.swing.JTextField jTextFieldEscala;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldObeservacoes;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
