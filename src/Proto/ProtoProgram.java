package Proto;

import Epulet.Epulettipus;
import Exceptions.ItemNotFoundException;
import Mezo.*;
import Proto.Commands.*;
import Proto.LogAndTesting.Logger;
import Targy.Targytipus;
import Mozgathato.*;
import Proto.Commander.Commander;
import Proto.Commander.Exceptions.WrongArgumentException;
import Proto.LogAndTesting.Tester;
import Targy.Targy;

import java.util.*;

/**
 * Ez tarolja a jatekot, mezoket es karaktereket.
 */
public class ProtoProgram {

    /**
     * A jatek karakterlistaja.
     */
    private static HashMap<String, Karakter> karakterek = new HashMap<>();
    private static List<String> elfaradtKarakterek = new ArrayList<>();

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

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {

        for (Map.Entry<T, E> entry : map.entrySet())
            if (Objects.equals(value, entry.getValue()))
                return entry.getKey();

        return null;
    }

    /**
     *  Letrehoz egy karaktert a parameterben megadott azonositoval,
     *  tipussal a megadott mezon a megadott targyakkal es beteszi a karakterlistaba.
     */
    public static void letrehozKarakter(String tipus, String mezo, List<Targy> targyak) throws WrongArgumentException {

        if(!mezok.containsKey(mezo))
            throw new WrongArgumentException("A(z) '" + mezo + "' nevu mezo nem talalhato!");

        MozgathatoTipus mozgathatoTipus;
        try {
            mozgathatoTipus = MozgathatoTipus.valueOf(tipus);
        } catch (IllegalArgumentException e) {
            throw new WrongArgumentException("A parameterul kapott tipus nem megfelelo!");
        }

        String karakterNev = tipus + "_" + karakterek.size();
        Karakter karakter;

        if(targyak.isEmpty())
            karakter = MozgathatoTipus.letrehoz(mozgathatoTipus, mezok.get(mezo));

        else
            karakter = MozgathatoTipus.letrehoz(mozgathatoTipus, mezok.get(mezo), targyak);

        karakterek.putIfAbsent(karakterNev, karakter);
        mozgathatok.putIfAbsent(karakterNev, karakter);
        mezok.get(mezo).addKarakter(karakterek.get(karakterNev));
    }

    public static void letrehozJegesmedve(String mezo) throws WrongArgumentException {

        if(jegesmedve != null)
            throw new WrongArgumentException("Mar van jegesmedve a palyan!");

        if(!mezok.containsKey(mezo))
            throw new WrongArgumentException("A(z) '" + mezo + "' nevu mezo nem talalhato!");

        jegesmedve = new Jegesmedve(mezok.get(mezo));
        mozgathatok.putIfAbsent("JEGESMEDVE", jegesmedve);
        mezok.get(mezo).setJegesmedve(jegesmedve);
    }

    /**
     * A parameterul megadott mezot ellatja megfelelo szamu ho reteggel es kapacitassal es egy targgyal.
     */
    public static void beallitInstabilJegtablat(String azonosito, int horeteg, int kapacitas, Targy targy) throws WrongArgumentException {

        if(!mezok.containsKey(azonosito))
            throw new WrongArgumentException("A(z) '" + azonosito + "' nevu mezo nem talalhato!");

        mezok.get(azonosito).setHoreteg(horeteg);
        mezok.get(azonosito).setKapacitas(kapacitas);
        ((Jegtabla)mezok.get(azonosito)).setTargy(targy);
    }

    public static void beallitStabilJegtablat(String azonosito, int horeteg, Targy targy) throws WrongArgumentException {

        if(!mezok.containsKey(azonosito))
            throw new WrongArgumentException("A(z) '" + azonosito + "' nevu mezo nem talalhato!");

        mezok.get(azonosito).setHoreteg(horeteg);
        ((Jegtabla)mezok.get(azonosito)).setTargy(targy);
    }

