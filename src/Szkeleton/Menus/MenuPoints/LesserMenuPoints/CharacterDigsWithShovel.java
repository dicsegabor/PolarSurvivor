package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Mezok.Mezo;
import Mezok.StabilJegtabla;
import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.MenuPoint;
import Szkeleton.Program;
import Targyak.Lapat;

public class CharacterDigsWithShovel extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterDigsWithShovel(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Init
        Lapat shovel = new Lapat();
        Mezo target = new StabilJegtabla();

        //Action
        shovel.hasznal(target);

        //End
        Program.endScenario();
    }
}
