package br.org.ufpr.ees006.model;

import br.org.ufpr.ees006.foundation.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Thiago Luis Garcia
 */
public class ModelClienteTable extends AbstractTableModel {

  private String[] colunas;
  private List<Cliente> lista = new ArrayList();

  public ModelClienteTable(List<Cliente> lista) {
    this.colunas = new String[]{"Código", "CPF", "Nome", "Sobrenome"};
    this.lista = lista;
  }

  public ModelClienteTable() {
    this.colunas = new String[]{"Código", "CPF", "Nome", "Sobrenome"};
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
    Cliente cliente = lista.get(rowIndex);
    switch (columnIndex) {
      case 0:
        return cliente.getId();
      case 1:
        return cliente.getCpf();
      case 2:
        return cliente.getNome();
      case 3:
        return cliente.getSobrenome();
      default:
        return null;
    }

  }

  @Override
  public void setValueAt(Object value, int row, int col) {
    Cliente cliente = lista.get(row);
    switch (col) {
      case 0:
        cliente.setId((Integer) value);
        break;
      case 1:
        cliente.setCpf((String) value);
        break;
      case 2:
        cliente.setNome((String) value);
        break;
      case 3:
        cliente.setSobrenome((String) value);
        break;
      default:
    }
    this.fireTableCellUpdated(row, col);
  
  }
  
  public void setListClientes(List<Cliente> clientes) {
    this.lista = clientes;
    this.fireTableDataChanged();
  }

  
  public Cliente getCliente(int linha) {
    return lista.get(linha);
  }

  @Override
  public int getColumnCount() {
    return this.colunas.length;
  }

}
