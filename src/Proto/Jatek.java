package Proto;

import Epulet.Epulettipus;
import Exceptions.ItemNotFoundException;
import Mezo.Mezo;
import Mezo.Jegtabla;
import Proto.Commands.KarakterCommand;
import Proto.Commands.SetFieldCommand;
import Targy.Targytipus;
import Mozgathato.*;
import Proto.Commander.Commander;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.Commands.LoadMapCommand;
import Proto.LogAndTesting.Tester;
import Targy.Targy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Ez tarolja a jatekot, mezoket es karaktereket.
 */
public class Jatek {

    /**
     * A jatek karakterlistaja.
     */
    private static HashMap<String, Karakter> karakterek = new HashMap<>();

    /**
     * A jatek mozgathatolistaja.
     */
    private static HashMap<String, Mozgathato> mozgathatok = new HashMap<>();

    /**
     * A jatek mezolistaja.
     */
    private static HashMap<String, Mezo> mezok = new HashMap<>();

    /**
     * A jegesmedve.
     */
    private static Jegesmedve jegesmedve;

    /**
     *  Letrehoz egy karaktert a parameterben megadott azonositoval,
     *  tipussal a megadott mezon a megadott targyakkal es beteszi a karakterlistaba.
     */
    public void letrehozKarakter(String azonosito, String tipus, String mezo, List<Targy> targyak){

        String karakterNev = tipus + azonosito;
        Karakter karakter = null;

        switch (tipus){

            case "e": karakter = new Eszkimo(mezok.get(mezo), targyak); break;
            case "k": karakter = new Kutato(mezok.get(mezo), targyak); break;
        }

        karakterek.putIfAbsent(karakterNev, karakter);
        mozgathatok.putIfAbsent(karakterNev, karakter);
        mezok.get(mezo).addKarakter(karakterek.get(karakterNev));
    }

    /**
     * A parameterul megadott mezot ellatja megfelelo szamu ho reteggel es kapacitassal es egy targgyal.
     */
    public void beallitInstabilJegtablat(String azonosito, int horeteg, int kapacitas, Targy targy) throws WrongArgumentException {

        if(!mezok.containsKey(azonosito))
            throw new WrongArgumentException("A(z) '" + azonosito + "' nevu mezo nem talalhato!");

        mezok.get(azonosito).setHoreteg(horeteg);
        mezok.get(azonosito).setKapacitas(kapacitas);
        ((Jegtabla)mezok.get(azonosito)).setTargy(targy);
    }

    public void beallitStabilJegtablat(String azonosito, int horeteg, Targy targy) throws WrongArgumentException {

        if(!mezok.containsKey(azonosito))
            throw new WrongArgumentException("A(z) '" + azonosito + "' nevu mezo nem talalhato!");

        mezok.get(azonosito).setHoreteg(horeteg);
        ((Jegtabla)mezok.get(azonosito)).setTargy(targy);
    }

    /**
     * A parameterul kapott mezorol a sarkkutato megallapatja a mezo kapacitasat.
     */
    public void megvizsgal(String karakter, String mezo) throws WrongArgumentException {

        if(!karakterek.containsKey(mezo))
            throw new WrongArgumentException("A(z) '" + mezo + "' nevu karakter nem talalhato!");

        int ertek = ((Kutato)karakterek.get(karakter)).jegetNez(mezok.get(mezo));

        System.out.println("A(z) " + karakter + " altal megvizsgalt mezo kapacitasa: " + ertek);
    }

    /**
     * A parameterben megadott karakter/jegesmedvet a megadott mezore lepteti.
     */
    public void lep(String mozgathato, String mezo) throws WrongArgumentException {

        if(!mezok.containsKey(mezo))
            throw new WrongArgumentException("A(z) '" + mezo + "' nevu mezo nem talalhato!");

        if (!mozgathatok.containsKey(mozgathato))
            throw new WrongArgumentException("A(z) '" + mozgathato + "' nevu mozgathato nem talalhato!");

        mozgathatok.get(mozgathato).lep(mezok.get(mezo));
    }

