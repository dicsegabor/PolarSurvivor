package Szkeleton.Menu.MenuPoints;

import Szkeleton.Menu.Menu;

public class CharacterSteps extends MenuPoint {

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
