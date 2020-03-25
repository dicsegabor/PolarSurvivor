package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.MenuPoint;

public class CharacterNeedsHelpInWater extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterNeedsHelpInWater(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Question
        Menu options = new Menu("Kimentik-e a karaktert a vízből");
        options.addMenuPoint(new CharachterSavedFromWater("Igen"));
        options.addMenuPoint(new CharacterNotSavedFromWater("Nem"));
        options.start();
    }
}
