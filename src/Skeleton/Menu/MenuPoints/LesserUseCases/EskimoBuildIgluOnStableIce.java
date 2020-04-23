package Skeleton.Menu.MenuPoints.LesserUseCases;

import Mezo.StabilJegtabla;
import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;

public class EskimoBuildIgluOnStableIce extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public EskimoBuildIgluOnStableIce(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        // Action
            MethodCallHandler.callMethod(StabilJegtabla.class, "setIgluzott", "true");
        MethodCallHandler.endOfInnerMethodCalls();

        //End
        MethodCallHandler.endScenario();
    }
}
