package Szkeleton.Menu.MenuPoints.MainUseCases;

import Mezo.Mezo;
import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.LesserUseCases.*;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class Storm extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public Storm(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Mezo.class, "vihar");
        MethodCallHandler.innerMethodCalls();

        //Question
        Menu options = new Menu("Mit kap el a vihar?");
        options.addMenuPoint(new StromStrikesCharacter("Karaktert"));
        options.addMenuPoint(new StormStrikesIglu("Iglut"));
        options.addMenuPoint(new EndOfScenario("Semmit"));
        options.start();
    }
}
