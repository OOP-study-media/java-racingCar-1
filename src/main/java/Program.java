
public class Program {
    public static void main(String[] args) throws Exception {
        Input input = new Input();
        if (!input.setup()) {
            return;
        }
        Game game = input.makeGame();
        game.playGame();
    }
}
