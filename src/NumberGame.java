import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10; //  the number of attempts.
        int totalRounds = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        boolean playAgain = true;

        while (playAgain) {
            int GuessNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("Guess a number between " + minRange + " and " + maxRange + ".");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess number: ");
                int userGuess = scanner.nextInt();

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Please guess a number between " + minRange + " and " + maxRange + ".");
                } else if (userGuess == GuessNumber) {
                    System.out.println("Congratulations! You guessed the correct number, which is " + GuessNumber + ".");
                    break;
                } else if (userGuess < GuessNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Out of attempts! The correct number was " + GuessNumber + ".");
            }

            totalRounds++;
            totalAttempts += attempts;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();

            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing! You completed " + totalRounds + " round(s) and had an average of " +
                (totalAttempts / totalRounds) + " attempts per round.");

    }
}
