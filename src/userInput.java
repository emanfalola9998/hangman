import java.util.Scanner;

public class userInput extends Results {
    public userInput(String[] words) {
        super(words);
    }


    public void play() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 5; // Set the number of attempts allowed

        // Call getRandomWordWithUnderscores() from Results class
        String[] result = getRandomWordWithUnderscores();
        String selectedWord = result[0];
        String underscores = result[1];

        StringBuilder guessedWord = new StringBuilder(underscores);

        while (attempts > 0 && guessedWord.indexOf("_") != -1) {
            System.out.println("Word: " + guessedWord);
            System.out.println("Attempts left: " + attempts);
            System.out.print("Enter a character: ");
            char guess = scanner.nextLine().charAt(0);

            boolean found = false;
            for (int i = 0; i < selectedWord.length(); i++) {
                if (selectedWord.charAt(i) == guess) {
                    guessedWord.setCharAt(i, guess);
                    found = true;
                }
            }

            if (!found) {
                attempts--;
                System.out.println("Incorrect guess. Try again.");
            }
        }

        if (guessedWord.indexOf("_") == -1) {
            System.out.println("Congratulations! You guessed the word: " + selectedWord);
        } else {
            System.out.println("Out of attempts. The word was: " + selectedWord);
        }
    }

}
