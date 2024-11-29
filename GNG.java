import java.util.Random;
import java.util.Scanner;

public class GNG {


    // Function that implements the number guessing game
    static void guessingNumberGame() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        int totalScore = 0; 
        boolean playAgain = true; 
        
        while (playAgain) {
            // Generate the number to guess
            int number = rand.nextInt(100) + 1; 
            int K = 5; //trails
            int guess, i;

            System.out.println( "A number is chosen between 1 to 100. " + "Guess the number within 5 trials.");

            
            for (i = 0; i < K; i++) {
                System.out.println("Guess the number:");
                guess = sc.nextInt();

                // If the number is guessed
                if (number == guess) {
                    System.out.println("Congratulations! You guessed the number.");
                    totalScore += (K - i) * 10; // Score based on remaining attempts
                    break;
                } else if (number > guess && i != K - 1) {
                    System.out.println("The number is greater than " + guess);
                } else if (number < guess && i != K - 1) {
                    System.out.println("The number is less than " + guess);
                }
            }

            if (i == K) {
                System.out.println("You have finished K trials.");
                System.out.println("The number was " + number);
            }

            System.out.println("Your total score is: " + totalScore);

            // Ask to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            String choice = sc.next();
            playAgain =choice.equalsIgnoreCase("yes");
        }

        System.out.println("Your final score is: " + totalScore);
        sc.close(); 
    }

    
    public static void main(String[] args) {
        
        guessingNumberGame();
    }
}
