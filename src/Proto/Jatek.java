package Proto;

import Mezo.Mezo;
import Mozgathato.Jegesmedve;
import Mozgathato.Karakter;
import Proto.Commander.Commander;
import Proto.Commands.LoadMapCommand;
import Proto.LogAndTesting.Tester;

import java.util.HashMap;
import java.util.Random;

/**
 * Ez tarolja a jatekot, mezoket es karaktereket.
 */
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

<<<<<<< HEAD
=======
    /**
     * main fv
     * @param args
     */
    public static void main(String[] args){


    }

>>>>>>> 7e2e70243c387cffcac7a07519cfaa3e94f8c9b1
    /**
     *  Letrehoz egy karaktert a parameterben megadott azonositoval,
     *  tipussal a megadott mezon a megadott targyakkal es beteszi a karakterlistaba.
     */
    public void letrehozKarakter(){}

    /**
     * A parameterul megadott mezot ellatja megfelelo szamu ho reteggel es kapacitassal es egy targgyal.
     */
    public void beallitMezot(){}

    /**
     * A parameterul kapott mezorol a sarkkutato megallapatja a mezo kapacitasat.
     */
    public void megvizsgal(){}

    /**
     * A parameterben megadott karakter/jegesmedvet a megadott mezore lepteti.
     */
    public void lep(){}

    /**
     * A parameterul kapott karakter felveszi a mezon levo targyat.
     */
    public void felvesz(){}

    /**
     * A parameterul kapott karakter 1 egyseg munka fejeben as
     */
    public void as(){}

    /**
     * A parameterul kapott mezon osszeszerelni probal.
     */
    public void kombinal(){}

    /**
     * Veget er egy kor.
     */
    public void kor(){}

    /**
     * A parameterul kapott karakter a tartozkodasi helyen epit.
     */
    public void epit(){}

    /**
     * A parameterben megkapott, a bemeneti nyelv kifejezeseit tartalmazo fajlbol
     * beolvasott utasitasokat hajtja vegre.
     */
    public void beolvas(){}

    /**
     * A param�terben kapott karakter tulajdons�gait �rja a k�perny�re.
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

    /**
     * jatek veget jelzi
     */
    public static void jatekVege(){

        //TODO: Kitalalni a jatekveget
    }

    /**
     * kovetkezo karakterre leptet
     */
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
