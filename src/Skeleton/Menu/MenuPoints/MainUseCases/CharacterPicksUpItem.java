package Skeleton.Menu.MenuPoints.MainUseCases;

import Skeleton.Menu.Menu;
import Skeleton.Menu.MenuPoints.LesserUseCases.CharacterPicksUpFood;
import Skeleton.Menu.MenuPoints.LesserUseCases.CharacterPicksUpNonFoodItem;
import Skeleton.Menu.MenuPoints.MenuPoint;

public class CharacterPicksUpItem extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public CharacterPicksUpItem(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Question
        Menu options = new Menu("Milyen targyat vesz fel a karakter?");
        options.addMenuPoint(new CharacterPicksUpFood("elelem"));
        options.addMenuPoint(new CharacterPicksUpNonFoodItem("Mas targy"));
        options.start();
    }
}
