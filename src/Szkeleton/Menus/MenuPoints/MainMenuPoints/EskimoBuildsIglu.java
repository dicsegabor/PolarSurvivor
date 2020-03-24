package Szkeleton.Menus.MenuPoints.MainMenuPoints;

import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.EndOfScenario;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.EskimoBuildsIgluOnStableIce;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.EskimoBuildsIgluOnUnstableIce;
import Szkeleton.Menus.MenuPoints.MenuPoint;

public class EskimoBuildsIglu extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public EskimoBuildsIglu(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Question
        Menu options = new Menu("Milyen jégtáblára épít iglut?");
        options.addMenuPoint(new EskimoBuildsIgluOnStableIce("Stabil jégtáblára"));
        options.addMenuPoint(new EskimoBuildsIgluOnUnstableIce("Instabil jégtáblára"));
        options.start();
    }
}
