package Skeleton.Menu.MenuPoints.LesserUseCases;

import Mozgathato.Kutato;
import Mezo.Lyuk;
import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;

public class ResearcherInspectsHole extends MenuPoint {
    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public ResearcherInspectsHole(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
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
