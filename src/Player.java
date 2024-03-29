import java.util.Scanner;

public class Player {
    private String name = "Anonymous";
    private int score = 0;
    private Scanner scanner = new Scanner(System.in);

    public Player() {
        text();
        name = scanner.nextLine();
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        if(name!=null && name.matches("^[A-Za-z0-9~]{3,}$")) {
            this.name = name;

        } else {
            throw new IllegalArgumentException();
        }
    }
    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public String guess(){
        String answer = scanner.nextLine();
        return answer;
    }

    public void incrementScore(){
        this.score++;
    }
    public void returnScore(){
        System.out.println(score);
    }

    private void text(){
        System.out.println("Podaj swoje imie:");
    }
}
