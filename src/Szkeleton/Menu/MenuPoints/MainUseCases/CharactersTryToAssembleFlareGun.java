package Szkeleton.Menu.MenuPoints.MainUseCases;

import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.LesserUseCases.*;
import Szkeleton.Menu.MenuPoints.MenuPoint;

public class CharactersTryToAssembleFlareGun extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharactersTryToAssembleFlareGun(String displayedText) {
        super(displayedText);
    }

    /**
     * A menüponthoz tartozó funkciót itt kell megvalósítani
     * A szekveniciadiagramok alapján megírt kódot tartalmazza.
     */
    @Override
    public void function() {

        //Question
        Menu options = new Menu("A karaktereknel vannak a jelzőpisztolyhoz szükséges tárgyak (pisztoly, jelzofeny, patron)?");
        options.addMenuPoint(new CharactersAssembleFlareGun("Igen"));
        options.addMenuPoint(new EndOfScenario("Nem"));
        options.start();
    }
}
