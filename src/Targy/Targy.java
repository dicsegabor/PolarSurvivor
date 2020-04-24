package Targy;

import Mozgathato.Karakter;

/**
 * A jegtablakban talalhato targyakat jelkepezi.
 */
public interface Targy {

    /**
     * Megvalositja a targy funkcionalitasat.
     */
    void hasznal(Karakter karakter);

    /**
     * Visszater a targy tipusaval.
     */
    Targytipus tipus() ;
}
