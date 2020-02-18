
public class GameLoop {
    private Level level;
    private Player player;
    private int lev = 1;

    public void startGame(){
        level = new Level();
        player = new Player();
        do {
            setQuestions();
        } while(equalsAnswer() && lev <=100);
        player.returnScore();
        Ranking.addToRanking(player.getName(), player.getScore());
        Ranking.returnTopScores();
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
        if(level.equalsResult(answerQuestion())){
            lev++;
            player.incrementScore();
            return true;
        }
        else return false;
    }
}
