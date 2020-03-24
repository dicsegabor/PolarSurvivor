package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Karakter;
import Mezok.Jegtabla;
import Mezok.StabilJegtabla;
import Szkeleton.Menus.MenuPoints.MenuPoint;

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
        Jegtabla from = new StabilJegtabla();
        Jegtabla to = new StabilJegtabla();
        from.befogad(character);
        from.setSzomszed(to);
        to.setSzomszed(from);

        //Action
        character.lep(to);
        from.szomszedE(to);
        from.kiad(character);
        to.befogad(character);

        waitForKey();
    }
}
