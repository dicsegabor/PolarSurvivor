package Szkeleton.Menu.MenuPoints.MainUseCases;

import Karakter.Eszkimo;
import Karakter.Karakter;
import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.LesserUseCases.EskimoBuildIgluOnStableIce;
import Szkeleton.Menu.MenuPoints.LesserUseCases.EskimoBuildIgluOnUnstableIce;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class EskimoBuildsIglu extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public EskimoBuildsIglu(String displayedText) {
        super(displayedText);
    }

    /**
     * A menüponthoz tartozó funkciót itt kell megvalósítani
     * A szekveniciadiagramok alapján megírt kódot tartalmazza.
     */
    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Eszkimo.class, "iglutEpit");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Eszkimo.class, "munkaCsokkent");

        //Question
        Menu options = new Menu("Milyen jégtáblára építi az iglut?");
        options.addMenuPoint(new EskimoBuildIgluOnStableIce("Stabil jégtáblára"));
        options.addMenuPoint(new EskimoBuildIgluOnUnstableIce("Instabil jégtáblára"));
        options.start();
    }
}
