package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Karakter;
import Mezo.Mezo;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;
import Targy.Kotel;

public class CharachterSavedFromWater extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharachterSavedFromWater(String displayedText) {
        super(displayedText);
    }

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
