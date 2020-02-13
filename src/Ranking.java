import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ranking {
    public static void addToRanking(String playerName, int score){
        dbQuery.rankingQuery(playerName,score);
    }

    public static Player[] returnTopScores(){
        Player[] players = dbQuery.rankingQuery();
        return players;
    }

}
