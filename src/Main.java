import BlackJack.BlackJack;
import GoFish.GoFish;
import Interfaces.Game;
import Uno.Uno;
import War.War;

public class Main {
    public static void main(String[] args) {
        /*
        TODO: ADD UI
         */
        int choice = 0;
        Game game;
        int players = 4;
        switch(choice) {
            case 0:
                game = new GoFish(players);
                break;
            case 1:
                game = new BlackJack();
                break;
            case 2:
                game = new Uno();
                break;
            case 3:
                game = new War();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
        game.play();
    }
}
