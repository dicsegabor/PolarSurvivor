package Skeleton.Menu.MenuPoints.LesserUseCases;

import Mozgathato.Karakter;
import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;
import Targy.Patron;

public class StartFlareGunWithFlare extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public StartFlareGunWithFlare(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
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
