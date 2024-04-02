package Uno;

import Interfaces.ActionCard;
import Interfaces.Game;

import java.util.function.Consumer;

public class Plus2Card extends ActionCard {
    public Plus2Card(char type, int value, String name) {
        super(type, value, name);
    }

    @Override
    public void doAction(Game g) {

    }
}
