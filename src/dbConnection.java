import javax.swing.plaf.nimbus.State;
import java.sql.*;


public class dbConnection {
    private final String JDBC_Driver = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/quiz?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Warsaw";

    static final String USER = "root";
    static final String PASS = "password";

    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            return conn;
        } catch (ClassNotFoundException e) {
            e.getMessage();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public static void close(){
        try {
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {
            e.getMessage();
        }
    }


}
