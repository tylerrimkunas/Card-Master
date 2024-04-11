package Uno;

import Interfaces.Card;
import Interfaces.Player;

import java.util.ArrayList;
import java.util.List;

public class UnoBot implements Player {
    private String name;
    private ArrayList<Card> cards;
    public UnoBot(String name, ArrayList<Card> cards) {
        this.cards = cards;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    @Override
    public Card takeTurn(Card last_card) {
        for(Card c: cards) {
            int x = c.compareTo(last_card);
            if(x < 3) {
                cards.remove(c);
                return c;
            }
        }
        return null;
    }

    public boolean hasCards() {
        return cards.isEmpty();
    }

    @Override
    public List<Card> getCards() {
        return null;
    }
    public void addCard(Card newCard) {
        cards.add(newCard);
    }
}
