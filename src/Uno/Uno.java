package Uno;

import Interfaces.ActionCard;
import Interfaces.Game;
import Interfaces.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.function.Consumer;

enum colors {
    RED,
    GREEN,
    BLUE,
    YELLOW,
    WILD;
    char toChar() {
        return switch (this) {
            case RED -> 'R';
            case BLUE -> 'B';
            case GREEN -> 'G';
            case YELLOW -> 'Y';
            case WILD -> 'W';
        };
    }
}

enum values {
    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    REVERSE,
    PLUS_2,
    SKIP;
    int toInt() {
        return switch (this) {
            case ZERO -> 0;
            case ONE -> 1;
            case TWO -> 2;
            case THREE -> 3;
            case FOUR -> 4;
            case FIVE -> 5;
            case SIX -> 6;
            case SEVEN -> 7;
            case EIGHT -> 8;
            case NINE -> 9;
            case REVERSE -> 10;
            case PLUS_2 -> 11;
            case SKIP -> 12;

        };
    }
    Consumer<?> toAction() {
        switch(this) {
            case ZERO:
            case SEVEN:
            case SKIP:
            case PLUS_2:
            case REVERSE:
            default:
                return null;

        }
    }
}

enum w_actions {
    CHANGE_COLOR,
    DRAW_4;
    int toInt() {
        return -1;
    }
    Consumer<?> toAction() {
        switch(this) {
            case CHANGE_COLOR:
            case DRAW_4:
        }
        return null;
    }
}

public class Uno implements Game {
    private Stack<ActionCard> cards;
    private Stack<ActionCard> discard;
    private ArrayList<Player> players;
    private boolean reverse;
    private ActionCard last_card;
    public Uno() {
        cards = new Stack<>();
        discard = new Stack<>();
        players = new ArrayList<>();
        reverse = false;
        for(colors c: colors.values()) {
            StringBuilder s = new StringBuilder();
            s.append(c).append(" ");
            if(c == colors.WILD) {
                for(w_actions w: w_actions.values()) {
                    s.append(w);
                    ActionCard card1 = new ActionCard(c.toChar(), w.toInt(), s.toString(), w.toAction());
                    ActionCard card2 = new ActionCard(c.toChar(), w.toInt(), s.toString(), w.toAction());
                    ActionCard card3 = new ActionCard(c.toChar(), w.toInt(), s.toString(), w.toAction());
                    ActionCard card4 = new ActionCard(c.toChar(), w.toInt(), s.toString(), w.toAction());
                    cards.push(card1);
                    cards.push(card2);
                    cards.push(card3);
                    cards.push(card4);

                }
            }
            else for(values v: values.values()) {
                s.append(v);
                ActionCard card1 = new ActionCard(c.toChar(), v.toInt(), s.toString(), v.toAction());
                ActionCard card2 = new ActionCard(c.toChar(), v.toInt(), s.toString(), v.toAction());
                cards.push(card1);
                cards.push(card2);
            }
        }
        Collections.shuffle(cards);
        last_card = cards.pop();
        discard.push(last_card);
    }
    @Override
    public void play() {

    }

    @Override
    public void deal() {

    }
}
