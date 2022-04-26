package model.dbquery;

import aquality.selenium.core.logging.Logger;
import model.Project;
import utils.*;
import utils.enumfield.ProjectTableFieldEnum;
import java.sql.*;

public class ProjectTable {

    private static Connection conn = null;
    private static PreparedStatement ps;
    private static String query;

    public static void add(Project project) {
        try {
            Connection conn = DataBaseConnection.getConnection(Config.DB_HOST, Config.DB_PORT, Config.DB_NAME, Config.DB_USER, Config.DB_PASS);
            query = QueryManager.getParameterValue("addProject");
            ps = conn.prepareStatement(query);
            ps.setString(1, project.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getInstance().warn(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getInstance().warn(e.getMessage());
        } finally {
            DataBaseConnection.closeConnection(conn);
        }
    }

    public static Project get(String nameProject) {
        Project project = new Project();
        try {
            conn = DataBaseConnection.getConnection(Config.DB_HOST, Config.DB_PORT, Config.DB_NAME, Config.DB_USER, Config.DB_PASS);
            query = QueryManager.getParameterValue("getProject");
            ps = conn.prepareStatement(query);
            ps.setString(1, nameProject);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                project.setId(rs.getInt(ProjectTableFieldEnum.ID.getValue()));
                project.setName(rs.getString(ProjectTableFieldEnum.NAME.getValue()));
            }
        } catch (SQLException e) {
            Logger.getInstance().warn(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getInstance().warn(e.getMessage());
        } finally {
            DataBaseConnection.closeConnection(conn);
        }
        return project.isCurrentProjectNameExist();
    }
}