    /**
     * A parameterul kapott karakter felveszi a mezon levo targyat.
     */
    public void felvesz(String karakter) throws WrongArgumentException {

        if (!karakterek.containsKey(karakter))
            throw new WrongArgumentException("A(z) '" + karakter + "' nevu karakter nem talalhato!");

        karakterek.get(karakter).felvesz();
    }

    /**
     * A parameterul kapott karakter 1 egyseg munka fejeben as
     */
    public void as(String karakter) throws WrongArgumentException {

        if (!karakterek.containsKey(karakter))
            throw new WrongArgumentException("A(z) '" + karakter + "' nevu karakter nem talalhato!");

        karakterek.get(karakter).as();
    }

    /**
     * A parameterul kapott mezon osszeszerelni probal.
     */
    public void kombinal(String karakter) throws WrongArgumentException {

        if (!karakterek.containsKey(karakter))
            throw new WrongArgumentException("A(z) '" + karakter + "' nevu karakter nem talalhato!");

        for(Map.Entry<String, Karakter> k : karakterek.entrySet())
            if(!karakterek.get(karakter).getMezo().equals(k.getValue().getMezo())) {

                System.out.println("A karakterek nincsenek ugyanazon a mezon!");
                return;
            }

        karakterek.get(karakter).kombinal();
    }

    /**
     * Veget er egy kor.
     */
    public void kor(){

        for(Map.Entry<String, Mezo> mezo : mezok.entrySet())
            mezo.getValue().vihar();

        jegesmedve.lep(null);

        for(Map.Entry<String, Karakter> karakter : karakterek.entrySet())
            karakter.getValue().munkatVisszaallit();
    }

    /**
     * A parameterul kapott karakter a tartozkodasi helyen epit.
     */
    public void epit(String karakter, Epulettipus epulettipus) throws WrongArgumentException {

        if (!karakterek.containsKey(karakter))
            throw new WrongArgumentException("A(z) '" + karakter + "' nevu karakter nem talalhato!");

        if(epulettipus.equals(Epulettipus.IGLU) && karakterek.get(karakter).tipus().equals(MozgathatoTipus.ESZKIMO))
            ((Eszkimo)karakterek.get(karakter)).iglutEpit();

        if (epulettipus.equals(Epulettipus.SATOR)){
            try { karakterek.get(karakter).keres(Targytipus.SATOR).hasznal(karakterek.get(karakter)); }
            catch (ItemNotFoundException e) { System.out.println(e.getMessage()); }
        }
    }

    /**
     * A parameterben megkapott, a bemeneti nyelv kifejezeseit tartalmazo fajlbol
     * beolvasott utasitasokat hajtja vegre.
     */
    public void beolvas(){


    }

    /**
     * A param�terben kapott karakter tulajdons�gait �rja a k�perny�re.
     */
    public void allapot(String azonosito) throws WrongArgumentException {

        if(mozgathatok.containsKey(azonosito)){

            //TODO: Mindent kitalalni
        }

        else if(mezok.containsKey(azonosito)){


        }

        else
            throw new WrongArgumentException("A(z) '" + azonosito + "' nevu objektum nem talalhato!");

    }

    /**
     * Megvizsgalja, hogy van-e egy mezon jegesmedve es karakter, mert ha igen, akkor vege a jatkenak.
     */
    public static void halalEllorzes() {

        for(Map.Entry<String, Mezo> mezoEntry : mezok.entrySet())
            if(mezoEntry.getValue().halalE())
                jatekVege("A medve nyert!");
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
    public static void jatekVege(String uzenet){

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
        commander.addCommand(new KarakterCommand(karakterek, mozgathatok, mezok));
    }

    public static void main(String[] args) {

        //init commander
        Commander commander = new Commander();
        loadCommands(commander);

        if (args.length > 0) {

            System.out.println("/////////////////////// Starting test: " + args[0] + " ///////////////////////");
            commander.exitOnMistake = true;
            Tester tester = new Tester(args[0], commander);
            tester.runTest();
            System.out.println("/////////////////////// End of test: " + args[0] + " ///////////////////////");
            System.exit(0);
        }

        commander.listen(System.in);
    }
}
