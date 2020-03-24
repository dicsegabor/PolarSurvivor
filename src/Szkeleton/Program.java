package Szkeleton;

import Szkeleton.Menus.*;
import Szkeleton.Menus.MenuPoints.MainMenuPoints.*;

public class Program {

    public static void main(String[] args){

        while(true)
            startMainMenu();
    }

    private static void startMainMenu(){

        Menu mainMenu = new Menu("Az alább található opciók forgatókönyvek közül válasszon egyet\n" +
                "a kívánt elemhez tartozó számnak a begépelésével, majd nyomjon entert!");

        mainMenu.addMenuPoint(new CharacterSteps("Karakter lép"));
        mainMenu.addMenuPoint(new CharacterFallsInWater("Karakter vízbe esik"));
        mainMenu.addMenuPoint(new EskimoBuildsIglu("Eszkimó iglut épít"));
        mainMenu.addMenuPoint(new ResearcherInspectsField("Sarkkutató szomszédos mezőt néz"));
        mainMenu.addMenuPoint(new CharacterPicksUpObject("Karakter tárgyat vesz fel"));
        mainMenu.addMenuPoint(new CharacterDigs("Karakter ás"));
        mainMenu.addMenuPoint(new CharactersAssembleFlareGun("Karakterek összeszerelik a jelzőrakétát"));
        mainMenu.addMenuPoint(new Exit("Kilépés"));

        mainMenu.start();
    }
}
