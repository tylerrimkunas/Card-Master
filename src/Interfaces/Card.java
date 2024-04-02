package Interfaces;

public class Card {
    private char type;
    private int value;
    private String name;
    public Card(char type, int value, String name) {
        this.type = type;
        this.value = value;
        this.name = name;
    }

    /**
     * Access method for type
     * @return card's type
     */
    public char getType() {
        return type;
    }

    /**
     * Access method for value
     * @return card's value
     */
    public int getValue() {
        return value;
    }

    /**
     * Compares one card to another. Checks value and type.
     * @param card the card that will be compared to this instance
     * @return 3 = type and value doesn't match, 2 = value doesn't match, 1 = type doesn't match, 0 = same card
     */
    public int compareTo(Card card) {
        int x = 0;
        if(value != card.getValue()) {
            x += 2;
        }
        if(type != card.getType()) {
            x += 1;
        }
        return x;    }

    /**
     * Access method for the name of card
     * @return name of the card ex: "Ace of Spades"
     */
    public String toString() {
        return name;
        }
}
