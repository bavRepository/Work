package model.dbquery;

import aquality.selenium.core.logging.Logger;
import model.Session;
import utils.Config;
import utils.DataBaseConnection;
import utils.QueryManager;
import utils.TestData;
import utils.enumfield.SessionTableFieldEnum;

import java.sql.*;

public class SessionTable {

    private static Connection conn = null;

    public static Session get() {
        Session session = new Session();
        try {
        conn = DataBaseConnection.getConnection(Config.DB_HOST, Config.DB_PORT, Config.DB_NAME, Config.DB_USER, Config.DB_PASS);
        String query = QueryManager.getParameterValue("getSession");
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, TestData.SESSION_ID);
            ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            session.setId(rs.getInt(SessionTableFieldEnum.ID.getValue()));
            session.setSession_key(rs.getString(SessionTableFieldEnum.SESSION_KEY.getValue()));
            session.setCreated_time(rs.getString(SessionTableFieldEnum.CREATED_TIME.getValue()));
            session.setBuild_number(rs.getInt(SessionTableFieldEnum.BUILD_NUMBER.getValue()));
        }
        } catch (SQLException e) {
            Logger.getInstance().warn(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getInstance().warn(e.getMessage());
        } finally {
            DataBaseConnection.closeConnection(conn);
        }
        return session;
    }
}
