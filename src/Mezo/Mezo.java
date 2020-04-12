package Mezo;

import Mozgathato.Jegesmedve;
import Mozgathato.Karakter;
import Mozgathato.Mozgathato;
import Program.Game;

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

    protected Jegesmedve jegesmedve;

    /**
     * A mezo karakterlistaja. Itt tarolja a tartalmazott karaktereket
     */
    protected List<Karakter> karakterek;

    /**
     * A mezo szomszedos mezoket tarolo listaja.
     */
    private List<Mezo> szomszedok = new ArrayList<Mezo>();

    /**
     * A jatekban a vihart jelkepezi.
     * Novlei veletlenszeru mennyiseggel a havat,
     * es a mezon allo karakterek testhojet csokkenti egyel.
     */
    public void vihar(){

        horeteg += Game.getRandomNumber(5);
    }

    /**
     * Beallitja a mezo szomszedjat.
     * Hozzaadja a szomszed listahoz.
     */
    public void setSzomszed(Mezo mezo){

        if(!szomszedE(mezo)) {

            szomszedok.add(mezo);

            if (!mezo.szomszedE(this))
                mezo.setSzomszed(this);
        }
    }

    /**
     * Visszater a mezo kapacitasaval.
     */
    public void getKapacitas(){}

    /**
     * Csokkenti a horeteget a megadott mennyiseggel.
     */
    public void havatCsokkent(int retegSzam){

        horeteg -= retegSzam;
    }

    /**
     * Berak egy karaktert a karakterlistajaba.
     */
    public void befogad(Mozgathato mozgathato) {

        if(mozgathato.getClass().equals(Jegesmedve.class))
            jegesmedve = (Jegesmedve) mozgathato;

        else
            karakterek.add((Karakter) mozgathato);
    }

    /**
     * Kivesz egy karaktert a karakterlistajabol es visszater azzal.
     */
    public void kiad(Mozgathato mozgathato){

        if(mozgathato.getClass().equals(Jegesmedve.class))
            jegesmedve = null;

        else
            karakterek.remove(mozgathato);
    }

    /**
     * Ellenorzi, hogy a megadott mezo szomszedos-e.
     */
    public boolean szomszedE(Mezo mezo){

        return szomszedok.contains(mezo);
    }

    /**
     * Ha a szomszedos mezok egyiken van karakter kotellel, akkor az kimenti a vizbe esett karaktereket.
     */
    @Override
    public void segitseg(){}
}
