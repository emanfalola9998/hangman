public class Main extends userInput{
    public Main(String[] words) {
        super(words);
    }

    public static void main(String[] args) {
        userInput game = new userInput(new String[]{"ferrari", "BMW", "VolksWagen", "Audi", "Ford"});
        game.play();
    }
};