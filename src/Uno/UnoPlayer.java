package Uno;

import Interfaces.Card;
import Interfaces.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        int i = 1;
        for(Card c: cards) {
            s.append(i++).append(c).append(" | ");
        }
        return s.toString();
    }
    @Override
    public Card takeTurn() {
        Scanner inputInt = new Scanner(System.in);
        int choice = inputInt.nextInt();
        if(choice == -1) {
            return null;
        }
        if(choice < 1 || choice >= cards.size()) {
            System.out.println("Out of Bounds! Try again.");
            return takeTurn();
        }
        else {
            Card c = cards.get(choice - 1);
            cards.remove(choice -1);
            return c;
        }
    }

    public boolean hasCards() {
        return cards.isEmpty();
    }

    public void addCard(Card newCard) {
        cards.add(newCard);
    }

    @Override
    public List<Card> getCards() {
        return null;
    }
}
