public class Main extends userInput{
    public Main(String[] words) {
        super(words);
    }

    public static void main(String[] args) {
        // Now that we passed it through the classes we now can set the array variable
        Main game = new Main(new String[]{"ferrari", "BMW", "VolksWagen", "Audi", "Ford"});
        game.play();
    }
};