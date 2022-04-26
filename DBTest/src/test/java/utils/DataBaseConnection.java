package utils;

import aquality.selenium.core.logging.Logger;

import java.sql.*;

public class DataBaseConnection {

    private static Connection conn = null;
    private DataBaseConnection() {
    }

    public static Connection getConnection(String host, String port, String dbName, String user, String pass) throws SQLException, ClassNotFoundException {

        try {
            if (conn == null) {
                String url = String.format("jdbc:mysql://%s:%s/%s", host, port, dbName);
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, pass);
            }
        }catch (SQLException e){
            Logger.getInstance().warn(e.getMessage());
        }
        return conn;
    }

    public static void closeConnection(Connection conn)
    {
        try {
            if (conn != null) {
                conn.close();
                DataBaseConnection.conn = null;
            }
        } catch (SQLException e) {
            Logger.getInstance().warn(e.getMessage());
        }
    }
}