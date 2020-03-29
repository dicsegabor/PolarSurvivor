package Mezo;

import Karakter.Karakter;

import java.util.ArrayList;
import java.util.List;

/**
 * Absztrakt mező osztály. Ez jelképezi a lépthető mezüket a játékban.
 */
public abstract class Mezo implements VizbeesesListener {

    /**
     * A mezőn található hómennyiséget jelképezi.
     * Ha 0 értékű, akkor látszik, hogy a mező lyuk-e.
     */
    private int horeteg;

    /**
     * A mező kapacitását jelképezi.
     * Ha a mező stabil jégtábla, akkor végtelen.
     * Ha a mező instabil jégtábla, akkor véges és ha túllépik, akkor a rajta álló karakterek vízbe esnek.
     * Ha a mező lyuk, akkor nulla, és a karakterek, amik rálépnek egyből vízbe esnek.
     */
    protected int kapacitas;

    //TODO: Beleírni a modellváltozást (igluzott a mező attribútuma lett)
    /**
     * Jelzi, hogy a jégtáblán áll-e iglu.
     * Ha igen, akkor a rajta álló karaktereknek a vihar nem csökkenti a testhőjét.
     */
    protected boolean igluzott;

    /**
     * A mező karakterlistája. Itt tárolja a tartalmazott karaktereket
     */
    private List<Karakter> karakterek = new ArrayList<>();

    /**
     * A mező szomszédos mezőket tároló listája.
     */
    private List<Mezo> szomszedok;

    //TODO: Beleírni a modellváltozást (vihar nem absztrakt már)

    /**
     * A játékban a vihart jelképezi.
     * Növlei véletlenszerű mennyiséggel a havat,
     * és a mezőn álló karakterek testhőjét csökkenti egyel.
     */
    public void vihar(){}

    /**
     * Beállítja a mező szomszédját.
     * Hozzáadja a szomszéd listához.
     */
    public void setSzomszed(){}

    /**
     * Visszatér a mező kapacitásával.
     */
    public void getKapacitas(){}

    /**
     * Csökkenti a horéteget a megadott mennyiséggel.
     */
    public void havatCsokkent(){}

    /**
     * Berak egy karaktert a karakterlistájába.
     */
    public abstract void befogad();

    /**
     * Kivesz egy karaktert a karakterlistájából és visszatér azzal.
     */
    public void kiad(){}

    /**
     * Ellenőrzi, hogy a megadott mező szomszédos-e.
     */
    public void szomszedE(){}

    /**
     * Ha a szomszédos mezők egyikén van karakter kötéllel, akkor az kimenti a vízbe esett karaktereket.
     */
    @Override
    public void segitseg(){}

    //TODO: Beleírni a modellváltozást (megjelent a függvény)

    /**
     * Beállítja a mező igluzott attribútumát a kapott értékre.
     */
    public abstract void setIgluzott();
}
