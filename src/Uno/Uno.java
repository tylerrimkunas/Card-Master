package Uno;

import Interfaces.ActionCard;
import Interfaces.Card;
import Interfaces.Game;
import Interfaces.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

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
}

enum w_actions {
    CHANGE_COLOR,
    DRAW_4;
    int toInt() {
        return switch (this) {
            case DRAW_4 -> -2;
            case CHANGE_COLOR -> -1;
        };
    }
}

public class Uno implements Game {
    private Stack<Card> cards;
    private Stack<Card> discard;
    private ArrayList<Player> players;
    private boolean reverse;
    private Card last_card;
    private int pIndex;
    public Uno() {
        cards = new Stack<>();
        discard = new Stack<>();
        players = new ArrayList<>();
        reverse = false; //TODO: Need implementation of settings
        pIndex = 0;
        for(colors c: colors.values()) {
            StringBuilder s = new StringBuilder();
            s.append(c).append(" ");
            if(c == colors.WILD) {
                for(w_actions w: w_actions.values()) {
                    s.append(w);
                    Card card1, card2, card3, card4;
                    if(w == w_actions.DRAW_4) {
                        card1 = new Draw4Card(c.toChar(), w.toInt(), s.toString());
                        card2 = new Draw4Card(c.toChar(), w.toInt(), s.toString());
                        card3 = new Draw4Card(c.toChar(), w.toInt(), s.toString());
                        card4 = new Draw4Card(c.toChar(), w.toInt(), s.toString());
                    } else {
                        card1 = new ChangeColorCard(c.toChar(), w.toInt(), s.toString());
                        card2 = new ChangeColorCard(c.toChar(), w.toInt(), s.toString());
                        card3 = new ChangeColorCard(c.toChar(), w.toInt(), s.toString());
                        card4 = new ChangeColorCard(c.toChar(), w.toInt(), s.toString());
                    }
                    cards.push(card1);
                    cards.push(card2);
                    cards.push(card3);
                    cards.push(card4);

                }
            }
            else for(values v: values.values()) {
                s.append(v);
                Card card1, card2;
                if(v == values.PLUS_2) {
                    card1 = new Plus2Card(c.toChar(), v.toInt(), s.toString());
                    card2 = new Plus2Card(c.toChar(), v.toInt(), s.toString());
                }
                else if(v == values.REVERSE) {
                    card1 = new ReverseCard(c.toChar(), v.toInt(), s.toString());
                    card2 = new ReverseCard(c.toChar(), v.toInt(), s.toString());
                }
                else if(v == values.SKIP) {
                    card1 = new SkipCard(c.toChar(), v.toInt(), s.toString());
                    card2 = new SkipCard(c.toChar(), v.toInt(), s.toString());
                }
                else if(v == values.ZERO && false) { //TODO: implementation of options in main for specific setting such as zeros and sevens special abilities. always false for now
                    card1 = new ZeroCard(c.toChar(), v.toInt(), s.toString());
                    card2 = new ZeroCard(c.toChar(), v.toInt(), s.toString());
                }
                else if(v == values.SEVEN && false) {
                    card1 = new SevenCard(c.toChar(), v.toInt(), s.toString());
                    card2 = new SevenCard(c.toChar(), v.toInt(), s.toString());
                } else {
                    card1 = new Card(c.toChar(), v.toInt(), s.toString());
                    card2 = new Card(c.toChar(), v.toInt(), s.toString());
                }
                cards.push(card1);
                cards.push(card2);
            }
        }
        Collections.shuffle(cards);
        last_card = cards.pop();
        discard.push(last_card);

        players.add(new UnoPlayer("USER", deal())); //TODO: Add more implementation of UNO players and bots. Needs functionality etc.
        players.add(new UnoBot("BOT1", deal()));
        players.add(new UnoBot("BOT2", deal()));
        players.add(new UnoBot("BOT3", deal()));
    }
    @Override
    public void play() {
        Player winner = null;
        while(true) {
            Card picked;
            if(players.get(pIndex) instanceof UnoPlayer) {
                UnoPlayer activeP = (UnoPlayer) players.get(pIndex);
                while(true) {
                    System.out.println("Last card: " + last_card + "\nYour cards: " + activeP.cardsToString() + "\nPlease pick a card using the number indicated or put -1 to pick up a card: ");
                    picked = activeP.takeTurn();
                    if(picked == null) {
                        System.out.println(activeP.getName() + " has chosen to pick up a card");
                        activeP.addCard(cards.pop());
                        continue;
                    }
                    else if(picked.getValue() != last_card.getValue() && picked.getType() != last_card.getType() && picked.getType() != 'W') {
                        System.out.println("Card cannot match with the last card. Please try again");
                        activeP.addCard(picked);
                        continue;
                    }
                    System.out.println(activeP.getName() + "has chosen " + picked);
                    break;
                }
                if(!activeP.hasCards()) {
                    winner = activeP;
                    break;
                }
            }
            else {
                UnoBot activeB = (UnoBot) players.get(pIndex);
                while(true) {
                    picked = activeB.takeTurn(last_card); //TODO: Bot either uses card from their deck or takes from pile
                    if(picked == null) {
                        activeB.addCard(cards.pop());
                        System.out.println(activeB.getName() + " has chosen to pick up a card");
                        continue;
                    }
                    break;
                }
                System.out.println(activeB.getName() + "has chosen " + picked);
                if(!activeB.hasCards()) {
                    winner = activeB;
                    break;
                }
            }
            if(picked instanceof ActionCard) {
                ((ActionCard) picked).doAction(this);
            }
            last_card = picked;
            if(cards.isEmpty()) {
                Collections.shuffle(discard);
                Stack<Card> t = cards;
                cards = discard;
                discard = t;
            }
            discard.push(picked);
            next();
        }
    }

    @Override
    public ArrayList<Card> deal() {
        ArrayList<Card> c = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            c.add(cards.pop());
        }
        return c;
    }

    public Player getCurrentPlayer() {
        return players.get(pIndex);
    }

    private void next() {
        if(reverse) {
            if(--pIndex < 0) {
                pIndex = players.size() - 1;
            }
        }
        else {
            if(++pIndex >= players.size()) {
                pIndex = 0;
            }
        }
    }
}
