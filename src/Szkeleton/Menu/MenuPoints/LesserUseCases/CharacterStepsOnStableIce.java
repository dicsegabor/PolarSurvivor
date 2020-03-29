package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Karakter;
import Mezo.Mezo;
import Mezo.StabilJegtabla;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class CharacterStepsOnStableIce extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterStepsOnStableIce(String displayedText) {
        super(displayedText);
    }

    /**
     * A menüponthoz tartozó funkciót itt kell megvalósítani
     * A szekveniciadiagramok alapján megírt kódot tartalmazza.
     */
    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Karakter.class, "lep", "StabilJegtabla");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Mezo.class, "szomszedE", "StabilJegtabla");
            MethodCallHandler.callMethod(Karakter.class, "munkaCsokkent");
            MethodCallHandler.callMethod(Mezo.class, "kiad", "Karakter");
            MethodCallHandler.callMethod(StabilJegtabla.class, "befogad", "Karakter");
        MethodCallHandler.endOfInnerMethodCalls();

        //End
        MethodCallHandler.endScenario();
    }
}
