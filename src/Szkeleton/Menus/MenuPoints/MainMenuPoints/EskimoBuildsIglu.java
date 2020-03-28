package Szkeleton.Menus.MenuPoints.MainMenuPoints;

import Karakterek.Eszkimo;
import Mezok.InstabilJegtabla;
import Szkeleton.Menus.MenuPoints.MenuPoint;
import Szkeleton.Program;

public class EskimoBuildsIglu extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public EskimoBuildsIglu(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {
        // Init
        Eszkimo e = new Eszkimo();

        // Action
        e.iglutEpit();

        // End
        Program.endScenario();
    }
}
