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

        // StringBuilder class again builds mutable strings
        StringBuilder guessedWord = new StringBuilder(underscores);

        // whilst attempts is 0 and the underscore is present run the loop
        while (attempts > 0 && guessedWord.indexOf("_") != -1) {
            System.out.println("Word: " + guessedWord);
            System.out.println("Attempts left: " + attempts);
            System.out.print("Enter a character: ");
            // reads the next line inputted by the user
            // .charAt() reads the first character (which is applicable for our example as we only want the first character
            char guess = scanner.nextLine().charAt(0);

            // initialised a boolean
            boolean found = false;
            // created a check using a forloop to see if any of the characters equals the character inputted by the user
            for (int i = 0; i < selectedWord.length(); i++) {
                if (selectedWord.charAt(i) == guess) {
                    // if it's correct then we replace our underscore with the guessed letter
                    guessedWord.setCharAt(i, guess);
                    // then we set the boolean to true
                    found = true;
                }
            }

            if (!found) {
                // if found remains false: incorrect guess, we reduced the number of attempts the user has
                attempts--;
                System.out.println("Incorrect guess. Try again.");
            }
        }

        if (guessedWord.indexOf("_") == -1) {
            // if there are no more underscores then the user has guessed the word
            System.out.println("Congratulations! You guessed the word: " + selectedWord);
        } else {
            // The user has not guessed the word and has run out of attempts
            System.out.println("Out of attempts. The word was: " + selectedWord);
        }
    }

}
