package Mozgathato;

import Epulet.Epulet;
import Epulet.Epulettipus;
import Mezo.*;
import Proto.ProtoProgram;
import Proto.LogAndTesting.Logger;
import SwingMVC.Controller.Controller;
import SwingMVC.Eventhandling.Events.LepesEvent;

/**
 * A palyan koszalo jegesmedvet jelkepezi a jatekban. Ha egy mezore kerul egy karakterrel, akkor vege a jateknak.
 */
public class Jegesmedve implements Mozgathato {

    /**
     * A mezot tarolja, amin a jegesmedve all.
     */
    private Mezo mezo;

    public Jegesmedve(Mezo mezo){

        Logger.log();

        this.mezo = mezo;
    }

    /**
     * A jegesmedve lepeset megvalosito fuggveny.
     * @param mezo
     */
    @Override
    public void lep(Mezo mezo){

        if(mezo == null)
            mezo = this.mezo.getRandomSzomszed();

        if(this.mezo.szomszedE(mezo)) {

            Controller.getInstance().lepesEvent(new LepesEvent(this, mezo, this.mezo));

            Logger.log();

            this.mezo.kiad(this);
            mezo.befogad(this);

            if (mezo.getKapacitas() != 0) {

                Epulet epulet = ((Jegtabla) mezo).getEpulet();

                if (epulet != null && epulet.epulettipus().equals(Epulettipus.IGLU))
                    lep(null);
            }

            this.mezo = mezo;

            ProtoProgram.halalEllorzes(mezo);
        }
    }

    @Override
    public Mezo getMezo() {

        return mezo;
    }


    @Override
    public MozgathatoTipus tipus(){

        return MozgathatoTipus.JEGESMEDVE;
    }
}
