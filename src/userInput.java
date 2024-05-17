import java.util.Scanner;

public class userInput extends Results {
    public userInput(String[] words) {
        // We want words pass through via super everytime, so we can access it when making the object
        super(words);
    }

    public void play() {
        // Scanner class used to create user input
        Scanner scanner = new Scanner(System.in);
        int attempts = 5; // Set the number of attempts allowed

        // Call getRandomWordWithUnderscores() from Results class
        String[] result = getRandomWordWithUnderscores();
        // get selectedWord from result
        String selectedWord = result[0];
        // get selectedWord from underscores
        String underscores = result[1];

        // We initialise guessedWord in our own class, so we can modify its content when the user guesses the correct answer
        // we initlise Stringbuilder again as the string returned is a String Object again because of underscores.toString()
        StringBuilder hiddenWord = new StringBuilder(underscores);
        int storedAttempts = 0; // Initialize storedAttempts to 0
        char[] attemptArray = new char[100]; // Initialize attemptArray with a fixed size

        // while attempts is greater than 0 and there are underscores present, run the loop
        while (attempts > 0 && hiddenWord.indexOf("_") != -1) {
            System.out.println("Word: " + hiddenWord);
            System.out.println("Attempts left: " + attempts);
            System.out.print("Enter a character: ");
            char guess = scanner.nextLine().charAt(0);
            // String converter
            String guessString = String.valueOf(guess);

            // Check if the guessed character is already in attemptArray
            boolean alreadyGuessed = false;
            for (char character : attemptArray) {
                if (character == guess) {
                    alreadyGuessed = true;
                    break;
                }
            }

            if (alreadyGuessed) {
                System.out.println("Enter another character as that character has already been selected.");
                continue; // Go to the next iteration of the loop
            }

            // Check if the guessed character is a number
            if (isNumber(guess)) {
                System.out.println("Enter another character as numbers are not allowed.");
                continue; // Go to the next iteration of the loop
            }

            boolean found = false; // Reset found flag for each guess
            for (int i = 0; i < selectedWord.length(); i++) {
                if (guessString.equalsIgnoreCase(String.valueOf(selectedWord.charAt(i)))) {
                    // If the guessed character matches a character in the word, replace the underscore
                    hiddenWord.setCharAt(i, guess);
                    found = true;
                }
            }

            if (!found) {
                // If the guessed character is not found in the word, reduce the number of attempts
                attempts--;
                System.out.println("Incorrect guess. Try again.");
            }

            // Add the guessed character to the attemptArray
            // at the index of storedAttemps
            attemptArray[storedAttempts++] = guess;
        }

        // Print appropriate message based on game outcome
        if (hiddenWord.indexOf("_") == -1) {
            System.out.println("Congratulations! You guessed the word: " + selectedWord);
            System.out.println("Would you like to proceed to the next level? (yes/no)");
            String playAgain = scanner.nextLine();
            if (playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Level 2: The hint is football teams!");
                words = new String[]{"Chelsea", "Arsenal", "Manchester"};
                play();
            }
        } else {
            System.out.println("Out of attempts. The word was: " + selectedWord);
            System.out.println("Would you like to play again? (yes/no)");
            String playAgain = scanner.nextLine();
            if (playAgain.equalsIgnoreCase("yes")) {
                play();
            }
        }
    }

    private boolean isNumber(char c) {
        return Character.isDigit(c);
    }
}
