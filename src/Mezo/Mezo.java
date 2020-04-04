package Mezo;

import Karakter.Karakter;

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

    //TODO: Beleirni a modellvaltozast (igluzott a mezo attributuma lett)
    /**
     * Jelzi, hogy a jegtablan all-e iglu.
     * Ha igen, akkor a rajta allo karaktereknek a vihar nem csokkenti a testhojet.
     */
    protected boolean igluzott;

    /**
     * A mezo karakterlistaja. Itt tarolja a tartalmazott karaktereket
     */
    private List<Karakter> karakterek = new ArrayList<>();

    /**
     * A mezo szomszedos mezoket tarolo listaja.
     */
    private List<Mezo> szomszedok;

    //TODO: Beleirni a modellvaltozast (vihar nem absztrakt mar)

    /**
     * A jatekban a vihart jelkepezi.
     * Novlei veletlenszeru mennyiseggel a havat,
     * es a mezon allo karakterek testhojet csokkenti egyel.
     */
    public void vihar(){}

    /**
     * Beallitja a mezo szomszedjat.
     * Hozzaadja a szomszed listahoz.
     */
    public void setSzomszed(){}

    /**
     * Visszater a mezo kapacitasaval.
     */
    public void getKapacitas(){}

    /**
     * Csokkenti a horeteget a megadott mennyiseggel.
     */
    public void havatCsokkent(){}

    /**
     * Berak egy karaktert a karakterlistajaba.
     */
    public abstract void befogad();

    /**
     * Kivesz egy karaktert a karakterlistajabol es visszater azzal.
     */
    public void kiad(){}

    /**
     * Ellenorzi, hogy a megadott mezo szomszedos-e.
     */
    public void szomszedE(){}

    /**
     * Ha a szomszedos mezok egyiken van karakter kotellel, akkor az kimenti a vizbe esett karaktereket.
     */
    @Override
    public void segitseg(){}

    //TODO: Beleirni a modellvaltozast (megjelent a fuggveny)

    /**
     * Beallitja a mezo igluzott attributumat a kapott ertekre.
     */
    public abstract void setIgluzott();
}
