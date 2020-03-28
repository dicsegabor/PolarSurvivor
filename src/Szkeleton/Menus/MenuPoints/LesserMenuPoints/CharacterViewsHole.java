package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Kutato;
import Mezok.InstabilJegtabla;
import Mezok.Lyuk;
import Szkeleton.Menus.MenuPoints.MenuPoint;
import Szkeleton.Program;

public class CharacterViewsHole extends MenuPoint {
    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterViewsHole(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //init
        Kutato kut = new Kutato();
        Lyuk lyuk = new Lyuk();

        //action
        kut.jegetNez(lyuk);




        //End
        Program.endScenario();

    }
}
