package Mozgathato;

import Mezo.Mezo;
import Proto.LogAndTesting.Logger;
import Targy.Targy;

import java.util.List;

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

    public Kutato(Mezo mezo, List<Targy> targyak) {

        Logger.log();

        this.testho = 4;
        this.munka = 4;
        this.mezo = mezo;
        this.targyak.addAll(targyak);
    }

    /**
     * Lekerdezi a mezotol a kapacitasat.
     */
    public int jegetNez(Mezo mezo) {

        Logger.log();

        munkaCsokkent(1);

        return mezo.getKapacitas();
    }

    @Override
    public MozgathatoTipus tipus(){

        return MozgathatoTipus.KUTATO;
    }

    @Override
    public String toString(){

        return "";
    }
}
