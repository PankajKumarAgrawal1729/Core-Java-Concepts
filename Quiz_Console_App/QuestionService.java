package Quiz_Console_App;

import java.util.Scanner;

public class QuestionService {
    Question[] questions = new Question[5];
    Scanner sc = new Scanner(System.in);
    int score = 0;
    String[][] answerSummary = new String[5][2];

    public QuestionService(){
        questions[0] = new Question(1, "What is Java?", "A. Programming Langg", "B. Dish", "C. Place", "D. None of these", "A");
        questions[1] = new Question(2, "Which of the following keywords is used to declare a constant in Java?", "A. constant", "B. var", "C. final", "D. static", "C");
        questions[2] = new Question(3, "In Java, which keyword is used to implement multiple inheritance?", "A. inherit", "B. extends", "C. implements", "D. extends and implements both", "B");
        questions[3] = new Question(4, "What is the purpose of the break statement in Java?", "A. To end the program's execution", "B. To terminate a loop prematurely and transfer control to the loop's exit condition", "C. To skip the current iteration of a loop and move to the next one", "D. To print a message to the console", "B");
        questions[4] = new Question(5, "Which of the following access modifiers allows a class or method to be accessed from anywhere, both within and outside the class's package?", "A. private", "B. protected", "C. default", "D. public", "D");
    }

    public void playQuiz(){
        System.out.println("Quiz: ");
       for(Question ques: questions){
        System.out.println(ques.toString());
        System.out.print("Your Answer: ");
        String userAnswer = sc.nextLine();
        if(userAnswer.equals(ques.getAnswer()) || userAnswer.toUpperCase().equals(ques.getAnswer())){
            score++;
        }
        int quesNumber = ques.getId();
        answerSummary[quesNumber - 1][0] = ques.getAnswer();
        answerSummary[quesNumber - 1][1] = userAnswer;
        System.out.println("............................\n");
       }
       showSummary();
    }

    public void showSummary(){
        System.out.println("............................\n");
        System.out.println("Answer Summary: \n");
        System.out.println("Your Answer\t|\tActual Answer\t");
        for(int i = 0; i < 5; i++){
            System.out.println("\t" + answerSummary[i][1].toUpperCase() + "\t|\t" + answerSummary[i][0] + "\t");
        }
        System.out.println("Your Total Score out of 5: " + score);
    }
}
