package Szkeleton.Menu;

import Szkeleton.Menu.MenuPoints.MenuPoint;

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
    private String menuText;

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
        int chosen = input.nextInt();

        while (!(chosen > 0 && chosen <= menuPoints.size() + 1)){

            System.out.println("Kérem írjon be egy helyes értéket");
            chosen = input.nextInt();
        }

        chooseMenuPoint(chosen);
    }

    /**
     * Végrehjatja a kiválasztott menüponthoz tartozó utasítást.
     * @param number A választott menüpont sorszáma.
     */
    private void chooseMenuPoint(int number){

        menuPoints.get(number - 1).function();
    }
}
