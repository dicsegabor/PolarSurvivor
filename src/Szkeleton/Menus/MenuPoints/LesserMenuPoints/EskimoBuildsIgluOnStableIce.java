package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Eszkimo;
import Karakterek.Karakter;
import Mezok.Jegtabla;
import Mezok.StabilJegtabla;
import Szkeleton.Menus.MenuPoints.MenuPoint;
import org.xml.sax.ext.DeclHandler;

public class EskimoBuildsIgluOnStableIce extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public EskimoBuildsIgluOnStableIce(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Init
        Eszkimo eskimo = new Eszkimo();
        StabilJegtabla stableIce = new StabilJegtabla();
        stableIce.befogad(eskimo);

        //Action
        eskimo.iglutEpit();
        stableIce.setIgluzott(true);

        waitForKey();
    }
}
