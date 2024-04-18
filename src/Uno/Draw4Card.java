package Uno;

import Interfaces.ActionCard;
import Interfaces.Game;

public class Draw4Card extends ChangeColorCard {
    public Draw4Card(char type, int value, String name) {
        super(type, value, name);
    }

    @Override
    public void doAction(Game g) {
        super.doAction(g);
        if(g instanceof Uno ug) {
            ug.useDraw(4);
            ug.next();
        }
    }
}
