import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random randomGenerator = new Random();

        int totalRoundsPlayed = 0;
        int roundsWon = 0;
        int roundsLost = 0;

        boolean keepPlaying = true;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        while (keepPlaying) {
            System.out.println("\nChoose Difficulty Level:");
            System.out.println("1. Easy (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard (1-200, 5 attempts)");
            System.out.print("Enter your choice (1-3): ");
            int difficultyChoice = inputScanner.nextInt();

            int upperBound = 100;
            int allowedAttempts = 7;

            switch (difficultyChoice) {
                case 1:
                    upperBound = 50;
                    allowedAttempts = 10;
                    break;
                case 2:
                    upperBound = 100;
                    allowedAttempts = 7;
                    break;
                case 3:
                    upperBound = 200;
                    allowedAttempts = 5;
                    break;
                default:
                    System.out.println("Invalid choice! Defaulting to Medium.");
            }

            int secretNumber = randomGenerator.nextInt(upperBound) + 1;
            int playerGuess;
            int currentAttempt = 0;
            boolean numberGuessedCorrectly = false;

            System.out.println("\n🎮 Game Started! You have " + allowedAttempts + " attempts to guess a number between 1 and " + upperBound);

            while (currentAttempt < allowedAttempts) {
                System.out.print("Attempt " + (currentAttempt + 1) + ": Enter your guess: ");
                playerGuess = inputScanner.nextInt();
                currentAttempt++;

                if (playerGuess < secretNumber) {
                    System.out.println("Too low!");
                } else if (playerGuess > secretNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("🎉 Correct! You guessed the number in " + currentAttempt + " attempts.");
                    numberGuessedCorrectly = true;
                    break;
                }
            }

            totalRoundsPlayed++;
            if (numberGuessedCorrectly) {
                roundsWon++;
            } else {
                roundsLost++;
                System.out.println("❌ Out of attempts! The number was: " + secretNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            inputScanner.nextLine();
            String playAgainResponse = inputScanner.nextLine().trim().toLowerCase();
            if (!playAgainResponse.equals("yes") && !playAgainResponse.equals("y")) {
                keepPlaying = false;
            }
        }

        System.out.println("\n📊 Game Summary:");
        System.out.println("Total Games Played: " + totalRoundsPlayed);
        System.out.println("Games Won: " + roundsWon);
        System.out.println("Games Lost: " + roundsLost);
        System.out.println("Thanks for playing, 👋");

        inputScanner.close();
    }
}
