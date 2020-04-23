package Targy;

import Epulet.*;
import Mezo.Jegtabla;
import Mozgathato.Karakter;
import Proto.LogAndTesting.Logger;

/**
 * Olyan epulet, mely egy hasznalat utan szetesik, nem ved meg a medvetol.
 * Egyben egy targykent is viselkedik.
 */
public class Sator implements Epulet, Targy {

    /**
     * Visszater az epulet tipusaval.
     */
    @Override
    public Epulettipus epulettipus() {

        return Epulettipus.SATOR;
    }

    /**
     * Epit egy satrat a karakter mezejere.
     * @param karakter A karakter, aki hasznalja
     */
    @Override
    public void hasznal(Karakter karakter) {

        Logger.log();

        ((Jegtabla)karakter.getMezo()).epit(new Sator());
    }

    /**
     * Visszater a targy tipusaval.
     */
    @Override
    public Targytipus tipus() {

        Logger.log();

        return Targytipus.SATOR;
    }
}
