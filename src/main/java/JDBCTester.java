import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTester {
    public static void main(String[] args) {
        Connection conn;
        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://127.0.0.1:3308/users_db";
        try {
            conn = DriverManager.getConnection(url,user,password);
            if (!conn.isClosed()) {
                System.out.println("Connection is active " + conn.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
