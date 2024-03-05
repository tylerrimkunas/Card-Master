package ClassicCards;

import Interfaces.Card;
import Interfaces.CardDeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public abstract class ClassicCardDeck implements CardDeck {
    private Stack<ClassicCard> stack;
    public ClassicCardDeck() {
        stack = new Stack<ClassicCard>();
        for(int i = 0; i < 52; i++) {
            stack.push(new ClassicCard(ClassicCardValue.convertInt(i % 13), ClassicSuit.convertInt(i / 13)));
        }
    }

    public void shuffle() {
        Collections.shuffle(stack);
    }

    public ClassicCard getTopCard() {
        return stack.peek();
    }

    public Card takeCard() {
        return (Card) stack.pop();
    }

    public abstract ArrayList<ClassicCard> deal();
}
