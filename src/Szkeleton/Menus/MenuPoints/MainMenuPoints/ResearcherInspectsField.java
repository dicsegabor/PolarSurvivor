package Szkeleton.Menus.MenuPoints.MainMenuPoints;

import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.*;
import Szkeleton.Menus.MenuPoints.MenuPoint;

public class ResearcherInspectsField extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public ResearcherInspectsField(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Question
        Menu opt = new Menu("Milyen típusú mezőt nézünk meg?");
        opt.addMenuPoint(new CharacterViewsStableIce("Stabil jégtábla"));
        opt.addMenuPoint(new CharacterViewsUnstableIce("Instabil jégtábla"));
        opt.addMenuPoint(new CharacterViewsHole("Lyuk"));
        opt.start();
    }
}
