package Szkeletonjajaj.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Karakter;
import Mezok.InstabilJegtabla;
import Mezok.Jegtabla;
import Mezok.StabilJegtabla;
import Szkeletonjajaj.Menus.Menu;
import Szkeletonjajaj.Menus.MenuPoints.MainMenuPoints.CharacterFallsInWater;
import Szkeletonjajaj.Menus.MenuPoints.MenuPoint;

public class CharacterStepsOnUnstableIce extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterStepsOnUnstableIce(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Init
        Karakter character = new Karakter();
        Jegtabla to = new InstabilJegtabla();

        //Action
        character.lep(to);

        //Question
        Menu optionsMenu = new Menu("Túllépi-e ezzel a mező kapacitását?");
        optionsMenu.addMenuPoint(new CharacterFallsInWater("Igen"));
        optionsMenu.addMenuPoint(new EndOfScenario("Nem"));
        optionsMenu.start();
    }
}
