package GoFish;
import Interfaces.*;

import java.util.ArrayList;

public class GoFish implements Game {
    private ArrayList<GoFishPlayer> players;
    private GoFishDeck deck;
    public GoFish(int numPlayers) {
        // TODO: Ask for names either in main or here. Add choosing of Bots
        players = new ArrayList<GoFishPlayer>();
        for(int i = 0; i < numPlayers; i++) {
            String name = "BOB"; // Temp variable
            players.add(new GoFishPlayer(name));
        }
        deck = new GoFishDeck();
        deck.shuffle();
    }

    @Override
    public void play() {
        boolean isDone = false;
        int playerIndex = 0;
        deal();
        while(!isDone) {

        }
    }

    // TODO: deal either here or in GoFishDeck
    @Override
    public void deal() {
        for(GoFishPlayer p : players) {
            p.setCards(deck.deal());
        }
    }

}
