package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Eszkimo;
import Szkeleton.Menus.MenuPoints.MenuPoint;
import Szkeleton.Program;

public class EskimoBuildIgluOnStableIce extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public EskimoBuildIgluOnStableIce(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        // Init
        Eszkimo e = new Eszkimo();

        // Action
        e.iglutEpit();

        //End
        Program.endScenario();
    }
}
