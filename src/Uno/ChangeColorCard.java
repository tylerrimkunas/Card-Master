package Uno;

import Interfaces.ActionCard;
import Interfaces.Game;

public class ChangeColorCard extends ActionCard {
    public ChangeColorCard(char type, int value, String name) {
        super(type, value, name);
    }

    @Override
    public void doAction(Game g) {
        if(g instanceof Uno ug) {
            ug.useChangeColor();
        }
    }
}
