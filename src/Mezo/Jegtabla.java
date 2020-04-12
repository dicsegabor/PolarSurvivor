package Mezo;

import Epulet.Epulet;
import Mozgathato.Mozgathato;
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
     * A mezon talalhato epulet, ami befolyasolja a karakterek viszonyulasat a kornyezethez.
     */
    private Epulet epulet;

    @Override
    public void vihar(){

        super.vihar();

        if(epulet.equals(null))
            karakterek.forEach(k -> k.testhotCsokkent(1));

        else
            epulet = null;
    }

    /**
     * Kiadja a tarolt targyat.
     */
    public Targy getTargy(){

        Targy targy = this.targy;

        this.targy = null;

        return targy;
    }

    /**
     * Berak egy karaktert a karakterlistajaba.
     */
    public abstract void befogad(Mozgathato mozgathato);
}
