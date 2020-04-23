package Skeleton.Menu.MenuPoints.LesserUseCases;

import Mozgathato.Karakter;
import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;
import Targy.Buvarruha;

public class CharacterUsesDivingSuit extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public CharacterUsesDivingSuit(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Karakter.class, "keres", "Buvarruha");
        MethodCallHandler.callMethod(Buvarruha.class, "hasznal");

        //End
        MethodCallHandler.endScenario();
    }
}
