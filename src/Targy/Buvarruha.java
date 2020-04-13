package Targy;

import Mozgathato.Karakter;

/**
 * Ha egy karakter a vizbe esik, akkor nem tortenik vele semmi.
 */
public class Buvarruha implements Targy {

    /**
     * Van
     */
    @Override
    public void hasznal(Karakter karakter) {}

    /**
     * Visszater a targy tipusaval.
     */
    @Override
    public Targytipus tipus() {

        return Targytipus.BUVARRUHA;
    }
}
