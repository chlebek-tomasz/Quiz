public class Game {
    public static void main(String[] args) {
        Level level = new Level();
        Player player = new Player("Tomek");
        dbConnection dbConnection = new dbConnection();
        level.setQuestions();
        level.getQuestions();
        String guess = player.guess();
        level.equalsResult(guess);
    }
}
