package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Kutato;
import Mezok.InstabilJegtabla;
import Mezok.StabilJegtabla;
import Szkeleton.Menus.MenuPoints.MenuPoint;
import Szkeleton.Program;

public class CharacterViewsUnstableIce extends MenuPoint {


    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterViewsUnstableIce(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {


        //init
        Kutato kut = new Kutato();
        InstabilJegtabla isjeg = new InstabilJegtabla();

        //action
        kut.jegetNez(isjeg);


        //End
        Program.endScenario();

    }
}
