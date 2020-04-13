package Targy;

import Mozgathato.Karakter;

/**
 * Ha egy karakter elfogyasztja, akkor egyel no a testhoje.
 */
public class Elelem implements Targy {

    /**
     * Megvalositja a targy funkcionalitasat.
     */
    @Override
    public void hasznal(Karakter karakter) {

        karakter.testhotCsokkent(-1);
    }

    /**
     * Visszater a targy tipusaval.
     */
    @Override
    public Targytipus tipus() {

        return Targytipus.ELELEM;
    }

}
