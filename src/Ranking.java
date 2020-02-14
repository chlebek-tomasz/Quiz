import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ranking {
    public static void addToRanking(String playerName, int score){
        dbQuery.rankingQuery(playerName, score);
    }

    public static void returnTopScores(){
        dbQuery.rankingQuery();
        int i = 0;
        /*for (Player p: players) {
            System.out.println((i+1) + " " + players[i].getName() + " " + players[i].getScore());
            i++;
        }*/
    }

}
