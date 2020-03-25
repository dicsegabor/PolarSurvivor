package Szkeletonjajaj.Menus.MenuPoints.MainMenuPoints;

import Szkeletonjajaj.Menus.Menu;
import Szkeletonjajaj.Menus.MenuPoints.LesserMenuPoints.EskimoBuildsIgluOnStableIce;
import Szkeletonjajaj.Menus.MenuPoints.LesserMenuPoints.EskimoBuildsIgluOnUnstableIce;
import Szkeletonjajaj.Menus.MenuPoints.MenuPoint;

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
