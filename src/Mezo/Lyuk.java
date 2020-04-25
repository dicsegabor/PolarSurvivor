package Mezo;

import Mozgathato.Mozgathato;
import Proto.LogAndTesting.Logger;

/**
 * Az lyukat jelkepezi.
 * Ha ralepnek, akkor vizbe esnek.
 */
public class Lyuk extends Mezo {

    public Lyuk(boolean fedett){

        if(fedett)
            horeteg = 1;

        else
            horeteg = 0;
    }

    /**
     * Berak egy karaktert a karakterlistajaba.
     * A ralepo karakterek egybel a vizbe esnek, es eltunik rola a ho.
     */
    @Override
    public void befogad(Mozgathato mozgathato) {

        Logger.log();

    }
}
