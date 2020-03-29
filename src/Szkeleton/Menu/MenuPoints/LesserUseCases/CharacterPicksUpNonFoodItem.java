package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Karakter;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class CharacterPicksUpNonFoodItem extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterPicksUpNonFoodItem(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Karakter.class, "felvesz", "Targy");

        //End
        MethodCallHandler.endScenario();
    }
}
