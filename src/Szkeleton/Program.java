package Szkeleton;

import Szkeleton.Menus.*;
import Szkeleton.Menus.MenuPoints.MainMenuPoints.*;

public class Program {

    public static int indent = 0;
    public static boolean write = true;

    public static void main(String[] args){

        while(true)
            startMainMenu();
    }

    private static void startMainMenu(){

        Menu mainMenu = new Menu("Az alább található opciók forgatókönyvek közül válasszon egyet\n" +
                "a kívánt elemhez tartozó számnak a begépelésével, majd nyomjon entert!");

        //TODO: Gábor
        mainMenu.addMenuPoint(new CharacterSteps("Karakter lép"));
        //TODO: Áron
        mainMenu.addMenuPoint(new CharacterFallsInWater("Karakter vízbe esik"));
        //TODO: Csaba
        mainMenu.addMenuPoint(new EskimoBuildsIglu("Eszkimó iglut épít"));
        //TODO: Marci
        mainMenu.addMenuPoint(new ResearcherInspectsField("Sarkkutató szomszédos mezőt néz"));
        //TODO: Dávid
        mainMenu.addMenuPoint(new CharacterPicksUpObject("Karakter tárgyat vesz fel"));
        //TODO: Gábor
        mainMenu.addMenuPoint(new CharacterDigs("Karakter ás"));
        //TODO: Áron
        mainMenu.addMenuPoint(new CharactersAssembleFlareGun("Karakterek összeszerelik a jelzőrakétát"));
        mainMenu.addMenuPoint(new Exit("Kilépés"));

        mainMenu.start();
    }

    public static void write(String string){

        if(write) {

            for (int i = 0; i < indent; i++)
                System.out.print("  ");

            System.out.print(string + "\n");
        }
    }
}
