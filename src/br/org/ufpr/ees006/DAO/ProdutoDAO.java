package br.org.ufpr.ees006.DAO;

import br.org.ufpr.ees006.foundation.Produto;
import br.org.ufpr.ees006.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago Luis Garcia
 */
public class ProdutoDAO {

  private final String insert = "INSERT INTO produto (id,descricao) VALUES (?,?)";
  private final String select = "SELECT * FROM produto";
  private final String select_single = "SELECT * from produto WHERE id = ?";
  private final String max = "SELECT MAX( id ) FROM produto";
  private final String update = "UPDATE produto SET descricao = ? WHERE id = ?";
  private final String delete = "DELETE FROM produto WHERE id = ?";

  private Connection connection = null;
  private PreparedStatement prepStatement = null;
  private ResultSet resultSet = null;
  
  public Produto getProduto(int id) {
    
    try {

      this.connection = ConnectionFactory.getConnection();
      this.prepStatement = connection.prepareStatement(select_single, Statement.RETURN_GENERATED_KEYS);
      this.prepStatement.setInt(1, id);
      this.resultSet = this.prepStatement.executeQuery();

      Produto produto = new Produto();

      while (this.resultSet.next()) {    

        produto.setId(this.resultSet.getInt(1));
        produto.setDescricao(this.resultSet.getString(2));

      }

      return produto;

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

  public void insert(Produto produto) {

    try {

      this.connection = ConnectionFactory.getConnection();
      this.prepStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

      this.prepStatement.setInt(1, produto.getId());
      this.prepStatement.setString(2, produto.getDescricao());

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

  public List<Produto> getList() throws SQLException {

    try {

      this.connection = ConnectionFactory.getConnection();
      this.prepStatement = connection.prepareStatement(select);
      this.resultSet = this.prepStatement.executeQuery();

      List<Produto> produtos = new ArrayList();

      while (this.resultSet.next()) {

        Produto produto = new Produto();

        produto.setId(this.resultSet.getInt(1));
        produto.setDescricao(this.resultSet.getString(2));

        produtos.add(produto);

      }

      return produtos;

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

  public void update(Produto produto) throws SQLException {

    try {

      this.connection = ConnectionFactory.getConnection();
      this.prepStatement = connection.prepareStatement(this.update, Statement.RETURN_GENERATED_KEYS);

      this.prepStatement.setString(1, produto.getDescricao());
      this.prepStatement.setInt(2, produto.getId());

      this.prepStatement.executeUpdate();

    } finally {
      this.prepStatement.close();
    }

  }

  public void delete(Produto produto) throws SQLException {

    try {

      this.connection = ConnectionFactory.getConnection();
      this.prepStatement = this.connection.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);

      this.prepStatement.setInt(1, produto.getId());
      this.prepStatement.executeUpdate();

    } finally {
      this.prepStatement.close();
    }

  }

  public int getMax() throws SQLException {

    int result = 0;

    try {

      this.connection = ConnectionFactory.getConnection();
      this.prepStatement = this.connection.prepareStatement(max);
      this.resultSet = this.prepStatement.executeQuery();

      if (this.resultSet.first()) {
        result = this.resultSet.getInt(1) + 1;
      }

      return result;

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
