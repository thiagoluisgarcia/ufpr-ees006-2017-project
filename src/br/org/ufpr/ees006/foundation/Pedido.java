package br.org.ufpr.ees006.foundation;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Thiago Luis Garcia
 */
public class Pedido {

  private int id;
  private String data;
  private Cliente cliente;
  private List<ItemDoPedido> itens;
  
  public Pedido(int id, String data) {
    super();
    this.id = id;
    this.data = data;
  }
  
  public Pedido() {
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getData() {
    return this.data;
  }

  public void setData(String data) {
    this.data = data;
  }
  
  public Cliente getCliente() {
    return this.cliente;
  }
  
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
  
  public List<ItemDoPedido> getItens() {
      return this.itens;
  }
  
  public void setItens(List<ItemDoPedido> itens) {
      this.itens = itens;
  }

  public void setString(String string) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
}
