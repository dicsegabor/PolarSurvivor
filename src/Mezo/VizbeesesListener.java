package Mezo;

import Mozgathato.Karakter;

/**
 * A karakterek vizbol valo kimeteset teszi lehetove.
 */
public interface VizbeesesListener {

    /**
     * Ha beesik a vizbe egy karakter, akkor meghivodik a fuggveny.
     */
    void segitseg(Karakter karakter);
}
