
import java.util.*;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    private int generatedNumber;
    private int attemptsLeft = 10;
    private int roundsWon = 0;

    public static void main(String[] args) {
        NumberGame numberGame = new NumberGame();
        numberGame.playGame();
    }

    private void playGame() {
        generateRandomNumber();
        updateInstructions();

        Scanner scanner = new Scanner(System.in);

        while (attemptsLeft > 0) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == generatedNumber) {
                roundsWon++;
                System.out.println("Congratulations! You guessed the number.");
                break;
            } else if (userGuess < generatedNumber) {
                System.out.println("Too low. Attempts left: " + --attemptsLeft);
            } else {
                System.out.println("Too high. Attempts left: " + --attemptsLeft);
            }
        }

        if (attemptsLeft == 0) {
            System.out.println("Out of attempts. The correct number was: " + generatedNumber);
        }

        scanner.close();
    }

    private void generateRandomNumber() {
        Random random = new Random();
        generatedNumber = random.nextInt(100) + 1;
    }

    private void updateInstructions() {
        System.out.println("Guess a number between 1 and 100:");
    }
}

