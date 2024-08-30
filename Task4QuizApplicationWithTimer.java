import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizApplication
{
    private static final int QUESTION_TIMEOUT = 30;
    private static final int TOTAL_QUESTIONS = 5; 

    private static final String[] questions = {
        "Who invented Java Programming?",
        "Number of primitive data types in java?",
        "Which of the below is not a java Profiler?",
        "What is the extension of java code files?",
        "What is the full form of JVM?",
    };

    private static final String[][] options = 
    {
        {"A. Games Gosling", "B. Dennis Ritchie", "C. Bjarne Stroustrup", "D. Charles Babbage"},
        {"A. 6", "B. 7", "C. 8", "D. 9"},
        {"A. jProfiler", "B. Eclipse Profiler", "C. JVM", "D. jConsole"},
        {"A. .js", "B. .txt", "C. .class", "D. .java"},
        {"A. Java Vital Machine", "B. Java Virtual Machine", "C. Java Vast Machine", "D. None"}

    };

    private static final String[] answers = {"A", "C", "C", "D", "B"};

    private static Timer timer;
    private static List<String> userResponses = new ArrayList<>(); 

    public static void main(String[] args) 
    {
        startQuiz();
    }

    private static void startQuiz()
     {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Quiz!\n");
        System.out.println("Here are the Quiz questions\n");
        int score = 0;
        for (int i = 0; i < TOTAL_QUESTIONS; i++) 
        {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (String option : options[i])
             {
                System.out.println(option);
            }

            System.out.println("Enter an option: "); 
            startTimer(QUESTION_TIMEOUT); 
            String userAnswer = scanner.nextLine().toUpperCase();
            stopTimer(); 
            userResponses.add(userAnswer); 
            System.out.println(); 
            if (userAnswer.equals(answers[i]))
             {
                score++;
            }
        }

        System.out.println("Quiz Finished.Thank You!");
        System.out.println("Check Your Quiz Result");
        System.out.println("Summary:");
        for (int i = 0; i < TOTAL_QUESTIONS; i++) 
        {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            String userAnswer = userResponses.get(i);
            if (userAnswer.equals(answers[i])) 
            {
                System.out.println("Your answer: " + userAnswer + " (Correct)");
            } else
             {
                System.out.println("Your answer: " + userAnswer + " (Incorrect. Correct option: " + answers[i] + ")");
            }
        }
        System.out.println("Your score: " + score + "/" + TOTAL_QUESTIONS);
        scanner.close();
    }
    private static void startTimer(int seconds) 
    {
        timer = new Timer();
        timer.schedule(new TimerTask()
         {
            int remainingTime = seconds;
            public void run() 
            {
                if (remainingTime == 0) 
                {
                    stopTimer(); 
                } 
                else
                 {
                    System.out.print("\rTime left: " + remainingTime + " seconds  ");
                    remainingTime--;
                }
            }
        }, 0, 1000); 
    }
    private static void stopTimer()
     {
        timer.cancel();
        System.out.println(); 
    }
}