    /**
     * A parameterul kapott mezorol a sarkkutato megallapatja a mezo kapacitasat.
     */
    public static void megvizsgal(String karakter, String mezo) throws WrongArgumentException {

        if(elfaradtKarakterek.contains(karakter))
            throw new WrongArgumentException("A(z) '" + karakter + "' nevu karakter elfaradt!");

        if(!mezok.containsKey(mezo))
            throw new WrongArgumentException("A(z) '" + mezo + "' nevu mezo nem talalhato!");

        if(karakterek.get(karakter).tipus().equals(MozgathatoTipus.KUTATO)) {

            int ertek = ((Kutato) karakterek.get(karakter)).jegetNez(mezok.get(mezo));
            System.out.println("A(z) " + karakter + " altal megvizsgalt mezo kapacitasa: " + ertek);
        }

        else
            throw new WrongArgumentException("A(z) '" + karakter + "' nevu karakter nem kutato!");
    }

    /**
     * A parameterben megadott karakter/jegesmedvet a megadott mezore lepteti.
     */
    public static void lep(String mozgathato, String mezo) throws WrongArgumentException {

        if(elfaradtKarakterek.contains(mozgathato))
            throw new WrongArgumentException("A(z) '" + mozgathato + "' nevu karakter elfaradt!");

        if(!mezok.containsKey(mezo))
            throw new WrongArgumentException("A(z) '" + mezo + "' nevu mezo nem talalhato!");

        if (!mozgathatok.containsKey(mozgathato))
            throw new WrongArgumentException("A(z) '" + mozgathato + "' nevu mozgathato nem talalhato!");

        mozgathatok.get(mozgathato).lep(mezok.get(mezo));
    }

    /**
     * A parameterul kapott karakter felveszi a mezon levo targyat.
     */
    public static void felvesz(String karakter) throws WrongArgumentException {

        if(elfaradtKarakterek.contains(karakter))
            throw new WrongArgumentException("A(z) '" + karakter + "' nevu karakter elfaradt!");

        if (!karakterek.containsKey(karakter))
            throw new WrongArgumentException("A(z) '" + karakter + "' nevu karakter nem talalhato!");

        karakterek.get(karakter).felvesz();
    }

    /**
     * A parameterul kapott karakter 1 egyseg munka fejeben as
     */
    public static void as(String karakter) throws WrongArgumentException {

        if(elfaradtKarakterek.contains(karakter))
            throw new WrongArgumentException("A(z) '" + karakter + "' nevu karakter elfaradt!");

        if (!karakterek.containsKey(karakter))
            throw new WrongArgumentException("A(z) '" + karakter + "' nevu karakter nem talalhato!");

        karakterek.get(karakter).as();
    }

