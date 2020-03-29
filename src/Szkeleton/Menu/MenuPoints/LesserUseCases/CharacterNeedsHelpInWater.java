package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Karakter;
import Mezo.Mezo;
import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class CharacterNeedsHelpInWater extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterNeedsHelpInWater(String displayedText) {
        super(displayedText);
    }

    /**
     * A menüponthoz tartozó funkciót itt kell megvalósítani
     * A szekveniciadiagramok alapján megírt kódot tartalmazza.
     */
    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Mezo.class, "segitseg", "Karakter");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Karakter.class, "keres", "Kotel");

        //Question
        Menu options = new Menu("Kimentik-e a karaktert a vízből");
        options.addMenuPoint(new CharachterSavedFromWater("Igen"));
        options.addMenuPoint(new CharacterNotSavedFromWater("Nem"));
        options.start();
    }
}
