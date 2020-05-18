package Mozgathato;

import Mezo.Mezo;
import Proto.LogAndTesting.Logger;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Events.KutatoKepessegEvent;
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

        String kapacitas;

        if(mezo.getKapacitas() == Integer.MAX_VALUE)
            kapacitas = "VÉGTELEN";

        else
            kapacitas = Integer.toString(mezo.getKapacitas());

        Controller.getInstance().kutatoKepessegEvent(new KutatoKepessegEvent(this, mezo, kapacitas));

        if(mezo.szomszedE(this.mezo) || mezo.equals(this.mezo))
            return mezo.getKapacitas();

        return -1;
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
