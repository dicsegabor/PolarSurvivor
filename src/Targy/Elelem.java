package Targy;

import Mozgathato.Karakter;
import Proto.LogAndTesting.Logger;

/**
 * Ha egy karakter elfogyasztja, akkor egyel no a testhoje.
 */
public class Elelem implements Targy {

    /**
     * Egyel noveli a megadott karakter testhojet.
     */
    @Override
    public void hasznal(Karakter karakter) {

        Logger.log();

        karakter.testhotCsokkent(-1);
    }

    /**
     * Visszater a targy tipusaval.
     */
    @Override
    public Targytipus tipus() {

        Logger.log();

        return Targytipus.ELELEM;
    }

}
