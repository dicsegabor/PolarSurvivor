package Skeleton.Menu.MenuPoints.LesserUseCases;

import Mozgathato.Karakter;
import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;
import Targy.Elelem;

public class CharacterPicksUpFood extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public CharacterPicksUpFood(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Karakter.class, "felvesz", "Elelem");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Elelem.class, "hasznal");
        MethodCallHandler.endOfInnerMethodCalls();

        //End
        MethodCallHandler.endScenario();
    }
}
