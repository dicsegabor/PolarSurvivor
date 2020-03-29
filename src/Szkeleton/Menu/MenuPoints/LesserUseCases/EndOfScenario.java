package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

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
        System.out.print("\nNincs további akció!\n");

        //End
        MethodCallHandler.endScenario();
    }
}
