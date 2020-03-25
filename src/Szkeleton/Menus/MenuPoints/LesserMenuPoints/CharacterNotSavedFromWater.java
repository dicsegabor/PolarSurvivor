package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Karakter;
import Szkeleton.Menus.MenuPoints.MenuPoint;
import Szkeleton.Program;

public class CharacterNotSavedFromWater extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterNotSavedFromWater(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Init
        Karakter victim = new Karakter();

        //Action
        victim.meghal();

        //End
        Program.endScenario();
    }
}
