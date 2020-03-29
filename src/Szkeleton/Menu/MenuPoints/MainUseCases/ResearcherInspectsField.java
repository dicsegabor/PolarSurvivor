package Szkeleton.Menu.MenuPoints.MainUseCases;

import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.LesserUseCases.*;
import Szkeleton.Menu.MenuPoints.MenuPoint;

public class ResearcherInspectsField extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public ResearcherInspectsField(String displayedText) {
        super(displayedText);
    }

    /**
     * A menüponthoz tartozó funkciót itt kell megvalósítani
     * A szekveniciadiagramok alapján megírt kódot tartalmazza.
     */
    @Override
    public void function() {

        //Question
        Menu opt = new Menu("Milyen típusú mezőt nézünk meg?");
        opt.addMenuPoint(new ResearcherInspectsStableIce("Stabil jégtábla"));
        opt.addMenuPoint(new ResearcherInspectsUnstableIce("Instabil jégtábla"));
        opt.addMenuPoint(new ResearcherInspectsHole("Lyuk"));
        opt.start();
    }
}
