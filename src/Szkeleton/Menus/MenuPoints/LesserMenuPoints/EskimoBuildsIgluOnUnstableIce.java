package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Eszkimo;
import Mezok.InstabilJegtabla;
import Mezok.StabilJegtabla;
import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.MainMenuPoints.CharacterFallsInWater;
import Szkeleton.Menus.MenuPoints.MenuPoint;

public class EskimoBuildsIgluOnUnstableIce extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public EskimoBuildsIgluOnUnstableIce(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Init
        Eszkimo eskimo = new Eszkimo();
        InstabilJegtabla unstableIce = new InstabilJegtabla();
        unstableIce.befogad(eskimo);

        //Action
        eskimo.iglutEpit();
        unstableIce.setIgluzott(true);

        //Question
        Menu options = new Menu("Túllépi-e ezzel a mező kapacitását?");
        options.addMenuPoint(new CharacterFallsInWater("Igen"));
        options.addMenuPoint(new EndOfScenario("Nem"));
        options.start();
    }
}
