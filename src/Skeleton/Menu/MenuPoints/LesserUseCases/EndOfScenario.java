package Skeleton.Menu.MenuPoints.LesserUseCases;

import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;

public class EndOfScenario extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public EndOfScenario(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Action
        System.out.print("\nNincs tovabbi akcio!\n");

        //End
        MethodCallHandler.endScenario();
    }
}
