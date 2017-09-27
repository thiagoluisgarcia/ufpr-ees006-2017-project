package br.org.ufpr.ees006.foundation;

/**
 *
 * @author Thiago Luis Garcia
 */
public class Produto {

  private int id;
  private String descricao;

  public Produto(int id, String descricao) {
    super();
    this.id = id;
    this.descricao = descricao;
  }

  public Produto() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

}
