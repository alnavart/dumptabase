package org.alnavart.dumptabase.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
  private static String DB_URL = "jdbc:h2://localhost:3307/dumptabase-sample";
  private static String DB_USER = "root";
  private static String DB_PASSWORD = "root";

  public static Connection getConnection() throws SQLException
  {
    Connection connection = DriverManager.getConnection(DB_URL, DB_USER,
                                                        DB_PASSWORD);
    System.err.println("The connection is successfully obtained");
    return connection;
  }
}
