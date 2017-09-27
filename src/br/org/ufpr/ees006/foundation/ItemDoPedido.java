package br.org.ufpr.ees006.foundation;

import java.util.List;

/**
 *
 * @author Thiago Luis Garcia
 */
public class ItemDoPedido {

  private Produto produto;
  private int qtdade;

  public ItemDoPedido() {

  }

  public ItemDoPedido(Produto produto, int qtdade) {
    super();
    this.produto = produto;
    this.qtdade = qtdade;
  }

  public int getQtdade() {
    return this.qtdade;
  }

  public void setQtdade(int qtdade) {
    this.qtdade = qtdade;
  }

  public Produto getProduto() {
    return this.produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

}
