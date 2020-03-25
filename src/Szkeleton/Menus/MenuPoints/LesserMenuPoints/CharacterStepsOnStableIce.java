package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Karakter;
import Mezok.Jegtabla;
import Mezok.StabilJegtabla;
import Szkeleton.Menus.MenuPoints.MenuPoint;
import Szkeleton.Program;

public class CharacterStepsOnStableIce extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterStepsOnStableIce(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Init
        Karakter character = new Karakter();
        Jegtabla to = new StabilJegtabla();

        //Action
        character.lep(to);

        //End
        Program.endScenario();
    }
}
