package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Karakter;
import Mezok.InstabilJegtabla;
import Mezok.Jegtabla;
import Mezok.StabilJegtabla;
import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.MainMenuPoints.CharacterFallsInWater;
import Szkeleton.Menus.MenuPoints.MenuPoint;

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
        Jegtabla from = new StabilJegtabla();
        Jegtabla to = new InstabilJegtabla();
        from.befogad(character);
        from.setSzomszed(to);
        to.setSzomszed(from);

        //Action
        character.lep(to);
        from.szomszedE(to);
        from.kiad(character);
        to.befogad(character);

        //Question
        Menu optionsMenu = new Menu("Túllépi-e ezzel a mező kapacitását?");
        optionsMenu.addMenuPoint(new CharacterFallsInWater("Igen"));
        optionsMenu.addMenuPoint(new EndOfScenario("Nem"));
        optionsMenu.start();
    }
}
