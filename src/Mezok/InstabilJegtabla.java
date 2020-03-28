package Mezok;

import Karakterek.Karakter;
import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.LesserMenuPoints.EndOfScenario;
import Szkeleton.Menus.MenuPoints.MainMenuPoints.CharacterFallsInWater;
import Szkeleton.Program;

public class InstabilJegtabla extends Jegtabla {

    @Override
    public void befogad(Karakter karakter) {

        Program.writeToBuffer("InstabilJegtabla.befogad()");
    }

    @Override
    public void setIgluzott(boolean igluzott) {
        Program.writeToBuffer("InstabilJegtabla.setIgluzott(){");
        Program.indent++;
        super.setIgluzott(igluzott);

        Menu optionsMenu = new Menu("Elbírja még a jégtábla az iglut?");
        optionsMenu.addMenuPoint(new EndOfScenario("Igen"));
        optionsMenu.addMenuPoint(new CharacterFallsInWater("Nem"));
        optionsMenu.start();
        Program.indent--;
    }
}
