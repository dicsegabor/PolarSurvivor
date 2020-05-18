package Targy;

import Mozgathato.Karakter;
import Proto.LogAndTesting.Logger;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Events.TargyhasznalatEvent;

/**
 * Hasznalataval megvizsgalja, hogy a mezon talalhato-e a tobbi komponens,
 * es ha igen akkor vege a jateknak.
 */
public class Patron implements Targy {

    /**
     * A mezon, amin a karakter all, megekeresi, hogy megvannak-e a targyak,
     * valamint, hogy van-e eleg munkaja a karaktereknek.
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

        return Targytipus.PATRON;
    }
}
