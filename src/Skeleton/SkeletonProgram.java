package Skeleton;

import Skeleton.Menu.Menu;
import Skeleton.Menu.MenuPoints.MainUseCases.*;


public class SkeletonProgram {

    public static void main(String[] args) {

        while (true)
            startMainMenu();
    }

    /**
     * A fomenut epiti fel es inditja el.
     */
    private static void startMainMenu() {

        Menu mainMenu = new Menu("Az alabb talalhato opciok forgatokonyvek kozul valasszon egyet\n" +
                "a kivant elemhez tartozo szamnak a begepelesevel, majd nyomjon entert!");

        mainMenu.addMenuPoint(new CharacterSteps("Karakter lep"));
        mainMenu.addMenuPoint(new CharacterFallsInWater("Karakter vizbe esik"));
        mainMenu.addMenuPoint(new EskimoBuildsIgloo("Eszkimo iglut epit"));
        mainMenu.addMenuPoint(new ResearcherInspectsField("Sarkkutato szomszedos mezot nez"));
        mainMenu.addMenuPoint(new CharacterPicksUpItem("Karakter targyat vesz fel"));
        mainMenu.addMenuPoint(new CharacterDigs("Karakter as"));
        mainMenu.addMenuPoint(new CharactersTryToAssembleFlareGun("Karakterek osszeszerelik a jelzoraketat"));
        mainMenu.addMenuPoint(new Storm("Vihar"));
        mainMenu.addMenuPoint(new Exit("Kilepes"));

        mainMenu.start();
    }
}