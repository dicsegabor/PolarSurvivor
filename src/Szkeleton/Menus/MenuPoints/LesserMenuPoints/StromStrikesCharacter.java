package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Karakter;
import Mezok.Mezo;
import Mezok.StabilJegtabla;
import Szkeleton.Menus.MenuPoints.MenuPoint;
import Szkeleton.Program;
import Targyak.Lapat;

public class StromStrikesCharacter extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public StromStrikesCharacter(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Init
        Karakter victim = new Karakter();

        //Action
        victim.testhotCsokkent(1);

        //End
        Program.endScenario();
    }
}
