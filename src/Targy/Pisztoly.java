package Targy;

/**
 * Hasznalataval megvizsgalja, hogy a mezon talalhato-e a tobbi komponens,
 * es ha igen akkor vege a jateknak.
 */
public class Pisztoly implements Targy {

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

        return Targytipus.PISZTOLY;
    }
}
