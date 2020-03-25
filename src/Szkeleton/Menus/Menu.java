package Szkeleton.Menus;

import Szkeleton.Menus.MenuPoints.MenuPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ez az osztály szolgál a konzolon megjelenő menük alapjául.
 */
public class Menu {

    /**
     * Tárolja, hogy mit ír ki a menü megjelenéskor.
     */
    private String menuText;aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

    /**
     * Tárolja a menüpontokat.
     */
    private List<MenuPoint> menuPoints;

    /**
     * @param menuText Ez a paraméter adja meg, hogy mit ír ki a menü megjelenésekor.
     */
    public Menu(String menuText){

        this.menuText = menuText;
        menuPoints = new ArrayList<>();
    }

    public void addMenuPoint(MenuPoint menuPoint){

        menuPoints.add(menuPoint);
    }

    /**
     * Kiíratja a menüt, valamint a menüpont kiválasztását és végrehajtását is kezeli.
     */
    public void start(){

        display();
        requestInput();
    }

    /**
     * Megejeleníti a menüt a konzolon. Kiírja a "menuText"-ben található szöveget,
     * majd növekvő számozással egyesével a menüpontokat.
     */
    private void display(){

        System.out.println(menuText);

        int number = 1;
        for(MenuPoint menuPoint : menuPoints)
            System.out.println(number++ + ". " + menuPoint.displayedText);
    }

    /**
     * Megkéri a felhasználót, hogy adjon meg egy bemenetet, valamint leellenőrzi azt.
     * Ha a kapott bemenet helyes, akkor kválasztja az adott menüpontot.
     */
    private void requestInput(){

        System.out.println("Kérem írja be a választott számot!");
        Scanner input = new Scanner(System.in);

        String inputValue = input.nextLine();

        while(!testProperInput(inputValue)) {

            System.out.println("Kérem írjon be egy helyes értéket!");
            inputValue = input.nextLine();
        }

        chooseMenuPoint(Integer.parseInt(inputValue));
    }

    /**
     * Leellenőrzi, hogy a kapott bemenet megfelel-e.
     * @param input Kapott bemenet.
     * @return Igazzal tér vissza, ha a bemenet egy 0 és a menüpontok száma közti szám.
     */
    private boolean testProperInput(String input){

        if ("-?(0|[1-9]\\d*)".matches(input)) {

            int chosen = Integer.parseInt(input);
            if (chosen > 0 && chosen <= menuPoints.size())
                return true;
        }

        return false;
    }

    /**
     * Végrehjatja a kiválasztott menüponthoz tartozó utasítást, valamint letörli a konzolt.
     * @param number A választott menüpont sorszáma.
     */
    private void chooseMenuPoint(int number){

        clearScreen();

        menuPoints.get(number - 1).function();
    }

    /**
     * Ezt a kódot csak úgy találtam.
     */
    private static void clearScreen() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
