import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbQuery {
    private static Connection conn = dbConnection.getConnection();
    private static Statement stmt = null;
    private static ResultSet rs = null;

    //funkcja zwraca tablice z pytaniami z DB
    public static String[] questionsQuery(int q_id){
        isClosed();
        String[] questions = new String[6];
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT question, answer1, answer2, answer3, answer4, correctAnswer FROM questions WHERE id=" + q_id);
            while (rs.next()) {
                questions[0] = rs.getString("question");
                questions[1] = rs.getString("answer1");
                questions[2] = rs.getString("answer2");
                questions[3] = rs.getString("answer3");
                questions[4] = rs.getString("answer4");
                questions[5] = rs.getString("correctAnswer");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                dbConnection.close();
                if (rs != null && stmt != null) {
                    stmt.close();
                    rs.close();
                }
            } catch (SQLException e) {
                e.getMessage();
            }
        }
        return questions;
    }

    public static int howManyId() {
        isClosed();
        int howMany = 0;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT id FROM questions");
            while (rs.next()) {
                howMany++;
            }
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                dbConnection.close();
                if (rs != null && stmt != null) {
                    rs.close();
                    stmt.close();
                }
            } catch (SQLException e) {
                e.getMessage();
            }
        }
        return howMany;
    }

    public static void rankingQuery(String playerName, int score) {
        int id = returnId() +1;
        isClosed();
        try {
            stmt = conn.createStatement();
            StringBuffer sb = new StringBuffer();
            sb.append("(" + id + ", '" + playerName + "', " + score + ")");
            stmt.executeUpdate("INSERT INTO ranking VALUES" + sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                dbConnection.close();
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }

    private static int returnId(){
        isClosed();
        int howMany = 0;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT idranking FROM ranking");
            while (rs.next()) {
                howMany++;
            }
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                dbConnection.close();
                if (rs != null && stmt != null) {
                    rs.close();
                    stmt.close();
                }
            } catch (SQLException e) {
                e.getMessage();
            }
        }
        return howMany;
    }

    public static void rankingQuery(){
        isClosed();
        Player[] players = new Player[10];
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT playerName, points FROM ranking ORDER BY points DESC LIMIT 10");
            int i = 0;
            while(rs.next()){
                String name = rs.getString("playerName");
                int points = rs.getInt("points");
                System.out.println(name + ": " + points);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                dbConnection.close();
                if (rs != null && stmt != null) {
                    stmt.close();
                    rs.close();
                }
            } catch (SQLException e) {
                e.getMessage();
            }
        }
    }

    private static void isClosed() {
        try {
            if (conn.isClosed()) {
                conn = dbConnection.getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
