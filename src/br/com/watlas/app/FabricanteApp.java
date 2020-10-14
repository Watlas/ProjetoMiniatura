/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.watlas.app;

/**
 * @author watla
 */

import br.com.watlas.bll.FabricanteBll;

import br.com.watlas.model.Fabricante;

import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class FabricanteApp extends javax.swing.JDialog {

    /**
     * Creates new form FabricanteApp
     */
    //ATRIBUTOS 
    private Fabricante objetoFab;
    private FabricanteBll fabricanteBll;

    private void atualizarGrid() throws Exception {
        DefaultTableModel model = (DefaultTableModel) jTableFabricantes.getModel();
        model.setRowCount(0);
        Object[] linha;

        List<Fabricante> fab = fabricanteBll.getallFabricante();
        for (Fabricante tipo : fab) {
            linha = new Object[]{
                    tipo.getFab_iden(),
                    tipo.getFab_nome()};
            model.addRow(linha);

        }
    }

    private void atualizarGridAlfa() throws Exception {
        DefaultTableModel model = (DefaultTableModel) jTableFabricantes.getModel();
        model.setRowCount(0);
        Object[] linha;

        List<Fabricante> fab = fabricanteBll.getallFabricanteAlfa();
        for (Fabricante tipo : fab) {
            linha = new Object[]{
                    tipo.getFab_iden(),
                    tipo.getFab_nome()};
            model.addRow(linha);

        }
    }

    private void instaciaOb() throws Exception {
        fabricanteBll = new FabricanteBll();

        objetoFab = new Fabricante();
    }

    private void limparCampo() {
        jTextFieldNomeFabricante.setText("");

    }

    public FabricanteApp(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            instaciaOb();
            atualizarGrid();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(parent, "deu erro ai mano");
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

        jLabel2 = new javax.swing.JLabel();
        jTextFieldNomeFabricante = new javax.swing.JTextField();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonIncluir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFabricantes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FABRICANTES");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(600, 500));

        jLabel2.setText("NOME");

        jButtonAlterar.setBackground(new java.awt.Color(0, 51, 102));
        jButtonAlterar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButtonAlterar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAlterar.setText("ALTERAR");
        jButtonAlterar.setBorderPainted(false);
        jButtonAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAlterarMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonAlterarMouseExited(evt);
            }
        });
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonExcluir.setBackground(new java.awt.Color(0, 51, 102));
        jButtonExcluir.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButtonExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExcluir.setText("EXCLUIR");
        jButtonExcluir.setBorderPainted(false);
        jButtonExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonExcluirMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonExcluirMouseExited(evt);
            }
        });
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonIncluir.setBackground(new java.awt.Color(0, 51, 102));
        jButtonIncluir.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButtonIncluir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonIncluir.setText("INCLUIR");
        jButtonIncluir.setBorderPainted(false);
        jButtonIncluir.setFocusPainted(false);
        jButtonIncluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonIncluirMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonIncluirMouseExited(evt);
            }
        });
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 51, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ORDERNAR");
        jButton1.setToolTipText("");
        jButton1.setFocusPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setForeground(new java.awt.Color(204, 51, 255));
        jScrollPane1.setMaximumSize(new java.awt.Dimension(500, 500));

        jTableFabricantes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTableFabricantes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "ID", "NOME"
                }
        ));
        jTableFabricantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableFabricantesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFabricantes);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FABRICANTES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldNomeFabricante)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomeFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonIncluir)
                                        .addComponent(jButtonExcluir)
                                        .addComponent(jButtonAlterar)
                                        .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        try {

            int id = Integer.parseInt(jTableFabricantes.getValueAt(jTableFabricantes.getSelectedRow(), 0).toString());
            objetoFab.setFab_iden(id);
            objetoFab.setFab_nome(jTextFieldNomeFabricante.getText());
            fabricanteBll.updateFabricante(objetoFab);

            limparCampo();
            atualizarGrid();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        try {
            int id = Integer.parseInt(jTableFabricantes.getValueAt(jTableFabricantes.getSelectedRow(), 0).toString());
            fabricanteBll.deleteFabrica(id);
            atualizarGrid();
            limparCampo();
            JOptionPane.showMessageDialog(this, "Excluido com exito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
        try {
            objetoFab.setFab_nome(jTextFieldNomeFabricante.getText().toLowerCase());
            fabricanteBll.addFabrica(objetoFab);

            atualizarGrid();
            limparCampo();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            atualizarGridAlfa();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableFabricantesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFabricantesMouseReleased
        jTextFieldNomeFabricante.setText(jTableFabricantes.getValueAt(jTableFabricantes.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_jTableFabricantesMouseReleased

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setBackground(new Color(56, 65, 84));
        jButton1.setForeground(new Color(58, 65, 80));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setBackground(new Color(0, 51, 102));
        jButton1.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButtonAlterarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAlterarMouseEntered
        jButtonAlterar.setBackground(new Color(56, 65, 84));
        jButtonAlterar.setForeground(new Color(58, 65, 80));
    }//GEN-LAST:event_jButtonAlterarMouseEntered

    private void jButtonExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExcluirMouseEntered
        jButtonExcluir.setBackground(new Color(56, 65, 84));
        jButtonExcluir.setForeground(new Color(58, 65, 80));
    }//GEN-LAST:event_jButtonExcluirMouseEntered

    private void jButtonIncluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonIncluirMouseEntered
        jButtonIncluir.setBackground(new Color(56, 65, 84));
        jButtonIncluir.setForeground(new Color(58, 65, 80));
    }//GEN-LAST:event_jButtonIncluirMouseEntered

    private void jButtonAlterarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAlterarMouseExited
        jButtonAlterar.setBackground(new Color(0, 51, 102));
        jButtonAlterar.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButtonAlterarMouseExited

    private void jButtonExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExcluirMouseExited
        jButtonExcluir.setBackground(new Color(0, 51, 102));
        jButtonExcluir.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButtonExcluirMouseExited

    private void jButtonIncluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonIncluirMouseExited
        jButtonIncluir.setBackground(new Color(0, 51, 102));
        jButtonIncluir.setForeground(Color.WHITE);
    }//GEN-LAST:event_jButtonIncluirMouseExited

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
            java.util.logging.Logger.getLogger(FabricanteApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FabricanteApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FabricanteApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FabricanteApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FabricanteApp dialog = new FabricanteApp(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFabricantes;
    private javax.swing.JTextField jTextFieldNomeFabricante;
    // End of variables declaration//GEN-END:variables
}
