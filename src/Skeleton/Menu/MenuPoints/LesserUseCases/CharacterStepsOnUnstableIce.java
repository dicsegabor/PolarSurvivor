package Skeleton.Menu.MenuPoints.LesserUseCases;

import Mozgathato.Karakter;
import Mezo.InstabilJegtabla;
import Mezo.Mezo;
import Skeleton.Menu.Menu;
import Skeleton.Menu.MenuPoints.MainUseCases.CharacterFallsInWater;
import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;

public class CharacterStepsOnUnstableIce extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public CharacterStepsOnUnstableIce(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
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
        Menu optionsMenu = new Menu("Tullepi-e ezzel a mezo kapacitasat?");
        optionsMenu.addMenuPoint(new CharacterFallsInWater("Igen"));
        optionsMenu.addMenuPoint(new EndOfScenario("Nem"));
        optionsMenu.start();
    }
}
