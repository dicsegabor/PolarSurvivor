package Targy;

import Mozgathato.Karakter;
import Proto.LogAndTesting.Logger;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Events.KimentesEvent;
import SwingMVC.Eventhandling.Events.TargyhasznalatEvent;

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

        Controller.getInstance().kimentesEvent(new KimentesEvent(this, megmento, aldozat));
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
