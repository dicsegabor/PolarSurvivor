package Mozgathato;

import Mezo.Mezo;

public class Jegesmedve implements Mozgathato {

    private Mezo mezo;

    public Jegesmedve(Mezo mezo){

        this.mezo = mezo;
    }

    @Override
    public void lep(Mezo mezo){

        //TODO: Jegesmedve lepesenek randolmizalasa

        this.mezo.kiad(this);

        mezo.befogad(this);
    }
}
