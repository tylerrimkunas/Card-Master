package ClassicCards;

public enum ClassicCardValue {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;

    public static ClassicCardValue convertInt(int x) {
        switch(x) {
            case 0:
                return TWO;
            case 1:
                return THREE;
            case 2:
                return FOUR;
            case 3:
                return FIVE;
            case 4:
                return SIX;
            case 5:
                return SEVEN;
            case 6:
                return EIGHT;
            case 7:
                return NINE;
            case 8:
                return TEN;
            case 9:
                return JACK;
            case 10:
                return QUEEN;
            case 11:
                return KING;
            case 12:
                return ACE;
        }
        return null;
    }

    public int toInt() {
        switch(this) {
            case TWO:
                return 0;
            case THREE:
                return 1;
            case FOUR:
                return 2;
            case FIVE:
                return 3;
            case SIX:
                return 4;
            case SEVEN:
                return 5;
            case EIGHT:
                return 6;
            case NINE:
                return 7;
            case TEN:
                return 8;
            case JACK:
                return 9;
            case QUEEN:
                return 10;
            case KING:
                return 11;
            case ACE:
                return 12;
        }
        return -1;
    }

    @Override
    public String toString() {
        switch(this) {
            case TWO:
                return "Two";
            case THREE:
                return "Three";
            case FOUR:
                return "Four";
            case FIVE:
                return "Five";
            case SIX:
                return "Six";
            case SEVEN:
                return "Seven";
            case EIGHT:
                return "Eight";
            case NINE:
                return "Nine";
            case TEN:
                return "Ten";
            case JACK:
                return "Jack";
            case QUEEN:
                return "Queen";
            case KING:
                return "King";
            case ACE:
                return "Ace";
        }
        return null;
    }
}
