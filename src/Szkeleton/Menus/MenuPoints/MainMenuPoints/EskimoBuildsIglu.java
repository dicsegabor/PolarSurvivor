package Szkeleton.Menus.MenuPoints.MainMenuPoints;

import Karakterek.Eszkimo;
import Mezok.InstabilJegtabla;
import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.EskimoBuildIgluOnStableIce;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.EskimoBuildIgluOnUnstableIce;
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

        //Question
        Menu options = new Menu("Milyen jégtáblára építi az iglut?");
        options.addMenuPoint(new EskimoBuildIgluOnStableIce("Stabil jégtáblára"));
        options.addMenuPoint(new EskimoBuildIgluOnUnstableIce("Instabil jégtáblára"));
        options.start();
    }
}
