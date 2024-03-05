package GoFish;

import ClassicCards.ClassicCard;
import Interfaces.Card;
import Interfaces.Player;

import java.util.ArrayList;
import java.util.List;

public class GoFishPlayer implements Player {
    private String name;
    private ArrayList<ClassicCard> cards;
    public GoFishPlayer(String name) {
        this.name = name;
        cards = new ArrayList<>();
    }
    @Override
    public void endTurn() {

    }

    public void setCards(ArrayList<ClassicCard> cards) {
        this.cards = cards;
    }

    @Override
    public List<Card> getCards() {
        return null;
    }
}
