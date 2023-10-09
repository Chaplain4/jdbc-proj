import java.sql.*;

public class JDBCTester {
    public static void main(String[] args) {

        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://127.0.0.1:3308/users_db";
        try (Connection conn = DriverManager.getConnection(url, user, password); Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users_db.employees")){
            if (!conn.isClosed()) {
                System.out.println("Connection is active " + conn.toString());
            }
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString(2);
                String lname = rs.getString(3);
                System.out.println(String.format("ROW : id : %d, name : %s, lastname : %s, created at : %s", id, name, lname, rs.getTimestamp(8)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}