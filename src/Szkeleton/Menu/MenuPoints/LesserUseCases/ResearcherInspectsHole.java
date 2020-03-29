package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Karakter;
import Karakter.Kutato;
import Mezo.Lyuk;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class ResearcherInspectsHole extends MenuPoint {
    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public ResearcherInspectsHole(String displayedText) {
        super(displayedText);
    }

    /**
     * A menüponthoz tartozó funkciót itt kell megvalósítani
     * A szekveniciadiagramok alapján megírt kódot tartalmazza.
     */
    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Kutato.class, "jegetNez", "Lyuk");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Kutato.class, "munkaCsokkent");
            MethodCallHandler.callMethod(Lyuk.class, "getKapacitas");
        MethodCallHandler.endOfInnerMethodCalls();

        //End
        MethodCallHandler.endScenario();

    }
}
