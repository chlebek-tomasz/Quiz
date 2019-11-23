import java.net.HttpURLConnection;
import java.net.http.HttpRequest;

public class GameLoop {
    private Level level;
    private Player player;
    private int lev = 1;

    public void startGame(){
        level = new Level();
        player = new Player("Tomek");
        do {
            setLevel(lev);
            setQuestions();
        } while(equalsAnswer() && lev <=10);
    }

    private void setLevel(int level){
        System.out.println("Witaj na poziomie " + level);
    }

    private void setQuestions(){
        setLevel(lev);
        level.setQuestions();
        level.getQuestions();
    }

    private String answerQuestion(){
        return player.guess();
    }

    private boolean equalsAnswer(){
        if(level.equalsResult(answerQuestion())) return true;
        else return false;
    }
}
