package Skeleton.Menu.MenuPoints.LesserUseCases;

import Mozgathato.Karakter;
import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;

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
