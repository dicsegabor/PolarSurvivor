package Mezo;

import Mozgathato.*;
import Proto.LogAndTesting.Logger;

/**
 * Az stabil jegtablat jelkepezi.
 */
public class StabilJegtabla extends Jegtabla {

    public StabilJegtabla(){

        kapacitas = Integer.MAX_VALUE;
    }

    /**
     * Berak egy karaktert vagy medvet a mezobe.
     */
    @Override
    public void befogad(Mozgathato mozgathato) {

        Logger.log();

        if(mozgathato.tipus().equals(MozgathatoTipus.JEGESMEDVE))
            jegesmedve = (Jegesmedve)mozgathato;

        else
            karakterek.add((Karakter)mozgathato);
    }
}
