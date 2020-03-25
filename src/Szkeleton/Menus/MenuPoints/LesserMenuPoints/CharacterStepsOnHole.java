package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Karakter;
import Mezok.Jegtabla;
import Mezok.Lyuk;
import Mezok.Mezo;
import Mezok.StabilJegtabla;
import Szkeleton.Menus.MenuPoints.MainMenuPoints.CharacterFallsInWater;
import Szkeleton.Menus.MenuPoints.MenuPoint;

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
        Mezo to = new Lyuk();

        //Action
        character.lep(to);

        //Question?
        new CharacterFallsInWater("").function();
    }
}
