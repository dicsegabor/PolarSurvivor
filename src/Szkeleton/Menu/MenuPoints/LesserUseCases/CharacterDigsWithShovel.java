package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Karakter;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;
import Mezo.Jegtabla;
import Targy.Lapat;

public class CharacterDigsWithShovel extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterDigsWithShovel(String displayedText) {
        super(displayedText);
    }

    /**
     * A menüponthoz tartozó funkciót itt kell megvalósítani
     * A szekveniciadiagramok alapján megírt kódot tartalmazza.
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
