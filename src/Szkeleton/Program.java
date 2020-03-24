package Szkeleton;

import Szkeleton.Menu.*;
import Szkeleton.Menu.MenuPoints.CharacterFallsInWater;
import Szkeleton.Menu.MenuPoints.CharacterSteps;
import Szkeleton.Menu.MenuPoints.EskimoBuildsIglu;
import Szkeleton.Menu.MenuPoints.ResearcherInspectsField;

public class Program {

    public static void main(String[] args){

        Menu mainMenu = createMainMenu();
        mainMenu.start();
    }

    private static Menu createMainMenu(){

        Menu mainMenu = new Menu("Az alább található opciók forgatókönyvek közül válasszon egyet\n" +
                "a kívánt elemhez tartozó számnak a begépelésével, majd nyomjon entert!");

        mainMenu.addMenuPoint(new CharacterSteps("Karakter lép"));
        mainMenu.addMenuPoint(new CharacterFallsInWater("Karakter vízbe esik"));
        mainMenu.addMenuPoint(new EskimoBuildsIglu("Eszkimó iglut épít"));
        mainMenu.addMenuPoint(new ResearcherInspectsField("Sarkkutató szomszédos mezőt néz"));

        return mainMenu;
    }
}
