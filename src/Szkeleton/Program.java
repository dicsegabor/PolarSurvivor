package Szkeleton;

import Szkeleton.Menus.*;
import Szkeleton.Menus.MenuPoints.MainMenuPoints.*;

import java.util.Scanner;

public class Program {

    public static int indent = 0;
    public static String buffer = "";

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

    public static void writeToBuffer(String string){

        for (int i = 0; i < indent; i++)
            buffer += "     ";

        buffer += string + "\n";
    }

    public static void endScenario(){

        while (indent-- > 0){

            for (int i = 0; i < indent; i++)
                buffer += "     ";

            buffer += "}\n";
        }
        System.out.print(Program.buffer);
        buffer = "";
        indent = 0;

        waitForKey();
    }

    private static void waitForKey(){

        Scanner scan = new Scanner(System.in);
        System.out.print("Nyomjon meg egy gombot a folytatáshoz . . .");
        scan.nextLine();
        clearScreen();
    }

    /**
     * Ezt a kódot csak úgy találtam.
     */
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
