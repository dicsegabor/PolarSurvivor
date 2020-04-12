package Targy;

/**
 * Ha egy karakter a vizbe esik, akkor nem tortenik vele semmi.
 */
public class Buvarruha implements Targy {

    /**
     * Megvalositja a targy funkcionalitasat.
     */
    @Override
    public void hasznal() {}

    /**
     * Visszater a targy tipusaval.
     */
    @Override
    public Targytipus tipus() {

        return Targytipus.BUVARRUHA;
    }
}
