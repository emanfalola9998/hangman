public class Main extends UserInput {
    public Main(String[] words, int attempts) {
        super(words, attempts);
    }

    public static void main(String[] args) {
        // Now that we passed it through the classes we now can set the array variable
        Main game = new Main(new String[]{"ferrari", "BMW", "VolksWagen", "Audi", "Ford"}, 5);
        game.play();
    }
}
b