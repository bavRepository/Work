package model.dbquery;

import aquality.selenium.core.logging.Logger;
import model.Test;
import utils.*;
import utils.enumfield.TestTableFieldEnum;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestTable {

    private static Connection conn = null;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static String query;
    private static int queryResult;
    private static List<Test> tests;

    public static boolean add(Test test) {
        try {
            conn = DataBaseConnection.getConnection(Config.DB_HOST, Config.DB_PORT, Config.DB_NAME, Config.DB_USER, Config.DB_PASS);
            query = QueryManager.getParameterValue("addTest");
            ps = conn.prepareStatement(query);
            ps.setString(1, test.getName());
            ps.setInt(2, test.getStatus_id());
            ps.setString(3, test.getMethod_name());
            ps.setInt(4, test.getProject_id());
            ps.setInt(5, test.getSession_id());
            ps.setString(6, test.getStart_time());
            ps.setString(7, test.getEnd_time());
            ps.setString(8, test.getEnv());
            ps.setString(9, test.getBrowser());
            ps.setInt(10, test.getAuthor_id());
            queryResult = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getInstance().warn(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getInstance().warn(e.getMessage());
        } finally {
            DataBaseConnection.closeConnection(conn);
        }
        return queryResult > 0;
    }

    public static List<Test> getTestsIdMatch(int idMatch) {
        try {
            conn = DataBaseConnection.getConnection(Config.DB_HOST, Config.DB_PORT, Config.DB_NAME, Config.DB_USER, Config.DB_PASS);
            query = String.format(QueryManager.getParameterValue("getTests"), idMatch, idMatch, TestData.COUNT_TEST);
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(query);
            tests = new ArrayList();

            while (rs.next()) {
                Test test = new Test();
                test.setId(rs.getInt(TestTableFieldEnum.ID.getValue()));
                test.setName(rs.getString(TestTableFieldEnum.NAME.getValue()));
                test.setStatus_id(rs.getInt(TestTableFieldEnum.STATUS_ID.getValue()));
                test.setMethod_name(rs.getString(TestTableFieldEnum.METHOD_NAME.getValue()));
                test.setProject_id(rs.getInt(TestTableFieldEnum.PROJECT_ID.getValue()));
                test.setSession_id(rs.getInt(TestTableFieldEnum.SESSION_ID.getValue()));
                test.setStart_time(rs.getString(TestTableFieldEnum.START_TIME.getValue()));
                test.setEnd_time(rs.getString(TestTableFieldEnum.END_TIME.getValue()));
                test.setEnv(rs.getString(TestTableFieldEnum.ENV.getValue()));
                test.setBrowser(rs.getString(TestTableFieldEnum.BROWSER.getValue()));
                test.setAuthor_id(rs.getInt(TestTableFieldEnum.AUTHOR_ID.getValue()));
                tests.add(test);
            }
        } catch (SQLException e) {
            Logger.getInstance().warn(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getInstance().warn(e.getMessage());
        } finally {
            DataBaseConnection.closeConnection(conn);
        }
        return tests;
    }

    public static List<Test> getTestsIdRange(int idRange) {
        try {
            conn = DataBaseConnection.getConnection(Config.DB_HOST, Config.DB_PORT, Config.DB_NAME, Config.DB_USER, Config.DB_PASS);
            query = QueryManager.getParameterValue("getTestsIdRange");
            ps = conn.prepareStatement(query);
            ps.setInt(1, idRange);
            rs = ps.executeQuery();
            tests = new ArrayList();

            while (rs.next()) {
                Test test = new Test();
                test.setId(rs.getInt(TestTableFieldEnum.ID.getValue()));
                test.setName(rs.getString(TestTableFieldEnum.NAME.getValue()));
                test.setStatus_id(rs.getInt(TestTableFieldEnum.STATUS_ID.getValue()));
                test.setMethod_name(rs.getString(TestTableFieldEnum.METHOD_NAME.getValue()));
                test.setProject_id(rs.getInt(TestTableFieldEnum.PROJECT_ID.getValue()));
                test.setSession_id(rs.getInt(TestTableFieldEnum.SESSION_ID.getValue()));
                test.setStart_time(rs.getString(TestTableFieldEnum.START_TIME.getValue()));
                test.setEnd_time(rs.getString(TestTableFieldEnum.END_TIME.getValue()));
                test.setEnv(rs.getString(TestTableFieldEnum.ENV.getValue()));
                test.setBrowser(rs.getString(TestTableFieldEnum.BROWSER.getValue()));
                test.setAuthor_id(rs.getInt(TestTableFieldEnum.AUTHOR_ID.getValue()));
                tests.add(test);
            }
        } catch (SQLException e) {
            Logger.getInstance().warn(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getInstance().warn(e.getMessage());
        } finally {
            DataBaseConnection.closeConnection(conn);
        }
        return tests;
    }

    public static boolean update(Test test) {
        try {
            conn = DataBaseConnection.getConnection(Config.DB_HOST, Config.DB_PORT, Config.DB_NAME, Config.DB_USER, Config.DB_PASS);
            query = QueryManager.getParameterValue("updateTest");
            ps = conn.prepareStatement(query);
            ps.setInt(1, test.getStatus_id());
            ps.setString(2, test.getStart_time());
            ps.setString(3, test.getEnd_time());
            ps.setString(4, test.getEnv());
            ps.setString(5, test.getBrowser());
            ps.setInt(6, test.getId());
            queryResult = ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getInstance().warn(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getInstance().warn(e.getMessage());
        } finally {
            DataBaseConnection.closeConnection(conn);
        }
        return queryResult > 0;
    }

    public static boolean delete(Test test) {
        try {
            conn = DataBaseConnection.getConnection(Config.DB_HOST, Config.DB_PORT, Config.DB_NAME, Config.DB_USER, Config.DB_PASS);
            query = QueryManager.getParameterValue("deleteTest");
            ps = conn.prepareStatement(query);
            ps.setInt(1, test.getId());
            queryResult = ps.executeUpdate();

        } catch (SQLException e) {
            Logger.getInstance().warn(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getInstance().warn(e.getMessage());
        } finally {
            DataBaseConnection.closeConnection(conn);
        }
        return queryResult > 0;
    }
}