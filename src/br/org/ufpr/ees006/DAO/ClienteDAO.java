package br.org.ufpr.ees006.DAO;

import br.org.ufpr.ees006.foundation.Cliente;
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
public class ClienteDAO {

  private final String insert = "INSERT INTO cliente (id,cpf,nome,sobrenome) VALUES (?,?,?,?)";
  private final String select = "SELECT * FROM cliente";
  private final String select_cpf = "SELECT * FROM cliente WHERE cpf = ?";
  private final String max = "SELECT MAX( id ) FROM cliente";
  private final String update = "UPDATE cliente SET cpf = ?, nome = ?, sobrenome = ? WHERE id = ?";
  private final String delete = "DELETE FROM cliente WHERE id = ?";
  private final String existOrder = "SELECT COUNT( * ) FROM pedido WHERE id_cliente = ?";

  private Connection connection = null;
  private PreparedStatement prepStatement = null;
  private ResultSet resultSet = null;

  public void insert(Cliente cliente) {

    try {

      this.connection = ConnectionFactory.getConnection();
      this.prepStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

      this.prepStatement.setInt(1, cliente.getId());
      this.prepStatement.setString(2, cliente.getCpf());
      this.prepStatement.setString(3, cliente.getNome());
      this.prepStatement.setString(4, cliente.getSobrenome());

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
  
  public Cliente getCliente(String cpf) throws SQLException {
    
    try {
      
      this.connection = ConnectionFactory.getConnection();
      this.prepStatement = connection.prepareStatement(select_cpf,Statement.RETURN_GENERATED_KEYS);
      this.prepStatement.setString(1, cpf);
      this.resultSet = this.prepStatement.executeQuery();

      Cliente cliente = new Cliente();
      
      while (this.resultSet.next()) {

        cliente.setId(this.resultSet.getInt(1));
        cliente.setCpf(this.resultSet.getString(2));
        cliente.setNome(this.resultSet.getString(3));
        cliente.setSobrenome(this.resultSet.getString(4));

      }

      return cliente;

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

  public List<Cliente> getList() throws SQLException {

    try {

      this.connection = ConnectionFactory.getConnection();
      this.prepStatement = connection.prepareStatement(select);
      this.resultSet = this.prepStatement.executeQuery();

      List<Cliente> clientes = new ArrayList();

      while (this.resultSet.next()) {

        Cliente cliente = new Cliente();

        cliente.setId(this.resultSet.getInt(1));
        cliente.setCpf(this.resultSet.getString(2));
        cliente.setNome(this.resultSet.getString(3));
        cliente.setSobrenome(this.resultSet.getString(4));

        clientes.add(cliente);

      }

      return clientes;

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

  public void update(Cliente cliente) throws SQLException {

    try {

      this.connection = ConnectionFactory.getConnection();
      this.prepStatement = connection.prepareStatement(this.update, Statement.RETURN_GENERATED_KEYS);

      this.prepStatement.setString(1, cliente.getCpf());
      this.prepStatement.setString(2, cliente.getNome());
      this.prepStatement.setString(3, cliente.getSobrenome());
      this.prepStatement.setInt(4, cliente.getId());

      this.prepStatement.executeUpdate();

    } finally {
      this.prepStatement.close();
    }

  }

  public void delete(Cliente cliente) throws SQLException {

    if (!hasAnyOrder()) {

      try {

        this.connection = ConnectionFactory.getConnection();
        this.prepStatement = this.connection.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);

        this.prepStatement.setInt(1, cliente.getId());
        this.prepStatement.executeUpdate();

      } finally {
        this.prepStatement.close();
      }

    } else {

      throw new RuntimeException("Impossível excluir este cliente, pois existe pedido associado.");

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

  private boolean hasAnyOrder() throws SQLException {

    boolean result = false;

    try {

      this.connection = ConnectionFactory.getConnection();
      this.prepStatement = this.connection.prepareStatement(existOrder);
      this.resultSet = this.prepStatement.executeQuery();

      if (this.resultSet.first()) {
        if (this.resultSet.getInt(1) >= 1) {
          result = true;
        }
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

    }

  }

}
