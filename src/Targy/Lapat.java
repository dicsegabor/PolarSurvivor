package Targy;

import Mozgathato.Karakter;
import Proto.LogAndTesting.Logger;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Events.TargyhasznalatEvent;

/**
 * Segitsegevel ket reteg havat ehet eltavolitani a mezorol.
 */
public class Lapat implements Targy {

    /**
     * Ket reteg havat takarit el a mezorol.
     */
    @Override
    public void hasznal(Karakter karakter) {

        Logger.log();

        karakter.getMezo().havatCsokkent(2);
    }

    /**
     * Visszater a targy tipusaval.
     */
    @Override
    public Targytipus tipus() {

        Logger.log();

        return Targytipus.LAPAT;
    }
}
