package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Mezok.Mezo;
import Mezok.StabilJegtabla;
import Szkeleton.Menus.MenuPoints.MenuPoint;
import Szkeleton.Program;
import Targyak.Lapat;

public class CharacterDigsWithoutShovel extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterDigsWithoutShovel(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Init
        Mezo target = new StabilJegtabla();

        //Action
        target.havatCsokkent(1);

        //End
        Program.endScenario();
    }
}