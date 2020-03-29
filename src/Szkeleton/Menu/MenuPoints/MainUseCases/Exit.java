package Szkeleton.Menu.MenuPoints.MainUseCases;

import Szkeleton.Menu.MenuPoints.MenuPoint;

public class Exit extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public Exit(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {


        //End
        System.exit(0);
    }
}
