package Mozgathato;

import Mezo.Mezo;

/**
 * Interface, ami az objektumok mozgatasat teszi lehetove.
 */
public interface Mozgathato {

    /**
     * Lepteti a leptetheto dolgot mezon.
     * @param mezo
     */
    void lep(Mezo mezo);

    Mezo getMezo();

    MozgathatoTipus tipus();
}
