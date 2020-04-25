package Mozgathato;

import Mezo.Mezo;
import Proto.ProtoProgram;
import Proto.LogAndTesting.Logger;

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

        Logger.log();

        this.mezo.kiad(this);

        if(mezo == null)
            mezo.getRandomSzomszed().befogad(this);

        else
            mezo.befogad(this);

        ProtoProgram.halalEllorzes();
    }

    @Override
    public MozgathatoTipus tipus(){

        return MozgathatoTipus.JEGESMEDVE;
    }
}
