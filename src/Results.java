public class Results extends StoringWords {
    private String[] words;

    public Results(String[] words) {
        super(words);
//        this.words = words;
    }

    public String[] getWords() {
        return this.words; // Access through the getter method
    }

    public void setWords(String[] words) {
        this.words = words; // Access through the setter method
    }

    public String[] getRandomWordWithUnderscores() {
        // Access getRandomWord() method from the superclass
        String randomWord = getRandomWord();
        // Access generateUnderscores() method in this class
        String underscores = generateUnderscores(randomWord.length());
        return new String[]{randomWord, underscores};
    }

    protected String generateUnderscores(int length) {
        // Using StringBuilder to generate underscores
        StringBuilder underscores = new StringBuilder();
        for (int i = 0; i < length; i++) {
            underscores.append("_");
        }
        // Return it back to an ordinary string object which makes it immutable
        return underscores.toString();
    }
}
