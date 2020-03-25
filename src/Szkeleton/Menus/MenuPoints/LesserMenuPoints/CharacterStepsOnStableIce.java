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
        Program.write = false;
        Karakter character = new Karakter();
        Jegtabla to = new StabilJegtabla();

        //Action
        Program.write = true;
        character.lep(to);

        //End
        Program.indent = 0;
        waitForKey();
    }
}
