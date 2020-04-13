package Mozgathato;

import Mezo.Mezo;

/**
 * Az kutato tipusu karaktert jelkepezi a jatekban.
 * Kepes megvizsgalni a szmszedos mezok kapacitasat.
 */
public class Kutato extends Karakter {

    public Kutato(Mezo mezo) {

        this.testho = 4;
        this.munka = 4;
        this.mezo = mezo;
    }

    /**
     * Lekerdezi a mezotol a kapacitasat.
     */
    public void jegetNez(Mezo mezo) {

        mezo.getKapacitas();
    }
}
