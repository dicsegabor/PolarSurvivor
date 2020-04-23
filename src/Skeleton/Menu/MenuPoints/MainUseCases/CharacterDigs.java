package Skeleton.Menu.MenuPoints.MainUseCases;

import Mozgathato.Karakter;
import Skeleton.Menu.Menu;
import Skeleton.Menu.MenuPoints.LesserUseCases.*;
import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;

public class CharacterDigs extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public CharacterDigs(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        MethodCallHandler.callMethod(Karakter.class, "as", "Jegtabla");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Karakter.class, "munkaCsokkent");

        //Question
        Menu options = new Menu("Van-e lapatja a karakternek?");
        options.addMenuPoint(new CharacterDigsWithShovel("Igen"));
        options.addMenuPoint(new CharacterDigsWithoutShovel("Nem"));
        options.start();
    }
}
