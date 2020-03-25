package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Szkeleton.Menus.MenuPoints.MenuPoint;

public class CharachterSavedFromWater extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharachterSavedFromWater(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        waitForKey();
    }
}
