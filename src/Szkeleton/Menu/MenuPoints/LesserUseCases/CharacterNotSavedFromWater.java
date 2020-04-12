package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Mozgathato.Karakter;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class CharacterNotSavedFromWater extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public CharacterNotSavedFromWater(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Action
        MethodCallHandler.endOfInnerMethodCalls();
        MethodCallHandler.callMethod(Karakter.class, "meghal");

        //End
        MethodCallHandler.endScenario();
    }
}
