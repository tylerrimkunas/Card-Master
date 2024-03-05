package GoFish;
import ClassicCards.ClassicCard;
import ClassicCards.ClassicCardDeck;

import java.util.ArrayList;

public class GoFishDeck extends ClassicCardDeck {
    public GoFishDeck() {
        super();
    }

    @Override
    public ArrayList<ClassicCard> deal() {
        ArrayList<ClassicCard> cards = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            cards.add((ClassicCard)this.takeCard());
        }
        return cards;
    }
}
