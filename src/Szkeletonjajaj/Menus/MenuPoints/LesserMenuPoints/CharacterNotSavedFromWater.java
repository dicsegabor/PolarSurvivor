package Szkeletonjajaj.Menus.MenuPoints.LesserMenuPoints;

import Szkeletonjajaj.Menus.MenuPoints.MenuPoint;

public class CharacterNotSavedFromWater extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterNotSavedFromWater(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        waitForKey();
    }
}
