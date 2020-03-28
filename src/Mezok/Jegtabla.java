package Mezok;

import Karakterek.Karakter;
import Szkeleton.Program;
import Targyak.Targy;

public abstract class Jegtabla extends Mezo {

    private boolean igluzott;
    private Targy targy;

    //TODO: Szkeleton után átírni Targy-ra a visszatérést
    public void getTargy(){}

    @Override
    public void vihar(){

        Program.writeToBuffer("Jegtabla.vihar()");
    }

    public abstract void befogad(Karakter karakter);

    @Override
    public void setIgluzott(boolean igluzott){

        Program.writeToBuffer("Jegtabla.setIgluzott()");
    }
}
