package Skeleton.Menu.MenuPoints.LesserUseCases;

import Mozgathato.Kutato;
import Mezo.StabilJegtabla;
import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;

public class ResearcherInspectsStableIce extends MenuPoint {

   public ResearcherInspectsStableIce(String displayedText){
       super(displayedText);

    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //action
        MethodCallHandler.callMethod(Kutato.class, "jegetNez", "StabilJegtabla");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Kutato.class, "munkaCsokkent");
            MethodCallHandler.callMethod(StabilJegtabla.class, "getKapacitas");
        MethodCallHandler.endOfInnerMethodCalls();

        //End
        MethodCallHandler.endScenario();
    }
}
