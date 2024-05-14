public class Results extends StoringWords {
    public Results(String[] words) {
        super(words);
    }

    public String[] getRandomWordWithUnderscores() {
        String randomWord = getRandomWord();
        String underscores = generateUnderscores(randomWord.length());
        return new String[]{randomWord, underscores};
    }

    private String generateUnderscores(int length) {
        StringBuilder underscores = new StringBuilder();
        for (int i = 0; i < length; i++) {
            underscores.append("_");
        }
        return underscores.toString();
    }
    public static void main(String[] args) {
        Results results = new Results(new String[]{"ferrari", "BMW", "VolksWagen", "Audi", "Ford"});
        String[] result = results.getRandomWordWithUnderscores();

        String selectedWord = result[0];
        String underscores = result[1];

        System.out.println("Selected word: " + selectedWord);
        System.out.println("Underscores: " + underscores);
    }
}
