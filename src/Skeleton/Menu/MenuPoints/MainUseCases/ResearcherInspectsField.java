package Skeleton.Menu.MenuPoints.MainUseCases;

import Skeleton.Menu.Menu;
import Skeleton.Menu.MenuPoints.LesserUseCases.*;
import Skeleton.Menu.MenuPoints.MenuPoint;

public class ResearcherInspectsField extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public ResearcherInspectsField(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Question
        Menu opt = new Menu("Milyen tipusu mezot nezunk meg?");
        opt.addMenuPoint(new ResearcherInspectsStableIce("Stabil jegtabla"));
        opt.addMenuPoint(new ResearcherInspectsUnstableIce("Instabil jegtabla"));
        opt.addMenuPoint(new ResearcherInspectsHole("Lyuk"));
        opt.start();
    }
}
