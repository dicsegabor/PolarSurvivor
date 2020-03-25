package Szkeletonjajaj.Menus.MenuPoints.MainMenuPoints;

import Szkeletonjajaj.Menus.Menu;
import Szkeletonjajaj.Menus.MenuPoints.LesserMenuPoints.CharacterStepsOnHole;
import Szkeletonjajaj.Menus.MenuPoints.LesserMenuPoints.CharacterStepsOnStableIce;
import Szkeletonjajaj.Menus.MenuPoints.LesserMenuPoints.CharacterStepsOnUnstableIce;
import Szkeletonjajaj.Menus.MenuPoints.MenuPoint;

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
