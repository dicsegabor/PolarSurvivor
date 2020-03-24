package Szkeleton.Menus.MenuPoints.MainMenuPoints;

import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.CharachterSavedFromWater;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.CharacterNotSavedFromWater;
import Szkeleton.Menus.MenuPoints.MenuPoint;

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
