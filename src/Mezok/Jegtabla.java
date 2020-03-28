package Mezok;

import Karakterek.Karakter;
import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.EndOfScenario;
import Szkeleton.Menus.MenuPoints.MainMenuPoints.CharacterFallsInWater;
import Szkeleton.Program;
import Targyak.Targy;

public abstract class Jegtabla extends Mezo {

    private boolean igluzott;
    private Targy targy;

    //TODO: Szkeleton után átírni Targy-ra a visszatérést
    public void getTargy(){}

    @Override
    public void vihar(){}

    public abstract void befogad(Karakter karakter);

    public void setIgluzott(boolean igluzott){
        Program.writeToBuffer("Jegtabla.setIgluzott(){");
        Program.writeToBuffer("}");
    }
}
