package Szkeleton.Menus.MenuPoints.LesserMenuPoints;

import Karakterek.Karakter;
import Karakterek.Kutato;
import Mezok.StabilJegtabla;
import Szkeleton.Menus.MenuPoints.MenuPoint;
import Szkeleton.Program;

public class CharacterViewsStableIce extends MenuPoint {

   public CharacterViewsStableIce(String displayedText){
       super(displayedText);

    }


    @Override
    public void function() {

        //init
        Kutato kut = new Kutato();
        StabilJegtabla sjeg = new StabilJegtabla();

        //action
        kut.jegetNez(sjeg);

        //End
        Program.endScenario();
    }
}
