package Szkeleton;

import Szkeleton.Menus.Menu;
import Szkeleton.Menus.MenuPoints.MainMenuPoints.*;

import java.util.Scanner;

public class Program {


    public static int indent = 0;
    public static String buffer = "";

    public static void main(String[] args){

        while(true)
            startMainMenu();
    }

    /**
     * A főmenüt építi fel és indítja el.
     */
    private static void startMainMenu(){

        Menu mainMenu = new Menu("Az alább található opciók forgatókönyvek közül válasszon egyet\n" +
                "a kívánt elemhez tartozó számnak a begépelésével, majd nyomjon entert!");

        mainMenu.addMenuPoint(new CharacterSteps("Karakter lép"));
        mainMenu.addMenuPoint(new CharacterFallsInWater("Karakter vízbe esik"));
        //TODO: Csaba
        mainMenu.addMenuPoint(new EskimoBuildsIglu("Eszkimó iglut épít"));
        //TODO: Marci
        mainMenu.addMenuPoint(new ResearcherInspectsField("Sarkkutató szomszédos mezőt néz"));
        //TODO: Dávid
        mainMenu.addMenuPoint(new CharacterPicksUpObject("Karakter tárgyat vesz fel"));
        mainMenu.addMenuPoint(new CharacterDigs("Karakter ás"));
        //TODO: Áron
        mainMenu.addMenuPoint(new CharactersAssembleFlareGun("Karakterek összeszerelik a jelzőrakétát"));
        mainMenu.addMenuPoint(new Exit("Kilépés"));

        mainMenu.start();
    }

    /**
     * A paraméterül kapoot sztringet egy bufferbe írja be.
     * @param string Ezt rja be a bufferbe.
     */
    public static void writeToBuffer(String string){

        for (int i = 0; i < indent; i++)
            buffer += "     ";

        buffer += string + "\n";
    }

    /**
     * Lezárja a kapcsos zárójeleket, valamint kiírja a buffer tartalmát a konzolra.
     * Nem kell sehol csökkenteni az indentálást, mert ez a függvény elintézi.
     * Vár a következő leütött billentyűig.
     */
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

    /**
     * Vár a következő leütött billentyűig.
     */
    private static void waitForKey(){

        Scanner scan = new Scanner(System.in);
        System.out.print("Nyomjon meg egy gombot a folytatáshoz . . .");
        scan.nextLine();
        clearScreen();
    }

    /**
     * Ezt a kódot csak úgy találtam. Törli a konzolt.
     */
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
