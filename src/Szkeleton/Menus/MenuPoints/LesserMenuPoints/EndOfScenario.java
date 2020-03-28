package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Szkeleton.Menus.MenuPoints.MenuPoint;
import Szkeleton.Program;

public class EndOfScenario extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public EndOfScenario(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Action
        Program.writeToBuffer("Nincs további akció");

        //End
        Program.endScenario();
    }
}
