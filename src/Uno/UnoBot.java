package Uno;

import Interfaces.Card;
import Interfaces.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnoBot extends UnoBeing {
    public UnoBot(String name, ArrayList<Card> cards) {
        super(name, cards);

    }

    @Override
    public char askColor() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('B', 0);
        map.put('G', 0);
        map.put('Y', 0);
        for(Card c: cards) {
            char t = c.getType();
            if(t == 'W') continue;
            map.put(t, map.get(t) + 1);
        }
        Map.Entry<Character, Integer> highest = null;
        for(Map.Entry<Character, Integer> e: map.entrySet()) {
            if(highest == null || e.getValue() > highest.getValue()) {
                highest = e;
            }
        }
        assert highest != null;
        return highest.getKey();

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
