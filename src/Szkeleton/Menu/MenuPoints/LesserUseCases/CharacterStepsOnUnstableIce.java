package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Karakter;
import Mezo.InstabilJegtabla;
import Mezo.Jegtabla;
import Mezo.Mezo;
import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.MainUseCases.CharacterFallsInWater;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class CharacterStepsOnUnstableIce extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterStepsOnUnstableIce(String displayedText) {
        super(displayedText);
    }

    /**
     * A menüponthoz tartozó funkciót itt kell megvalósítani
     * A szekveniciadiagramok alapján megírt kódot tartalmazza.
     */
    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Karakter.class, "lep", "InstabilJegtabla");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Mezo.class, "szomszedE", "InstabilJegtabla");
            MethodCallHandler.callMethod(Karakter.class, "munkaCsokkent");
            MethodCallHandler.callMethod(Mezo.class, "kiad", "Karakter");
            MethodCallHandler.callMethod(InstabilJegtabla.class, "befogad", "Karakter");
            MethodCallHandler.innerMethodCalls();

        //Question
        Menu optionsMenu = new Menu("Túllépi-e ezzel a mező kapacitását?");
        optionsMenu.addMenuPoint(new CharacterFallsInWater("Igen"));
        optionsMenu.addMenuPoint(new EndOfScenario("Nem"));
        optionsMenu.start();
    }
}
