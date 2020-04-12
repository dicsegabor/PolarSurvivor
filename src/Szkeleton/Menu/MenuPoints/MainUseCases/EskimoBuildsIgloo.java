package Szkeleton.Menu.MenuPoints.MainUseCases;

import Mozgathato.Eszkimo;
import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.LesserUseCases.EskimoBuildIgluOnStableIce;
import Szkeleton.Menu.MenuPoints.LesserUseCases.EskimoBuildIgluOnUnstableIce;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class EskimoBuildsIgloo extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public EskimoBuildsIgloo(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Eszkimo.class, "iglutEpit");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Eszkimo.class, "munkaCsokkent");

        //Question
        Menu options = new Menu("Milyen jegtablara epiti az iglut?");
        options.addMenuPoint(new EskimoBuildIgluOnStableIce("Stabil jegtablara"));
        options.addMenuPoint(new EskimoBuildIgluOnUnstableIce("Instabil jegtablara"));
        options.start();
    }
}
