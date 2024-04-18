package Uno;

import Interfaces.Card;
import Interfaces.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnoPlayer extends UnoBeing {
    public UnoPlayer(String name, ArrayList<Card> cards) {
        super(name, cards);
    }

    public String cardsToString() {
        StringBuilder s = new StringBuilder();
        int i = 1;
        for(Card c: cards) {
            s.append(i++).append(c).append(" | ");
        }
        return s.toString();
    }
    @Override
    public Card takeTurn() {
        Scanner inputInt = new Scanner(System.in);
        int choice = inputInt.nextInt();
        if(choice == -1) {
            return null;
        }
        if(choice < 1 || choice >= cards.size()) {
            System.out.println("Out of Bounds! Try again.");
            return takeTurn();
        }
        else {
            Card c = cards.get(choice - 1);
            cards.remove(choice -1);
            return c;
        }
    }

    @Override
    public char askColor() {
        Scanner inputStr = new Scanner(System.in);
        System.out.println("Select what color you would like using the characters from this list:\nR - Red\nB - Blue\nG - Green\nY - Yellow\n");
        char color = (char) inputStr.nextByte();
        if(color != 'R' && color != 'B' && color != 'G' && color != 'Y') {
            System.out.println("Character invalid. Please try again");
            return askColor();
        }
        return color;
    }
}
