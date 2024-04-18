package Uno;

import Interfaces.Card;
import Interfaces.Player;

import java.util.ArrayList;
import java.util.List;

public class UnoBot extends UnoBeing {
    public UnoBot(String name, ArrayList<Card> cards) {
        super(name, cards);

    }
    @Override
    public Card takeTurn(Card last_card) {
        for(Card c: super.getCards()) {
            int x = c.compareTo(last_card);
            if(x < 3) {
                cards.remove(c);
                return c;
            }
        }
        return null;
    }
}
