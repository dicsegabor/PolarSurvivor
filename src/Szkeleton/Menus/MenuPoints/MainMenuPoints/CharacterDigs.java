package Szkeleton.Menus.MenuPoints.MainMenuPoints;

import Karakterek.Karakter;
import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.*;
import Szkeleton.Menus.MenuPoints.MenuPoint;

public class CharacterDigs extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterDigs(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Init
        Karakter digger = new Karakter();

        //Action
        digger.as();

        //Question
        Menu options = new Menu("Van-e lapátja a karakternek?");
        options.addMenuPoint(new CharacterDigsWithShovel("Igen"));
        options.addMenuPoint(new CharacterDigsWithoutShovel("Nem"));
        options.start();
    }
}
