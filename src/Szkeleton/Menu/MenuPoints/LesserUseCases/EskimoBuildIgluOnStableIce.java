package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Eszkimo;
import Mezo.StabilJegtabla;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class EskimoBuildIgluOnStableIce extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public EskimoBuildIgluOnStableIce(String displayedText) {
        super(displayedText);
    }

    /**
     * A menüponthoz tartozó funkciót itt kell megvalósítani
     * A szekveniciadiagramok alapján megírt kódot tartalmazza.
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
