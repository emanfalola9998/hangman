import java.util.Scanner;

public class UserInput extends Results {
    private int attempts;

    public UserInput(String[] words, int attempts) {
        super(words);
        this.attempts = attempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int attempts = this.attempts; // Use instance variable for attempts

        String[] result = getRandomWordWithUnderscores();
        String selectedWord = result[0];
        String underscores = result[1];

        StringBuilder hiddenWord = new StringBuilder(underscores);
        int storedAttempts = 0;
        char[] attemptArray = new char[100];

        while (attempts > 0 && hiddenWord.indexOf("_") != -1) {
            System.out.println("Word: " + hiddenWord);
            System.out.println("Attempts left: " + attempts);
            System.out.print("Enter a character: ");
            char guess = scanner.nextLine().charAt(0);

            boolean alreadyGuessed = false;
            for (char character : attemptArray) {
                if (character == guess) {
                    alreadyGuessed = true;
                    break;
                }
            }

            if (alreadyGuessed) {
                System.out.println("Enter another character as that character has already been selected.");
                continue;
            }

            if (isNumber(guess)) {
                System.out.println("Enter another character as numbers are not allowed.");
                continue;
            }

            boolean found = false;
            for (int i = 0; i < selectedWord.length(); i++) {
                if (String.valueOf(selectedWord.charAt(i)).equalsIgnoreCase(String.valueOf(guess))) {
                    hiddenWord.setCharAt(i, guess);
                    found = true;
                }
            }

            if (!found) {
                attempts--;
                System.out.println("Incorrect guess. Try again.");
            }

            attemptArray[storedAttempts++] = guess;
        }

        if (hiddenWord.indexOf("_") == -1) {
            System.out.println("Congratulations! You guessed the word: " + selectedWord);
            System.out.println("Would you like to proceed to the next level? (yes/no)");
            String playAgain = scanner.nextLine();
            if (playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Level 2: The hint is football teams!");
                setWords(new String[]{"Chelsea", "Arsenal", "Manchester"});
                setAttempts(5); // Reset attempts for the next level
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
