package Interfaces;

import java.util.function.Consumer;

public abstract class ActionCard extends Card {
    public ActionCard(char type, int value, String name) {
        super(type, value, name);
    }

    public abstract void doAction(Game g);
}
