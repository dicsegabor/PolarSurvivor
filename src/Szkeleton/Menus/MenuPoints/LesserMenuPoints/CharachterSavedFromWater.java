package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Karakter;
import Mezok.Lyuk;
import Mezok.Mezo;
import Mezok.StabilJegtabla;
import Szkeleton.Menus.MenuPoints.MenuPoint;
import Szkeleton.Program;
import Targyak.Kotel;

public class CharachterSavedFromWater extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharachterSavedFromWater(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Init
        Kotel rope = new Kotel();
        Mezo from = new Lyuk();

        //Action
        rope.hasznal(from);

        //End
        Program.endScenario();
    }
}
