package Mezo;

import Targy.Targy;

/**
 * A jégtáblát jelképezi. Tárolhat tárgyat.
 * Absztrakt osztály, belőle származik le a stbil és instabil jégtábla.
 */
public abstract class Jegtabla extends Mezo {

    /**
     * A mező által tárol tárgy, amit a karakter felvehet.
     */
    private Targy targy;

    /**
     * Kiadja a tárolt tárgyat.
     */
    public void getTargy(){}

    /**
     * Berak egy karaktert a karakterlistájába.
     */
    public abstract void befogad();

    /**
     * Beállítja a mező igluzott attribútumát a kapott értékre.
     */
    @Override
    public void setIgluzott(){}
}
