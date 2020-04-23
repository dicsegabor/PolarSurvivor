package Skeleton.Menu.MenuPoints.LesserUseCases;

import Mozgathato.Karakter;
import Mezo.Mezo;
import Mezo.StabilJegtabla;
import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;

public class CharacterStepsOnStableIce extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public CharacterStepsOnStableIce(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
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
