package br.org.ufpr.ees006.DAO;

import br.org.ufpr.ees006.connection.ConnectionFactory;
import br.org.ufpr.ees006.foundation.Cliente;
import br.org.ufpr.ees006.foundation.Pedido;
import java.sql.Connection;
import java.sql.Date;
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
public class PedidoDAO {
  
  private final String insert = "INSERT INTO pedido (id,data,id_cliente) VALUES (?,?,?)";
  private final String select = "SELECT pedido.id, pedido.data FROM pedido AS pedido INNER JOIN cliente AS cliente ON pedido.id_cliente = cliente.id WHERE cpf = ?";
  private final String max = "SELECT MAX( id ) FROM pedido";

  private Connection connection = null;
  private PreparedStatement prepStatement = null;
  private ResultSet resultSet = null;
  
  public void insert(Pedido pedido) {
    
    try {

      this.connection = ConnectionFactory.getConnection();
      this.prepStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
      
      this.prepStatement.setInt(1, pedido.getId());
      this.prepStatement.setDate(2, (Date) pedido.getData());
      this.prepStatement.setInt(3, pedido.getCliente().getId());

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
  
  public List<Pedido> getList(String cpf) throws SQLException {

    try {

      this.connection = ConnectionFactory.getConnection();
      this.prepStatement = connection.prepareStatement(select, Statement.RETURN_GENERATED_KEYS);
      
      ClienteDAO clienteDAO = new ClienteDAO();
      
      this.prepStatement.setString(1, cpf);
      this.resultSet = this.prepStatement.executeQuery();

      List<Pedido> pedidos = new ArrayList();

      while (this.resultSet.next()) {

        Pedido pedido = new Pedido();
      
        pedido.setId(this.resultSet.getInt(1));
        pedido.setData(this.resultSet.getDate(2));
        pedido.setCliente(clienteDAO.getCliente(cpf));
        
        ItemDoPedidoDAO itemDAO = new ItemDoPedidoDAO();
        itemDAO.getList(pedido.getId());

        pedidos.add(pedido);

      }

      return pedidos;

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
