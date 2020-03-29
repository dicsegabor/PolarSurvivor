package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Eszkimo;
import Mezo.StabilJegtabla;
import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.MainUseCases.CharacterFallsInWater;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class EskimoBuildIgluOnUnstableIce extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public EskimoBuildIgluOnUnstableIce(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Action
            MethodCallHandler.callMethod(StabilJegtabla.class, "setIgluzott", "true");

        //Question
        Menu optionsMenu = new Menu("Túllépi-e ezzel a mező kapacitását?");
        optionsMenu.addMenuPoint(new CharacterFallsInWater("Igen"));
        optionsMenu.addMenuPoint(new EndOfScenario("Nem"));
        optionsMenu.start();
    }
}
