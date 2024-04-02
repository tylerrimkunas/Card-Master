package Interfaces;

import java.util.function.Consumer;

public class ActionCard extends Card {
    private Consumer<?> action;
    public ActionCard(char type, int value, String name, Consumer<?> action) {
        super(type, value, name);
        this.action = action;
    }

    public Consumer<?> getAction() {
        return action;
    }
}
