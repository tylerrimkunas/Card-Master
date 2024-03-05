package ClassicCards;

import Interfaces.Card;

public class ClassicCard implements Card {
    private ClassicCardValue rank;
    private ClassicSuit suit;
    public ClassicCard(ClassicCardValue value, ClassicSuit suit) {
        this.rank = value;
        this.suit = suit;
    }

    public ClassicCardValue getRank() {
        return rank;
    }

    public ClassicSuit getSuit() {
        return suit;
    }

    @Override
    public int getValue() {
        return rank.toInt();
    }

    @Override
    public int getType() {
        return suit.toInt();
    }

    @Override
    public int compareTo(Card card) {
        if(getValue() == card.getValue() && getType() == card.getType()) {
            return 0;
        }
        else if(getValue() != card.getValue() && getType() == card.getType()) {
            return 1;
        }
        else if(getType() != card.getType() && getValue() == card.getValue()) {
            return 2;
        }
        else return 3;
    }

    @Override
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }
}
