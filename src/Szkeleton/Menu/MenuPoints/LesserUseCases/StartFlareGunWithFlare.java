package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Karakter;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;
import Targy.Patron;
import Targy.Pisztoly;

public class StartFlareGunWithFlare extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public StartFlareGunWithFlare(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Patron.class, "hasznal", "Mezo");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Karakter.class, "keres", "Pisztoly");
            MethodCallHandler.callMethod(Karakter.class, "keres", "Jelzofeny");
            MethodCallHandler.callMethod(Karakter.class, "kombinal");
        MethodCallHandler.endOfInnerMethodCalls();

        //End
        MethodCallHandler.endScenario();
    }
}
