package Szkeleton.Menus.MenuPoints.MainMenuPoints;

import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.MenuPoint;

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
