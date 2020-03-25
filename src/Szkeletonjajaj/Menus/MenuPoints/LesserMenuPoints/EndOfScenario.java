package Szkeletonjajaj.Menus.MenuPoints.LesserMenuPoints;

import Szkeletonjajaj.Menus.MenuPoints.MenuPoint;

public class EndOfScenario extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public EndOfScenario(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        waitForKey();
    }
}
