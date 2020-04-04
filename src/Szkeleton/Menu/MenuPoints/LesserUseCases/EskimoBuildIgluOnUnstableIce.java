package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Eszkimo;
import Mezo.StabilJegtabla;
import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.MainUseCases.CharacterFallsInWater;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class EskimoBuildIgluOnUnstableIce extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public EskimoBuildIgluOnUnstableIce(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Action
            MethodCallHandler.callMethod(StabilJegtabla.class, "setIgluzott", "true");

        //Question
        Menu optionsMenu = new Menu("Tullepi-e ezzel a mezo kapacitasat?");
        optionsMenu.addMenuPoint(new CharacterFallsInWater("Igen"));
        optionsMenu.addMenuPoint(new EndOfScenario("Nem"));
        optionsMenu.start();
    }
}
