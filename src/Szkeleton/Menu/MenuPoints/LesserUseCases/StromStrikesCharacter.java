package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Mozgathato.Karakter;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class StromStrikesCharacter extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public StromStrikesCharacter(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Action
            MethodCallHandler.callMethod(Karakter.class, "testhotCsokkent", "1");
        MethodCallHandler.endOfInnerMethodCalls();

        //End
        MethodCallHandler.endScenario();
    }
}