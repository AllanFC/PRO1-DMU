import java.util.Arrays;
import java.util.Random;

public class Ex02 {
    public static void main(String[] args) {
        String[][] questions = new String[10][8];
        String[] answers = {"A", "B", "C", "D", "A", "B", "C", "D", "A", "B"};
        Random rd = new Random();

        for (int s = 0; s < questions[0].length; s++) {
            for (int q = 0; q < questions.length; q++) {
                int rand = rd.nextInt(4);
                if (rand == 0) {
                    questions[q][s] = "A";
                } else if (rand == 1) {
                    questions[q][s] = "B";
                } else if (rand == 2) {
                    questions[q][s] = "C";
                } else {
                    questions[q][s] = "D";
                }
            }
        }

        System.out.println("Correct answers: " + Arrays.toString(answers));
        for (int r = 0; r < questions.length; r++) {
            System.out.printf("Question %d: ", r + 1);
            for (int c = 0; c < questions[0].length; c++) {
                System.out.printf("%3s",questions[r][c]);
            }
            System.out.println();
        }

        int[] studentCorrectAnswers = new int[8];
        for(int c = 0; c < questions[0].length; c++){
            int studentAnswers = 0;
            for(int r = 0; r < questions.length; r++){
                if(questions[r][c] == answers[r]){
                    studentAnswers++;
                }
            }
            studentCorrectAnswers[c] = studentAnswers;
        }
        System.out.println("Students correct answers: " + Arrays.toString(studentCorrectAnswers));

        int[] questionsAnsweredCorrect = new int[10];
        for(int r = 0; r < questions.length; r++){
            int correctAnswers = 0;
            for(int c = 0; c < questions[r].length; c++){
                if(questions[r][c] == answers[r]){
                    correctAnswers++;
                }
            }
            questionsAnsweredCorrect[r] = correctAnswers;
        }
        System.out.println("Right answers per question: " + Arrays.toString(questionsAnsweredCorrect));
    }
}