package Szkeleton.Menu.MenuPoints.MainUseCases;

import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.LesserUseCases.*;
import Szkeleton.Menu.MenuPoints.MenuPoint;

public class CharacterFallsInWater extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public CharacterFallsInWater(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Question
        Menu options = new Menu("Van-e a karakteren buvarruha?");
        options.addMenuPoint(new CharacterUsesDivingSuit("Igen"));
        options.addMenuPoint(new CharacterNeedsHelpInWater("Nem"));
        options.start();
    }
}
