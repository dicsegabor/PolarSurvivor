package Skeleton.Menu.MenuPoints.MainUseCases;

import Skeleton.Menu.Menu;
import Skeleton.Menu.MenuPoints.LesserUseCases.*;
import Skeleton.Menu.MenuPoints.MenuPoint;

public class CharacterSteps extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public CharacterSteps(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Question
        Menu stepOptions = new Menu("Milyen palyaelemre lep a karakter?");
        stepOptions.addMenuPoint(new CharacterStepsOnStableIce("Stabil jegtablara"));
        stepOptions.addMenuPoint(new CharacterStepsOnUnstableIce("Instabil jegtablara"));
        stepOptions.addMenuPoint(new CharacterStepsOnHole("Lyukra"));
        stepOptions.start();
    }
}
