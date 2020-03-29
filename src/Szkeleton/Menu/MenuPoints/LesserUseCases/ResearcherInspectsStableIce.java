package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Kutato;
import Mezo.Lyuk;
import Mezo.StabilJegtabla;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class ResearcherInspectsStableIce extends MenuPoint {

   public ResearcherInspectsStableIce(String displayedText){
       super(displayedText);

    }


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
