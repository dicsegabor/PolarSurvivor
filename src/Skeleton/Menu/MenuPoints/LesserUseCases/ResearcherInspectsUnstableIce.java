package Skeleton.Menu.MenuPoints.LesserUseCases;

import Mozgathato.Kutato;
import Mezo.InstabilJegtabla;
import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;

public class ResearcherInspectsUnstableIce extends MenuPoint {


    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public ResearcherInspectsUnstableIce(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
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
