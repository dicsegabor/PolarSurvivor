package Mezo;

import Mozgathato.Jegesmedve;
import Mozgathato.Karakter;
import Mozgathato.Mozgathato;
import Proto.Jatek;
import Proto.LogAndTesting.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Absztrakt mezo osztaly. Ez jelkepezi a leptheto mezuket a jatekban.
 */
public abstract class Mezo implements VizbeesesListener {

    /**
     * A mezon talalhato homennyiseget jelkepezi.
     * Ha 0 erteku, akkor latszik, hogy a mezo lyuk-e.
     */
    private int horeteg;

    /**
     * A mezo kapacitasat jelkepezi.
     * Ha a mezo stabil jegtabla, akkor vegtelen.
     * Ha a mezo instabil jegtabla, akkor veges es ha tullepik, akkor a rajta allo karakterek vizbe esnek.
     * Ha a mezo lyuk, akkor nulla, es a karakterek, amik ralepnek egybol vizbe esnek.
     */
    protected int kapacitas;

    /**
     * A mezon allo jegesmedvet jelkepezi.
     */
    protected Jegesmedve jegesmedve;

    /**
     * A mezo karakterlistaja. Itt tarolja a tartalmazott karaktereket
     */
    protected List<Karakter> karakterek;

    /**
     * A mezo szomszedos mezoket tarolo listaja.
     */
    private List<Mezo> szomszedok = new ArrayList<Mezo>();

    public void addKarakter(Karakter karakter){

        karakterek.add(karakter);
    }

    public void setHoreteg(int horeteg) {

        this.horeteg = horeteg;
    }

    public void setKapacitas(int kapacitas) {

        this.kapacitas = kapacitas;
    }

    public Jegesmedve getJegesmedve(){

        Logger.log();

        return jegesmedve;
    }

    public List<Karakter> getKarakterek() {

        Logger.log();

        return karakterek;
    }

    public int getHoreteg(){

        Logger.log();

        return horeteg;
    }

    /**
     * Visszater a mezo kapacitasaval.
     */
    public int getKapacitas(){

        Logger.log();

        return kapacitas;
    }

    /**
     * A jatekban a vihart jelkepezi.
     * Novlei veletlenszeru mennyiseggel a havat,
     * es a mezon allo karakterek testhojet csokkenti egyel.
     */
    public void vihar(){

        Logger.log();

        horeteg += Jatek.getRandomNumber(5);
    }

    /**
     * Beallitja a mezo szomszedjat.
     * Hozzaadja a szomszedlistajahoz, ha meg nem szomszedja,
     * valamint a celmezo szomszedjanak beallitja sajat magat.
     */
    public void setSzomszed(Mezo mezo){

        Logger.log();

        if(!szomszedE(mezo)) {

            szomszedok.add(mezo);

            if (!mezo.szomszedE(this))
                mezo.setSzomszed(this);
        }
    }

    /**
     * Csokkenti a horeteget a megadott mennyiseggel.
     */
    public void havatCsokkent(int retegSzam){

        Logger.log();

        horeteg -= retegSzam;
    }

    /**
     * Ha karaktert kap azt a karakterlistaba rakja, ha medvet, akkor a medvebe.
     */
    public void befogad(Mozgathato mozgathato) {

        Logger.log();

        if(mozgathato.getClass().equals(Jegesmedve.class)) //TODO: megjavitani
            jegesmedve = (Jegesmedve) mozgathato;

        else
            karakterek.add((Karakter) mozgathato);
    }

    /**
     * Kiveszi a megadott karakter/medvet a mezobol.
     */
    public void kiad(Mozgathato mozgathato){

        Logger.log();

        if(mozgathato.getClass().equals(Jegesmedve.class)) //TODO: megjavitani
            jegesmedve = null;

        else
            karakterek.remove(mozgathato);
    }

    /**
     * Ellenorzi, hogy a megadott mezo szomszedos-e.
     */
    public boolean szomszedE(Mezo mezo){

        Logger.log();

        return szomszedok.contains(mezo);
    }

    /**
     * Ha a szomszedos mezok egyiken van karakter kotellel, akkor az kimenti a vizbe esett karaktereket.
     */
    @Override
    public void segitseg(Karakter karakter){

        Logger.log();

    }
}
