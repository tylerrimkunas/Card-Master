package Uno;

import Interfaces.ActionCard;
import Interfaces.Game;

import java.util.function.Consumer;

public class ZeroCard extends ActionCard {
    public ZeroCard(char type, int value, String name) {
        super(type, value, name);
    }

    @Override
    public void doAction(Game g) {

    }
}
