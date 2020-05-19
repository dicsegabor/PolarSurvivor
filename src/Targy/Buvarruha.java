package Targy;

import Mozgathato.Karakter;
import Proto.LogAndTesting.Logger;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Events.AtfordulasEvent;
import SwingMVC.Eventhandling.Events.TargyhasznalatEvent;

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
        Controller.getInstance().targyhasznalatEvent(new TargyhasznalatEvent(this, karakter));
        Controller.getInstance().atfordultEvent(new AtfordulasEvent(karakter.getMezo()));
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
