package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Karakter;
import Mezok.Mezo;
import Mezok.StabilJegtabla;
import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.MenuPoint;
import Szkeleton.Program;
import Targyak.Buvarruha;

public class CharacterUsesDivingSuit extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterUsesDivingSuit(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Init
        Buvarruha divingSuit = new Buvarruha();
        Mezo field = new StabilJegtabla();

        //Action
        divingSuit.hasznal(field);

        //End
        Program.endScenario();
    }
}
