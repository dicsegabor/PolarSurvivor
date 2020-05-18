package Mozgathato;

import Epulet.Iglu;
import Mezo.Mezo;
import Mezo.Jegtabla;
import Proto.LogAndTesting.Logger;
import Targy.Targy;

import java.util.List;

/**
 * Az eszkimo tipusu karaktert jelkepezi a jatekban.
 * Tobb testhovel indul, mint a kutato, es kepes iglut epiteni.
 */
public class Eszkimo extends Karakter {

    public Eszkimo(Mezo mezo) {

        Logger.log();

        this.testho = 5;
        this.munka = 4;
        this.mezo = mezo;
    }

    public Eszkimo(Mezo mezo, List<Targy> targyak) {

        Logger.log();

        this.testho = 5;
        this.munka = 4;
        this.mezo = mezo;
        this.targyak.addAll(targyak);
    }

    /**
     * Iglut epit a jegtablara amin, all, igy elkerulve a vihar hatasait.
     */
    public void iglutEpit(){

        Logger.log();

        if(((Jegtabla)mezo).getEpulet() == null)
            ((Jegtabla)mezo).epit(new Iglu());

        munkaCsokkent(1);
    }

    @Override
    public MozgathatoTipus tipus(){

        return MozgathatoTipus.ESZKIMO;
    }
}
