package Mozgathato;

import Mezo.Mezo;
import Proto.LogAndTesting.Logger;

/**
 * Az kutato tipusu karaktert jelkepezi a jatekban.
 * Kepes megvizsgalni a szmszedos mezok kapacitasat.
 */
public class Kutato extends Karakter {

    public Kutato(Mezo mezo) {

        Logger.log();

        this.testho = 4;
        this.munka = 4;
        this.mezo = mezo;
    }

    /**
     * Lekerdezi a mezotol a kapacitasat.
     */
    public void jegetNez(Mezo mezo) {

        Logger.log();

        mezo.getKapacitas();
    }
}
