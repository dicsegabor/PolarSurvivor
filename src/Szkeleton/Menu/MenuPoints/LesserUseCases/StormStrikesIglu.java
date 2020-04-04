package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Karakter;
import Mezo.Mezo;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class StormStrikesIglu extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public StormStrikesIglu(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Action
            MethodCallHandler.callMethod(Mezo.class, "setIgluzott", "false");
        MethodCallHandler.endOfInnerMethodCalls();

        //End
        MethodCallHandler.endScenario();
    }
}
