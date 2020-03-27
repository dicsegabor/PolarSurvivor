package Szkeleton.Menus.MenuPoints.MainMenuPoints;

import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.*;
import Szkeleton.Menus.MenuPoints.MenuPoint;

public class CharactersAssembleFlareGun extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharactersAssembleFlareGun(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //sikeres az osszeszereles?
        Menu optionsTargyak=new Menu("a karakternel vannak a jelzopisztolyhoz szukseges targyak (pisztoly, jelzofeny, patron)?");
        optionsTargyak.addMenuPoint(new EndOfScenario("igen"));
        optionsTargyak.start();
        //Question
    }
}
