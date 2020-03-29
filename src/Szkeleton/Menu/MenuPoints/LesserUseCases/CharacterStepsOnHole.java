package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Karakter;
import Mezo.Lyuk;
import Mezo.Mezo;
import Szkeleton.Menu.MenuPoints.MainUseCases.CharacterFallsInWater;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class CharacterStepsOnHole extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharacterStepsOnHole(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Action
        MethodCallHandler.callMethod(Karakter.class, "lep", "Lyuk");
        MethodCallHandler.innerMethodCalls();
            MethodCallHandler.callMethod(Mezo.class, "szomszedE", "Lyuk");
            MethodCallHandler.callMethod(Karakter.class, "munkaCsokkent");
            MethodCallHandler.callMethod(Mezo.class, "kiad", "Karakter");
            MethodCallHandler.callMethod(Lyuk.class, "befogad", "Karakter");
            MethodCallHandler.innerMethodCalls();

        //Question?
        new CharacterFallsInWater("").function();
    }
}
