package Uno;

import Interfaces.ActionCard;
import Interfaces.Game;

import java.util.function.Consumer;

public class SevenCard extends ActionCard {
    public SevenCard(char type, int value, String name) {
        super(type, value, name);
    }

    @Override
    public void doAction(Game g) {

    }
}
