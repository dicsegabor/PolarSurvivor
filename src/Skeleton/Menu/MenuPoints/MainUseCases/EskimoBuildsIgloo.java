package Skeleton.Menu.MenuPoints.MainUseCases;

import Mozgathato.Eszkimo;
import Skeleton.Menu.Menu;
import Skeleton.Menu.MenuPoints.LesserUseCases.EskimoBuildIgluOnStableIce;
import Skeleton.Menu.MenuPoints.LesserUseCases.EskimoBuildIgluOnUnstableIce;
import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;

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
