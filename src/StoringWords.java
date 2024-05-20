import java.util.Random;

public abstract class StoringWords {
    // Keep the field private
    private String[] words;

    // Constructor
    public StoringWords(String[] words){
        this.words = words;
    }

    // Abstract getter
    public abstract String[] getWords();

    // Abstract setter
    public abstract void setWords(String[] words);

    // Concrete method to select a random word
    public String getRandomWord() {
        // Generate a random index within the range of the array's length
        Random random = new Random();
        // sets the maximum range the randomIndex can take
        int randomIndex = random.nextInt(getWords().length);
        // Return the word at the random index
        return getWords()[randomIndex];
    }
}
