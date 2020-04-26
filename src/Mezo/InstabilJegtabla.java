package Mezo;

import Exceptions.ItemNotFoundException;
import Mozgathato.*;
import Proto.LogAndTesting.Logger;
import Targy.Targytipus;

/**
 * Az instabil jegtablat jelkepezi.
 * Ha tullepik a kapaciitasat, akkor a rajta allo karakterek vizbe esnek.
 */
public class InstabilJegtabla extends Jegtabla {

    /**
     * Berak egy karaktert vagy medvet a mezobe.
     * Megvizsgalja, hogy tullepik-e a kapacitast.
     */
    @Override
    public void befogad(Mozgathato mozgathato) {

        Logger.log();

        if(mozgathato.tipus().equals(MozgathatoTipus.JEGESMEDVE))
            jegesmedve = (Jegesmedve)mozgathato;

        else
            karakterek.add((Karakter)mozgathato);

        if(osszsuly() > kapacitas)
            for(Karakter k : karakterek) {

                try { k.keres(Targytipus.BUVARRUHA).hasznal(k); }
                catch (ItemNotFoundException e) { segitseg(k); }
            }
    }
}