    /**
     * A parameterul kapott mezon osszeszerelni probal.
     */
    public static void kombinal(String karakter) throws WrongArgumentException {

        if(elfaradtKarakterek.contains(karakter))
            throw new WrongArgumentException("A(z) '" + karakter + "' nevu karakter elfaradt!");

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
    public static void kor(){

        for(Map.Entry<String, Mezo> mezo : mezok.entrySet())
            mezo.getValue().vihar();

        if(jegesmedve != null)
            jegesmedve.lep(null);

        for(Map.Entry<String, Karakter> karakter : karakterek.entrySet())
            karakter.getValue().munkatVisszaallit();

        elfaradtKarakterek.clear();
    }

    /**
     * A parameterul kapott karakter a tartozkodasi helyen epit.
     */
    public static void epit(String karakter, Epulettipus epulettipus) throws WrongArgumentException {

        if(elfaradtKarakterek.contains(karakter))
            throw new WrongArgumentException("A(z) '" + karakter + "' nevu karakter elfaradt!");

        if (!karakterek.containsKey(karakter))
            throw new WrongArgumentException("A(z) '" + karakter + "' nevu karakter nem talalhato!");

        if(epulettipus.equals(Epulettipus.IGLU)) {

            if(karakterek.get(karakter).tipus().equals(MozgathatoTipus.ESZKIMO))
                ((Eszkimo) karakterek.get(karakter)).iglutEpit();

            else
                throw new WrongArgumentException("A(z) '" + karakter + "' nevu karakter nem eszkimo!");
        }

        if (epulettipus.equals(Epulettipus.SATOR)){
            try { karakterek.get(karakter).keres(Targytipus.SATOR).hasznal(karakterek.get(karakter)); }
            catch (ItemNotFoundException e) { System.out.println(e.getMessage()); }
        }
    }

    /**
     * A param�terben kapott karakter tulajdons�gait �rja a k�perny�re.
     */
    public static void allapot(String azonosito) throws WrongArgumentException {

        StringBuilder stat = new StringBuilder();

        if(mozgathatok.containsKey(azonosito)){

            if(mozgathatok.get(azonosito).tipus().equals(MozgathatoTipus.JEGESMEDVE)){

                stat.append("Azonosito: ").append(azonosito).append("\n");
                String mezonev = getKeyByValue(mezok, jegesmedve.getMezo());
                stat.append("Mezo: ").append(mezonev);
            }

            else {

                Karakter karakter = (Karakter) mozgathatok.get(azonosito);

                stat.append("Azonosito: ").append(azonosito).append("\n");
                String mezonev = getKeyByValue(mezok, karakter.getMezo());
                stat.append("Mezo: ").append(mezonev).append("\n");
                stat.append("Tesho: ").append(karakter.getTestho()).append("\n");
                stat.append("Munka: ").append(karakter.getMunka()).append("\n");
                if(!karakter.getTargyak().isEmpty()){

                    stat.append("Targyak: ");

                    for (Targy t : karakter.getTargyak())
                        stat.append(t.tipus()).append(" ");

                    stat.append( "\n");
                }
            }
        }

        else if(mezok.containsKey(azonosito)){

            if(azonosito.matches(".*(STABIL).*")) {

                stat.append("Azonosito: ").append(azonosito).append("\n");
                Jegtabla mezo = (Jegtabla) mezok.get(azonosito);
                stat.append("Horeteg: ").append(mezo.getHoreteg()).append("\n");
                stat.append("Kapacitas: ").append(mezo.getKapacitas()).append("\n");
                if(mezo.getTargy() != null && mezo.getHoreteg() == 0)
                    stat.append("Targy: ").append(mezo.getTargy().tipus() + "\n");
            }

            else {

                stat.append("Azonosito: ").append(azonosito).append("\n");
                Lyuk mezo = (Lyuk) mezok.get(azonosito);
                stat.append("Horeteg: ").append(mezo.getHoreteg()).append("\n");
                stat.append("Kapacitas: ").append(mezo.getKapacitas() + "\n");
            }
        }

        else
            throw new WrongArgumentException("A(z) '" + azonosito + "' nevu objektum nem talalhato!");

        System.out.println(stat.toString());
        Logger.log(stat.toString());
    }

    /**
     * Megvizsgalja, hogy van-e egy mezon jegesmedve es karakter, mert ha igen, akkor vege a jatkenak.
     */
    public static void halalEllorzes(Mezo mezo) {

        Logger.log();

        if(mezo.halalE())
            for(Karakter k : mezo.getKarakterek())
                k.meghal("A medve ma nem koplalt...");
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

        Logger.log();

        System.out.println("A jatek veget ert! " + uzenet);
    }

    /**
     * kovetkezo karakterre leptet
     */
    public static void kovetkezoKarakter(Karakter karakter){

        Logger.log();

        elfaradtKarakterek.add(getKeyByValue(karakterek, karakter));
    }

    private static void loadCommands(Commander commander){

        commander.addCommand(new LoadMapCommand(mezok));
        commander.addCommand(new KarakterCommand());
        commander.addCommand(new JegesmedveCommand());
        commander.addCommand(new SetFieldCommand());
        commander.addCommand(new MoveCommand());
        commander.addCommand(new LookCommand());
        commander.addCommand(new PickUpCommand());
        commander.addCommand(new DigCommand());
        commander.addCommand(new CombineCommand());
        commander.addCommand(new TurnCommand());
        commander.addCommand(new BuildCommand());
        commander.addCommand(new ScriptCommand(commander));
        commander.addCommand(new StatCommand());
    }

    public static void main(String[] args) {

        //init commander
        Commander commander = new Commander();
        loadCommands(commander);

        if (args.length > 0) {

            commander.exitOnMistake = true;
            Tester tester = new Tester(args[0], commander);
            tester.runTest();
        }

        Logger.logging = false;
        commander.listen(System.in);
    }
}
