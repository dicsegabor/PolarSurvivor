package Szkeleton.Menus.MenuPoints.MainMenuPoints;

import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.CharacterStepsOnHole;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.CharacterStepsOnStableIce;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.CharacterStepsOnUnstableIce;
import Szkeleton.Menus.MenuPoints.MenuPoint;

public class CharacterSteps extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterSteps(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        Menu stepOptions = new Menu("Milyen pályaelemre lép a karakter?");
        stepOptions.addMenuPoint(new CharacterStepsOnStableIce("Stabil jégtáblára"));
        stepOptions.addMenuPoint(new CharacterStepsOnUnstableIce("Instabil jégtáblára"));
        stepOptions.addMenuPoint(new CharacterStepsOnHole("Lyukra"));
        stepOptions.start();
    }
}
