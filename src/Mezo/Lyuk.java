package Mezo;

import Exceptions.ItemNotFoundException;
import Mozgathato.*;
import Proto.LogAndTesting.Logger;
import Targy.Targytipus;

/**
 * Az lyukat jelkepezi.
 * Ha ralepnek, akkor vizbe esnek.
 */
public class Lyuk extends Mezo {

    public Lyuk(boolean fedett){

        Logger.log();

        if(fedett)
            horeteg = 1;

        else
            horeteg = 0;
    }

    @Override
    public void vihar() {

    }

    /**
     * Berak egy karaktert a karakterlistajaba.
     * A ralepo karakterek egybel a vizbe esnek, es eltunik rola a ho.
     */
    @Override
    public void befogad(Mozgathato mozgathato) {

        Logger.log();

        if(mozgathato.tipus().equals(MozgathatoTipus.JEGESMEDVE))
            jegesmedve = (Jegesmedve)mozgathato;

        else
            karakterek.add((Karakter) mozgathato);

        for(Karakter k : karakterek) {

            try { k.keres(Targytipus.BUVARRUHA).hasznal(k); }
            catch (ItemNotFoundException e) { segitseg(k); break;}
        }
    }
}
