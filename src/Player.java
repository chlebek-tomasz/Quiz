import java.util.Scanner;

public class Player {
    private String name = "Anonymous";
    private Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!(name.isEmpty()) && name != null){
            this.name = name;
        }
    }

    public String guess(){
        String answer = scanner.nextLine();
        return answer;
    }
}
