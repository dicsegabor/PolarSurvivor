package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.MainMenuPoints.CharacterFallsInWater;
import Szkeleton.Menus.MenuPoints.MenuPoint;

public class CharacterStepsOnUnstableIce extends MenuPoint {

    public CharacterStepsOnUnstableIce(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        Menu optionsMenu = new Menu("Túllépi-e ezzel a mező kapacitását?");

        optionsMenu.addMenuPoint(new CharacterFallsInWater("Igen"));
        optionsMenu.addMenuPoint(new EndOfScenario("Nem"));

        optionsMenu.start();
    }
}
