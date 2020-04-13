package Targy;

import Epulet.*;
import Mezo.Jegtabla;
import Mozgathato.Karakter;

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

        //karakter.((Jegtabla)getMezo()).epit(new Sator());
    }

    @Override
    public Targytipus tipus() {

        return Targytipus.SATOR;
    }
}
