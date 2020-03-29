package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Karakter;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class StromStrikesCharacter extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public StromStrikesCharacter(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Action
            MethodCallHandler.callMethod(Karakter.class, "testhotCsokkent", "1");
        MethodCallHandler.endOfInnerMethodCalls();

        //End
        MethodCallHandler.endScenario();
    }
}
