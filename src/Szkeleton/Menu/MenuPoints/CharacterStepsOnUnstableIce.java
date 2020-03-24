package Szkeleton.Menu.MenuPoints;

import Szkeleton.Menu.Menu;

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
