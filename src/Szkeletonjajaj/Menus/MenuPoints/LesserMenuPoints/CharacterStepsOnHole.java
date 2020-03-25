package Szkeletonjajaj.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Karakter;
import Mezok.Jegtabla;
import Mezok.Lyuk;
import Mezok.Mezo;
import Mezok.StabilJegtabla;
import Szkeletonjajaj.Menus.MenuPoints.MainMenuPoints.CharacterFallsInWater;
import Szkeletonjajaj.Menus.MenuPoints.MenuPoint;

public class CharacterStepsOnHole extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterStepsOnHole(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Init
        Karakter character = new Karakter();
        Jegtabla from = new StabilJegtabla();
        Mezo to = new Lyuk();
        from.befogad(character);
        from.setSzomszed(to);
        to.setSzomszed(from);

        //Action
        character.lep(to);
        from.szomszedE(to);
        from.kiad(character);
        to.befogad(character);

        new CharacterFallsInWater("").function();
    }
}
