// We extend StoringWords to Result allowing it to use all the variables and methods which aren't set to private
public class Results extends StoringWords {
    public Results(String[] words) {
        // We want words pass through via super everytime, so we can access it when making the object
        super(words);
    }

    public String[] getRandomWordWithUnderscores() {
        // Now that we extended StoringWord class we can access getRandomWord() method
        String randomWord = getRandomWord();
        // Now that we extended StoringWord we can access generateUnderscores() method
        String underscores = generateUnderscores(randomWord.length());
        return new String[]{randomWord, underscores};
    }

    protected String generateUnderscores(int length) {
        // Strings in Java are immutable, meaning that once created, their values cannot be changed.
        // StringBuilder provides a mutable sequence of characters
        StringBuilder underscores = new StringBuilder();
        for (int i = 0; i < length; i++) {
            underscores.append("_");
        }
        // when we return underscores.toString() we return it back to an ordinary string object which makes it immutable
        return underscores.toString();
    }

}
