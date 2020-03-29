package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Karakter;
import Mezo.Mezo;
import Mezo.StabilJegtabla;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;
import Targy.Buvarruha;

public class CharacterUsesDivingSuit extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterUsesDivingSuit(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Karakter.class, "keres", "Buvarruha");
        MethodCallHandler.callMethod(Buvarruha.class, "hasznal");

        //End
        MethodCallHandler.endScenario();
    }
}
