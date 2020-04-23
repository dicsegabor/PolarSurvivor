package Skeleton.Menu.MenuPoints.LesserUseCases;

import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;
import Mezo.Jegtabla;
import Targy.Lapat;

public class CharacterDigsWithShovel extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public CharacterDigsWithShovel(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Action
            MethodCallHandler.callMethod(Lapat.class, "hasznal", "Jegtabla");
            MethodCallHandler.innerMethodCalls();
                MethodCallHandler.callMethod(Jegtabla.class, "havatCsokkent", "2");
        MethodCallHandler.endOfInnerMethodCalls();
        MethodCallHandler.endOfInnerMethodCalls();

        //End
        MethodCallHandler.endScenario();
    }
}
