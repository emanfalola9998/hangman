import java.util.Random;

public abstract class StoringWords {
    // Constructor
    public StoringWords(String[] words) {
        setWords(words); // Use the abstract setter method
    }

    // Abstract getter
    public abstract String[] getWords();

    // Abstract setter
    public abstract void setWords(String[] words);

    // Concrete method to select a random word
    public String getRandomWord() {
        // Generate a random index within the range of the array's length
        Random random = new Random();
        // Sets the maximum range the randomIndex can take
        int randomIndex = random.nextInt(getWords().length);
        // Return the word at the random index
        return getWords()[randomIndex];
    }
}
