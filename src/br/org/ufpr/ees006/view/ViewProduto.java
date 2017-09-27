/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ufpr.ees006.view;

import br.org.ufpr.ees006.DAO.ProdutoDAO;
import br.org.ufpr.ees006.model.ModelProdutoTable;
import br.org.ufpr.ees006.foundation.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Thiago Luis Garcia
 */
public class ViewProduto extends javax.swing.JDialog {

  private ModelProdutoTable modelProduto;
  private int clickedLine = -1;

  public ViewProduto() {
    modelProduto = new ModelProdutoTable();
    initComponents();
    listarProduto();
  }

  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    fieldCodigo = new javax.swing.JTextField();
    fieldDescricao = new javax.swing.JTextField();
    btNovo = new javax.swing.JButton();
    btAtualizar = new javax.swing.JButton();
    btExcluir = new javax.swing.JButton();
    jScrollPane = new javax.swing.JScrollPane(tableProduto);
    tableProduto = new javax.swing.JTable();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Manter Produto");
    setMinimumSize(new java.awt.Dimension(620, 408));
    setPreferredSize(new java.awt.Dimension(620, 408));
    setResizable(false);

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel1.setText("Produto");

    jLabel2.setText("Código:");

    jLabel3.setText("Descrição:");

    fieldCodigo.setEditable(false);
    fieldCodigo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        fieldCodigoActionPerformed(evt);
      }
    });

    btNovo.setText("Novo");
    btNovo.setMaximumSize(new java.awt.Dimension(75, 25));
    btNovo.setMinimumSize(new java.awt.Dimension(75, 25));
    btNovo.setPreferredSize(new java.awt.Dimension(75, 25));
    btNovo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btNovoActionPerformed(evt);
      }
    });

    btAtualizar.setText("Atualizar");
    btAtualizar.setMaximumSize(new java.awt.Dimension(75, 25));
    btAtualizar.setMinimumSize(new java.awt.Dimension(75, 25));
    btAtualizar.setPreferredSize(new java.awt.Dimension(75, 25));
    btAtualizar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btAtualizarActionPerformed(evt);
      }
    });

    btExcluir.setText("Excluir");
    btExcluir.setMaximumSize(new java.awt.Dimension(75, 25));
    btExcluir.setMinimumSize(new java.awt.Dimension(75, 25));
    btExcluir.setPreferredSize(new java.awt.Dimension(75, 25));
    btExcluir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btExcluirActionPerformed(evt);
      }
    });

    tableProduto.setModel(modelProduto);
    tableProduto.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
    tableProduto.setColumnSelectionAllowed(true);
    tableProduto.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tableProdutoMouseClicked(evt);
      }
    });
    jScrollPane.setViewportView(tableProduto);
    tableProduto.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(layout.createSequentialGroup()
        .add(10, 10, 10)
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
          .add(jLabel1)
          .add(layout.createSequentialGroup()
            .add(jLabel2)
            .add(23, 23, 23)
            .add(fieldCodigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 78, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
          .add(layout.createSequentialGroup()
            .add(jLabel3)
            .add(10, 10, 10)
            .add(fieldDescricao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 177, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
          .add(jScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 581, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
          .add(layout.createSequentialGroup()
            .add(btNovo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(btAtualizar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(btExcluir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(359, 359, 359))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(layout.createSequentialGroup()
        .add(11, 11, 11)
        .add(jLabel1)
        .add(18, 18, 18)
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(jLabel2)
          .add(fieldCodigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        .add(6, 6, 6)
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
          .add(layout.createSequentialGroup()
            .add(3, 3, 3)
            .add(jLabel3))
          .add(fieldDescricao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        .add(6, 6, 6)
        .add(jScrollPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        .add(6, 6, 6)
        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(btAtualizar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .add(btExcluir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
          .add(btNovo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

    private void fieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodigoActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_fieldCodigoActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed

      Produto produto = new Produto();
      ProdutoDAO produtoDAO = new ProdutoDAO();

      try {

        produto.setId(produtoDAO.getMax());
        produto.setDescricao(fieldDescricao.getText());

        produtoDAO.insert(produto);

      } catch (Exception ex) {

        JOptionPane.showMessageDialog(null, "Erro ao inserir no banco de dados. E=" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

      }

      listarProduto();

    }//GEN-LAST:event_btNovoActionPerformed

  private void listarProduto() {

    try {

      ProdutoDAO produtoDAO = new ProdutoDAO();

      List<Produto> listProduto;
      listProduto = produtoDAO.getList();
      modelProduto.setListProdutos(listProduto);

    } catch (Exception ex) {

      JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);

    }

    clearScreen();

  }

  private void clearScreen() {

    this.fieldCodigo.setText("");
    this.fieldDescricao.setText("");

  }

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed

      if (clickedLine != -1) {

        Produto produto = modelProduto.getProduto(clickedLine);

        produto.setDescricao(fieldDescricao.getText());

        ProdutoDAO dao = null;

        try {

          dao = new ProdutoDAO();
          dao.update(produto);

        } catch (Exception ex) {

          JOptionPane.showMessageDialog(null, "Erro ao atualizar no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);

        }

        listarProduto();

      }

    }//GEN-LAST:event_btAtualizarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

      try {

        ProdutoDAO dao = new ProdutoDAO();

        int[] selectedRows = tableProduto.getSelectedRows();

        List<Produto> toDelList = new ArrayList();

        for (int i = 0; i < selectedRows.length; i++) {

          Produto produto = modelProduto.getProduto(selectedRows[i]);
          dao.delete(produto);
          toDelList.add(produto);

        }

        listarProduto();

      } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Erro ao realizar exclusão de Produto", "Erro", JOptionPane.ERROR_MESSAGE);
      }

    }//GEN-LAST:event_btExcluirActionPerformed

    private void tableProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProdutoMouseClicked

      clickedLine = tableProduto.rowAtPoint(evt.getPoint());

      Produto produto = modelProduto.getProduto(clickedLine);

      this.fieldCodigo.setText(String.valueOf(produto.getId()));
      this.fieldDescricao.setText(produto.getDescricao());

    }//GEN-LAST:event_tableProdutoMouseClicked

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
        if ("Windows".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(ViewProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(ViewProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(ViewProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(ViewProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new ViewProduto().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btAtualizar;
  private javax.swing.JButton btExcluir;
  private javax.swing.JButton btNovo;
  private javax.swing.JTextField fieldCodigo;
  private javax.swing.JTextField fieldDescricao;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JScrollPane jScrollPane;
  private javax.swing.JTable tableProduto;
  // End of variables declaration//GEN-END:variables
}
