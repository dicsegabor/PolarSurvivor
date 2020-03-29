package Szkeleton.Menu.MenuPoints.MainUseCases;

import Mezo.Mezo;
import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.LesserUseCases.*;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class Storm extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public Storm(String displayedText) {
        super(displayedText);
    }

    /**
     * A menüponthoz tartozó funkciót itt kell megvalósítani
     * A szekveniciadiagramok alapján megírt kódot tartalmazza.
     */
    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Mezo.class, "vihar");
        MethodCallHandler.innerMethodCalls();

        //Question
        Menu stepOptions = new Menu("Elkap-e valakit a vihar?");
        stepOptions.addMenuPoint(new StromStrikesCharacter("Igen"));
        stepOptions.addMenuPoint(new EndOfScenario("Nem"));
        stepOptions.start();
    }
}
