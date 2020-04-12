package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Mozgathato.Karakter;
import Mezo.Mezo;
import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class CharacterNeedsHelpInWater extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public CharacterNeedsHelpInWater(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Mezo.class, "segitseg", "Karakter");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Karakter.class, "keres", "Kotel");

        //Question
        Menu options = new Menu("Kimentik-e a karaktert a vizbol");
        options.addMenuPoint(new CharachterSavedFromWater("Igen"));
        options.addMenuPoint(new CharacterNotSavedFromWater("Nem"));
        options.start();
    }
}
