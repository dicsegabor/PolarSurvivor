package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Eszkimo;
import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.MainMenuPoints.CharacterFallsInWater;
import Szkeleton.Menus.MenuPoints.MenuPoint;
import Szkeleton.Program;

public class EskimoBuildIgluOnUnstableIce extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public EskimoBuildIgluOnUnstableIce(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Init
        Eszkimo eskimo = new Eszkimo();

        //Action
        eskimo.iglutEpit();

        //Question
        Menu optionsMenu = new Menu("Túllépi-e ezzel a mező kapacitását?");
        optionsMenu.addMenuPoint(new CharacterFallsInWater("Igen"));
        optionsMenu.addMenuPoint(new EndOfScenario("Nem"));
        optionsMenu.start();
    }
}
