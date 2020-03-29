package Szkeleton.Menu.MenuPoints.MainUseCases;

import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.LesserUseCases.*;
import Szkeleton.Menu.MenuPoints.MenuPoint;

public class CharacterSteps extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterSteps(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Question
        Menu stepOptions = new Menu("Milyen pályaelemre lép a karakter?");
        stepOptions.addMenuPoint(new CharacterStepsOnStableIce("Stabil jégtáblára"));
        stepOptions.addMenuPoint(new CharacterStepsOnUnstableIce("Instabil jégtáblára"));
        stepOptions.addMenuPoint(new CharacterStepsOnHole("Lyukra"));
        stepOptions.start();
    }
}
