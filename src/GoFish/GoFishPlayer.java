package GoFish;

import ClassicCards.ClassicCard;
import ClassicCards.ClassicCardValue;
import Interfaces.Card;
import Interfaces.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoFishPlayer implements Player {
    private String name;
    private ArrayList<ClassicCard> cards;
    private int score;
    public GoFishPlayer(String name) {
        this.name = name;
        cards = new ArrayList<>();
        score = 0;
    }
    @Override
    public void takeTurn() {

    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    private void inc_score() {
        score++;
    }

    public int has(ClassicCardValue rank) {
        int counter = 0;
        for(ClassicCard c: cards) {
            if(c.getRank() == rank) {
                counter++;
            }
        }
        return counter;
    }


    public void gainCard(ClassicCard newCard) {
        if(1 + has(newCard.getRank()) == 4) {
            loseCards(3, newCard.getRank());
            score++;
        }
        else cards.add(newCard);
    }
    public void gainCards(ClassicCard[] newCards) {
        if(newCards.length + has(newCards[0].getRank()) == 4) {
            loseCards(3, newCards[0].getRank());
            score++;
        }
        else cards.addAll(Arrays.asList(newCards));
    }

    public ClassicCard[] loseCards(int count, ClassicCardValue value) {
        ClassicCard[] lostCards = new ClassicCard[count];
        int index = 0;
        for(ClassicCard c: cards) {
            if(c.getRank() == value) {
                lostCards[index++] = c;
                cards.remove(c);
                if(index >= count) {
                    break;
                }
            }
        }
        return lostCards;
    }

    public void setCards(ArrayList<ClassicCard> cards) {
        this.cards = cards;
    }

    @Override
    public List<Card> getCards() {
        return cards.isEmpty() ? null : (List) cards;
    }

    public String cardsToString() {
        StringBuilder x = new StringBuilder();
        for(ClassicCard c: cards) {
            x.append(c.toString()).append(" | ");
        }
        return x.toString();
    }
}
