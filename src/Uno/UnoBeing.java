package Uno;

import Interfaces.Card;
import Interfaces.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class UnoBeing implements Player {
    protected String name;
    protected ArrayList<Card> cards;
    public UnoBeing(String name, ArrayList<Card> cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    @Override
    public abstract void takeTurn();

    public abstract char askColor();

    public boolean hasNoCards() {
        return cards.isEmpty();
    }

    public void addCard(Card newCard) {
        cards.add(newCard);
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }
}
