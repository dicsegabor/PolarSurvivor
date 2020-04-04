package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Karakter;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;
import Targy.Pisztoly;

import java.awt.event.KeyAdapter;

public class StartFlareGunWithGun extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public StartFlareGunWithGun(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Pisztoly.class, "hasznal", "Mezo");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Karakter.class, "keres", "Jezofeny");
            MethodCallHandler.callMethod(Karakter.class, "keres", "Patron");
            MethodCallHandler.callMethod(Karakter.class, "kombinal");
            MethodCallHandler.callMethod(Karakter.class, "munkaCsokkent");
        MethodCallHandler.endOfInnerMethodCalls();

        //End
        MethodCallHandler.endScenario();
    }
}
