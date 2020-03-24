package Mezok;

import Karakterek.Karakter;
import Targyak.Targy;

public abstract class Jegtabla extends Mezo {

    private boolean igluzott;
    private Targy targy;

    //TODO: Szkeleton után átírni Targy-ra a visszatérést
    public void getTargy(){}

    @Override
    public void vihar(){}

    public abstract void befogad(Karakter karakter);
}
