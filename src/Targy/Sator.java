package Targy;

import Epulet.*;
import Mezo.Jegtabla;
import Mozgathato.Karakter;
import Proto.LogAndTesting.Logger;

public class Sator implements Epulet, Targy {

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

    @Override
    public Targytipus tipus() {

        Logger.log();

        return Targytipus.SATOR;
    }
}
