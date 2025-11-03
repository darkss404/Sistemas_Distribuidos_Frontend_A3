package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB {

    private static final String URL = "jdbc:mysql://localhost:3306/estoque?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USUARIO = "estoque";
    private static final String SENHA = "1234";

    public static Connection get() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver MySQL não encontrado.", e);
        }
    }

    public static PreparedStatement prepareStatement(String sql) throws SQLException {
        Connection conn = get();
        return conn.prepareStatement(sql);
    }
}
