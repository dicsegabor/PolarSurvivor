package Skeleton.Menu.MenuPoints.LesserUseCases;

import Mezo.Mezo;
import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;
import Targy.Kotel;

public class CharachterSavedFromWater extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public CharachterSavedFromWater(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Kotel.class, "hasznal", "Mezo");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Mezo.class, "kiad", "Karakter");
            MethodCallHandler.callMethod(Mezo.class, "befogad", "Karakter");
        MethodCallHandler.endOfInnerMethodCalls();

        //End
        MethodCallHandler.endScenario();
    }
}
