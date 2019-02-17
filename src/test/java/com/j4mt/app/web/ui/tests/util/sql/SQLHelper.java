package com.j4mt.app.web.ui.tests.util.sql;

import java.sql.*;

public class SQLHelper {

    public static Connection sqlConn(String dbType) throws ClassNotFoundException, SQLException {
        String username;
        String password;
        String dbUrl = "";
        if(dbType.equals("")) {
            username = System.getenv("USERNAME");
            password = System.getenv("PASSWORD");
        }else{
            username = System.getenv("USERNAME");
            password = System.getenv("PASSWORD");
        }
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        return con;
    }

    public static void sqlCheck(String queryString, String dbType) throws SQLException, ClassNotFoundException {
        Connection conn = sqlConn(dbType);
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(queryString);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
