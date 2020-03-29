package Szkeleton.Menu.MenuPoints.MainUseCases;

import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.LesserUseCases.*;
import Szkeleton.Menu.MenuPoints.MenuPoint;

public class CharacterFallsInWater extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterFallsInWater(String displayedText) {
        super(displayedText);
    }

    /**
     * A menüponthoz tartozó funkciót itt kell megvalósítani
     * A szekveniciadiagramok alapján megírt kódot tartalmazza.
     */
    @Override
    public void function() {

        //Question
        Menu options = new Menu("Van-e a karakteren búvárruha?");
        options.addMenuPoint(new CharacterUsesDivingSuit("Igen"));
        options.addMenuPoint(new CharacterNeedsHelpInWater("Nem"));
        options.start();
    }
}
