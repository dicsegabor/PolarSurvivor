package Targy;

import Mozgathato.Karakter;

/**
 * Segitsegevel ki lehet huzni egy karaktert a vizbol.
 */
public class Kotel implements Targy {

    /**
     * Megvalositja a targy funkcionalitasat.
     */
    @Override
    public void hasznal(Karakter karakter) {}

    /**
     * Az aldozatot atrakja a megmento mezojere.
     * @param aldozat A karakter, akit megment.
     * @param megmento A karakter, aki megmenti.
     */
    public void hasznal(Karakter aldozat, Karakter megmento) {}

    /**
     * Visszater a targy tipusaval.
     */
    @Override
    public Targytipus tipus() {

        return Targytipus.KOTEL;
    }
}
