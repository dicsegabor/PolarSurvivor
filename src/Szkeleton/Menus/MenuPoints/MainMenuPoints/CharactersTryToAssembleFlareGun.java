package Szkeleton.Menus.MenuPoints.MainMenuPoints;

import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.*;
import Szkeleton.Menus.MenuPoints.MenuPoint;

public class CharactersTryToAssembleFlareGun extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharactersTryToAssembleFlareGun(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Question
        Menu options = new Menu("A karakternel vannak a jelzopisztolyhoz szukseges targyak (pisztoly, jelzofeny, patron)?");
        options.addMenuPoint(new CharacterAssemblesFlareGun("Igen"));
        options.addMenuPoint(new EndOfScenario("Nem"));
        options.start();
    }
}
