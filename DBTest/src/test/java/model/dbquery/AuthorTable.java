package model.dbquery;

import aquality.selenium.core.logging.Logger;
import model.Author;
import utils.enumfield.AuthorTableFieldEnum;
import utils.Config;
import utils.DataBaseConnection;
import utils.QueryManager;

import java.sql.*;

public class AuthorTable {

    private static Connection conn = null;
    private static PreparedStatement ps;
    private static String query;

    public static void add(Author author) {
        try {
            conn = DataBaseConnection.getConnection(Config.DB_HOST, Config.DB_PORT, Config.DB_NAME, Config.DB_USER, Config.DB_PASS);
            query = QueryManager.getParameterValue("addAuthor");
            ps = conn.prepareStatement(query);
            ps.setString(1, author.getName());
            ps.setString(2, author.getLogin());
            ps.setString(3, author.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getInstance().warn(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getInstance().warn(e.getMessage());
        } finally {
            DataBaseConnection.closeConnection(conn);
        }
    }

    public static Author get(String login) {
        Author author = new Author();
        try {
            conn = DataBaseConnection.getConnection(Config.DB_HOST, Config.DB_PORT, Config.DB_NAME, Config.DB_USER, Config.DB_PASS);
            query = QueryManager.getParameterValue("getAuthor");
            ps = conn.prepareStatement(query);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                author.setId(rs.getInt(AuthorTableFieldEnum.ID.getValue()));
                author.setName(rs.getString(AuthorTableFieldEnum.NAME.getValue()));
                author.setName(rs.getString(AuthorTableFieldEnum.LOGIN.getValue()));
                author.setEmail(rs.getString(AuthorTableFieldEnum.EMAIL.getValue()));
            }
        } catch (SQLException e) {
            Logger.getInstance().warn(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getInstance().warn(e.getMessage());
        } finally {
            DataBaseConnection.closeConnection(conn);
        }
        return author.isAuthorEmpty();
    }
}
