package Mozgathato;

import Mezo.Mezo;

/**
 * A palyan koszalo jegesmedvet jelkepezi a jatekban. Ha egy mezore kerul egy karakterrel, akkor vege a jateknak.
 */
public class Jegesmedve implements Mozgathato {

    /**
     * A mezot tarolja, amin a jegesmedve all.
     */
    private Mezo mezo;

    public Jegesmedve(Mezo mezo){

        this.mezo = mezo;
    }

    /**
     * A jegesmedve lepeset megvalosito fuggveny.
     * @param mezo
     */
    @Override
    public void lep(Mezo mezo){

        //TODO: Jegesmedve lepesenek randolmizalasa

        this.mezo.kiad(this);

        mezo.befogad(this);
    }
}
