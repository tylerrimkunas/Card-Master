package Uno;

import Interfaces.ActionCard;
import Interfaces.Game;

import java.util.function.Consumer;

public class ReverseCard extends ActionCard {
    public ReverseCard(char type, int value, String name) {
        super(type, value, name);
    }

    @Override
    public void doAction(Game g) {

    }
}
