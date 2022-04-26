package model.dbquery;

import aquality.selenium.core.logging.Logger;
import model.Status;
import utils.*;
import utils.enumfield.StatusTableFieldEnum;
import java.sql.*;

public class StatusTable {

    private static Connection conn;

    public static Status get() {
        Status status = new Status();
        try {
            conn = DataBaseConnection.getConnection(Config.DB_HOST, Config.DB_PORT, Config.DB_NAME, Config.DB_USER, Config.DB_PASS);
            String query = QueryManager.getParameterValue("getStatus");
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, TestData.STATUS_ID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                status.setId(rs.getInt(StatusTableFieldEnum.ID.getValue()));
                status.setName(rs.getString(StatusTableFieldEnum.NAME.getValue()));
            }
        } catch (SQLException e) {
            Logger.getInstance().warn(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getInstance().warn(e.getMessage());
        } finally {
            DataBaseConnection.closeConnection(conn);
        }
        return status;
    }
}
