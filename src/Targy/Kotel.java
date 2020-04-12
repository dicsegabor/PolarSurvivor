package Targy;

/**
 * Segitsegevel ki lehet huzni egy karaktert a vizbol.
 */
public class Kotel implements Targy {

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

        return Targytipus.KOTEL;
    }
}
