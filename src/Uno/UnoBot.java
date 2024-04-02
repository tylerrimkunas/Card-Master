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
    public void takeTurn() {

    }

    @Override
    public List<Card> getCards() {
        return null;
    }
}
