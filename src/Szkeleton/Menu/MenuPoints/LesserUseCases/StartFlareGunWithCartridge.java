package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Karakter;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;
import Targy.Jelzofeny;
import Targy.Pisztoly;

public class StartFlareGunWithCartridge extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public StartFlareGunWithCartridge(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Jelzofeny.class, "hasznal", "Mezo");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Karakter.class, "keres", "Pisztoly");
            MethodCallHandler.callMethod(Karakter.class, "keres", "Patron");
            MethodCallHandler.callMethod(Karakter.class, "kombinal");
        MethodCallHandler.endOfInnerMethodCalls();

        //End
        MethodCallHandler.endScenario();
    }
}
