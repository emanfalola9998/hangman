import java.util.Random;

public class StoringWords {
    // We defined the string array to words
    protected String[] words;

    // Constructor
    public StoringWords(String[] words){
        this.words = words;
    };
    // getter
    public String[] getWords() {
        return words;
    };
    //setter
    public void setWords(String[] words) {
        this.words = words;
    };
    // Method used to select a random word from the list we give it
    public String getRandomWord() {
        // Generate a random index within the range of the array's length
        Random random = new Random();
        // sets the maximum range the randomIndex can take
        int randomIndex = random.nextInt(words.length);
        // Return the word at the random index
        return words[randomIndex];
    };

}
