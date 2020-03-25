package Szkeleton.Menus.MenuPoints;

import java.util.Scanner;

/**
 * Ez az osztály jelképezi a menüpontokat.
 */
public abstract class MenuPoint {

    /**
     * Tárolja, hogy milen szöveg jelenik meg a menüponthoz.
     */
    public String displayedText;

    /**
     * @param displayedText Ez a szöveg jelenik meg a menüponthoz.
     */
    public MenuPoint(String displayedText){

        this.displayedText = displayedText;
    }

    /**
     * Itt kell megvalósítani a menüponthoz tartozó funkciót.
     * Pl.: Csinál egy új menüt, Függvényeket hív a programból
     * Lásd példának CharacterSteps, CharacterStepsOnStableIce
     */
    public abstract void function();

    /**
     * Addig vár amíg nem kap bármi bemenetet.
     */
    protected void waitForKey() {

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
