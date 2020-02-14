import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level {
    private String[] questions = new String[6];
    private String correctAnswer = questions[5];
    private int bound = dbQuery.howManyId();
    private Random random = new Random();
    private List<Integer> usedQuestion = new ArrayList<>(); // List of questions used


    private int randomQuestion(){
        int id;
        do {
            id = random.nextInt(bound) + 1;
        } while(usedQuestion.contains(id));
        return id;
    }

    public void setQuestions() {
        int id = randomQuestion();
        usedQuestion.add(id);
        questions = dbQuery.questionsQuery(id);
        setCorrectAnswer(questions[5]);
        }

    public void getQuestions() {
        for(int i=0; i<questions.length-1;i++){
            System.out.println(questions[i]);
        }
    }

    private void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean equalsResult(String answer){
        if(correctAnswer.equalsIgnoreCase(answer)){
            return true;
        } else {
            System.out.println("Poprawna odpowiedz: " + correctAnswer);
            return false;
        }
    }

}
