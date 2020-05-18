package Targy;

import Mozgathato.Karakter;
import Proto.LogAndTesting.Logger;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Events.KimentesEvent;
import SwingMVC.Eventhandling.Events.TargyhasznalatEvent;
import SwingMVC.Eventhandling.Events.UzenetEvent;

/**
 * Segitsegevel ki lehet huzni egy karaktert a vizbol.
 */
public class Kotel implements Targy {

    /**
     * Megvalositja a targy funkcionalitasat.
     */
    @Override
    public void hasznal(Karakter karakter) {

        Logger.log();

    }

    /**
     * Az aldozatot atrakja a megmento mezojere.
     * @param aldozat A karakter, akit megment.
     * @param megmento A karakter, aki megmenti.
     */
    public void hasznal(Karakter aldozat, Karakter megmento) {

        Logger.log();

        aldozat.lep(megmento.getMezo());

        Controller.getInstance().uzenet(new UzenetEvent(this, "Óvatosan! Most még kihúztak."));
    }

    /**
     * Visszater a targy tipusaval.
     */
    @Override
    public Targytipus tipus() {

        Logger.log();

        return Targytipus.KOTEL;
    }
}
