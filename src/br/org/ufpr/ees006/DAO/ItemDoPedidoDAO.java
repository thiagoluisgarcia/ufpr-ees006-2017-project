/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ufpr.ees006.DAO;

import br.org.ufpr.ees006.connection.ConnectionFactory;
import br.org.ufpr.ees006.foundation.ItemDoPedido;
import br.org.ufpr.ees006.foundation.Pedido;
import br.org.ufpr.ees006.foundation.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago Luis Garcia
 */
public class ItemDoPedidoDAO {
  
  private final String insert = "INSERT INTO item_do_pedido (id_pedido,id_produto,qtdade) VALUES (?,?,?)";
  private final String select = "SELECT produto.descricao, item.qtdade FROM item_do_pedido AS item INNER JOIN pedido AS pedido ON pedido.id = item.id_pedido INNER JOIN produto AS produto ON produto.id = item.id_produto WHERE pedido.id = ?";
  
  private Connection connection = null;
  private PreparedStatement prepStatement = null;
  private ResultSet resultSet = null;
  
  public void insert(ItemDoPedido item) {
    
    try {

      this.connection = ConnectionFactory.getConnection();
      this.prepStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

      this.prepStatement.setInt(1, 1);
      this.prepStatement.setInt(2, item.getProduto().getId());
      this.prepStatement.setInt(3, item.getQtdade());

      this.prepStatement.execute();

      this.prepStatement.getGeneratedKeys();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {

      try {
        prepStatement.close();
      } catch (SQLException ex) {
        throw new RuntimeException("Falha ao fechar sentença.");
      }

      try {
        connection.close();
      } catch (SQLException ex) {
        throw new RuntimeException("Falha ao fechar conexão.");
      }

    }
    
  }
  
  public List<ItemDoPedido> getList(int id_pedido) throws SQLException {

    try {

      this.connection = ConnectionFactory.getConnection();
      this.prepStatement = connection.prepareStatement(select, Statement.RETURN_GENERATED_KEYS);
      this.prepStatement.setInt(1, id_pedido);
      this.resultSet = this.prepStatement.executeQuery();
      
      List<ItemDoPedido> itens = new ArrayList();

      while (this.resultSet.next()) {

        ItemDoPedido item = new ItemDoPedido();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        item.setProduto(produtoDAO.getProduto(id_pedido));
        item.setQtdade(this.resultSet.getInt(2));

        itens.add(item);

      }

      return itens;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {

      try {
        prepStatement.close();
      } catch (SQLException ex) {
        throw new RuntimeException("Falha ao fechar sentença.");
      }

      try {
        connection.close();
      } catch (SQLException ex) {
        throw new RuntimeException("Falha ao fechar conexão.");
      }

    }

  }
    
}
