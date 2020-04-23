package Skeleton.Menu.MenuPoints.MainUseCases;

import Skeleton.Menu.MenuPoints.MenuPoint;

public class Exit extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public Exit(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //End
        System.exit(0);
    }
}
