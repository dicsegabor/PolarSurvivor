package Targy;

import Mozgathato.Karakter;

/**
 * Hasznalataval megvizsgalja, hogy a mezon talalhato-e a tobbi komponens,
 * es ha igen akkor vege a jateknak.
 */
public class Pisztoly implements Targy {

    /**
     * A mezon, amin a karakter all, megekeresi, hogy megvannak-e a targyak,
     * valamint, hogy van-e eleg munkaja a karaktereknek.
     */
    @Override
    public void hasznal(Karakter karakter) {}

    /**
     * Visszater a targy tipusaval.
     */
    @Override
    public Targytipus tipus() {

        return Targytipus.PISZTOLY;
    }
}
