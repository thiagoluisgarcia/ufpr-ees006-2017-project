package br.org.ufpr.ees006.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Thiago Luis Garcia
 */
public class ConnectionFactory {

  public static Connection getConnection() {
    try {
      
      Properties properties = new Properties();
      FileInputStream file = new FileInputStream("/config/config.properties");
      properties.load(file);
      file.close();
      
      String url = properties.getProperty("url");
      String username = properties.getProperty("username");
      String password = properties.getProperty("password");
      
      return DriverManager.getConnection(url, username, password);
      
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

}
