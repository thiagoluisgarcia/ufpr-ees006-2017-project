package br.org.ufpr.ees006.model;

import br.org.ufpr.ees006.foundation.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Thiago Luis Garcia
 */
public class ModelProdutoTable extends AbstractTableModel {

  private String[] colunas;
  private List<Produto> lista = new ArrayList();

  public ModelProdutoTable(List<Produto> lista) {
    this.colunas = new String[]{"Código", "Descrição"};
    this.lista = lista;
  }

  public ModelProdutoTable() {
    this.colunas = new String[]{"Código", "Descrição"};
  }

  @Override
  public int getRowCount() {
    return this.lista.size();
  }

  @Override
  public String getColumnName(int index) {
    return this.colunas[index];
  }

  @Override
  public boolean isCellEditable(int row, int column) {
    return false;
    //if(column==0)
    //return false;
    //return true;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Produto produto = lista.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return produto.getId();
      case 1:
        return produto.getDescricao();
      default:
        return null;
    }
  }

  @Override
  public void setValueAt(Object value, int row, int col) {
    Produto produto = lista.get(row);
    switch (col) {
      case 0:
        produto.setId((Integer) value);
        break;
      case 1:
        produto.setDescricao((String) value);
        break;
      default:
    }
    this.fireTableCellUpdated(row, col);
  }

  public void setListProdutos(List<Produto> produtos) {
    this.lista = produtos;
    this.fireTableDataChanged();
  }

  
  public Produto getProduto(int linha) {
    return lista.get(linha);
  }

  @Override
  public int getColumnCount() {
    return this.colunas.length;
  }

}
