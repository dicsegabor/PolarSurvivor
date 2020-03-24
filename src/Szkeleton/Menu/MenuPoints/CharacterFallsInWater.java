package Szkeleton.Menu.MenuPoints;

import Szkeleton.Menu.Menu;

public class CharacterFallsInWater extends MenuPoint {

    public CharacterFallsInWater(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        Menu helpOptions = new Menu("Kimentik-e a karaktert a vízből?");

        helpOptions.addMenuPoint(new CharachterSavedFromWater("Igen"));
        helpOptions.addMenuPoint(new CharacterNotSavedFromWater("Nem"));

        helpOptions.start();
    }
}
