package Szkeleton.Menu.MenuPoints.MainUseCases;

import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.LesserUseCases.CharacterPicksUpFood;
import Szkeleton.Menu.MenuPoints.LesserUseCases.CharacterPicksUpNonFoodItem;
import Szkeleton.Menu.MenuPoints.MenuPoint;

public class CharacterPicksUpItem extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterPicksUpItem(String displayedText) {
        super(displayedText);
    }

    /**
     * A menüponthoz tartozó funkciót itt kell megvalósítani
     * A szekveniciadiagramok alapján megírt kódot tartalmazza.
     */
    @Override
    public void function() {

        //Question
        Menu options = new Menu("Milyen tárgyat vesz fel a karakter?");
        options.addMenuPoint(new CharacterPicksUpFood("Élelem"));
        options.addMenuPoint(new CharacterPicksUpNonFoodItem("Más tárgy"));
        options.start();
    }
}
