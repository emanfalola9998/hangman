import java.util.Random;

public class StoringWords {
    protected String[] words;

    public StoringWords(String[] words){
        this.words = words;
    };

    public String[] getWords() {
        return words;
    };

    public void setWords(String[] words) {
        this.words = words;
    };

    public String getRandomWord() {
        // Generate a random index within the range of the array's length
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        // Return the word at the random index
        return words[randomIndex];
    };


}
