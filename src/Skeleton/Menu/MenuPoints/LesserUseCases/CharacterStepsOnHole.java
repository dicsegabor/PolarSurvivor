package Skeleton.Menu.MenuPoints.LesserUseCases;

import Mozgathato.Karakter;
import Mezo.Lyuk;
import Mezo.Mezo;
import Skeleton.Menu.MenuPoints.MainUseCases.CharacterFallsInWater;
import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;

public class CharacterStepsOnHole extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public CharacterStepsOnHole(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
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
