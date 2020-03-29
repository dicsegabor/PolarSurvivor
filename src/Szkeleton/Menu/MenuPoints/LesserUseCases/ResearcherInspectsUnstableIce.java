package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Kutato;
import Mezo.InstabilJegtabla;
import Mezo.Lyuk;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class ResearcherInspectsUnstableIce extends MenuPoint {


    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public ResearcherInspectsUnstableIce(String displayedText) {
        super(displayedText);
    }

    /**
     * A menüponthoz tartozó funkciót itt kell megvalósítani
     * A szekveniciadiagramok alapján megírt kódot tartalmazza.
     */
    @Override
    public void function() {

        //action
        MethodCallHandler.callMethod(Kutato.class, "jegetNez", "InstabilJegtabla");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Kutato.class, "munkaCsokkent");
            MethodCallHandler.callMethod(InstabilJegtabla.class, "getKapacitas");
        MethodCallHandler.endOfInnerMethodCalls();

        //End
        MethodCallHandler.endScenario();

    }
}
