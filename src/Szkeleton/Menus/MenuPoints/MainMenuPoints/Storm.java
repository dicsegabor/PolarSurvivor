package Szkeleton.Menus.MenuPoints.MainMenuPoints;

import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.*;
import Szkeleton.Menus.MenuPoints.MenuPoint;

public class Storm extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public Storm(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Question
        Menu stepOptions = new Menu("Elkap-e valakit a vihar?");
        stepOptions.addMenuPoint(new StromStrikesCharacter("Igen"));
        stepOptions.addMenuPoint(new EndOfScenario("Nem"));
        stepOptions.start();
    }
}
