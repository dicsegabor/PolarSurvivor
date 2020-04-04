package Szkeleton.Menu.MenuPoints.MainUseCases;

import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.LesserUseCases.*;
import Szkeleton.Menu.MenuPoints.MenuPoint;

public class CharactersTryToAssembleFlareGun extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public CharactersTryToAssembleFlareGun(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Question
        Menu options = new Menu("A karaktereknel vannak a jelzopisztolyhoz szukseges targyak (pisztoly, jelzofeny, patron)?");
        options.addMenuPoint(new CharactersAssembleFlareGun("Igen"));
        options.addMenuPoint(new EndOfScenario("Nem"));
        options.start();
    }
}
