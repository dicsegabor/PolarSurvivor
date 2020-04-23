package Skeleton.Menu;

import Skeleton.Menu.MenuPoints.MenuPoint;
import Skeleton.MethodCallHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ez az osztaly szolgal a konzolon megjeleno menuk alapjaul.
 */
public class Menu {

    /**
     * Tarolja, hogy mit ir ki a menu megjeleneskor (altalaban a kerdest).
     */
    private String menuText;

    /**
     * Tarolja a menupontokat.
     */
    private List<MenuPoint> menuPoints;

    /**
     * @param menuText Ez a parameter adja meg, hogy mit ir ki a menu megjelenesekor.
     */
    public Menu(String menuText){

        this.menuText = menuText;
        menuPoints = new ArrayList<>();
    }

    public void addMenuPoint(MenuPoint menuPoint){

        menuPoints.add(menuPoint);
    }

    /**
     * Kiiratja a menut, valamint a menupont kivalasztasat es vegrehajtasat is kezeli.
     */
    public void start(){

        display();
        requestInput();
    }

    /**
     * Megejeleniti a menut a konzolon. Kiirja a "menuText"-ben talalhato szoveget,
     * majd novekvo szamozassal egyesevel a menupontokat.
     */
    private void display(){

        System.out.println(menuText);

        int number = 1;
        for(MenuPoint menuPoint : menuPoints)
            System.out.println(number++ + ". " + menuPoint.displayedText);
    }

    /**
     * Megkeri a felhasznalot, hogy adjon meg egy bemenetet, valamint leellenorzi azt.
     * Ha a kapott bemenet helyes, akkor kvalasztja az adott menupontot.
     */
    private void requestInput(){

        System.out.println("Kerem irja be a valasztott szamot!");
        Scanner input = new Scanner(System.in);
        String inputValue = input.nextLine();

        while(!testProperInput(inputValue)) {

            System.out.println("Kerem irjon be egy helyes erteket!");
            inputValue = input.nextLine();
        }

        chooseMenuPoint(Integer.parseInt(inputValue));
    }

    /**
     * Leellenorzi, hogy a kapott bemenet megfelel-e.
     * @param input Kapott bemenet.
     * @return Igazzal ter vissza, ha a bemenet egy 0 es a menupontok szama kozti szam.
     */
    private boolean testProperInput(String input){

        if (input.matches("-?(0|[1-9]\\d*)")) {

            int chosen = Integer.parseInt(input);
            return chosen > 0 && chosen <= menuPoints.size();
        }

        return false;
    }

    /**
     * Vegrehjatja a kivalasztott menuponthoz tartozo utasitast, valamint letorli a konzolt.
     * @param number A valasztott menupont sorszama.
     */
    private void chooseMenuPoint(int number){

        MethodCallHandler.clearScreen();

        menuPoints.get(number - 1).function();
    }
}
