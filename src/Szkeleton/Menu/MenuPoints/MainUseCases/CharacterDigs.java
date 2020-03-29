package Szkeleton.Menu.MenuPoints.MainUseCases;

import Karakter.Karakter;
import Mezo.Jegtabla;
import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.LesserUseCases.*;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class CharacterDigs extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterDigs(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        MethodCallHandler.callMethod(Karakter.class, "as", "Jegtabla");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Karakter.class, "munkaCsokkent");

        //Question
        Menu options = new Menu("Van-e lapátja a karakternek?");
        options.addMenuPoint(new CharacterDigsWithShovel("Igen"));
        options.addMenuPoint(new CharacterDigsWithoutShovel("Nem"));
        options.start();
    }
}
