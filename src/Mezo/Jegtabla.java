package Mezo;

import Epulet.Epulet;
import Mozgathato.Mozgathato;
import Proto.LogAndTesting.Logger;
import Targy.Targy;

/**
 * A jegtablat jelkepezi. Tarolhat targyat.
 * Absztrakt osztaly, belole szarmazik le a stbil es instabil jegtabla.
 */
public abstract class Jegtabla extends Mezo {

    /**
     * A mezo altal tarolt targy, amit a karakter felvehet.
     */
    private Targy targy;

    /**
     * A mezon talalhato epulet, ami befolyasolja a karakterek viszonyulasat a kornyezethez.
     */
    private Epulet epulet;

    /**
     * Meghivja a mezo viharat, valamint teszteli, hogy van-e epulet.
     * Ha van, akkor nem csokken a karakterek testhoje, viszint elpusztul az epulet.
     * Ha nincs, akkor csokken a testhojuk egyel.
     */
    @Override
    public void vihar(){

        Logger.log();

        super.vihar();

        if(epulet.equals(null))
            karakterek.forEach(k -> k.testhotCsokkent(1));

        else
            epulet = null;
    }

    /**
     * A jegtablara rak egy epuletet, ha nincs meg rajta.
     * @param epulet
     */
    public void epit(Epulet epulet){

        Logger.log();

        if(epulet != null)
            this.epulet = epulet;

        else
            System.out.println("Mar van epulet a mezon!");
    }

    public void setTargy(Targy targy) {

        this.targy = targy;
    }

    /**
     * Kiadja a tarolt targyat es eltavolitja a mezorol.
     */
    public Targy getTargy(){

        Logger.log();

        Targy targy = this.targy;

        this.targy = null;

        return targy;
    }

    /**
     * Berak egy karaktert a karakterlistajaba.
     */
    public abstract void befogad(Mozgathato mozgathato);
}
