package Skeleton.Menu.MenuPoints.LesserUseCases;

import Skeleton.Menu.Menu;
import Skeleton.Menu.MenuPoints.MenuPoint;

public class CharactersAssembleFlareGun extends MenuPoint {

    /**
     * @param displayedText Ez a szoveg jelenik meg a menuponthoz.
     */
    public CharactersAssembleFlareGun(String displayedText) {
        super(displayedText);
    }

    /**
     * A menuponthoz tartozo funkciot itt kell megvalositani
     * A szekveniciadiagramok alapjan megirt kodot tartalmazza.
     */
    @Override
    public void function() {

        //Question
        Menu options = new Menu("Melyik alkatresz van nalunk?");
        options.addMenuPoint(new StartFlareGunWithGun("Pisztoly"));
        options.addMenuPoint(new StartFlareGunWithFlare("Jelzofeny"));
        options.addMenuPoint(new StartFlareGunWithCartridge("Patron"));
        options.start();
    }
}

