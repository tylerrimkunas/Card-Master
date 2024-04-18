package Uno;

import Interfaces.ActionCard;
import Interfaces.Game;

import java.util.function.Consumer;

public class SkipCard extends ActionCard {
    public SkipCard(char type, int value, String name) {
        super(type, value, name);
    }

    @Override
    public void doAction(Game g) {
        if(g instanceof Uno ug) {
            ug.next();
        }
    }
}
