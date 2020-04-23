package Targy;

import Mozgathato.Karakter;
import Proto.LogAndTesting.Logger;

/**
 * Ha egy karakter a vizbe esik, akkor nem tortenik vele semmi.
 */
public class Buvarruha implements Targy {

    /**
     * Van
     */
    @Override
    public void hasznal(Karakter karakter) {

        Logger.log();

    }

    /**
     * Visszater a targy tipusaval.
     */
    @Override
    public Targytipus tipus() {

        Logger.log();

        return Targytipus.BUVARRUHA;
    }
}
