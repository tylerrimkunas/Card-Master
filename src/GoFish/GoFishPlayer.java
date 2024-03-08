package GoFish;

import ClassicCards.ClassicCard;
import ClassicCards.ClassicCardValue;
import Interfaces.Card;
import Interfaces.Player;

import java.util.ArrayList;
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

    public void setCards(ArrayList<ClassicCard> cards) {
        this.cards = cards;
    }

    @Override
    public List<Card> getCards() {
        return null;
    }
}
