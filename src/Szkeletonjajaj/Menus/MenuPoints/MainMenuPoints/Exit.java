package Szkeletonjajaj.Menus.MenuPoints.MainMenuPoints;

import Szkeletonjajaj.Menus.MenuPoints.MenuPoint;

public class Exit extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public Exit(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        System.exit(0);
    }
}
