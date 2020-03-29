package Szkeleton;

import Szkeleton.Menu.Menu;
import Szkeleton.Menu.MenuPoints.MainUseCases.*;


public class Program {

    public static void main(String[] args) {

        while (true)
            startMainMenu();
    }

    /**
     * A főmenüt építi fel és indítja el.
     */
    private static void startMainMenu() {

        Menu mainMenu = new Menu("Az alább található opciók forgatókönyvek közül válasszon egyet\n" +
                "a kívánt elemhez tartozó számnak a begépelésével, majd nyomjon entert!");

        mainMenu.addMenuPoint(new CharacterSteps("Karakter lép"));
        mainMenu.addMenuPoint(new CharacterFallsInWater("Karakter vízbe esik"));
        mainMenu.addMenuPoint(new EskimoBuildsIglu("Eszkimó iglut épít"));
        mainMenu.addMenuPoint(new ResearcherInspectsField("Sarkkutató szomszédos mezőt néz"));
        mainMenu.addMenuPoint(new CharacterPicksUpItem("Karakter tárgyat vesz fel"));
        mainMenu.addMenuPoint(new CharacterDigs("Karakter ás"));
        mainMenu.addMenuPoint(new CharactersTryToAssembleFlareGun("Karakterek összeszerelik a jelzőrakétát"));
        //TODO: Beleírni a modellváltozást (Vihar)
        mainMenu.addMenuPoint(new Storm("Vihar"));
        mainMenu.addMenuPoint(new Exit("Kilépés"));

        mainMenu.start();
    }
}