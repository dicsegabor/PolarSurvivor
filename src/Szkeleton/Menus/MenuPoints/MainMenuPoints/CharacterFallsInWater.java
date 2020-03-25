package Szkeleton.Menus.MenuPoints.MainMenuPoints;

import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.*;
import Szkeleton.Menus.MenuPoints.MenuPoint;

public class CharacterFallsInWater extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterFallsInWater(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Question
        Menu options = new Menu("Van-e a karakteren búvárruha");
        options.addMenuPoint(new EndOfScenario("Igen"));
        options.addMenuPoint(new CharacterNeedsHelpInWater("Nem"));
        options.start();
    }
}
