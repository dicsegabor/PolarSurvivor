package Szkeleton.Menu.MenuPoints;

import Karakterek.Karakter;
import Mezok.Jegtabla;
import Mezok.StabilJegtabla;

public class CharacterStepsOnStableIce extends MenuPoint {

    public CharacterStepsOnStableIce(String displayedText) {
        super(displayedText);
    }

    @Override
    public void function() {

        Karakter character = new Karakter();
        Jegtabla from = new StabilJegtabla();
        Jegtabla to = new StabilJegtabla();

        from.befogad(character);
        from.setSzomszed(to);
        to.setSzomszed(from);

        character.lep(to);
        from.szomszedE(to);
        from.kiad(character);
        to.befogad(character);
    }
}
