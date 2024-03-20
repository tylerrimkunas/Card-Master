package GoFish;

import Interfaces.Card;
import Interfaces.Player;

import java.util.List;

public class GoFishBot extends GoFishPlayer {
    private String name;
    public GoFishBot(String name) {
        super(name);
    }

    @Override
    public void takeTurn() {

    }

    @Override
    public List<Card> getCards() {
        return null;
    }
}
