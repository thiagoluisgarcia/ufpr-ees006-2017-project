package br.org.ufpr.ees006.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thiago Luis Garcia
 */
public class ConnectionFactory {

  public static Connection getConnection() {
    try {
      return DriverManager.getConnection("jdbc:mysql://localhost:3306/javabasic", "root", "1234");
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

}
