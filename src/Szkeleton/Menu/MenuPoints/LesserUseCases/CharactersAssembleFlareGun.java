package Szkeleton.Menu.MenuPoints.LesserUseCases;

import Karakter.Karakter;
import Mezo.Jegtabla;
import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.MenuPoint;
import Szkeleton.MethodCallHandler;

public class CharactersAssembleFlareGun extends MenuPoint {

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public CharactersAssembleFlareGun(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        //Question
        Menu options = new Menu("Melyik alkatrész van nálunk?");
        options.addMenuPoint(new StartFlareGunWithGun("Pisztoly"));
        options.addMenuPoint(new StartFlareGunWithFlare("Jelzőfeny"));
        options.addMenuPoint(new StartFlareGunWithCartridge("Patron"));
        options.start();
    }
}

