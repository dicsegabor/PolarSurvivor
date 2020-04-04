package Mezo;

import Targy.Targy;

/**
 * A jegtablat jelkepezi. Tarolhat targyat.
 * Absztrakt osztaly, belole szarmazik le a stbil es instabil jegtabla.
 */
public abstract class Jegtabla extends Mezo {

    /**
     * A mezo altal tarol targy, amit a karakter felvehet.
     */
    private Targy targy;

    /**
     * Kiadja a tarolt targyat.
     */
    public void getTargy(){}

    /**
     * Berak egy karaktert a karakterlistajaba.
     */
    public abstract void befogad();

    /**
     * Beallitja a mezo igluzott attributumat a kapott ertekre.
     */
    @Override
    public void setIgluzott(){}
}
