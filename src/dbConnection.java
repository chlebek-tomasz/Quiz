import java.sql.*;


public class dbConnection {
    private final String JDBC_Driver = "com.mysql..jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/quiz?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Warsaw";

    static final String USER = "root";
    static final String PASS = "password";

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public boolean open(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            return true;
        } catch (ClassNotFoundException e) {
            e.getMessage();
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void close(){
        try {
            if (conn != null) {
                conn.close();
            }

            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public String[] executeQuery(int q_id){
        String[] questions = new String[6];
        if(open()) {
            try {
                rs = stmt.executeQuery("SELECT question, answer1, answer2, answer3, answer4, correctAnswer FROM questions WHERE id="+q_id);
                while (rs.next()){
                    questions[0] = rs.getString("question");
                    questions[1] = rs.getString("answer1");
                    questions[2] = rs.getString("answer2");
                    questions[3] = rs.getString("answer3");
                    questions[4] = rs.getString("answer4");
                    questions[5] = rs.getString("correctAnswer");
                }
            } catch (SQLException e){
                e.getMessage();
            } finally {
                try{
                    close();
                    if(rs != null){
                    rs.close();}
                } catch (SQLException e){
                    e.getMessage();
                }
            }
        }
        return questions;
    }

    public int executeQuery(){
        int howMany = 0;
        if(open()) {
            try {
                rs = stmt.executeQuery("SELECT id FROM questions");
                while (rs.next()){
                    howMany++;
                }
            } catch (SQLException e){
                e.getMessage();
            } finally {
                try{
                    close();
                    if(rs != null){
                        rs.close();}
                } catch (SQLException e){
                    e.getMessage();
                }
            }
        }
        return howMany;
    }


}
