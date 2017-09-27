package br.org.ufpr.ees006.model;

import br.org.ufpr.ees006.foundation.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Thiago Luis Garcia
 */
public class ModelPedidoCliente extends AbstractTableModel {
  
  private String[] colunas;
  private List<Pedido> lista = new ArrayList();

  public ModelPedidoCliente(List<Pedido> lista) {
    this.colunas = new String[]{"Código", "Data"};
    this.lista = lista;
  }
  
  public ModelPedidoCliente() {
    this.colunas = new String[]{"Código", "Data"};
  }

  @Override
  public int getRowCount() {
    return this.lista.size();
  }

  @Override
  public int getColumnCount() {
    return this.colunas.length; 
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Pedido pedido = lista.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return pedido.getId();
      case 1:
        return pedido.getData();
      default:
        return null;
    } 
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
  
  public void setListPedidos(List<Pedido> pedidos) {
    this.lista = pedidos;
    this.fireTableDataChanged();
  }
  
  public Pedido getPedido(int linha) {
    return lista.get(linha);
  }
  
}
