package ClassicCards;

public enum ClassicSuit {
    HEART,
    DIAMOND,
    SPADE,
    CLUB;

    public static ClassicSuit convertInt(int x) {
        switch(x) {
            case 0:
                return HEART;
            case 1:
                return DIAMOND;
            case 2:
                return SPADE;
            case 3:
                return CLUB;
        }
        return null;
    }

    public int toInt() {
        switch(this) {
            case HEART:
                return 0;
            case DIAMOND:
                return 1;
            case SPADE:
                return 2;
            case CLUB:
                return 3;
        }
        return -1;
    }

    @Override
    public String toString() {
        switch(this) {
            case HEART:
                return "Hearts";
            case DIAMOND:
                return "Diamonds";
            case SPADE:
                return "Spades";
            case CLUB:
                return "Clubs";
        }
        return null;
    }
}
