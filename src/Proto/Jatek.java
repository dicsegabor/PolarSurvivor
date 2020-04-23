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
     *  L�trehoz egy karaktert a param�terben megadott azonos�t�val,
     *  t�pussal a megadott mez�n a megadott t�rgyakkal �s beteszi a karakterlistaba.
     */
    public void letrehozKarakter(){}

    /**
     * A param�ter�l megadott mez�t ell�tja megfelel� sz�m� h� r�teggel �s kapacit�ssal �s egy t�rggyal.
     */
    public void beallitMezot(){}

    /**
     * A param�ter�l kapott mez�r�l a sarkkutat� meg�llap�tja a mez� kapacit�s�t.
     */
    public void megvizsgal(){}

    /**
     * A param�terben megadott karakter/jegesmedv�t a megadott mez�re l�pteti.
     */
    public void lep(){}

    /**
     * A param�ter�l kapott karakter felveszi a mez�n l�v� t�rgyat.
     */
    public void felvesz(){}

    /**
     * A param�ter�l kapott karakter 1 egys�g munka fej�ben �s
     */
    public void as(){}

    /**
     * A param�ter�l kapott mez�n �sszeszerelni pr�b�l.
     */
    public void kombinal(){}

    /**
     * Veget er egy kor.
     */
    public void kor(){}

    /**
     * A param�ter�l kapott karakter a tart�zkod�si hely�n �p�t.
     */
    public void epit(){}

    /**
     * A param�terben megkapott, a bemeneti nyelv kifejez�seit tartalmaz� f�jlb�l
     * beolvasott utas�t�sokat hajtja v�gre.
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
