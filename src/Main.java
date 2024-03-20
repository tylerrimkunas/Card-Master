import BlackJack.BlackJack;
import GoFish.GoFish;
import Interfaces.Game;
import Uno.Uno;
import War.War;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        TODO: ADD UI
         */
        System.out.println("Welcome to Card Master!\nWhich game would you like to play:\n1. Go Fish\n2. Blackjack\n3. Uno\n4. War");
        Scanner stringInput = new Scanner(System.in);
        int choice = Integer.parseInt(stringInput.nextLine());
        Game game;
        int players = 4;
        switch(choice) {
            case 1:
                game = new GoFish(players);
                break;
            case 2:
                System.out.println("COMING SOON!");
                game = new BlackJack();
                break;
            case 3:
                System.out.println("COMING SOON!");
                game = new Uno();
                break;
            case 4:
                System.out.println("COMING SOON!");
                game = new War();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
        game.play();
    }
}
