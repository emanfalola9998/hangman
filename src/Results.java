public class Results extends StoringWords {
    private String[] words;

    public Results(String[] words) {
        super(words);
    }

    @Override
    public String[] getWords() {
        return this.words;
    }

    @Override
    public void setWords(String[] words) {
        this.words = words;
    }

    public String[] getRandomWordWithUnderscores() {
        // Access getRandomWord() method from the superclass
        String randomWord = getRandomWord();
        // Generate underscores for the length of the random word
        String underscores = generateUnderscores(randomWord.length());
        return new String[]{randomWord, underscores};
    }

    protected String generateUnderscores(int length) {
        // Using StringBuilder to generate underscores
        StringBuilder underscores = new StringBuilder();
        for (int i = 0; i < length; i++) {
            underscores.append("_");
        }
        return underscores.toString();
    }
}
