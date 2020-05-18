package Targy;

import Mozgathato.Karakter;
import Proto.LogAndTesting.Logger;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Events.TargyhasznalatEvent;

/**
 * Segitsegevel ket reteg havat ehet eltavolitani a mezorol, viszont harom hasznalat utan eltorik.
 */
public class TorekenyLapat extends Lapat implements Targy {

    /**
     * Azt tarolja, hogy meg hanyszor hasznalhato a targy.
     */
    private int hasznalhato;

    public TorekenyLapat(){

        Logger.log();

        hasznalhato = 3;
    }

    /**
     * Ket reteg havat takarit el a mezorol. Csokken egyel a tartossaga, es ha nulla eltunik.
     * @param karakter A karakter, aki hasznalja
     */
    @Override
    public void hasznal(Karakter karakter) {

        Logger.log();

        super.hasznal(karakter);

        hasznalhato--;

        if(hasznalhato == 0)
            karakter.eldob(this);
    }

    @Override
    public Targytipus tipus() {

        Logger.log();

        return Targytipus.TOREKENYLAPAT;
    }
}
