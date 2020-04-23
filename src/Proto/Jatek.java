package Proto;

import Mezo.Mezo;
import Mozgathato.Jegesmedve;
import Mozgathato.Karakter;
import Proto.Commander.Commander;
import Proto.Commands.LoadMapCommand;
import Proto.LogAndTesting.Tester;

import java.util.HashMap;
import java.util.Random;

public class Jatek {

    /**
     * A jatek karakterlistaja.
     */
    private HashMap<String, Karakter> karakterek;

    /**
     * A jatek mezolistaja.
     */
    private HashMap<String, Mezo> mezok;

    /**
     * A jegesmedve.
     */
    private Jegesmedve jegesmedve;

    /**
     *  Létrehoz egy karaktert a paraméterben megadott azonosítóval,
     *  típussal a megadott mezõn a megadott tárgyakkal és beteszi a karakterlistaba.
     */
    public void letrehozKarakter(){}

    /**
     * A paraméterül megadott mezõt ellátja megfelelõ számú hó réteggel és kapacitással és egy tárggyal.
     */
    public void beallitMezot(){}

    /**
     * A paraméterül kapott mezõrõl a sarkkutató megállapítja a mezõ kapacitását.
     */
    public void megvizsgal(){}

    /**
     * A paraméterben megadott karakter/jegesmedvét a megadott mezõre lépteti.
     */
    public void lep(){}

    /**
     * A paraméterül kapott karakter felveszi a mezõn lévõ tárgyat.
     */
    public void felvesz(){}

    /**
     * A paraméterül kapott karakter 1 egység munka fejében ás
     */
    public void as(){}

    /**
     * A paraméterül kapott mezõn összeszerelni próbál.
     */
    public void kombinal(){}

    /**
     * Veget er egy kor.
     */
    public void kor(){}

    /**
     * A paraméterül kapott karakter a tartózkodási helyén épít.
     */
    public void epit(){}

    /**
     * A paraméterben megkapott, a bemeneti nyelv kifejezéseit tartalmazó fájlból
     * beolvasott utasításokat hajtja végre.
     */
    public void beolvas(){}

    /**
     * A paraméterben kapott karakter tulajdonságait írja a képernyõre.
     */
    public void allapot(){}

    /**
     * Megvizsgalja, hogy van-e egy mezon jegesmedve es karakter, mert ha igen, akkor vege a jatkenak.
     */
    public void halalEllorzes() {


    }

    /**
     * Ez a fuggveny initnel es a jegesmedve mozgatasanal lesz hasznos.
     * @param max Mekkora lehet a maximalis szam.
     * @return Visszater egy random szammal a megadott szamon belul.
     */
    public static int getRandomNumber(int max){

        Random random = new Random();

        return random.nextInt(max);
    }

    public static void jatekVege(){

        //TODO: Kitalalni a jatekveget
    }

    public static void kovetkezoKarakter(){

        //TODO: Kitalalni a korveget
    }

    private static void loadCommands(Commander commander){

        commander.addCommand(new LoadMapCommand());
    }

    public static void main(String[] args) {

        //init commander
        Commander commander = new Commander();
        loadCommands(commander);

        if (args.length > 0) {

            System.out.println("/////////////////////// Starting test: " + args[0] + " ///////////////////////");
            Tester tester = new Tester(args[0], commander);
            tester.runTest();
            System.out.println("/////////////////////// End of test: " + args[0] + " ///////////////////////");
        }

        commander.listen(System.in);
    }
}
