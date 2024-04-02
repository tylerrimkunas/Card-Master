package Uno;

import Interfaces.Card;
import Interfaces.Player;

import java.util.ArrayList;
import java.util.List;

public class UnoPlayer implements Player {
    private ArrayList<Card> cards;
    private String name;
    public UnoPlayer(String name, ArrayList<Card> cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public String cardsToString() {
        StringBuilder s = new StringBuilder();
        for(Card c: cards) {
            s.append(c).append(" | ");
        }
        return s.toString();
    }
    @Override
    public void takeTurn() {

    }

    @Override
    public List<Card> getCards() {
        return null;
    }
}
